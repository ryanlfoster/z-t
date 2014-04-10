package com.australia.servlet.image;

import java.io.IOException;

import javax.jcr.RepositoryException;

import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.dam.api.Asset;
import com.day.cq.dam.api.handler.AssetHandler;
import com.day.cq.dam.api.handler.store.AssetStore;
import com.day.cq.wcm.api.WCMMode;
import com.day.cq.wcm.commons.AbstractImageServlet;
import com.day.cq.wcm.foundation.Image;
import com.day.image.Layer;

@SlingServlet(label = "Adaptive Image Servlet", description = "Adaptive Image Component Servlet", extensions = "jpg", selectors = "adapt", resourceTypes = "sling/servlet/default", metatype = true)
public class AdaptiveImageComponentServlet extends AbstractImageServlet {
	private static final Logger log = LoggerFactory.getLogger(AdaptiveImageComponentServlet.class);
	private static final long serialVersionUID = 42L;
	private static final String FULL_SIZE_SELECTOR = "full";

	@Reference
	private AssetStore assetStore;

	@Override
	protected Layer createLayer(AbstractImageServlet.ImageContext imageContext) throws RepositoryException, IOException {
		SlingHttpServletRequest request = imageContext.request;
		String[] selectors = request.getRequestPathInfo().getSelectors();

		if (selectors.length < 3) {
			log.error("Expected a width and quality selector.");
			return null;
		}

		String widthSelector = selectors[1];
		if (imageContext.resource.adaptTo(Asset.class) == null) {
			return createLayerForImage(imageContext, widthSelector);
		} else {
			return createLayerForAsset(imageContext, widthSelector);
		}
	}

	private Layer createLayerForAsset(ImageContext imageContext, String widthSelector) throws NumberFormatException,
		RepositoryException, IOException {
		Asset asset = imageContext.resource.adaptTo(Asset.class);
		AssetHandler assetHandler = assetStore.getAssetHandler(asset.getMimeType());

		if (!asset.getMimeType().split("/")[0].equals("image")) {
			log.error("The asset is not an image");

			return null;
		}

		AdaptiveImageHelper adaptiveHelper = new AdaptiveImageHelper();

		if (FULL_SIZE_SELECTOR.equals(widthSelector)) {
			return new Layer(assetHandler.getImage(asset.getOriginal()));
		}

		return adaptiveHelper.scaleThisImage(asset, assetHandler, Integer.parseInt(widthSelector), 0,
			imageContext.style);
	}

	private Layer createLayerForImage(AbstractImageServlet.ImageContext imageContext, String widthSelector)
		throws RepositoryException, IOException {
		Image image = new Image(imageContext.resource);

		if (!(image.hasContent())) {
			log.error("The image associated with this page does not have a valid file reference; drawing a placeholder.");

			return null;
		}

		AdaptiveImageHelper adaptiveHelper = new AdaptiveImageHelper();

		if (FULL_SIZE_SELECTOR.equals(widthSelector)) {
			return adaptiveHelper.applyStyleDataToImage(image, imageContext.style);
		}

		return adaptiveHelper.scaleThisImage(image, Integer.parseInt(widthSelector), 0, imageContext.style);
	}

	@Override
	protected void writeLayer(SlingHttpServletRequest request, SlingHttpServletResponse response,
		AbstractImageServlet.ImageContext context, Layer layer) throws IOException, RepositoryException {
		double quality;
		String[] selectors = request.getRequestPathInfo().getSelectors();
		if (selectors.length == 3) {
			String imageQualitySelector = selectors[2];
			quality = getRequestedImageQuality(imageQualitySelector);
		} else {
			quality = getImageQuality();
		}

		// don't cache images on authoring instances
		// Cache-Control: no-cache allows caching (e.g. in the browser cache)
		// but
		// will force revalidation using If-Modified-Since or If-None-Match
		// every time,
		// avoiding aggressive browser caching
		if (!WCMMode.DISABLED.equals(WCMMode.fromRequest(request))) {
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
			response.setHeader("Expires", "0");
		}

		writeLayer(request, response, context, layer, quality);
	}

	private double getRequestedImageQuality(String imageQualitySelector) {
		AdaptiveImageHelper.Quality newQuality = AdaptiveImageHelper.getQualityFromString(imageQualitySelector);
		if (newQuality != null) {
			return newQuality.getQualityValue();
		}

		return getImageQuality();
	}

	@Override
	protected String getImageType() {
		return "image/jpeg";
	}
}