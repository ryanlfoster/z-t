package com.australia.foodandwine.components.content.taste;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;

import com.australia.utils.TagUtils;
import com.day.cq.commons.jcr.JcrConstants;
import com.day.cq.tagging.Tag;
import com.day.cq.tagging.TagManager;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.foundation.Image;

public class Experience {
	private final String imageTitle;
	private final String imagePath;
	private final String city;
	private final String state;
	private final String[] tags;
	private final String icon;

	public Experience(Page page, TagManager tagManager) {
		ValueMap properties = page.getProperties();
		Resource jcrResource = page.adaptTo(Resource.class).getChild(JcrConstants.JCR_CONTENT);
		Image image = new Image(jcrResource, "image");
		if (image != null && image.hasContent()) {
			imagePath = image.getPath() + ".img.jpg";
		} else {
			imagePath = "";
		}
		// icon
		icon = properties.get("categoryLogoPath", String.class);
		// title
		imageTitle = page.getTitle();
		// tags
		String[] cattags = properties.get("cq:tags", new String[0]);
		List<String> tagTitles = new ArrayList<String>();
		for (Tag tag : TagUtils.getFoodAndWineCategoryTags(tagManager, cattags)) {
			tagTitles.add(tag.getTitle());
		}
		tags = tagTitles.toArray(new String[0]);
		// state
		Tag stateTag = TagUtils.getStateTag(tagManager, tags);
		state = (stateTag != null ? stateTag.getTitle() : StringUtils.EMPTY);
		// city
		Tag cityTag = TagUtils.getCityTag(tagManager, tags);
		city = (cityTag != null ? cityTag.getTitle() : StringUtils.EMPTY);
	}

	public String getImagePath() {
		return imagePath;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String[] getTags() {
		return tags;
	}

	public String getIcon() {
		return icon;
	}

	public String getImageTitle() {
		return imageTitle;
	}

}
