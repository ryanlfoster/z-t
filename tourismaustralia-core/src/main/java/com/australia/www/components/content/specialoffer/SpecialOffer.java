package com.australia.www.components.content.specialoffer;

import com.australia.utils.LinkUtils;
import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Listener;
import com.citytechinc.cq.component.annotations.Tab;
import com.citytechinc.cq.component.annotations.widgets.Html5SmartImage;
import com.citytechinc.cq.component.annotations.widgets.NumberField;
import com.citytechinc.cq.component.annotations.widgets.PathField;
import com.day.cq.wcm.foundation.Image;
import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;

import java.util.Locale;

@Component(value = "Special Offer", disableTargeting = true, tabs = {@Tab(title = "Image"), @Tab(title = "Extra Information")}, listeners = {@Listener(name = "aftercopy", value = "REFRESH_PAGE"),
        @Listener(name = "afterdelete", value = "REFRESH_PAGE"), @Listener(name = "afteredit", value = "REFRESH_PAGE"),
        @Listener(name = "afterinsert", value = "REFRESH_PAGE")})
public class SpecialOffer {

    @DialogField(fieldLabel = "Image", required = true, hideLabel = true, tab = 1)
    @Html5SmartImage(name = "image", disableZoom = true, allowUpload = false, tab = true)
    private String image;

    @DialogField(fieldLabel = "Alt Text", required = true, tab = 2)
    private String altText;

    @DialogField(fieldLabel = "Title", required = false, tab = 2)
    private String title;

    @DialogField(fieldLabel = "Text", required = false, tab = 2)
    private String text;

    @DialogField(fieldLabel = "Price", required = false, tab = 2)
    @NumberField(allowDecimals = false, allowNegative = false)
    private int price;

    private String formattedPrice;

    @DialogField(fieldLabel = "Price per text", required = false, tab = 2)
    private String pricePerText;

    @DialogField(fieldLabel = "View More Information Link", fieldDescription = "For external links please use prefix http:// or https:// (eg. http://www.google.com)", required = false, tab = 2)
    @PathField
    private final String viewMoreInformationLink;

    private boolean viewMoreInformationLinkIsExternal;

    @DialogField(fieldLabel = "View Terms and condition Link", fieldDescription = "For external links please use prefix http:// or https:// (eg. http://www.google.com)",  required = false, tab = 2)
    @PathField
    private final String viewTermsAndConditionLink;

    private boolean viewTermsAndConditionLinkIsExternal;

    public SpecialOffer(SlingHttpServletRequest request) {
        ValueMap properties = request.getResource().adaptTo(ValueMap.class);
        Image imageObj = new Image(request.getResource(), "image");
        if (imageObj != null && imageObj.hasContent()) {
            image = imageObj.getPath();
        }
        altText = properties.get("altText", StringUtils.EMPTY);
        title = properties.get("title", StringUtils.EMPTY);
        text = properties.get("text", StringUtils.EMPTY);
        price = properties.get("price", 0);
        formattedPrice = java.text.NumberFormat.getNumberInstance(Locale.US).format(price);
        pricePerText = properties.get("pricePerText", StringUtils.EMPTY);
        viewMoreInformationLink = LinkUtils.getHrefFromPath(properties.get("viewMoreInformationLink", StringUtils.EMPTY));
        viewMoreInformationLinkIsExternal = LinkUtils.isExternal(properties.get("viewMoreInformationLink", StringUtils.EMPTY));
        viewTermsAndConditionLink = LinkUtils.getHrefFromPath(properties.get("viewTermsAndConditionLink", StringUtils.EMPTY));
        viewTermsAndConditionLinkIsExternal = LinkUtils.isExternal(properties.get("viewTermsAndConditionLink", StringUtils.EMPTY));
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

    public String getText() {
        return text;
    }

    public int getPrice() {

        return price;
    }

    public String getFormattedPrice() { return formattedPrice; }

    public String getPricePerText() {
        return pricePerText;
    }

    public String getViewMoreInformationLink() {
        return viewMoreInformationLink;
    }

    public boolean getViewMoreInformationLinkIsExternal() { return viewMoreInformationLinkIsExternal; }

    public String getViewTermsAndConditionLink() {
        return viewTermsAndConditionLink;
    }

    public boolean getViewTermsAndConditionLinkIsExternal() { return viewTermsAndConditionLinkIsExternal; }
}
