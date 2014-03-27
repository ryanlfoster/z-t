package com.australia.foodandwine.components.content.numberIconText;

import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.FieldProperty;
import com.citytechinc.cq.component.annotations.widgets.PathField;
import com.citytechinc.cq.component.annotations.widgets.RichTextEditor;

public class IconText {

	@DialogField(fieldLabel = "Icon Image", required = true, additionalProperties = @FieldProperty(name = "anchor", value = "100%"))
	@PathField(rootPath = "/content/dam")
	private String iconImage;

	@DialogField(fieldLabel = "Description", required = true, additionalProperties = @FieldProperty(name = "anchor", value = "100%"))
	@RichTextEditor
	private String richText;

	private Integer number;

	public String getIconImage() {
		return iconImage;
	}

	public void setIconImage(String iconImage) {
		this.iconImage = iconImage;
	}

	public String getRichText() {
		return richText;
	}

	public void setRichText(String richText) {
		this.richText = richText;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

}
