package com.australia.www.components.content.smallimagewithtext;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Tab;
import com.citytechinc.cq.component.annotations.widgets.Html5SmartImage;
import com.day.cq.wcm.foundation.Image;
import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;

/**
 * Created by myeasmin on 8/04/14.
 * 
 * This component is composed of 1 tab - Image and Text.
 */
@Component(value = "Small Image With Text", disableTargeting = true, tabs = { @Tab(title = "Image and Text") })
public class SmallImageWithText {
	@DialogField(tab = 1, hideLabel = true)
	@Html5SmartImage(height = 400, tab = false, name = "imageSrc")
	private final String imageSrc;

	@DialogField(tab = 1, fieldLabel = "Image Alt Text")
	private final String imageAltText;

	@DialogField(tab = 1, fieldLabel = "Image Text")
	private final String imageText;

	public SmallImageWithText(SlingHttpServletRequest slingRequest) {
		ValueMap properties = slingRequest.getResource().adaptTo(ValueMap.class);
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
