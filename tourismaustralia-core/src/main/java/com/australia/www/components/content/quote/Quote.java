package com.australia.www.components.content.quote;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Listener;
import com.citytechinc.cq.component.annotations.Tab;
import com.citytechinc.cq.component.annotations.widgets.Html5SmartImage;
import com.day.cq.wcm.foundation.Image;
import com.day.cq.wcm.foundation.forms.MergedValueMap;

@Component(disableTargeting = true, value = "Quote", tabs = { @Tab(title = "Image"), @Tab(title = "Properties") }, listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class Quote {

	@DialogField(hideLabel = true, tab = 1)
	@Html5SmartImage(name = "imageSrc")
	private final String imageSrc;

	@DialogField(fieldLabel = "Quote Text", tab = 2)
	private final String quoteText;

	@DialogField(fieldLabel = "Byline", tab = 2)
	private final String byline;

	public Quote(SlingHttpServletRequest request) {
		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		properties = properties == null ? new MergedValueMap(new ArrayList<Resource>()) : properties;
		Image image = new Image(request.getResource(), "imageSrc");
		imageSrc = image.getSrc();
		quoteText = properties.get("quoteText", StringUtils.EMPTY);
		byline = properties.get("byline", StringUtils.EMPTY);
	}

	public String getQuoteText() {
		return quoteText;
	}

	public String getByline() {
		return byline;
	}

	public String getImageSrc() {
		return imageSrc;
	}

}
