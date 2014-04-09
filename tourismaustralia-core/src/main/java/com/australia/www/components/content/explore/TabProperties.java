package com.australia.www.components.content.explore;


import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.widgets.PathField;
import com.citytechinc.cq.component.annotations.widgets.RichTextEditor;
import com.day.cq.wcm.foundation.Image;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import org.apache.sling.api.resource.Resource;
import com.day.cq.wcm.api.PageManagerFactory;
import org.apache.sling.api.resource.ResourceResolver;

public class TabProperties {
	@DialogField(fieldDescription = "Back alt text")
	private String altTextBack;

	@DialogField(fieldDescription = "Path to page")
	@PathField
	private String pagePath;

	@DialogField(fieldDescription = "Back image of page")
	@PathField
	private String imageBack;

	private Page page;

	public String getAltTextBack() {
		return altTextBack;
	}
	public void setAltTextBack(final String text) {
		altTextBack = text;
	}
	public void setPage(String path, Resource resource){
		PageManager pageManager = resource.getResourceResolver().adaptTo(PageManager.class);
		pagePath = path;
		page = pageManager.getContainingPage(path);
	}


	public String getPageTitle(){
		return page.getTitle();
	}

	public String getPageImagePath(){
		Image imageObj = new Image(page.getContentResource("image"));
		return imageObj.getFileReference();
	}

	public String getPageDescription(){
		return page.getDescription();
	}
}


