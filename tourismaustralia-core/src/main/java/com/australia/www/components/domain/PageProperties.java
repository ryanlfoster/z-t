package com.australia.www.components.domain;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;

import com.australia.utils.LinkUtils;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.foundation.Image;

public class PageProperties {

	private String pageTitle;
	private String pageSubtitle;
	private String pageDescription;
	private String pageImagePath;
	private String pagePath;

	public PageProperties(Page page) {
		pageTitle = page.getPageTitle();
		pageDescription = page.getDescription();
		pagePath = page.getPath();

		ValueMap properties = page.getProperties();
		if (properties != null) {
			pageSubtitle = properties.get("subtitle", "");
		}

		Resource imageRes = page.getContentResource("image");
		if (imageRes != null) {
			Image pageImage = new Image(imageRes);
			pageImagePath = pageImage.getFileReference();
		}
	}

	public String getTitle() {
		return pageTitle;
	}

	public String getSubtitle() {
		return pageSubtitle;
	}

	public String getDescription() {
		return pageDescription;
	}

	public String getImagePath() {
		return pageImagePath;
	}

	public String getPath() {
		return LinkUtils.getHrefFromPath(pagePath);
	}

}
