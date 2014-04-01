package com.australia.foodandwine.link;

import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.FieldProperty;
import com.citytechinc.cq.component.annotations.widgets.PathField;

public class IconLink {

	@DialogField(fieldLabel = "Icon Image", additionalProperties = @FieldProperty(name = "anchor", value = "100%"), required = true)
	@PathField(rootPath = "/content/dam")
	private final String icon;

	@DialogField(fieldLabel = "Icon Alt Text", required = true)
	private final String alt;

	@DialogField(fieldLabel = "Link", additionalProperties = @FieldProperty(name = "anchor", value = "100%"))
	@PathField(rootPath = "/content")
	private final String link;

	private final boolean external;

	public IconLink(String icon, String alt, String link, boolean external) {
		this.icon = icon;
		this.alt = alt;
		this.link = link;
		this.external = external;
	}

	public String getIcon() {
		return icon;
	}

	public String getAlt() {
		return alt;
	}

	public String getLink() {
		return link;
	}

	public boolean isExternal() {
		return external;
	}
}
