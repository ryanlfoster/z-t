package com.australia.foodandwine.components.content.contactIconText;

import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.FieldProperty;
import com.citytechinc.cq.component.annotations.widgets.PathField;

public class IconTitleText {

	@DialogField(fieldLabel = "Icon", required = true, additionalProperties = @FieldProperty(name = "anchor", value = "100%"))
	@PathField(rootPath = "/content/dam")
	private String iconImage;

	@DialogField(fieldLabel = "Title", required = true)
	private String iconTitle;

	@DialogField(fieldLabel = "Text", required = true)
	private String iconText;

	public String getIconImage() {
		return iconImage;
	}

	public void setIconImage(String iconImage) {
		this.iconImage = iconImage;
	}

	public String getIconTitle() {
		return iconTitle;
	}

	public void setTitle(String iconTitle) {
		this.iconTitle = iconTitle;
	}

	public String getIconText() {
		return iconText;
	}

	public void setIconText(String iconText) {
		this.iconText = iconText;
	}

	public void setIconTitle(String iconTitle) {
		this.iconTitle = iconTitle;
	}

}
