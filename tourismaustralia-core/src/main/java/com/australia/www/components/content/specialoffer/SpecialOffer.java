package com.australia.www.components.content.specialoffer;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Tab;
import com.citytechinc.cq.component.annotations.widgets.Html5SmartImage;
import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;

@Component(value = "Special Offer", tabs = { @Tab(title = "Image"), @Tab(title = "Extra Information") })
public class SpecialOffer {

	@DialogField(fieldLabel = "Image", required = true, hideLabel = true, tab = 1)
	@Html5SmartImage(name = "image", disableZoom = true, allowUpload = false, tab = true, height = 400)
	private String image;

	@DialogField(fieldLabel = "Alt Text", required = true, tab = 2)
	private String altText;

	@DialogField(fieldLabel = "Title", required = false, tab = 2)
	private String title;

	@DialogField(fieldLabel = "Text", required = false, tab = 2)
	private String text;

	@DialogField(fieldLabel = "Price", required = false, tab = 2)
	private String price;

	@DialogField(fieldLabel = "Price per text", required = false, tab = 2)
	private String pricePerText;

	@DialogField(fieldLabel = "View More Information Link", required = false, tab = 2)
	private String viewMoreInformationLink;

	@DialogField(fieldLabel = "View Terms and condition Link", required = false, tab = 2)
	private String viewTermsAndConditionLink;

	public SpecialOffer(SlingHttpServletRequest request) {
		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		image = properties.get("image", StringUtils.EMPTY);
		altText = properties.get("altText", StringUtils.EMPTY);
		title = properties.get("title", StringUtils.EMPTY);
		text = properties.get("text", StringUtils.EMPTY);
		price = properties.get("price", StringUtils.EMPTY);
		pricePerText = properties.get("pricePerText", StringUtils.EMPTY);
		viewMoreInformationLink = properties.get("viewMoreInformationLink", StringUtils.EMPTY);
		viewTermsAndConditionLink = properties.get("viewTermsAndConditionLink", StringUtils.EMPTY);

	}

	public String getImage() {
		return image;
	}

	public String getAltText() {
		return altText;
	}

	public String getTitle() {
		return title;
	}

	public String getText() {
		return text;
	}

	public String getPrice() {
		return price;
	}

	public String getPricePerText() {
		return pricePerText;
	}

	public String getViewMoreInformationLink() {
		return viewMoreInformationLink;
	}

	public String getViewTermsAndConditionLink() {
		return viewTermsAndConditionLink;
	}
}
