package com.australia.foodandwine.components.content.bigtitle;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;

@Component(group = "food and wine", basePath = "jcr_root/apps/foodandwine/components", value = "Big Title")
public class BigTitle {
	@DialogField(fieldLabel = "Big Title")
	private final String bigTitle;
	@DialogField(fieldLabel = "Byline")
	private final String byLineText;

	public BigTitle(SlingHttpServletRequest request) {
		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		bigTitle = properties.get("bigTitle", StringUtils.EMPTY);
		byLineText = properties.get("byLineText", StringUtils.EMPTY);

	}

	public String getBigTitle() {
		return bigTitle;
	}

	public String getByLineText() {
		return byLineText;
	}

}
