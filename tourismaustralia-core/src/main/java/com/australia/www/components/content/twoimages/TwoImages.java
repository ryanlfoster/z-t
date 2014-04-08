package com.australia.www.components.content.twoimages;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Tab;
import com.citytechinc.cq.component.annotations.widgets.Html5SmartImage;
import com.day.cq.wcm.foundation.Image;
import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;

/**
 * Created by myeasmin on 3/04/14.
 *
 * This component is composed of 2 tabs - Large Image and Text, and Small Image and Text.
 */
@Component(value="Two Images", disableTargeting = true, tabs = {@Tab(title="Large Image and Text"), @Tab(title="Small Image and Text")})
public class TwoImages {
	@DialogField(tab = 1, hideLabel = true)
	@Html5SmartImage(height = 400, tab = false, name="largeImageSrc")
	private final String largeImageSrc;

	@DialogField(tab = 1, fieldLabel = "Large Image Alt Text")
	private final String  largeImageAltText;

	@DialogField(tab = 1, fieldLabel = "Large Image Text")
	private final String largeImageText;

	@DialogField(tab = 2, hideLabel = true)
	@Html5SmartImage(height = 400, tab = false, name="smallImageSrc")
	private final String smallImageSrc;

	@DialogField(tab = 2, fieldLabel = "Small Image Alt Text")
	private final String  smallImageAltText;

	@DialogField(tab = 2, fieldLabel = "Small Image Text")
	private final String smallImageText;

	public TwoImages(SlingHttpServletRequest slingRequest) {
		ValueMap properties = slingRequest.getResource().adaptTo(ValueMap.class);
		Image largeImage = new Image(slingRequest.getResource(),"largeImageSrc");
		this.largeImageSrc = largeImage.getSrc();
		this.largeImageAltText = properties.get("largeImageAltText", StringUtils.EMPTY);
		this.largeImageText = properties.get("largeImageText", StringUtils.EMPTY);
		Image smallImage = new Image(slingRequest.getResource(),"smallImageSrc");
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
