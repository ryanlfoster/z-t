package com.australia.www.components.content.imageWithDate;

import com.citytechinc.cq.component.annotations.Tab;
import com.citytechinc.cq.component.annotations.widgets.*;
import com.citytechinc.cq.component.annotations.widgets.rte.Image;
import com.citytechinc.cq.component.annotations.widgets.RichTextEditor;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import org.omg.DynamicAny._DynFixedStub;

/**
 * Created by wma on 12/03/14.
 */
@Component(value = "Image with Date", tabs = {@Tab(title="Image"), @Tab(title="Extra Information")})
public class ImageWithDate {

    @DialogField(fieldLabel = "Image", required = true, hideLabel = true, tab = 1 )
    @Html5SmartImage(name="image",disableZoom = true, allowUpload = false, tab = true, height = 400 )
    private String image;

    @DialogField(fieldLabel = "Alt Text", required = true, tab = 2 )
    private String altText;

    @DialogField(fieldLabel = "Date", required = false, tab = 2 )
    @DateField( format = "M d", showToday = true)
    private String date;

    @DialogField(fieldLabel = "Title", required = false, tab = 2 )
    private String title;

    @DialogField(fieldLabel = "Text", required = false, tab = 2 )
    @RichTextEditor()
    private String text;

    public ImageWithDate(SlingHttpServletRequest request) {
        ValueMap properties = request.getResource().adaptTo(ValueMap.class);
        altText = properties.get("altText", "");
        date = properties.get("date", "");
        title = properties.get("title", "");
        text = properties.get("text", "");
        com.day.cq.wcm.foundation.Image imageObj = new com.day.cq.wcm.foundation.Image(request.getResource(),"image");
        image=imageObj.getSrc();
    }

    public String getImage() { return image; }

    public String getAltText() { return altText; }

    public String getDate() { return date; }

    public String getTitle() { return title; }

    public String getText() { return text; }

}
