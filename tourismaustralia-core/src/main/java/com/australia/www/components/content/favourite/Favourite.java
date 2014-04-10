package com.australia.www.components.content.favourite;

import com.citytechinc.cq.component.annotations.Component;
import com.day.cq.wcm.api.PageManager;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;

/**
 * Created by wma on 1/04/2014.
 */
@Component(value = "Favourite", disableTargeting = true, actions = { "-", "copymove", "delete" })
public class Favourite {

	private final String pagePath;

	public Favourite(SlingHttpServletRequest request) {
		PageManager pageManager = request.getResourceResolver().adaptTo(PageManager.class);
		pagePath = pageManager.getContainingPage(request.getResource()).getPath();
	}

	public String getPagePath() {
		return pagePath;
	}

}
