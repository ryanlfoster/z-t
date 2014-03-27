package com.australia.foodandwine.components.content.numberIconText;

import java.util.List;

import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.FieldProperty;
import com.citytechinc.cq.component.annotations.widgets.MultiField;
import com.citytechinc.cq.component.annotations.widgets.PathField;
import com.citytechinc.cq.component.annotations.widgets.RichTextEditor;

public class IconText {

	@DialogField(fieldLabel = "Icon Images", additionalProperties = @FieldProperty(name = "anchor", value = "100%"))
	@PathField(rootPath = "/content/dam")
	@MultiField
	private List<String> iconImages;

	@DialogField(fieldLabel = "Description", additionalProperties = @FieldProperty(name = "anchor", value = "100%"))
	@RichTextEditor
	private String richText;

	private Integer number;

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

	public List<String> getIconImages() {
		return iconImages;
	}

	public void setIconImages(List<String> iconImages) {
		this.iconImages = iconImages;
	}

}
