package com.australia.foodandwine.components.content.footer;

import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.widgets.PathField;

public class TextLink {

	@DialogField(fieldLabel = "Description")
	private String linkText;

	@DialogField(fieldLabel = "Link Path")
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
