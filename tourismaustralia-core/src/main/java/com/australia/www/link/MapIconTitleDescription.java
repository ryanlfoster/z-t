package com.australia.www.link;

import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.FieldProperty;
import com.citytechinc.cq.component.annotations.widgets.PathField;
import com.citytechinc.cq.component.annotations.widgets.RichTextEditor;

/**
 * Created by wma on 15/05/2014.
 */
public class MapIconTitleDescription {

	@DialogField(fieldLabel = "Image", fieldDescription = "Dimensions: 23px x 22px", required = true,
		additionalProperties = @FieldProperty(name = "anchor", value = "100%"))
	@PathField(rootPath = "/content/dam")
	private String icon;

	@DialogField(fieldLabel = "Title",
		fieldDescription = "E.g. Best time to go, Duration, Total distance, Mode of transport, More information",
		required = true,
		additionalProperties = @FieldProperty(name = "anchor", value = "100%"))
	private String title;

	@DialogField(fieldLabel = "Description", required = false,
		additionalProperties = @FieldProperty(name = "anchor", value = "100%"))
	@RichTextEditor
	private String description;

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
