package com.australia.www.components.content.largeTitle;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;

@Component(value = "Large Title")
public class LargeTitle {

	@DialogField
	private String title;

	public LargeTitle(SlingHttpServletRequest request) {
		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		if (properties != null) {
			title = properties.get("title", StringUtils.EMPTY);
		}
	}

	public String getTitle() {
		return title;
	}
	
	public boolean getHasTitle() {
		return !StringUtils.isBlank(title);
	}

}
