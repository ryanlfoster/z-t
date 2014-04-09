package com.australia.foodandwine.components.content.stateLinks;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.Listener;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

@Component(value = "State Links", group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", disableTargeting = true, listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class StateLinks {

	private final String[] OZ_STATES = { "victoria", "queensland", "nsw", "capital", "northern", "south", "tasmania",
		"western" };

	private String state;

	public StateLinks(SlingHttpServletRequest request) {
		Page currentPage = request.getResourceResolver().adaptTo(PageManager.class)
			.getContainingPage(request.getResource());

		for (String state : OZ_STATES) {
			if (StringUtils.contains(currentPage.getName(), state)) {
				this.state = state;
				break;
			}
		}
	}

	public String getState() {
		return state;
	}

}
