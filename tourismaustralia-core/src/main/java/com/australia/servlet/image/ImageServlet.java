package com.australia.servlet.image;

import java.io.IOException;
import java.io.InputStream;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.commons.ImageHelper;
import com.day.cq.commons.jcr.JcrConstants;
import com.day.cq.wcm.api.NameConstants;
import com.day.cq.wcm.api.WCMMode;
import com.day.cq.wcm.commons.AbstractImageServlet;
import com.day.cq.wcm.foundation.Image;
import com.day.image.Layer;

@Component
@Service
@Properties({ @Property(name = "service.description", value = "Image rendering servlet."),
	@Property(name = "sling.servlet.methods", value = "GET"),
	@Property(name = "sling.servlet.selectors", value = "img"),
	@Property(name = "sling.servlet.resourceTypes", value = { "sling/servlet/default" }) })
public final class ImageServlet extends AbstractImageServlet {

	/** Required. */
	private static final long serialVersionUID = 1L;

	private static final String PAGE_IMAGE_NAME = "image";

	/** Logger */
	private static final Logger LOG = LoggerFactory.getLogger(ImageServlet.class);

	class ImageWrapper {

		private final int width;

		private final String name;

		private final Resource resource;

		public ImageWrapper(final SlingHttpServletRequest request) {
			final String[] selectors = request.getRequestPathInfo().getSelectors();

			final boolean isPage = isPage(request);

			if (isPage) {
				resource = request.getResource().getChild(JcrConstants.JCR_CONTENT);
			} else {
				resource = request.getResource();
			}

			if (selectors.length > 1) {
				final String selector = selectors[1];

				if (StringUtils.isNumeric(selector)) {
					name = isPage || isPageContent(request) ? PAGE_IMAGE_NAME : null;
					width = Integer.valueOf(selector);
				} else {
					name = selector;

					if (selectors.length > 2) {
						width = Integer.valueOf(selectors[2]);
					} else {
						width = -1;
					}
				}
			} else {
				name = isPage || isPageContent(request) ? PAGE_IMAGE_NAME : null;
				width = -1;
			}
		}

		public Image getImage() {
			final Image image;

			if (name == null) {
				LOG.debug("getImage() resource = " + resource.getPath());

				image = new Image(resource);
			} else {
				LOG.debug("getImage() resource = " + resource.getPath() + ", name = " + name);

				image = new Image(resource, name);
			}

			return image;
		}

		public int getWidth() {
			LOG.debug("getWidth() width = " + width);

			return width;
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void writeLayer(final SlingHttpServletRequest request, final SlingHttpServletResponse response,
		final ImageContext context, final Layer layer) throws RepositoryException, IOException {
		final ImageWrapper wrapper = new ImageWrapper(request);

		final Image image = wrapper.getImage();

		if (!image.hasContent()) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}

		// get style and set constraints
		image.loadStyleData(context.style);

		// get pure layer
		Layer imageLayer = image.getLayer(false, false, false);
		boolean modified = false;

		if (imageLayer != null) {
			// check for selector-based resizing
			modified = resizeLayer(wrapper, imageLayer);

			// crop
			modified |= image.crop(imageLayer) != null;

			// rotate
			modified |= image.rotate(imageLayer) != null;

			// resize
			modified |= image.resize(imageLayer) != null;

			// apply diff if needed (because we create the layer inline)
			modified |= applyDiff(imageLayer, context);
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

		if (modified) {
			String mimeType = image.getMimeType();
			if (ImageHelper.getExtensionFromType(mimeType) == null) {
				// get default mime type
				mimeType = "image/png";
			}
			response.setContentType(mimeType);
			imageLayer.write(mimeType, mimeType.equals("image/gif") ? 255 : 1.0, response.getOutputStream());
		} else {
			// do not re-encode layer, just spool
			javax.jcr.Property data = image.getData();
			InputStream in = data.getStream();
			response.setContentLength((int) data.getLength());
			response.setContentType(image.getMimeType());
			IOUtils.copy(in, response.getOutputStream());
			in.close();
		}
		response.flushBuffer();
	}

	@Override
	protected Layer createLayer(final ImageContext context) throws RepositoryException, IOException {
		return null;
	}

	private boolean resizeLayer(final ImageWrapper wrapper, final Layer layer) {
		final int ratioW = layer.getWidth();
		final int ratioH = layer.getHeight();

		boolean resized = false;

		final int width = wrapper.getWidth();

		if (width > -1) {
			int height = 0;

			if (ratioW != 0 && ratioH != 0) {
				height = (width * ratioH) / ratioW;

				LOG.debug("resizeLayer() resizing to width = " + width + ", height = " + height);

				layer.resize(width, height);

				resized = true;
			}
		}

		return resized;
	}

	private boolean isPageContent(final SlingHttpServletRequest request) {
		final Resource resource = request.getResource();

		return JcrConstants.JCR_CONTENT.equals(resource.getName());
	}

	private boolean isPage(final SlingHttpServletRequest request) {
		final Resource resource = request.getResource();
		final Node node = resource.adaptTo(Node.class);

		boolean isPage = false;

		try {
			if (NameConstants.NT_PAGE.equals(node.getPrimaryNodeType().getName())) {
				isPage = true;
			}
		} catch (final RepositoryException re) {
			LOG.error("error getting node type for resource = " + resource.getPath(), re);
		}

		return isPage;
	}
}