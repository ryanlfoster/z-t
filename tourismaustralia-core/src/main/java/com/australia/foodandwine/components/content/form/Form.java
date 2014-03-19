package com.australia.foodandwine.components.content.form;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Listener;
import com.citytechinc.cq.component.annotations.widgets.PathField;

/**
 *
 */
@Component(group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", value = "Form", listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class Form {

	@DialogField(fieldLabel = "Email Template", name = "./emailTemplate")
	@PathField
	private final String emailTemplate;

	public Form(SlingHttpServletRequest request) {
		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		emailTemplate = properties.get("emailTemplate", "");
	}

	public String getEmailTemplate() {
		return emailTemplate;
	}

}
