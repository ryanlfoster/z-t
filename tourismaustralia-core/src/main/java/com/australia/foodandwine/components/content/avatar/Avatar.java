package com.australia.foodandwine.components.content.avatar;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Listener;
import com.citytechinc.cq.component.annotations.widgets.Html5SmartImage;
import com.day.cq.wcm.foundation.Image;

@Component(group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", value = "Avatar", listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class Avatar {
	@DialogField(fieldLabel = "Text for image caption", required = true)
	private String imageText;

	@DialogField(fieldLabel = "Avatar Image", required = true)
	@Html5SmartImage(tab = false, height = 400, allowUpload = false, name = "image")
	private String imagePath;

	public Avatar(SlingHttpServletRequest request) {
		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		if (properties != null) {
			imageText = properties.get("imageText", "");
			Image avatarImage = new Image(request.getResource(), "image");
			if (avatarImage != null && avatarImage.hasContent()) {
				imagePath = avatarImage.getSrc();
			}
		}
	}

	public String getImageText() {
		return imageText;
	}

	public String getImagePath() {
		return imagePath;
	}

}
