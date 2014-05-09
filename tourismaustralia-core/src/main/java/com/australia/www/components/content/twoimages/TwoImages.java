package com.australia.www.components.content.twoimages;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Tab;
import com.citytechinc.cq.component.annotations.widgets.Html5SmartImage;
import com.day.cq.wcm.foundation.Image;
import com.day.cq.wcm.foundation.forms.MergedValueMap;

@Component(value = "Two Images", disableTargeting = true, tabs = { @Tab(title = "Large Image"),
	@Tab(title = "Small Image"), @Tab(title = "Properties") })
public class TwoImages {
	@DialogField(tab = 1, hideLabel = true, required = true)
	@Html5SmartImage(name = "largeImageSrc")
	private final String largeImageSrc;

	@DialogField(tab = 2, hideLabel = true, required = true)
	@Html5SmartImage(name = "smallImageSrc")
	private final String smallImageSrc;

	@DialogField(tab = 3, fieldLabel = "Large Image Text")
	private final String largeImageText;

	@DialogField(tab = 3, fieldLabel = "Image Alt Tag", required = true)
	private final String largeImageAltText;

	@DialogField(tab = 3, fieldLabel = "Small Image Text")
	private final String smallImageText;

	@DialogField(tab = 3, fieldLabel = "Image Alt Tag", required = true)
	private final String smallImageAltText;

	public TwoImages(SlingHttpServletRequest slingRequest) {
		ValueMap properties = slingRequest.getResource().adaptTo(ValueMap.class);
		properties = properties == null ? new MergedValueMap(new ArrayList<Resource>()) : properties;
		Image largeImage = new Image(slingRequest.getResource(), "largeImageSrc");
		this.largeImageSrc = largeImage.getSrc();
		this.largeImageAltText = properties.get("largeImageAltText", StringUtils.EMPTY);
		this.largeImageText = properties.get("largeImageText", StringUtils.EMPTY);
		Image smallImage = new Image(slingRequest.getResource(), "smallImageSrc");
		this.smallImageSrc = smallImage.getSrc();
		this.smallImageAltText = properties.get("smallImageAltText", StringUtils.EMPTY);
		this.smallImageText = properties.get("smallImageText", StringUtils.EMPTY);
	}

	public String getLargeImageSrc() {
		return largeImageSrc;
	}

	public String getLargeImageAltText() {
		return largeImageAltText;
	}

	public String getLargeImageText() {
		return largeImageText;
	}

	public String getSmallImageSrc() {
		return smallImageSrc;
	}

	public String getSmallImageAltText() {
		return smallImageAltText;
	}

	public String getSmallImageText() {
		return smallImageText;
	}
}
