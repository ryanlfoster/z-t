package com.australia.foodandwine.components.content.text;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Listener;
import com.citytechinc.cq.component.annotations.widgets.RichTextEditor;
import com.citytechinc.cq.component.annotations.widgets.rte.Format;
import com.citytechinc.cq.component.annotations.widgets.rte.Justify;
import com.citytechinc.cq.component.annotations.widgets.rte.Lists;
import com.citytechinc.cq.component.annotations.widgets.rte.ParaFormat;
import com.citytechinc.cq.component.annotations.widgets.rte.ParaFormatFormat;
import com.citytechinc.cq.component.annotations.widgets.rte.Style;
import com.citytechinc.cq.component.annotations.widgets.rte.Styles;

@Component(disableTargeting = true, group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", value = "Text", listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class Text {
	@DialogField(fieldLabel = "Text content")
	@RichTextEditor(lists = @Lists(indent = false, ordered = false, outdent = false, unordered = false), justify = @Justify(justifycenter = false, justifyleft = false, justifyright = false), styles = @Styles(styles = @Style(cssName = "form-thank-you-small-print", text = "Small print")), format = @Format(bold = true, underline = true, italic = false), paraformat = @ParaFormat(formats = {
		@ParaFormatFormat(description = "Paragraph", tag = "p"),
		@ParaFormatFormat(description = "Heading 3", tag = "h3") }))
	private String textContent;

	public Text(SlingHttpServletRequest request) {
		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		if (properties != null)
			textContent = properties.get("textContent", "");
	}

	public String getTextContent() {
		return textContent;
	}

}
