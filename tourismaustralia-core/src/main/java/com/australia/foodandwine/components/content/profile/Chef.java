package com.australia.foodandwine.components.content.profile;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Listener;
import com.citytechinc.cq.component.annotations.widgets.DateField;
import com.citytechinc.cq.component.annotations.widgets.PathField;

@Component(group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", value = "Chef Profile", listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class Chef {


	@DialogField(fieldLabel = "Title", required = true)
	private final String title;

	@DialogField(fieldLabel = "Chef Profile Image Path" ,name="./imagePath")
	@PathField
	private final String imagePath;
	
	@DialogField(fieldLabel = "Text for image caption")
	private final String imageText;

	@DialogField(fieldLabel = "Content", required = true)
	private final String content;

	public Chef(SlingHttpServletRequest request) {
		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		title = properties.get("title", "");
		imageText = properties.get("imageText", "");
		imagePath = properties.get("imagePath",StringUtils.EMPTY);
		content = properties.get("content", "");
	}

	public String getTitle() {
		return title;
	}

	public String getImageText() {
		return imageText;
	}
	public String getImagePath() {
		return imagePath;
	}
	public String getContent() {
		return content;
	}

}
