package com.australia.www.components.content.tagCloud;

import java.util.ArrayList;
import java.util.List;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.day.cq.tagging.Tag;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;


@Component(disableTargeting = true, value = "Tag Cloud")
public class TagCloud {
	
	private List<String> tagList;
	
	@DialogField(fieldLabel = "Title", required = true)
	private String title;
	
	public TagCloud(SlingHttpServletRequest request) {
		
		final ResourceResolver resourceResolver	 = request.getResourceResolver();
        final ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		
		//Get the current page
		final PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
		final Page page = pageManager.getContainingPage(request.getResource());
		
		//Get the tags off the current page
		Tag[] tags = page.getTags();
		tagList = new ArrayList<String>();
		//For each tag, generate a link
		for (Tag tag : tags) {
			String title = tag.getTitle(request.getLocale());
			tagList.add(title);
		}
		
		title = properties.get("title", "");
		
	}
	
	public List<String> getTags() {
		return tagList;
	}
	
	public String getTitle() {
		return title;
	}
}