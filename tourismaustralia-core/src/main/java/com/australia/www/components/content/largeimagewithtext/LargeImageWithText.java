package com.australia.www.components.content.largeimagewithtext;

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

@Component(value = "Large Image With Text", disableTargeting = true, tabs = { @Tab(title = "Image"),
	@Tab(title = "Properties") })
public class LargeImageWithText {

	@DialogField(tab = 1, hideLabel = true, required = true)
	@Html5SmartImage(name = "imageSrc")
	private final String imageSrc;

	@DialogField(tab = 2, fieldLabel = "Image Text", required = true)
	private final String imageText;

	@DialogField(tab = 2, fieldLabel = "Image Alt Tag", required = true)
	private final String imageAltText;

	public LargeImageWithText(SlingHttpServletRequest slingRequest) {
		ValueMap properties = slingRequest.getResource().adaptTo(ValueMap.class);
		properties = properties == null ? new MergedValueMap(new ArrayList<Resource>()) : properties;
		Image image = new Image(slingRequest.getResource(), "imageSrc");
		this.imageSrc = image.getSrc();
		this.imageAltText = properties.get("imageAltText", StringUtils.EMPTY);
		this.imageText = properties.get("imageText", StringUtils.EMPTY);
	}

	public String getImageSrc() {
		return imageSrc;
	}

	public String getImageAltText() {
		return imageAltText;
	}

	public String getImageText() {
		return imageText;
	}

}
