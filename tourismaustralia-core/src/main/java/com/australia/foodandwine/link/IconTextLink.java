package com.australia.foodandwine.link;

import com.australia.utils.LinkUtils;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.FieldProperty;
import com.citytechinc.cq.component.annotations.widgets.PathField;

public class IconTextLink {

	@DialogField(fieldLabel = "Description", additionalProperties = @FieldProperty(name = "anchor", value = "100%"))
	private String linkText;

	@DialogField(fieldLabel = "Link Path", additionalProperties = @FieldProperty(name = "anchor", value = "100%"))
	private String pagePath;

	@DialogField(fieldLabel = "Icon Image", additionalProperties = @FieldProperty(name = "anchor", value = "100%"))
	@PathField(rootPath = "/content/dam")
	private String iconImage;

	private boolean external;

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
		this.external = LinkUtils.isExternal(pagePath);
	}

	public boolean isExternal() {
		return external;
	}

}
