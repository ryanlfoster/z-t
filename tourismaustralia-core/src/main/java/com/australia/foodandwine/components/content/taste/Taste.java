package com.australia.foodandwine.components.content.taste;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Listener;
import com.citytechinc.cq.component.annotations.Tab;
import com.citytechinc.cq.component.annotations.widgets.Html5SmartImage;
import com.citytechinc.cq.component.annotations.widgets.PathField;
import com.day.cq.tagging.TagManager;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.day.cq.wcm.foundation.Image;

@Component(value = "A Taste Of", group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", dialogHeight = 500, disableTargeting = true, tabs = {
	@Tab(title = "Image"), @Tab(title = "Properties") }, listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class Taste {

	@DialogField(fieldLabel = "Title", tab = 2)
	private final String title;

	@DialogField(fieldLabel = "Description", tab = 2)
	private final String description;

	@DialogField(fieldLabel = "Image Path", required = true, tab = 1)
	@Html5SmartImage(allowUpload = false, name = "mosaicImage")
	private String imagePath;

	@DialogField(fieldLabel = "Image Text", tab = 2)
	private final String imageTitle;

	@DialogField(fieldLabel = "Image Subscript", tab = 2)
	private final String imageSubscript;

	@DialogField(fieldLabel = "Image Alt Tag", required = true, tab = 2)
	private final String imageAltTag;

	@DialogField(fieldLabel = "Upper Left Link", required = true, tab = 2)
	@PathField(rootPath = "/content")
	private final String upperLeftLink;

	@DialogField(fieldLabel = "Upper Right Link", required = true, tab = 2)
	@PathField(rootPath = "/content")
	private final String upperRightLink;

	@DialogField(fieldLabel = "Lower Left Link", required = true, tab = 2)
	@PathField(rootPath = "/content")
	private final String lowerLeftLink;

	@DialogField(fieldLabel = "Lower Right Link", required = true, tab = 2)
	@PathField(rootPath = "/content")
	private final String lowerRightLink;

	private Experience upperLeftExperience;
	private Experience upperRightExperience;
	private Experience lowerLeftExperience;
	private Experience lowerRightExperience;

	public Taste(SlingHttpServletRequest request) {
		PageManager pageManager = request.getResourceResolver().adaptTo(PageManager.class);
		TagManager tagManager = request.getResourceResolver().adaptTo(TagManager.class);
		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		Image image = new Image(request.getResource(), "mosaicImage");
		if (image != null && image.hasContent()) {
			imagePath = image.getPath() + ".img.jpg";
		}
		title = properties.get("title", StringUtils.EMPTY);
		description = properties.get("description", StringUtils.EMPTY);
		imageTitle = properties.get("imageTitle", StringUtils.EMPTY);
		imageSubscript = properties.get("imageSubscript", StringUtils.EMPTY);
		imageAltTag = properties.get("imageAltTag", StringUtils.EMPTY);
		// four mosaic tiles links to other pages
		upperLeftLink = properties.get("upperLeftLink", StringUtils.EMPTY);
		Page page = pageManager.getPage(upperLeftLink);
		if (page != null) {
			upperLeftExperience = new Experience(page, tagManager);
		}
		upperRightLink = properties.get("upperRightLink", StringUtils.EMPTY);
		page = pageManager.getPage(upperRightLink);
		if (page != null) {
			upperRightExperience = new Experience(page, tagManager);
		}
		lowerLeftLink = properties.get("lowerLeftLink", StringUtils.EMPTY);
		page = pageManager.getPage(lowerLeftLink);
		if (page != null) {
			lowerLeftExperience = new Experience(page, tagManager);
		}
		lowerRightLink = properties.get("lowerRightLink", StringUtils.EMPTY);
		page = pageManager.getPage(lowerRightLink);
		if (page != null) {
			lowerRightExperience = new Experience(page, tagManager);
		}
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getImagePath() {
		return imagePath;
	}

	public String getImageAltTag() {
		return imageAltTag;
	}

	public String getUpperLeftLink() {
		return upperLeftLink;
	}

	public String getUpperRightLink() {
		return upperRightLink;
	}

	public String getLowerLeftLink() {
		return lowerLeftLink;
	}

	public String getLowerRightLink() {
		return lowerRightLink;
	}

	public String getImageTitle() {
		return imageTitle;
	}

	public String getImageSubscript() {
		return imageSubscript;
	}

	public Experience getUpperLeftExperience() {
		return upperLeftExperience;
	}

	public Experience getUpperRightExperience() {
		return upperRightExperience;
	}

	public Experience getLowerLeftExperience() {
		return lowerLeftExperience;
	}

	public Experience getLowerRightExperience() {
		return lowerRightExperience;
	}

}
