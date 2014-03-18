package com.australia.www.components.content.categorizediconlinks;

import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.widgets.DialogFieldSet;

public class TitleText {
    @DialogField(fieldLabel = "Title")
    private String title;

    @DialogField(fieldLabel = "Text")
    private String text;

    @DialogField(fieldLabel = "Icon Text 1")
    private String iconText1;

    @DialogField(fieldLabel = "Icon Text 2")
    private String iconText2;

    @DialogField(fieldLabel = "Icon Text 3")
    private String iconText3;

    public String getIconText1() {
        return iconText1;
    }

    public void setIconText1(String iconText1) {
        this.iconText1 = iconText1;
    }

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
}
