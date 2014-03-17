package com.australia.www.components.content.specialoffer;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Tab;
import com.citytechinc.cq.component.annotations.widgets.Html5SmartImage;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;

/**
 * Created by vpushpanayagam on 17/03/14.
 */

@Component(value = "Special Offer", tabs = { @Tab(title = "Image"), @Tab(title = "Extra Information") })
public class SpecialOffer {

	@DialogField(fieldLabel = "Image", required = true, hideLabel = true, tab = 1)
	@Html5SmartImage(name = "image", disableZoom = true, allowUpload = false, tab = true, height = 400)
	private String image;

	@DialogField(fieldLabel = "Alt Text", required = true, tab = 2)
	private String altText;

	public SpecialOffer(SlingHttpServletRequest request) {
		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		altText = properties.get("image", "");
		altText = properties.get("altText", "");
	}

	public String getImage() {
		return image;
	}

	public String getAltText() {
		return altText;
	}
}
