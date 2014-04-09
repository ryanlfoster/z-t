package com.australia.foodandwine.components.content.exploreBy;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Listener;
import com.citytechinc.cq.component.annotations.Tab;
import com.citytechinc.cq.component.annotations.widgets.Html5SmartImage;
import com.day.cq.wcm.foundation.Image;

@Component(value = "Explore By", group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", disableTargeting = true, tabs = {
	@Tab(title = "Image"), @Tab(title = "Properties") }, listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class ExploreBy {

	@DialogField(fieldLabel = "Top Text", tab = 2)
	private final String topText;

	@DialogField(fieldLabel = "Bottom Text", tab = 2)
	private final String bottomText;

	@DialogField(fieldLabel = "Image Path", tab = 1, required = true)
	@Html5SmartImage(allowUpload = false, name = "backgroundImage")
	private String imagePath;

	@DialogField(fieldLabel = "Image Alt Tag", tab = 2, required = true)
	private final String imageAltTag;

	public ExploreBy(SlingHttpServletRequest request) {
		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		Image image = new Image(request.getResource(), "backgroundImage");
		if (image != null && image.hasContent()) {
			imagePath = image.getPath();
		}
		topText = properties.get("topText", StringUtils.EMPTY);
		bottomText = properties.get("bottomText", StringUtils.EMPTY);
		imageAltTag = properties.get("imageAltTag", StringUtils.EMPTY);
	}

	public String getTopText() {
		return topText;
	}

	public String getBottomText() {
		return bottomText;
	}

	public String getImagePath() {
		return imagePath;
	}

	public String getImageAltTag() {
		return imageAltTag;
	}

}
