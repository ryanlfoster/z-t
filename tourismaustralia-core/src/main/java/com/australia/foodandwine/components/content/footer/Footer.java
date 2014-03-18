package com.australia.foodandwine.components.content.footer;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Listener;

/**
 *
 */
@Component(group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", value = "Footer", listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class Footer {

	@DialogField(fieldLabel = "Target Application", required = true)
	private final String applicationUrl;

	public Footer(SlingHttpServletRequest request) {
		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		applicationUrl = properties.get("applicationUrl", "");
	}

	public String getApplicationUrl() {
		return applicationUrl;
	}
}
