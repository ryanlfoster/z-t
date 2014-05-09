package com.australia.www.components.content.imagewithbutton;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;

import com.australia.utils.LinkUtils;
import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Listener;
import com.citytechinc.cq.component.annotations.Tab;
import com.citytechinc.cq.component.annotations.widgets.Html5SmartImage;
import com.citytechinc.cq.component.annotations.widgets.PathField;
import com.day.cq.wcm.foundation.Image;
import com.day.cq.wcm.foundation.forms.MergedValueMap;

@Component(value = "Image With Button", disableTargeting = true, dialogHeight = 400, tabs = {
	@Tab(title = "Main Image"), @Tab(title = "Overlay Icon Image"), @Tab(title = "Reference Icon Image"),
	@Tab(title = "Properties") }, listeners = { @Listener(name = "afteredit", value = "REFRESH_PAGE"),
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class ImageWithButton {

	@DialogField(required = true, tab = 1, hideLabel = true)
	@Html5SmartImage(name = "mainImageSrc")
	private final String mainImageSrc;

	@DialogField(tab = 2, hideLabel = true)
	@Html5SmartImage(name = "overlayIconImageSrc")
	private final String overlayIconImageSrc;

	@DialogField(tab = 3, hideLabel = true)
	@Html5SmartImage(name = "refIconImageSrc")
	private final String refIconImageSrc;

	@DialogField(tab = 4, fieldLabel = "Image Button Text")
	private final String imageButtonText;

	@DialogField(tab = 4, fieldLabel = "Image Button Path")
	@PathField
	private final String imageButtonPath;

	@DialogField(tab = 4, fieldLabel = "Quote Text")
	private final String quoteText;

	@DialogField(tab = 4, fieldLabel = "Reference Bold Text")
	private final String refBoldText;

	@DialogField(tab = 4, fieldLabel = "Reference Text")
	private final String refRegularText;

	@DialogField(tab = 4, fieldLabel = "Main Image Alt Tag", required = true)
	private final String mainImageAlt;

	@DialogField(tab = 4, fieldLabel = "Overlay Img Alt Tag")
	private final String overlayIconImageAlt;

	@DialogField(tab = 4, fieldLabel = " Ref Image Alt Tag")
	private final String refIconImageAlt;

	private final boolean buttonPathExternal;

	public ImageWithButton(SlingHttpServletRequest slingRequest) {
		ValueMap properties = slingRequest.getResource().adaptTo(ValueMap.class);
		properties = properties == null ? new MergedValueMap(new ArrayList<Resource>()) : properties;

		Image mainImage = new Image(slingRequest.getResource(), "mainImageSrc");
		this.mainImageSrc = mainImage.getSrc();
		this.mainImageAlt = properties.get("mainImageAlt", StringUtils.EMPTY);

		Image overlayIconImage = new Image(slingRequest.getResource(), "overlayIconImageSrc");
		this.overlayIconImageSrc = overlayIconImage.getSrc();
		this.overlayIconImageAlt = properties.get("overlayIconImageAlt", StringUtils.EMPTY);

		Image refIconImage = new Image(slingRequest.getResource(), "refIconImageSrc");
		this.refIconImageSrc = refIconImage.getSrc();
		this.refIconImageAlt = properties.get("refIconImageAlt", StringUtils.EMPTY);

		this.imageButtonText = properties.get("imageButtonText", StringUtils.EMPTY);
		this.imageButtonPath = LinkUtils.getHrefFromPath(properties.get("imageButtonPath", StringUtils.EMPTY));
		this.buttonPathExternal = LinkUtils.isExternal(properties.get("imageButtonPath", StringUtils.EMPTY));

		this.quoteText = properties.get("quoteText", StringUtils.EMPTY);
		this.refBoldText = properties.get("refBoldText", StringUtils.EMPTY);
		this.refRegularText = properties.get("refRegularText", StringUtils.EMPTY);
	}

	public String getMainImageSrc() {
		return mainImageSrc;
	}

	public String getMainImageAlt() {
		return mainImageAlt;
	}

	public String getOverlayIconImageSrc() {
		return overlayIconImageSrc;
	}

	public String getOverlayIconImageAlt() {
		return overlayIconImageAlt;
	}

	public String getRefIconImageSrc() {
		return refIconImageSrc;
	}

	public String getRefIconImageAlt() {
		return refIconImageAlt;
	}

	public String getImageButtonText() {
		return imageButtonText;
	}

	public String getImageButtonPath() {
		return imageButtonPath;
	}

	public boolean isButtonPathExternal() {
		return buttonPathExternal;
	}

	public String getQuoteText() {
		return quoteText;
	}

	public String getRefBoldText() {
		return refBoldText;
	}

	public String getRefRegularText() {
		return refRegularText;
	}

}