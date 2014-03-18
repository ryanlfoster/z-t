package com.australia.www.components.content.imageWithButton;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Tab;
import com.citytechinc.cq.component.annotations.widgets.DialogFieldSet;
import com.citytechinc.cq.component.annotations.widgets.Html5SmartImage;
import com.citytechinc.cq.component.annotations.widgets.PathField;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;
import com.day.cq.wcm.foundation.Image;

/**
 * Created by myeasmin on 18/03/14.
 * This component is composed of 2 tabs - Image, and Text and Button.
 */
@Component(value="Image With Button", tabs = {@Tab(title="Image"), @Tab(title="Text and Button")})
public class ImageWithButton {

    @DialogField(required = true, tab =1, fieldLabel = "Image Src", name = "./imageSrc")
    @Html5SmartImage(height = 400)
    private String imageSrc;

    @DialogField(required = true, tab = 1, fieldLabel = "Image ALt Text", name ="./imageAltText")
    private String imgAltText;

    @DialogField(required = true, tab = 2, fieldLabel = "Text", name = "./text")
    private String text;

    @DialogField(tab = 2, fieldLabel = "Author Text", name = "./authorText")
    private String authorText;

    @DialogField(tab = 2, fieldLabel = "Sub Text", name = "./subText")
    private String subText;

    @DialogField(required = true,  tab = 2, fieldLabel = "Button Text", name = "./buttonText")
    private String buttonText;

    @DialogField(required = true,  tab = 2, fieldLabel = "Button Path", name = "./buttonPath")
    @PathField
    private String buttonPath;

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }

    public String getImgAltText() {
        return imgAltText;
    }

    public void setImgAltText(String imgAltText) {
        this.imgAltText = imgAltText;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthorText() {
        return authorText;
    }

    public void setAuthorText(String authorText) {
        this.authorText = authorText;
    }

    public String getSubText() {
        return subText;
    }

    public void setSubText(String subText) {
        this.subText = subText;
    }

    public String getButtonText() {
        return buttonText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    public String getButtonPath() {
        return buttonPath;
    }

    public void setButtonPath(String buttonPath) {
        this.buttonPath = buttonPath;
    }

    public ImageWithButton(SlingHttpServletRequest slingRequest) {
        ValueMap properties = slingRequest.getResource().adaptTo(ValueMap.class);
        setImgAltText(properties.get("imageAltText", ""));
        Image image = new Image(slingRequest.getResource(), "image");
        setImageSrc(image.getSrc());
        setText(properties.get("text", ""));
        setAuthorText(properties.get("authorText", ""));
        setSubText(properties.get("subText", ""));
        setButtonPath(properties.get("buttonPath", ""));
        setButtonText(properties.get("buttonText", ""));
    }
}