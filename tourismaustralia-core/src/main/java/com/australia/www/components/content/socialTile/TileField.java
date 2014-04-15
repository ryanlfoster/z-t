package com.australia.www.components.content.socialTile;

import org.apache.commons.lang3.StringUtils;

import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.widgets.PathField;

public class TileField {

	@DialogField(fieldLabel = "Image")
	@PathField
	private String imagePath;

	@DialogField(fieldLabel = "Text")
	// Required
	private String text;

	@DialogField(fieldLabel = "See more link")
	private String link;

	@DialogField(fieldLabel = "Social Icon")
	// Required
	@PathField
	private String iconPath;

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public void setIconPath(String iconPath) {
		this.iconPath = iconPath;
	}

	public String getImagePath() {
		return imagePath;
	}

	public String getText() {
		return text;
	}

	public String getLink() {
		return link;
	}

	public String getIconPath() {
		return iconPath;
	}

	public boolean getIsValid() {
		return (!StringUtils.isBlank(text) && !StringUtils.isBlank(iconPath));
	}

}
