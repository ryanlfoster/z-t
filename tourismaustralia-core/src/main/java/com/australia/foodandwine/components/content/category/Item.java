package com.australia.foodandwine.components.content.category;

import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.widgets.PathField;

public class Item {
	@DialogField(fieldLabel = "Image Path", required = true)
	@PathField(rootPath = "/content/dam")
	private final String imagePath;

	@DialogField(fieldLabel = "Caption text", required = true)
	private final String caption;

	public Item(String imagePath, String caption) {
		this.imagePath = imagePath;
		this.caption = caption;
	}

	public String getCaption() {
		return caption;
	}

	public String getImagePath() {
		return imagePath;
	}

}
