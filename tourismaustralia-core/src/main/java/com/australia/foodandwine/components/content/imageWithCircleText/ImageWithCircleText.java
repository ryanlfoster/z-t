package com.australia.foodandwine.components.content.imageWithCircleText;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.FieldProperty;
import com.citytechinc.cq.component.annotations.Listener;
import com.citytechinc.cq.component.annotations.Tab;
import com.citytechinc.cq.component.annotations.widgets.Html5SmartImage;
import com.citytechinc.cq.component.annotations.widgets.TextArea;
import com.day.cq.wcm.foundation.Image;

@Component(disableTargeting = true, group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", value = "Image With Circle Text", tabs = {
	@Tab(title = "Background Image"), @Tab(title = "Properties") }, dialogHeight = 400, dialogWidth = 700, listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class ImageWithCircleText {
	@DialogField(fieldLabel = "Image Path", required = true, tab = 1)
	@Html5SmartImage(allowUpload = false, name = "backgroundImageCircleText")
	private String backGroundImage;

	@DialogField(fieldLabel = "Small Text", name = "./smallTitle", fieldDescription = "Maximum 50 character limit", additionalProperties = @FieldProperty(name = "maxLength", value = "50"), required = true, tab = 2)
	private final String smallTitle;

	@DialogField(fieldLabel = "Big Text", name = "./bigText", fieldDescription = "Maximum 50 character limit", additionalProperties = @FieldProperty(name = "maxLength", value = "50"), required = true, tab = 2)
	private final String bigText;

	@DialogField(fieldLabel = "Description", required = false, name = "./descriptionText", fieldDescription = "Maximum 500 character limit", additionalProperties = @FieldProperty(name = "maxLength", value = "500"), tab = 2)
	@TextArea
	private final String descriptionText;

	@DialogField(fieldLabel = "Image Alt Tag", name = "./imageAltTag", tab = 2, required = true)
	private final String imageAltTag;

	private static final String BACK_GROUND_IMAGE = "backgroundImageCircleText";
	private static final String SMALL_TITLE = "smallTitle";
	private static final String BIG_TEXT = "bigText";
	private static final String DESCRIPTION_TEXT = "descriptionText";
	private static final String IMAGE_ALT_TAG = "imageAltTag";

	public ImageWithCircleText(SlingHttpServletRequest request) {
		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		Image image = new Image(request.getResource(), BACK_GROUND_IMAGE);
		if (image != null && image.hasContent()) {
			backGroundImage = image.getPath();
		}
		smallTitle = properties.get(SMALL_TITLE, StringUtils.EMPTY);
		bigText = properties.get(BIG_TEXT, StringUtils.EMPTY);
		descriptionText = properties.get(DESCRIPTION_TEXT, StringUtils.EMPTY);
		imageAltTag = properties.get(IMAGE_ALT_TAG, StringUtils.EMPTY);
	}

	public String getBackGroundImage() {
		return backGroundImage;
	}

	public String getSmallTitle() {
		return smallTitle;
	}

	public String getDescriptionText() {
		return descriptionText;
	}

	public String getImageAltTag() {
		return imageAltTag;
	}

	public String getBigText() {
		return bigText;
	}
}
