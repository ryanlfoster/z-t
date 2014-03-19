package com.australia.foodandwine.components.content.quote;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Listener;
import com.citytechinc.cq.component.annotations.widgets.DateField;

@Component(group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", value = "Quote", listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class Quote {

	@DialogField(fieldLabel = "Quote Text", required = true)
	private final String quoteText;

	@DialogField(fieldLabel = "Byline", required = true)
	private final String byline;

	@DialogField(fieldLabel = "Quote Date", required = true)
	@DateField(format = "M Y")
	private final String quoteDate;

	public Quote(SlingHttpServletRequest request) {
		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		quoteText = properties.get("quoteText", "");
		byline = properties.get("byline", "");
		quoteDate = properties.get("quoteDate", "");
	}

	public String getQuoteText() {
		return quoteText;
	}

	public String getByline() {
		return byline;
	}

	public String getQuoteDate() {
		return quoteDate;
	}

}
