package com.australia.foodandwine.components.content.header;

import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.widgets.PathField;

public class HeaderBean {
	@DialogField(fieldLabel="Header Link Text",name="headerLinkText")
	private String linkText;
	@DialogField(fieldLabel="Header Link Path",name="headerLinkPath")
	@PathField
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
