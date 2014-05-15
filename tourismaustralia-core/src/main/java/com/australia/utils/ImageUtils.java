package com.australia.utils;

import java.awt.Dimension;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;

import com.day.cq.dam.api.Asset;
import com.day.image.Layer;

public class ImageUtils {
	private ImageUtils() {
	}

	public static final Dimension getLargestSixteenByNineImageDimensions(int width, int height) {
		if (width > 0 && height > 0) {
			int factor = Math.floor(width / 16.0) > Math.floor(height / 9) ? (int) Math.floor(height / 9) : (int) Math
				.floor(width / 16);

			int newWidth = 16 * factor;
			int newHeight = 9 * factor;

			return new Dimension(newWidth, newHeight);
		} else {
			return null;
		}
	}

	public static final Dimension getLargestSixteenByNineImageDimensions(ResourceResolver resourceResolver,
		String imagePath) {
		Resource resource = resourceResolver.resolve(imagePath);
		if (resource != null) {
			Asset asset = resource.adaptTo(Asset.class);
			if (asset != null) {
				Layer layer = asset.getOriginal().adaptTo(Layer.class);
				if (layer != null) {
					return getLargestSixteenByNineImageDimensions(layer.getWidth(), layer.getHeight());
				}
			}
		}
		return null;
	}

	public static final String getCropStringForLargestSixteenByNineImage(ResourceResolver resourceResolver,
		String imagePath) {
		Dimension dimension = getLargestSixteenByNineImageDimensions(resourceResolver, imagePath);
		int width = (int) dimension.getWidth();
		int height = (int) dimension.getHeight();
		return "0,0," + width + "," + height;
	}
}
