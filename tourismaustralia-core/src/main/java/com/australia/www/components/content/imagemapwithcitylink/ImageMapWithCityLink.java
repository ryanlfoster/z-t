package com.australia.www.components.content.imagemapwithcitylink;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Listener;
import com.citytechinc.cq.component.annotations.Tab;
import com.citytechinc.cq.component.annotations.widgets.Html5SmartImage;
import com.citytechinc.cq.component.annotations.widgets.PathField;
import com.day.cq.wcm.foundation.Image;
import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;

/**
 * Created by wma on 28/03/2014.
 */

@Component(value = "Image Map with City Link", tabs = {@Tab(title = "Image"), @Tab(title = "Map Information")}, listeners = {@Listener(name = "aftercopy", value = "REFRESH_PAGE"),
        @Listener(name = "afterdelete", value = "REFRESH_PAGE"), @Listener(name = "afteredit", value = "REFRESH_PAGE"),
        @Listener(name = "afterinsert", value = "REFRESH_PAGE")})

public class ImageMapWithCityLink {
    @DialogField(fieldLabel = "Image", required = true, hideLabel = true, tab = 1)
    @Html5SmartImage(name = "image", disableZoom = true, allowUpload = false, tab = true)
    private String image;

    @DialogField(fieldLabel = "Alt Text", required = true, tab = 2)
    private String altText;

    @DialogField(fieldLabel = "Title", required = false, tab = 2)
    private String title;

    @DialogField(fieldLabel = "Link Text", required = false, tab = 2)
    private String linkText;

    @DialogField(required = false, tab = 2, fieldLabel = "Link")
    @PathField
    private final String link;

    public ImageMapWithCityLink(SlingHttpServletRequest request) {
        ValueMap properties = request.getResource().adaptTo(ValueMap.class);
        Image imageObj = new Image(request.getResource(), "image");
        if (imageObj != null && imageObj.hasContent()) {
            image = imageObj.getPath();
        }
        altText = properties.get("altText", StringUtils.EMPTY);
        title = properties.get("title", StringUtils.EMPTY);
        linkText = properties.get("linkText", StringUtils.EMPTY);
        link = properties.get("link", StringUtils.EMPTY);
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

    public String getLinkText() {
        return linkText;
    }

    public String getLink() {
        return link;
    }
}
