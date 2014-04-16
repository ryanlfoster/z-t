package com.australia.www.components.content.socialTiles;

import org.apache.commons.lang3.StringUtils;

import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.widgets.PathField;
import com.citytechinc.cq.component.annotations.widgets.RichTextEditor;

public class TileField {

	@RichTextEditor
	@DialogField(fieldLabel = "Text", fieldDescription = "Required")
	private String text;

	@DialogField(fieldLabel = "Social Icon", fieldDescription = "Required")
	@PathField
	private String iconPath;

	@DialogField(fieldLabel = "Image")
	@PathField
	private String imagePath;

	@DialogField(fieldLabel = "Title")
	private String title;

	@DialogField(fieldLabel = "See more link")
	private String link;

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getTitle() {
		return title;
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

	public boolean getHasImage() {
		return (!StringUtils.isBlank(imagePath));
	}

}
