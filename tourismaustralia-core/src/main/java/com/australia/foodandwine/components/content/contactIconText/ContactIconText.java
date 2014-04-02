package com.australia.foodandwine.components.content.contactIconText;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.FieldProperty;
import com.citytechinc.cq.component.annotations.Listener;
import com.citytechinc.cq.component.annotations.widgets.PathField;

@Component(disableTargeting = true, group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", value = "Contact Icon with Text", dialogHeight = 500, dialogWidth = 700, listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class ContactIconText {

	@DialogField(fieldLabel = "Icon", required = true, additionalProperties = @FieldProperty(name = "anchor", value = "100%"))
	@PathField(rootPath = "/content/dam")
	private final String icon;

	@DialogField(fieldLabel = "Title", required = true)
	private final String title;

	@DialogField(fieldLabel = "Text", required = true)
	private final String text;

	public ContactIconText(SlingHttpServletRequest request) {
		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		icon = properties.get("icon", StringUtils.EMPTY);
		title = properties.get("title", StringUtils.EMPTY);
		text = properties.get("text", StringUtils.EMPTY);
	}

	public String getIcon() {
		return icon;
	}

	public String getTitle() {
		return title;
	}

	public String getText() {
		return text;
	}

}
