package com.australia.www.components.content.socialTiles;

import org.apache.commons.lang3.StringUtils;

import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.FieldProperty;
import com.citytechinc.cq.component.annotations.widgets.Html5SmartImage;
import com.citytechinc.cq.component.annotations.widgets.PathField;
import com.citytechinc.cq.component.annotations.widgets.RichTextEditor;

public class TileField {

	@DialogField(xtype = "static", additionalProperties = { @FieldProperty(name = "text", value = "To render a tile, "
		+ "both Text and Social Icon are required." + "\n"),
		@FieldProperty(name = "italic", value = "true")  })
	@SuppressWarnings("unused")
	private String notice;
	
	@DialogField(fieldLabel = "Title")
	private String title;

	@RichTextEditor
	@DialogField(fieldLabel = "Text", fieldDescription = "Required")
	private String text;

	@DialogField(fieldLabel = "Social Icon", fieldDescription = "Required")
	@Html5SmartImage(tab = false, height = 100, allowUpload = false, name = "smallImage")
	private String iconPath;

	@DialogField(fieldLabel = "Image")
	@Html5SmartImage(tab = false, height = 150, allowUpload = false, name = "image")
	private String imagePath;

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setTitle(String title) {
		this.title = title;
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
