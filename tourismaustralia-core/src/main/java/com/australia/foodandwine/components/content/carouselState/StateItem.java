package com.australia.foodandwine.components.content.carouselState;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;

import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.widgets.Html5SmartImage;
import com.citytechinc.cq.component.annotations.widgets.PathField;
import com.day.cq.wcm.foundation.Image;

public class StateItem {

	@DialogField(fieldLabel = "Image Alt Tag")
	private final String imageAltTag;

	@DialogField(fieldLabel = "Circle Top Text")
	private final String circleTopText;

	@DialogField(fieldLabel = "Circle Middle Text")
	private final String circleMiddleText;

	@DialogField(fieldLabel = "Circle Bottom Text")
	private final String circleBottomText;

	@DialogField(fieldLabel = "Text")
	private final String text;

	@DialogField(fieldLabel = "Find Out More")
	@PathField(rootPath = "/content")
	private final String findOutMoreLink;

	@DialogField(fieldLabel = "Background Image")
	@Html5SmartImage(allowUpload = false, name = "stateImage", tab = false, height = 400)
	private final String imagePath;

	public StateItem(Resource resource) {
		ValueMap linkProps = resource.adaptTo(ValueMap.class);
		Image image = new Image(resource, "stateImage");
		if (image != null && image.hasContent()) {
			imagePath = image.getPath();
		} else {
			imagePath = "";
		}
		imageAltTag = linkProps.get("imageAltTag", StringUtils.EMPTY);
		circleTopText = linkProps.get("circleTopText", StringUtils.EMPTY);
		circleMiddleText = linkProps.get("circleMiddleText", StringUtils.EMPTY);
		circleBottomText = linkProps.get("circleBottomText", StringUtils.EMPTY);
		text = linkProps.get("text", StringUtils.EMPTY);
		findOutMoreLink = linkProps.get("findOutMoreLink", StringUtils.EMPTY);
	}

	public String getImagePath() {
		return imagePath;
	}

	public String getImageAltTag() {
		return imageAltTag;
	}

	public String getCircleTopText() {
		return circleTopText;
	}

	public String getCircleMiddleText() {
		return circleMiddleText;
	}

	public String getCircleBottomText() {
		return circleBottomText;
	}

	public String getText() {
		return text;
	}

	public String getFindOutMoreLink() {
		return findOutMoreLink;
	}

}
