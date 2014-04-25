package com.australia.foodandwine.searchresults.domain;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;

import com.australia.utils.LinkUtils;
import com.australia.utils.TagUtils;
import com.day.cq.commons.jcr.JcrConstants;
import com.day.cq.tagging.Tag;
import com.day.cq.tagging.TagManager;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.foundation.Image;

public class FAWSearch {
	private final String title;
	private final String imagePath;
	private final String city;
	private final String state;
	// private final String[] tags;
	private final String icon;
	private final String primaryCategory;
	private final String link;
	private final String pageDescription;
	private final long totalSearchCount;
	private String templateName;
	private String userName;
	private String messagePosts;
	private String postLink=StringUtils.EMPTY;
	private String linkChecker;
	private String socialIconsWhite;
	private String socialIconsBlack;

	public FAWSearch(long totalSearchCount, Page page, TagManager tagManager) {
		ValueMap properties = page.getProperties();
		Resource jcrResource = page.adaptTo(Resource.class).getChild(JcrConstants.JCR_CONTENT);
		Image image = new Image(jcrResource, "image");
		if (image != null && image.hasContent()) {
			imagePath = image.getPath() + ".img.jpg";
		} else {
			imagePath = "";
		}
		link = LinkUtils.getHrefFromPath(page.getPath());
		// icon
		icon = properties.get("categoryLogoPath", String.class);
		// description
		pageDescription = properties.get(JcrConstants.JCR_DESCRIPTION, String.class);
		// title
		title = page.getTitle();
		// tags
		String[] cattags = properties.get("cq:tags", new String[0]);
		List<String> tagTitles = new ArrayList<String>();
		for (Tag tag : TagUtils.getFoodAndWineCategoryTags(tagManager, cattags)) {
			tagTitles.add(tag.getTitle());
		}
		// tags = tagTitles.toArray(new String[0]);
		// state
		Tag stateTag = TagUtils.getStateTag(tagManager, cattags);
		state = (stateTag != null ? stateTag.getTitle() : StringUtils.EMPTY);
		// city
		Tag cityTag = TagUtils.getCityTag(tagManager, cattags);
		city = (cityTag != null ? cityTag.getTitle() : StringUtils.EMPTY);
		Tag primaryCategoryTag = TagUtils.getFoodAndWinePrimaryCategory(tagManager, cattags);
		primaryCategory = (primaryCategoryTag != null ? primaryCategoryTag.getTitle() : StringUtils.EMPTY);
		templateName = page.getTemplate().getName();

		if (templateName.equals("facebookpage")) {
			templateName = templateName.replace("page", "");
			userName = properties.get("userName", "");
			messagePosts = properties.get("postText", "");
			postLink = LinkUtils.getHrefFromPath(properties.get("postLink", ""));
			socialIconsWhite = "/etc/designs/foodandwine/clientlibs/imgs/base/share/share-fb-white.png";
			socialIconsBlack = "/etc/designs/foodandwine/clientlibs/imgs/base/share/share-fb-black.png";
		}
		if (templateName.equals("twitterpage")) {
			templateName = templateName.replace("page", "");
			userName = properties.get("userName", "");
			messagePosts = properties.get("tweet", "");
			postLink = LinkUtils.getHrefFromPath(properties.get("postLink", ""));
			socialIconsWhite = "/etc/designs/foodandwine/clientlibs/imgs/base/share/share-twitter-white.png";
			socialIconsBlack = "/etc/designs/foodandwine/clientlibs/imgs/base/share/share-twitter-black.png";
		}
		if (templateName.equals("instagrampage")) {
			templateName = templateName.replace("page", "");
			userName = properties.get("userName", "");
			messagePosts = properties.get("description", "");
			postLink = LinkUtils.getHrefFromPath(properties.get("postLink", ""));
			socialIconsWhite = "/etc/designs/foodandwine/clientlibs/imgs/base/share/share-instagram-white.png";
			socialIconsBlack = "/etc/designs/foodandwine/clientlibs/imgs/base/share/share-instagram-black.png";
		}
		if (templateName.equals("articlepage")) {
			templateName = null;
		}
		if (postLink.endsWith(".html")) {
			linkChecker = "true";
		} else {
			linkChecker = null;
		}
		this.totalSearchCount = totalSearchCount;

	}

	public String getLinkChecker() {
		return linkChecker;
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

	// public String[] getTags() {
	// return tags;
	// }

	public String getIcon() {
		return icon;
	}

	public String getTitle() {
		return title;
	}

	public String getPrimaryCategory() {
		return primaryCategory;
	}

	public String getLink() {
		return link;
	}

	public String getPageDescription() {
		return pageDescription;
	}

	public long getTotalSearchCount() {
		return totalSearchCount;
	}

	public String getTemplateName() {
		return templateName;
	}

	public String getUserName() {
		return userName;
	}

	public String getMessagePosts() {
		return messagePosts;
	}

	public String getPostLink() {
		return postLink;
	}

	public String getSocialIconsWhite() {
		return socialIconsWhite;
	}

	public String getSocialIconsBlack() {
		return socialIconsBlack;
	}

}
