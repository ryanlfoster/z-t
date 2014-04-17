package com.australia.foodandwine.components.content.carouselState;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;

import com.australia.utils.LinkUtils;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.widgets.Html5SmartImage;
import com.citytechinc.cq.component.annotations.widgets.PathField;
import com.day.cq.wcm.foundation.Image;

public class StateItem {

	@DialogField(fieldLabel = "Circle Top Text")
	private final String circleTopText;

	@DialogField(fieldLabel = "Circle Middle Text", required = true)
	private final String circleMiddleText;

	@DialogField(fieldLabel = "Circle Bottom Text")
	private final String circleBottomText;

	@DialogField(fieldLabel = "Text")
	private final String text;

	@DialogField(fieldLabel = "Find Out More", required = true)
	@PathField(rootPath = "/content")
	private String findOutMoreLink;

	@DialogField(fieldLabel = "Image Alt Tag", required = true)
	private final String imageAltTag;

	@DialogField(fieldLabel = "Image", required = true)
	@Html5SmartImage(allowUpload = false, name = "backgroundImage", tab = false, height = 400)
	private final String imagePath;

	private boolean external;

	public StateItem(Resource resource) {
		ValueMap linkProps = resource.adaptTo(ValueMap.class);
		Image image = new Image(resource, "backgroundImage");
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
		if (StringUtils.isNotEmpty(findOutMoreLink)) {
			external = LinkUtils.isExternal(findOutMoreLink);
			if (!external) {
				findOutMoreLink = findOutMoreLink.concat(".html");
			}
		}
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

	public void setExternal(boolean external) {
		this.external = external;
	}

	public boolean isExternal() {
		return external;
	}

}
