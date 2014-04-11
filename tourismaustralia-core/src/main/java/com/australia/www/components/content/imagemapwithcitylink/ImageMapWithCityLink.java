package com.australia.www.components.content.imagemapwithcitylink;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;

import com.australia.utils.LinkUtils;
import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Listener;
import com.citytechinc.cq.component.annotations.Tab;
import com.citytechinc.cq.component.annotations.widgets.Html5SmartImage;
import com.citytechinc.cq.component.annotations.widgets.PathField;
import com.day.cq.wcm.foundation.Image;

/**
 * Created by wma on 28/03/2014.
 */

@Component(value = "Image Map with City Link", disableTargeting = true, tabs = {@Tab(title = "Image"),
        @Tab(title = "Map Information")}, listeners = {@Listener(name = "aftercopy", value = "REFRESH_PAGE"),
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

    @DialogField(fieldLabel = "Link", fieldDescription = "For external links please use prefix http:// or https:// (eg. http://www.google.com)", required = false, tab = 2)
    @PathField
    private String link;

    private boolean linkIsExternal;

    public ImageMapWithCityLink(SlingHttpServletRequest request) {
        ValueMap properties = request.getResource().adaptTo(ValueMap.class);
        Image imageObj = new Image(request.getResource(), "image");
        if (imageObj != null && imageObj.hasContent()) {
            image = imageObj.getPath();
        }
        if (properties != null) {
            altText = properties.get("altText", StringUtils.EMPTY);
            title = properties.get("title", StringUtils.EMPTY);
            linkText = properties.get("linkText", StringUtils.EMPTY);
            link = LinkUtils.getHrefFromPath(properties.get("link", StringUtils.EMPTY));
            linkIsExternal = LinkUtils.isExternal(properties.get("link", StringUtils.EMPTY));
        }
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

    public boolean getLinkIsExternal() {
        return linkIsExternal;
    }
}
