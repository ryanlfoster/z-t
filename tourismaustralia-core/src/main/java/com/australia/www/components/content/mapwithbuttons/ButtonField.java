package com.australia.www.components.content.mapwithbuttons;

import org.apache.commons.lang3.StringUtils;

import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.widgets.Html5SmartImage;
import com.citytechinc.cq.component.annotations.widgets.PathField;

public class ButtonField {

	@DialogField(fieldLabel = "Image", fieldDescription = "All fields are required to show button")
	@Html5SmartImage(tab = false, height = 100, allowUpload = false, name = "image")
	private String imagePath;

	@DialogField(fieldLabel = "Title")
	private String title;

	@DialogField(fieldLabel = "Text", xtype = "textarea")
	private String text;

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImagePath() {
		return imagePath;
	}

	public String getTitle() {
		return title;
	}

	public String getText() {
		return text;
	}

	public boolean getIsEmpty() {
		if (StringUtils.isBlank(title) || StringUtils.isBlank(text) || StringUtils.isBlank(imagePath))
			return false;
		else
			return true;
	}

}
