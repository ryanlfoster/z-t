package com.australia.www.components.content.noticeBar;

import com.australia.utils.LinkUtils;
import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.FieldProperty;
import com.citytechinc.cq.component.annotations.Listener;
import com.citytechinc.cq.component.annotations.widgets.PathField;
import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;

/**
 * Created by wma on 8/05/2014.
 */

@Component(value = "Notice Bar",  dialogWidth = 500, disableTargeting = true, group = ".hidden", listeners = { @Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"), @Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })

public class NoticeBar {
    @DialogField(fieldLabel = "Title", required = false)
    private String title;

    @DialogField(fieldLabel = "Summary", required = false)
    private String text;

    @DialogField(fieldLabel = "Link text", required = false)
    private String linkText;

    @DialogField(fieldLabel = "Link Path", required = false)
    @PathField(rootPath = "/content")
    private String linkPath;

    private boolean isExternal;

    public NoticeBar(SlingHttpServletRequest request) {
        ValueMap properties = request.getResource().adaptTo(ValueMap.class);
        if (properties != null) {
            title = properties.get("title", StringUtils.EMPTY);
            text = properties.get("text", StringUtils.EMPTY);
            linkText = properties.get("linkText", StringUtils.EMPTY);
            linkPath = LinkUtils.getHrefFromPath(properties.get("linkPath", StringUtils.EMPTY));
            isExternal = LinkUtils.isExternal(properties.get("linkPath", StringUtils.EMPTY));
        }
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String getLinkText() {
        return linkText;
    }

    public String getLinkPath() {
        return linkPath;
    }

    public boolean getIsExternal() {
        return isExternal;
    }
}
