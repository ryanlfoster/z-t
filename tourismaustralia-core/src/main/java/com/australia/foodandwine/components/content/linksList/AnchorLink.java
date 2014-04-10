package com.australia.foodandwine.components.content.linksList;

import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.FieldProperty;

public class AnchorLink {

	@DialogField(fieldLabel = "Name", required = true)
	private String displayText;

	@DialogField(fieldLabel = "Link URL", required = true, additionalProperties = @FieldProperty(name = "anchor", value = "100%"))
	private String url;

	public String getDisplayText() {
		return displayText;
	}

	public void setDisplayText(String displayText) {
		this.displayText = displayText;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
