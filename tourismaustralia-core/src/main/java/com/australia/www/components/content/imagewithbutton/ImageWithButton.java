package com.australia.www.components.content.imagewithbutton;

import com.australia.utils.LinkUtils;
import com.australia.www.components.content.links.Links;
import com.citytechinc.cq.component.annotations.*;
import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Tab;
import com.citytechinc.cq.component.annotations.widgets.Html5SmartImage;
import com.citytechinc.cq.component.annotations.widgets.PathField;
import com.day.cq.wcm.foundation.Image;

/**
 * Created by myeasmin on 18/03/14.
 *
 * This component is composed of 4 tabs - Main Image, Overlay Icon Image, Reference Icon Image, and Additional Properties.
  */
@Component(value="Image With Button", disableTargeting = true , tabs = {@Tab(title="Main Image"), @Tab(title="Overlay Icon Image"), @Tab(title="Reference Icon Image"), @Tab(title="Additional Properties")}, listeners = {
	@Listener(name = "afteredit", value = "REFRESH_PAGE"),
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"),
	@Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afterinsert", value = "REFRESH_PAGE")})

public class ImageWithButton {

	@DialogField(required = true, tab = 1, hideLabel = true)
	@Html5SmartImage(height = 400, tab = false, name="mainImageSrc")
	private final String mainImageSrc;

	@DialogField(required = true, tab = 1, fieldLabel = "Main Image Alt")
	private final String mainImageAlt;

	@DialogField(tab = 2, hideLabel = true)
	@Html5SmartImage(height = 400, tab = false, name="overlayIconImageSrc")
	private final String overlayIconImageSrc;

	@DialogField(tab = 2, fieldLabel = "Overlay Icon Image Alt")
	private final String overlayIconImageAlt;

	@DialogField(tab = 3, hideLabel = true)
	@Html5SmartImage(height = 400, tab = false, name="refIconImageSrc")
	private final String refIconImageSrc;

	@DialogField(tab = 3, fieldLabel = " Reference Icon Image Alt")
	private final String refIconImageAlt;

	@DialogField(tab = 4, fieldLabel = "Image Button Text")
	private final String imageButtonText;

	@DialogField(tab = 4, fieldLabel = "Image Button Path")
	@PathField
	private String imageButtonPath;

	private boolean buttonPathExternal;

	@DialogField(tab = 4, fieldLabel = "Overlay Quote Text")
	private final String quoteText;

	@DialogField(tab = 4, fieldLabel = "Reference Bold Text")
    private final String refBoldText;

    @DialogField(tab = 4, fieldLabel = "Reference Regular Text")
    private final String refRegularText;

	public ImageWithButton(SlingHttpServletRequest slingRequest) {
		ValueMap properties = slingRequest.getResource().adaptTo(ValueMap.class);

		Image mainImage = new Image(slingRequest.getResource(),"mainImageSrc");
		this.mainImageSrc = mainImage.getSrc();
		this.mainImageAlt = properties.get("mainImageAlt", StringUtils.EMPTY);

		Image overlayIconImage = new Image(slingRequest.getResource(),"overlayIconImageSrc");
		this.overlayIconImageSrc = overlayIconImage.getSrc();
		this.overlayIconImageAlt = properties.get("overlayIconImageAlt", StringUtils.EMPTY);

		Image refIconImage = new Image(slingRequest.getResource(),"refIconImageSrc");
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

	public String getImageButtonPath() { return imageButtonPath; }

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