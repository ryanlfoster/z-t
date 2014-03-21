package com.australia.foodandwine.components.content.footer;

import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.widgets.PathField;

public class IconTextLink {

	@DialogField(fieldLabel = "Description")
	private String linkText;

	@DialogField(fieldLabel = "Link Path")
	private String pagePath;

	@DialogField(fieldLabel = "Icon Image")
	@PathField(rootPath = "/content/dam")
	private String iconImage;

	public String getIconImage() {
		return iconImage;
	}

	public void setIconImage(String iconImage) {
		this.iconImage = iconImage;
	}

	public String getLinkText() {
		return linkText;
	}

	public String getPagePath() {
		return pagePath;
	}

	public void setLinkText(String linkText) {
		this.linkText = linkText;
	}

	public void setPagePath(String pagePath) {
		this.pagePath = pagePath;
	}

}
