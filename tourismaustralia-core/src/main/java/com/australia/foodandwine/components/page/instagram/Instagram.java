package com.australia.foodandwine.components.page.instagram;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.widgets.PathField;

@Component(group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", path = "page", value = "Instagram", editConfig = false, fileName = "instagram_dialog")
public class Instagram {

	@DialogField(fieldLabel = "Username", required = true)
	private String userName;

	@DialogField(fieldLabel = "Description", required = true)
	private String description;

	@DialogField(fieldLabel = "Post Link", required = true)
	@PathField(rootPath = "/content")
	private String postLink;

	public Instagram(SlingHttpServletRequest request) {
		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		if (properties != null) {
			this.userName = properties.get("userName", "");
			this.description = properties.get("description", "");
			this.postLink = properties.get("postLink", "");
		}
	}

	public String getUserName() {
		return userName;
	}

	public String getDescription() {
		return description;
	}

	public String getPostLink() {
		return postLink;
	}

}
