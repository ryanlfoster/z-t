package com.australia.www.components.content.text;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.widgets.RichTextEditor;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;
import org.apache.commons.lang.StringUtils;

/**
 * Created by wma on 31/03/2014.
 */
@Component(value = "Text")
public class Text {
    @DialogField(fieldLabel = "Text", required = true)
    @RichTextEditor
    private String text;

    public Text(SlingHttpServletRequest request) {
        ValueMap properties = request.getResource().adaptTo(ValueMap.class);
        if (properties != null) {
            text = properties.get("text", StringUtils.EMPTY);
        }
    }

    public String getText() {
        return text;
    }
}
