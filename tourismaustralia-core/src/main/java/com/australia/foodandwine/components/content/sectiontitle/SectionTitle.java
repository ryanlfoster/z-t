package com.australia.foodandwine.components.content.sectiontitle;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;

@Component(disableTargeting = true, group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", value = "Section Title")
public class SectionTitle {
	@DialogField(fieldLabel = "Title")
	private final String title;

	public SectionTitle(SlingHttpServletRequest request) {
		ValueMap props = request.getResource().adaptTo(ValueMap.class);
		title = props.get("title", StringUtils.EMPTY);
	}

	public String getTitle() {
		return title;
	}
}
