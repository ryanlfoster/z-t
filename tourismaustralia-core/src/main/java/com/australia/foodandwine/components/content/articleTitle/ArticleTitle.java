package com.australia.foodandwine.components.content.articleTitle;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Listener;

@Component(group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", value = "Article Title", listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class ArticleTitle {

	@DialogField(fieldLabel = "Article Name", required = true)
	private String name;

	@DialogField(fieldLabel = "Byline")
	private String byline;

	public ArticleTitle(SlingHttpServletRequest request) {
		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		if (properties != null) {
			name = properties.get("name", StringUtils.EMPTY);
			byline = properties.get("byline", StringUtils.EMPTY);
		}
	}

	public String getName() {
		return name;
	}

	public String getByline() {
		return byline;
	}

}
