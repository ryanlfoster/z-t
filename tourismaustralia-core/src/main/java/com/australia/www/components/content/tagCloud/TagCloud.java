package com.australia.www.components.content.tagCloud;

import java.util.ArrayList;
import java.util.List;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ResourceResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.australia.www.components.domain.Link;
import com.citytechinc.cq.component.annotations.Component;
import com.day.cq.tagging.Tag;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;


@Component(value = "Tag Cloud")
public class TagCloud {

	private static final Logger LOG = LoggerFactory.getLogger(TagCloud.class);
	
	private List<Link> tagList;
	
	public TagCloud(SlingHttpServletRequest request) {
		
		final ResourceResolver resourceResolver	 = request.getResourceResolver();
		
		//Get the current page
		final PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
		final Page page = pageManager.getContainingPage(request.getResource());
		LOG.debug("The containing page is " + page.getPath());
		
		//Get the tags off the current page
		Tag[] tags = page.getTags();
		tagList = new ArrayList<Link>();
		//For each tag, generate a link
		for (Tag tag : tags) {
			String title = tag.getTitle(request.getLocale());
			tagList.add(new Link("#",title));
		}
		
		
		
//		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
//		BrcService brcService = BrcUtils.getSlingSettingService();

//		videoRandomId = new String(UUID.randomUUID().toString().replaceAll("-", ""));
//		playerId = properties.get("playerId", brcService.getDefVideoPlayerID());
//		playerKey = properties.get("playerKey", brcService.getDefVideoPlayerKey());
//		videoPlayer = properties.get("videoPlayer", "");
	}
	
	public List<Link> getTags() {
		return tagList;
	}
}