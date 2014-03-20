package com.australia.www.components.content.categorizediconlinks;

import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.widgets.DialogFieldSet;
import com.citytechinc.cq.component.annotations.widgets.Html5SmartImage;

public class TitleText {
    @DialogField(fieldLabel = "Title")
    private String title;

    @DialogField(fieldLabel = "Text")
    private String text;

    @DialogField(fieldLabel = "Icon image 1")
    @Html5SmartImage(name="iconImage1",disableZoom = true, allowUpload = false, tab = false, height = 100 )
    private String iconImage1;

    @DialogField(fieldLabel = "Icon Alt Text 1")
    private String iconAltText1;

    @DialogField(fieldLabel = "Link 1")
    private String iconLink1;

    @DialogField(fieldLabel = "Link Text 1")
    private String linkText1;

    @DialogField(fieldLabel = "Icon image 2")
    @Html5SmartImage(name="iconImage2",disableZoom = true, allowUpload = false, tab = false, height = 100 )
    private String iconImage2;

    @DialogField(fieldLabel = "Icon Alt Text 2")
    private String iconAltText2;

    @DialogField(fieldLabel = "Link 2")
    private String iconLink2;

    @DialogField(fieldLabel = "Link Text 2")
    private String linkText2;

    @DialogField(fieldLabel = "Icon image 3")
    @Html5SmartImage(name="iconImage3",disableZoom = true, allowUpload = false, tab = false, height = 100 )
    private String iconImage3;

    @DialogField(fieldLabel = "Icon Alt Text 3")
    private String iconAltText3;

    @DialogField(fieldLabel = "Link 3")
    private String iconLink3;

    @DialogField(fieldLabel = "Link Text 3")
    private String linkText3;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIconImage1() {
        return iconImage1;
    }

    public void setIconImage1(String iconImage1) {
        this.iconImage1 = iconImage1;
    }

    public String getIconAltText1() {
        return iconAltText1;
    }

    public void setIconAltText1(String iconAltText1) {
        this.iconAltText1 = iconAltText1;
    }

    public String getIconLink1() {
        return iconLink1;
    }

    public void setIconLink1(String iconLink1) {
        this.iconLink1 = iconLink1;
    }

    public String getLinkText1() {
        return linkText1;
    }

    public void setLinkText1(String linkText1) {
        this.linkText1 = linkText1;
    }

    public String getIconImage2() {
        return iconImage2;
    }

    public void setIconImage2(String iconImage2) {
        this.iconImage2 = iconImage2;
    }

    public String getIconAltText2() {
        return iconAltText2;
    }

    public void setIconAltText2(String iconAltText2) {
        this.iconAltText2 = iconAltText2;
    }

    public String getIconLink2() {
        return iconLink2;
    }

    public void setIconLink2(String iconLink2) {
        this.iconLink2 = iconLink2;
    }

    public String getLinkText2() {
        return linkText2;
    }

    public void setLinkText2(String linkText2) {
        this.linkText2 = linkText2;
    }

    public String getIconImage3() {
        return iconImage3;
    }

    public void setIconImage3(String iconImage3) {
        this.iconImage3 = iconImage3;
    }

    public String getIconAltText3() {
        return iconAltText3;
    }

    public void setIconAltText3(String iconAltText3) {
        this.iconAltText3 = iconAltText3;
    }

    public String getIconLink3() {
        return iconLink3;
    }

    public void setIconLink3(String iconLink3) {
        this.iconLink3 = iconLink3;
    }

    public String getLinkText3() {
        return linkText3;
    }

    public void setLinkText3(String linkText3) {
        this.linkText3 = linkText3;
    }
}
