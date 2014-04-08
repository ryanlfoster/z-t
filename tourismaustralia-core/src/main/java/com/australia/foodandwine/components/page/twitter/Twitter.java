package com.australia.foodandwine.components.page.twitter;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.widgets.PathField;

@Component(group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", path = "page", value = "Twitter", editConfig = false, fileName = "twitter_dialog")
public class Twitter {

	@DialogField(fieldLabel = "Handle", required = true, fieldDescription = "Twitter handle e.g. @kimkardashian")
	private String userName;

	@DialogField(fieldLabel = "Tweet", required = true)
	private String tweet;

	@DialogField(fieldLabel = "Post Link", required = true)
	@PathField(rootPath = "/content")
	private String postLink;

	public Twitter(SlingHttpServletRequest request) {
		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		if (properties != null) {
			this.userName = properties.get("userName", "");
			this.tweet = properties.get("tweet", "");
			this.postLink = properties.get("postLink", "");
		}
	}

	public String getUserName() {
		return userName;
	}

	public String getTweet() {
		return tweet;
	}

	public String getPostLink() {
		return postLink;
	}

}
