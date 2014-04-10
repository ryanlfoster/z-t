package com.australia.www.components.content.buttons;

import org.apache.commons.lang3.StringUtils;

import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.widgets.PathField;

public class ButtonField {

	@DialogField(fieldLabel = "Image", fieldDescription = "All fields are required to show button")
	@PathField(rootPath = "/", rootTitle = "Assets")
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
