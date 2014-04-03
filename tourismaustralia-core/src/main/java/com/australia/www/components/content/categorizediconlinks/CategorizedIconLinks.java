package com.australia.www.components.content.categorizediconlinks;

import com.australia.utils.LinkUtils;
import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Listener;
import com.citytechinc.cq.component.annotations.Tab;
import com.citytechinc.cq.component.annotations.widgets.DialogFieldSet;
import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;


@Component(value = "Categorized Icon Links", disableTargeting = true, tabs = {@Tab(title = "Category 1"), @Tab(title = "Category 2"),
        @Tab(title = "Category 3")}, listeners = {@Listener(name = "aftercopy", value = "REFRESH_PAGE"),
        @Listener(name = "afterdelete", value = "REFRESH_PAGE"), @Listener(name = "afteredit", value = "REFRESH_PAGE"),
        @Listener(name = "afterinsert", value = "REFRESH_PAGE")})
public class CategorizedIconLinks {
    @DialogField(tab = 1)
    @DialogFieldSet(namePrefix = "title1/")
    private TitleText titleText1;

    @DialogField(tab = 2)
    @DialogFieldSet(namePrefix = "title2/")
    private TitleText titleText2;

    @DialogField(tab = 3)
    @DialogFieldSet(namePrefix = "title3/")
    private TitleText titleText3;

    public CategorizedIconLinks(SlingHttpServletRequest request) {
        ValueMap properties = request.getResource().adaptTo(ValueMap.class);
        titleText1 = new TitleText();
        titleText1.setTitle(properties.get("title1/title", StringUtils.EMPTY));
        titleText1.setText(properties.get("title1/text", StringUtils.EMPTY));
		titleText1.setIconImage1(properties.get("title1/iconImage1", StringUtils.EMPTY));
		titleText1.setIconLink1(LinkUtils.getHrefFromPath(properties.get("title1/iconLink1", StringUtils.EMPTY)));
        titleText1.setIconLink1IsExternal(LinkUtils.isExternal(properties.get("title1/iconLink1", StringUtils.EMPTY)));
		titleText1.setLinkText1(properties.get("title1/linkText1", StringUtils.EMPTY));
		titleText1.setIconAltText1(properties.get("title1/iconAltText1", StringUtils.EMPTY));
		titleText1.setIconImage2(properties.get("title1/iconImage2", StringUtils.EMPTY));
		titleText1.setIconLink2(LinkUtils.getHrefFromPath(properties.get("title1/iconLink2", StringUtils.EMPTY)));
        titleText1.setIconLink2IsExternal(LinkUtils.isExternal(properties.get("title1/iconLink2", StringUtils.EMPTY)));
		titleText1.setLinkText2(properties.get("title1/linkText2", StringUtils.EMPTY));
		titleText1.setIconAltText2(properties.get("title1/iconAltText2", StringUtils.EMPTY));
		titleText1.setIconImage3(properties.get("title1/iconImage3", StringUtils.EMPTY));
		titleText1.setIconLink3(LinkUtils.getHrefFromPath(properties.get("title1/iconLink3", StringUtils.EMPTY)));
        titleText1.setIconLink3IsExternal(LinkUtils.isExternal(properties.get("title1/iconLink3", StringUtils.EMPTY)));
		titleText1.setLinkText3(properties.get("title1/linkText3", StringUtils.EMPTY));
		titleText1.setIconAltText3(properties.get("title1/iconAltText3", StringUtils.EMPTY));

		titleText2 = new TitleText();
		titleText2.setTitle(properties.get("title2/title", StringUtils.EMPTY));
		titleText2.setText(properties.get("title2/text", StringUtils.EMPTY));
		titleText2.setIconImage1(properties.get("title2/iconImage1", StringUtils.EMPTY));
        titleText2.setIconLink1(LinkUtils.getHrefFromPath(properties.get("title2/iconLink1", StringUtils.EMPTY)));
        titleText2.setIconLink1IsExternal(LinkUtils.isExternal(properties.get("title2/iconLink1", StringUtils.EMPTY)));
		titleText2.setLinkText1(properties.get("title2/linkText1", StringUtils.EMPTY));
		titleText2.setIconAltText1(properties.get("title2/iconAltText1", StringUtils.EMPTY));
		titleText2.setIconImage2(properties.get("title2/iconImage2", StringUtils.EMPTY));
        titleText2.setIconLink2(LinkUtils.getHrefFromPath(properties.get("title2/iconLink2", StringUtils.EMPTY)));
        titleText2.setIconLink2IsExternal(LinkUtils.isExternal(properties.get("title2/iconLink2", StringUtils.EMPTY)));
		titleText2.setLinkText2(properties.get("title2/linkText2", StringUtils.EMPTY));
		titleText2.setIconAltText2(properties.get("title2/iconAltText2", StringUtils.EMPTY));
		titleText2.setIconImage3(properties.get("title2/iconImage3", StringUtils.EMPTY));
        titleText2.setIconLink3(LinkUtils.getHrefFromPath(properties.get("title2/iconLink3", StringUtils.EMPTY)));
        titleText2.setIconLink3IsExternal(LinkUtils.isExternal(properties.get("title2/iconLink3", StringUtils.EMPTY)));
		titleText2.setLinkText3(properties.get("title2/linkText3", StringUtils.EMPTY));
		titleText2.setIconAltText3(properties.get("title2/iconAltText3", StringUtils.EMPTY));

		titleText3 = new TitleText();
		titleText3.setTitle(properties.get("title3/title", StringUtils.EMPTY));
		titleText3.setText(properties.get("title3/text", StringUtils.EMPTY));
		titleText3.setIconImage1(properties.get("title3/iconImage1", StringUtils.EMPTY));
        titleText3.setIconLink1(LinkUtils.getHrefFromPath(properties.get("title3/iconLink1", StringUtils.EMPTY)));
        titleText3.setIconLink1IsExternal(LinkUtils.isExternal(properties.get("title3/iconLink1", StringUtils.EMPTY)));
		titleText3.setLinkText1(properties.get("title3/linkText1", StringUtils.EMPTY));
		titleText3.setIconAltText1(properties.get("title3/iconAltText1", StringUtils.EMPTY));
		titleText3.setIconImage2(properties.get("title3/iconImage2", StringUtils.EMPTY));
        titleText3.setIconLink2(LinkUtils.getHrefFromPath(properties.get("title3/iconLink2", StringUtils.EMPTY)));
        titleText3.setIconLink2IsExternal(LinkUtils.isExternal(properties.get("title3/iconLink2", StringUtils.EMPTY)));
		titleText3.setLinkText2(properties.get("title3/linkText2", StringUtils.EMPTY));
		titleText3.setIconAltText2(properties.get("title3/iconAltText2", StringUtils.EMPTY));
		titleText3.setIconImage3(properties.get("title3/iconImage3", StringUtils.EMPTY));
        titleText3.setIconLink3(LinkUtils.getHrefFromPath(properties.get("title3/iconLink3", StringUtils.EMPTY)));
        titleText3.setIconLink3IsExternal(LinkUtils.isExternal(properties.get("title3/iconLink3", StringUtils.EMPTY)));
		titleText3.setLinkText3(properties.get("title3/linkText3", StringUtils.EMPTY));
		titleText3.setIconAltText3(properties.get("title3/iconAltText3", StringUtils.EMPTY));
    }

    public TitleText getTitleText1() {
        return titleText1;
    }

    public TitleText getTitleText2() {
        return titleText2;
    }

    public TitleText getTitleText3() {
        return titleText3;
    }
}
