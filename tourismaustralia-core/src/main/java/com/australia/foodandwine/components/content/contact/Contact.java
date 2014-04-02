package com.australia.foodandwine.components.content.contact;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Listener;
import com.citytechinc.cq.component.annotations.widgets.DateField;
import com.citytechinc.cq.component.annotations.widgets.PathField;

@Component(group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", value = "Contact", listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class Contact {


	@DialogField(fieldLabel = "Title Text", required = true)
	private final String title;

	@DialogField(fieldLabel = "Contact text")
	private final String text;

	@DialogField(fieldLabel = "Logo Image Path" ,name="./imagePath", required = true)
	@PathField
	private final String imagePath;
	
	@DialogField(fieldLabel = "Icon text", required = true)
	private final String iconText;

	@DialogField(fieldLabel = "Additional text")
	private final String additionalText;

	public Contact(SlingHttpServletRequest request) {
		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		title = properties.get("title", "");
		text = properties.get("text", "");
		iconText = properties.get("iconText", "");
		imagePath = properties.get("imagePath",StringUtils.EMPTY);
		additionalText = properties.get("additionalText", "");
	}

	public String getTitle() {
		return title;
	}

	public String getText() {
		return text;
	}
	public String getIconText() {
		return iconText;
	}
	public String getImagePath() {
		return imagePath;
	}
	public String getAdditionalText() {
		return additionalText;
	}

}
