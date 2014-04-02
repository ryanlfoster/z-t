package com.australia.www.components.content.explore;


import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.widgets.PathField;

public class Tab {

	@DialogField(fieldLabel = "Icon Image Path")
	@PathField
	private String iconImagePath;

	@DialogField(fieldLabel = "Icon Selected Image Path")
	@PathField
	private String selectedImagePath;

	@DialogField(fieldLabel = "Tab Title")
	private String title;

	public String getIconImagePath() {
		return iconImagePath;
	}

	public String getSelectedImagePath() {
		return selectedImagePath;
	}

	public void setIconImagePath(String path) {
		this.iconImagePath = path;
	}

	public void setSelectedImagePath(String path) {
		this.selectedImagePath = path;
	}

	public String getTitle() { return title; }

	public void setTitle(String text) {
		this.title = text;
	}

}