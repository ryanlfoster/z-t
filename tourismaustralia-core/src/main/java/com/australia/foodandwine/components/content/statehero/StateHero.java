package com.australia.foodandwine.components.content.statehero;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Listener;
import com.citytechinc.cq.component.annotations.Tab;
import com.citytechinc.cq.component.annotations.widgets.Html5SmartImage;
import com.day.cq.wcm.foundation.Image;

@Component(disableTargeting = true, group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", value = "State Hero", tabs = {
	@Tab(title = "Background Image"), @Tab(title = "Big Title") }, listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class StateHero {

	@DialogField(fieldLabel = "Image Path", required = true, tab = 1)
	@Html5SmartImage(allowUpload = false, name = "backgroundImage")
	private String imagePath;

	@DialogField(fieldLabel = "Image Alt Tag", tab = 2, fieldDescription = "Image Alt tag for the Background Image", required = true)
	private String imageAltTag;

	@DialogField(fieldLabel = "Top Small Text", tab = 2)
	private String topText;

	@DialogField(fieldLabel = "Center Text", tab = 2)
	private String centerText;

	@DialogField(fieldLabel = "Bottom Small Text", tab = 2)
	private String bottomText;
	/**
	 * Constants
	 */
	private static final String IMAGE_ALT_TAG = "imageAltTag";
	private static final String TOPTEXT = "topText";
	private static final String CENTERTEXT = "centerText";
	private static final String BOTTOMTEXT = "bottomText";

	public StateHero(SlingHttpServletRequest request) {
		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		if (properties != null) {
			Image backgroundImage = new Image(request.getResource(), "backgroundImage");
			if (backgroundImage != null && backgroundImage.hasContent()) {
				imagePath = backgroundImage.getPath();
			}
			imageAltTag = properties.get(IMAGE_ALT_TAG, StringUtils.EMPTY);
			topText = properties.get(TOPTEXT, StringUtils.EMPTY);
			centerText = properties.get(CENTERTEXT, StringUtils.EMPTY);
			bottomText = properties.get(BOTTOMTEXT, StringUtils.EMPTY);

		}
	}

	/**
	 * @return
	 */
	public String getImagePath() {
		return imagePath;
	}

	public String getImageAltTag() {
		return imageAltTag;
	}

	public String getTopText() {
		return topText;
	}

	public String getCenterText() {
		return centerText;
	}

	public String getBottomText() {
		return bottomText;
	}

}
