package com.australia.foodandwine.link;

import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.FieldProperty;
import com.citytechinc.cq.component.annotations.widgets.PathField;

public class TextLink {

	@DialogField(fieldLabel = "Title", additionalProperties = @FieldProperty(name = "anchor", value = "100%"))
	private String linkText;

	@DialogField(fieldLabel = "Link Path", additionalProperties = @FieldProperty(name = "anchor", value = "100%"))
	@PathField(rootPath = "/content")
	private String pagePath;

	public String getLinkText() {
		return linkText;
	}

	public void setLinkText(String linkText) {
		this.linkText = linkText;
	}

	public String getPagePath() {
		return pagePath;
	}

	public void setPagePath(String pagePath) {
		this.pagePath = pagePath;
	}

}
