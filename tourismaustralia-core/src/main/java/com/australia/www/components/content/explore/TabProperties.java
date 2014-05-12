package com.australia.www.components.content.explore;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.Resource;

import com.australia.content.domain.Content;
import com.australia.pagecategories.PageCategory;
import com.australia.utils.LinkUtils;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.widgets.PathField;

public class TabProperties {
	@DialogField(fieldDescription = "Back alt text")
	private String altTextBack;

	@DialogField(fieldDescription = "Path to page")
	@PathField
	private String pagePath;

	@DialogField(fieldDescription = "Image on the back of card")
	@PathField(rootPath = "/content/dam")
	private String imageBack;

	private Content content;

	public String getAltTextBack() {
		return altTextBack;
	}

	public String getImageBack() {
		return imageBack;
	}

	public String getPageTitle() {
		return content != null ? content.getTitle() : "";
	}

	public String getPageImagePath() {
		return content != null ? content.getImagePath() : "";
	}

	public String getPageDescription() {
		return content != null ? content.getText() : "";
	}

	public PageCategory getPageCategory() {
		return content != null ? content.getPageCategory() : PageCategory.ABORIGINAL_AUSTRALIA;
	}

	public String getPagePath() {
		return LinkUtils.getHrefFromPath(pagePath);
	}

	public void setImageBack(final String path) {
		imageBack = path;
	}

	public void setAltTextBack(final String text) {
		altTextBack = text;
	}

	public void setPage(String path, Resource resource) {
		pagePath = path;
		if (resource != null && StringUtils.isNotBlank(path)) {
			Resource pageResource = resource.getResourceResolver().resolve(path);
			content = Content.fromResource(pageResource);
		} else {
			content = null;
		}
	}

	public boolean isValid() {
		return pagePath != null && !pagePath.trim().isEmpty();
	}

}
