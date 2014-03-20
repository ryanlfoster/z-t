package com.australia.foodandwine.components.content.footer;

import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.widgets.PathField;

public class IconTextLink extends TextLink {

	@DialogField(fieldLabel = "Icon Image", tab = 1)
	@PathField(rootPath = "/content/dam")
	private String iconImage;

	public String getIconImage() {
		return iconImage;
	}

	public void setIconImage(String iconImage) {
		this.iconImage = iconImage;
	}

}
