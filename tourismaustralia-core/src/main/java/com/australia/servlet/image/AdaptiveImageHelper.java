package com.australia.servlet.image;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.io.IOException;

import javax.jcr.RepositoryException;

import com.day.cq.dam.api.Asset;
import com.day.cq.dam.api.handler.AssetHandler;
import com.day.cq.wcm.api.designer.Style;
import com.day.cq.wcm.foundation.Image;
import com.day.image.Layer;

public class AdaptiveImageHelper {
	public static Quality getQualityFromString(String imageQualityString) {
		if (imageQualityString == null) {
			return null;
		}

		return Quality.valueOf(imageQualityString.toUpperCase());
	}

	public Layer scaleThisImage(Image image, int newWidth, int newHeight, Style style) throws RepositoryException,
		IOException {
		Dimension newSize;
		Layer layer = applyStyleDataToImage(image, style);

		int currentWidth = layer.getWidth();
		int currentHeight = layer.getHeight();

		double widthRatio = (double) newWidth / (double) currentWidth;
		double heightRatio = (double) newHeight / (double) currentHeight;

		if (newHeight == 0) {
			newHeight = (int) (currentHeight * widthRatio);
		}

		int potentialScaledHeight = (int) (currentHeight * widthRatio);
		if (potentialScaledHeight >= newHeight) {
			newSize = new Dimension(newWidth, potentialScaledHeight);
		} else {
			newSize = new Dimension((int) (currentWidth * heightRatio), newHeight);
		}

		return renderScaledImageOnLayer(layer, newSize, newWidth, newHeight);
	}

	public Layer scaleThisImage(Asset asset, AssetHandler assetHandler, int newWidth, int newHeight, Style style)
		throws RepositoryException, IOException {
		Dimension newSize;
		Layer layer = new Layer(assetHandler.getImage(asset.getOriginal()));

		int currentWidth = layer.getWidth();
		int currentHeight = layer.getHeight();

		double widthRatio = (double) newWidth / (double) currentWidth;
		double heightRatio = (double) newHeight / (double) currentHeight;

		if (newHeight == 0) {
			newHeight = (int) (currentHeight * widthRatio);
		}

		int potentialScaledHeight = (int) (currentHeight * widthRatio);
		if (potentialScaledHeight >= newHeight) {
			newSize = new Dimension(newWidth, potentialScaledHeight);
		} else {
			newSize = new Dimension((int) (currentWidth * heightRatio), newHeight);
		}

		return renderScaledImageOnLayer(layer, newSize, newWidth, newHeight);
	}

	public Layer applyStyleDataToImage(Image image, Style style) throws RepositoryException, IOException {
		Layer layer = image.getLayer(false, false, false);

		image.loadStyleData(style);
		image.crop(layer);
		image.rotate(layer);

		return layer;
	}

	public static Layer renderScaledPlaceholderImage(int width, int height) {
		Layer background = new Layer(width, height, Color.white);
		return background;
	}

	private Layer renderScaledImageOnLayer(Layer layer, Dimension scaledSize, int newWidth, int newHeight) {
		layer.resize(scaledSize.width, scaledSize.height);

		int shiftX = 0;
		int shiftY = 0;

		if (scaledSize.width != newWidth) {
			shiftX = Math.abs(scaledSize.width - newWidth) / 2;
		} else {
			shiftY = Math.abs(scaledSize.height - newHeight) / 2;
		}

		Rectangle newDimensions = new Rectangle();
		newDimensions.setBounds(shiftX, shiftY, newWidth, newHeight);

		layer.crop(newDimensions);
		return layer;
	}

	public static enum Quality {
		LOW(.5),
		MEDIUM(.75),
		HIGH(1);

		private final double quality;

		public double getQualityValue() {
			return this.quality;
		}

		private Quality(double quality) {
			this.quality = quality;
		}
	}
}