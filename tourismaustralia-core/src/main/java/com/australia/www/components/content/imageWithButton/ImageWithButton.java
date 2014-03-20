package com.australia.www.components.content.imagewithbutton;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Tab;
import com.citytechinc.cq.component.annotations.widgets.Html5SmartImage;
import com.citytechinc.cq.component.annotations.widgets.PathField;
import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;
import com.day.cq.wcm.foundation.Image;

/**
 * Created by myeasmin on 18/03/14.
 *
 * This component is composed of 2 tabs - Image, and Additional Properties.
  */
@Component(value="Image With Button", tabs = {@Tab(title="Image"), @Tab(title="Additional Properties")})
public class ImageWithButton {

    @DialogField(required = true, tab = 1, hideLabel = true)
    @Html5SmartImage(height = 400, tab = true, name="imageSrc")
    private final String imageSrc;

    @DialogField(required = true, tab = 2, fieldLabel = "Image Alt Text")
    private final String imgAltText;

    @DialogField(required = true, tab = 2, fieldLabel = "Text")
    private final String text;

    @DialogField(tab = 2, fieldLabel = "Author Text")
    private final String authorText;

    @DialogField(tab = 2, fieldLabel = "Sub Text")
    private final String subText;

    @DialogField(required = true,  tab = 2, fieldLabel = "Button Text")
    private final String buttonText;

    @DialogField(required = true,  tab = 2, fieldLabel = "Button Path")
    @PathField
    private final String buttonPath;

	public ImageWithButton(SlingHttpServletRequest slingRequest) {
		ValueMap properties = slingRequest.getResource().adaptTo(ValueMap.class);
		Image image = new Image(slingRequest.getResource(),"imageSrc");
		this.imageSrc = image.getSrc();
		this.imgAltText = properties.get("imageAltText", StringUtils.EMPTY);
		this.text = properties.get("text", StringUtils.EMPTY);
		this.authorText = properties.get("authorText", StringUtils.EMPTY);
		this.subText = properties.get("subText", StringUtils.EMPTY);
		this.buttonPath = properties.get("buttonPath", StringUtils.EMPTY);
		this.buttonText = properties.get("buttonText", StringUtils.EMPTY);
	}

	public String getImageSrc() {
        return imageSrc;
    }

    public String getImgAltText() {
        return imgAltText;
    }

    public String getText() {
        return text;
    }

    public String getAuthorText() {
        return authorText;
    }

    public String getSubText() {
        return subText;
    }

    public String getButtonText() {
        return buttonText;
    }

    public String getButtonPath() { return buttonPath; }


}