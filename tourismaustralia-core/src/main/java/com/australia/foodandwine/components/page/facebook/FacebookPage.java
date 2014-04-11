package com.australia.foodandwine.components.page.facebook;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;

@Component(group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", path = "page", value = "Facebook", fileName = "facebook_dialog")
public class FacebookPage {

	@DialogField(fieldLabel = "Username")
	private String userName;

	@DialogField(fieldLabel = "Post text")
	private String postText;

	@DialogField(fieldLabel = "Post link")
	private String postLink;

	public FacebookPage(SlingHttpServletRequest request) {
		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		if (properties != null) {
			this.userName = properties.get("userName", "");
			this.postText = properties.get("postText", "");
			this.postLink = properties.get("postLink", "");
		}
	}

	public String getUserName() {
		return userName;
	}

	public String getPostText() {
		return postText;
	}

	public String getPostLink() {
		return postLink;
	}

}
