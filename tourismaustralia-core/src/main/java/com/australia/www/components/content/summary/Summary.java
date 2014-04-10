package com.australia.www.components.content.summary;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.widgets.RichTextEditor;

/**
 * Created by wma on 31/03/2014.
 */
@Component(value = "Summary")
public class Summary {
	@DialogField(fieldLabel = "Text", required = true)
	@RichTextEditor
	private String text;

	public Summary(SlingHttpServletRequest request) {
		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		if (properties != null) {
			text = properties.get("text", StringUtils.EMPTY);
		}
	}

	public String getText() {
		return text;
	}
}
