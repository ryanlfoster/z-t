package com.australia.www.components.content.imagewithbutton;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Option;
import com.citytechinc.cq.component.annotations.Tab;
import com.citytechinc.cq.component.annotations.widgets.Html5SmartImage;
import com.citytechinc.cq.component.annotations.widgets.PathField;
import com.citytechinc.cq.component.annotations.widgets.Selection;
import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;
import com.day.cq.wcm.foundation.Image;

/**
 * Created by myeasmin on 18/03/14.
 *
 * This component is composed of 3 tabs - Background Image, Image Icon, and Additional Properties.
  */
@Component(value="Image With Button", tabs = {@Tab(title="Background Image"), @Tab(title="Image Icon"), @Tab(title="Additional Properties")})
public class ImageWithButton {

	@DialogField(required = true, tab = 1, hideLabel = true)
	@Html5SmartImage(height = 400, tab = false, name="backgroundImageSrc")
	private final String backgroundImageSrc;

	@DialogField(tab = 2, hideLabel = true)
	@Html5SmartImage(height = 400, tab = false, name="iconImageSrc")
	private final String iconImageSrc;

    @DialogField(required = true, tab = 3, fieldLabel = "Image Alt Text")
    private final String imgAltText;

    @DialogField(required = true, tab = 3, fieldLabel = "Quote Text")
    private final String quoteText;

    @DialogField(tab = 3, fieldLabel = "Quote Author Text")
    private final String quoteAuthorText;

    @DialogField(tab = 3, fieldLabel = "Quote Sub Text")
    private final String quoteSubText;

	@DialogField(tab = 3, fieldLabel = "Quote Source Text")
	private final String quoteSourceText;

    @DialogField(tab = 3, fieldLabel = "Image Button Text")
    private final String imageButtonText;

    @DialogField(tab = 3, fieldLabel = "Image Button Path")
    @PathField
    private String imageButtonPath;

	@DialogField(tab = 3, fieldLabel = "Make Text White", fieldDescription = "Default text color is black")
	@Selection(type = Selection.CHECKBOX, options = @Option(value = "true"))
	private final boolean textWhite;


	public ImageWithButton(SlingHttpServletRequest slingRequest) {
		ValueMap properties = slingRequest.getResource().adaptTo(ValueMap.class);
		Image backgroundImage = new Image(slingRequest.getResource(),"backgroundImageSrc");
		this.backgroundImageSrc = backgroundImage.getSrc();
		Image iconImage = new Image(slingRequest.getResource(),"iconImageSrc");
		this.iconImageSrc = iconImage.getSrc();
		this.imgAltText = properties.get("imageAltText", StringUtils.EMPTY);
		this.quoteText = properties.get("quoteText", StringUtils.EMPTY);
		this.quoteAuthorText = properties.get("quoteAuthorText", StringUtils.EMPTY);
		this.quoteSubText = properties.get("quoteSubText", StringUtils.EMPTY);
		this.quoteSourceText = properties.get("quoteSourceText", StringUtils.EMPTY);
		this.imageButtonText = properties.get("imageButtonText", StringUtils.EMPTY);
		setImageButtonPath(properties.get("imageButtonPath", StringUtils.EMPTY));
		this.textWhite = properties.get("textWhite", false);
	}

	public String getBackgroundImageSrc() {
        return backgroundImageSrc;
    }

	public String getIconImageSrc() {
		return iconImageSrc;
	}
    public String getImgAltText() {
        return imgAltText;
    }

    public String getQuoteText() {
        return quoteText;
    }

    public String getQuoteAuthorText() {
        return quoteAuthorText;
    }

    public String getQuoteSubText() {
        return quoteSubText;
    }

	public String getQuoteSourceText() {
		return quoteSourceText;
	}

    public String getImageButtonText() {
        return imageButtonText;
    }

    public String getImageButtonPath() { return imageButtonPath; }

	public boolean isTextWhite() {
		return textWhite;
	}

	private void setImageButtonPath(String buttonPath) {
		if (!(StringUtils.isEmpty(buttonPath))) {
			imageButtonPath = buttonPath + ".html";
		} else {
			imageButtonPath = "";
		}
	}


}