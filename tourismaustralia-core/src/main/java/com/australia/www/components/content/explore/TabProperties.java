package com.australia.www.components.content.explore;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.resource.Resource;

import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.widgets.PathField;
import com.day.cq.wcm.foundation.Image;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

public class TabProperties {
	@DialogField(fieldDescription = "Back alt text")
	private String altTextBack;

	@DialogField(fieldDescription = "Path to page")
	@PathField
	private String pagePath;

	@DialogField(fieldDescription = "Back image of page")
	@PathField
	private String imageBack;

	private String pageDescription;
	private String pageTitle;
	private String pageImagePath;

	public String getAltTextBack() { return altTextBack; }
	public String getImageBack(){ return imageBack; }
	public String getPageTitle(){ return pageTitle; }
	public String getPageImagePath(){ return pageImagePath; }
	public String getPageDescription(){ return pageDescription; }
	public String getPagePath(){ return pagePath; }

	public void setImageBack(final String path) {
		imageBack = path;
	}
	public void setAltTextBack(final String text) {
		altTextBack = text;
	}
	public void setPage(String path, Resource resource){
		if(StringUtils.isNotBlank(path)){
			PageManager pageManager = resource.getResourceResolver().adaptTo(PageManager.class);
			pagePath = path;
			Page page = pageManager.getContainingPage(path);
			pageDescription = page.getDescription();
			pageTitle = page.getTitle();
			Resource imageRes = page.getContentResource("image");
			Image imageObj = new Image(page.getContentResource("image"));
			pageImagePath = imageObj.getFileReference();
		}else{
			pageDescription = "";
			pageTitle = "";
			pageImagePath = "";
			pagePath = "";
		}
	}
}


