package com.australia.foodandwine.components.content.imageWithCircleText;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;

import com.australia.utils.TagUtils;
import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.FieldProperty;
import com.citytechinc.cq.component.annotations.Listener;
import com.citytechinc.cq.component.annotations.Tab;
import com.citytechinc.cq.component.annotations.widgets.Html5SmartImage;
import com.citytechinc.cq.component.annotations.widgets.TextArea;
import com.day.cq.tagging.Tag;
import com.day.cq.tagging.TagManager;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.day.cq.wcm.foundation.Image;

@Component(disableTargeting = true, group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", value = "Image With Circle Text", tabs = {
	@Tab(title = "Background Image"), @Tab(title = "Properties") }, dialogHeight = 400, dialogWidth = 700, listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class ImageWithCircleText {
	@DialogField(fieldLabel = "Image Path", required = true, tab = 1)
	@Html5SmartImage(allowUpload = false, name = "backgroundImageCircleText")
	private String backGroundImage;

	@DialogField(fieldLabel = "Small Title", name = "./smallTitle", additionalProperties = @FieldProperty(name = "maxLength", value = "50"), required = true, tab = 2)
	private final String smallTitle;

	@DialogField(fieldLabel = "Circle Description Text", required = true, name = "./descriptionText", additionalProperties = @FieldProperty(name = "maxLength", value = "500"), tab = 2)
	@TextArea
	private final String descriptionText;

	@DialogField(fieldLabel = "Image Alt Tag", name = "./imageAltTag", tab = 2)
	private final String imageAltTag;

	private String stateTitle;

	private static final String BACK_GROUND_IMAGE = "backgroundImageCircleText";
	private static final String SMALL_TITLE = "smallTitle";
	private static final String DESCRIPTION_TEXT = "descriptionText";
	private static final String IMAGE_ALT_TAG = "imageAltTag";
	private static final String CQ_TAGS = "cq:tags";

	public ImageWithCircleText(SlingHttpServletRequest request) {

		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		Image image = new Image(request.getResource(), BACK_GROUND_IMAGE);
		if (image != null && image.hasContent()) {
			backGroundImage = image.getPath();
		}
		smallTitle = properties.get(SMALL_TITLE, StringUtils.EMPTY);
		descriptionText = properties.get(DESCRIPTION_TEXT, StringUtils.EMPTY);
		imageAltTag = properties.get(IMAGE_ALT_TAG, StringUtils.EMPTY);

		getStateTitleByTags(request);

	}

	private void getStateTitleByTags(SlingHttpServletRequest request) {
		PageManager pageManager = request.getResourceResolver().adaptTo(PageManager.class);
		Page currentPage = pageManager.getContainingPage(request.getResource());
		String[] pageTags = currentPage.getProperties().get(CQ_TAGS, new String[0]);
		TagManager tagManager = request.getResourceResolver().adaptTo(TagManager.class);
		Tag stateTag = TagUtils.getStateTag(tagManager, pageTags);
		if (stateTag != null) {
			stateTitle = stateTag.getTitle();
		}
	}

	public String getStateTitle() {
		return stateTitle;
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
}
