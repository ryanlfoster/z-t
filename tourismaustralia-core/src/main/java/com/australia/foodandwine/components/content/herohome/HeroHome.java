package com.australia.foodandwine.components.content.herohome;

import org.apache.sling.api.SlingHttpServletRequest;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.Listener;


@Component(group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", value = "Hero Home", listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class HeroHome {

	
	
	public HeroHome(SlingHttpServletRequest request) {

		
		
		
	}

	
}
