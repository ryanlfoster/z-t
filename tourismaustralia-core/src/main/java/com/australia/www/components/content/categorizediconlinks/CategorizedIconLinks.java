package com.australia.www.components.content.categorizediconlinks;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Tab;
import com.citytechinc.cq.component.annotations.widgets.DialogFieldSet;
import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;

@Component(value = "Categorized Icon Links", tabs = {@Tab(title = "Category 1"), @Tab(title = "Category 2"),
        @Tab(title = "Category 3")})
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
