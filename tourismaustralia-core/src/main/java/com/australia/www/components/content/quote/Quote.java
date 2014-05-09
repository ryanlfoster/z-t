package com.australia.www.components.content.quote;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Listener;
import com.citytechinc.cq.component.annotations.widgets.DateField;
import com.day.cq.wcm.foundation.forms.MergedValueMap;

@Component(disableTargeting = true, value = "Quote", listeners = {
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
		properties = properties == null ? new MergedValueMap(new ArrayList<Resource>()) : properties;
		quoteText = properties.get("quoteText", StringUtils.EMPTY);
		byline = properties.get("byline", StringUtils.EMPTY);
		quoteDate = properties.get("quoteDate", StringUtils.EMPTY);
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
