package com.australia.foodandwine.components.content.text;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Listener;
import com.citytechinc.cq.component.annotations.Option;
import com.citytechinc.cq.component.annotations.widgets.Selection;
import com.citytechinc.cq.component.annotations.widgets.TextArea;

@Component(group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", value = "Text", listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class Text {
	@DialogField(fieldLabel = "Text or paragraph", name = "./texts")
	@TextArea
	private String text;
	@DialogField(fieldLabel = "Select style")
	@Selection(type = Selection.SELECT, options = { @Option(value = "large", text = "Form Large Text"),
		@Option(value = "small", text = "Form Small Text"),
		@Option(value = "articlesmall", text = "Article Small Text"),
		@Option(value = "articlelarge", text = "Article Large Text")

	})
	private String textStyle;

	public Text(SlingHttpServletRequest request) {
		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		if (properties != null) {
			text = properties.get("texts", "");
			textStyle = properties.get("textStyle", "");
		}
	}

	public String getTextStyle() {
		return textStyle;
	}

	public String getText() {
		return text;
	}

}
