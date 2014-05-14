package com.australia.foodandwine.experience.domain;

import java.util.ArrayList;
import java.util.List;

import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;

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

public class Experience {
	private final String title;
	private final String imagePath;
	private final String city;
	private final String state;
	private final String[] tags;
	private final String icon;
	private final String primaryCategory;
	private String link;
	private String website;

	public Experience(Page page, TagManager tagManager) {
		ValueMap properties = page.getProperties();
		Resource jcrResource = page.adaptTo(Resource.class).getChild(
				JcrConstants.JCR_CONTENT);
		Image image = new Image(jcrResource, "image");
		if (image != null && image.hasContent()) {
			imagePath = image.getPath() + ".img.jpg";
		} else {
			imagePath = "";
		}
		//link = LinkUtils.getHrefFromPath(page.getPath());
		// icon
		String linkFromContributorsList = properties.get("linkFromContributorsList", String.class);
		if(linkFromContributorsList!=null &&linkFromContributorsList.equals("true") ){
		link =LinkUtils.getHrefFromPath(page.getPath());
		}
		icon = properties.get("categoryLogoPath", String.class);
		// title
		title = page.getTitle();
		// tags
		String[] cattags = properties.get("cq:tags", new String[0]);
		List<String> tagTitles = new ArrayList<String>();
		for (Tag tag : TagUtils.getFoodAndWineCategoryTags(tagManager, cattags)) {
			tagTitles.add(tag.getTitle());
		}
		tags = tagTitles.toArray(new String[0]);
		// state
		Tag stateTag = TagUtils.getStateTag(tagManager, cattags);
		state = (stateTag != null ? stateTag.getTitle() : StringUtils.EMPTY);
		// city
		Tag cityTag = TagUtils.getCityTag(tagManager, cattags);
		city = (cityTag != null ? cityTag.getTitle() : StringUtils.EMPTY);
		Tag primaryCategoryTag = TagUtils.getFoodAndWinePrimaryCategory(
				tagManager, cattags);
		primaryCategory = (primaryCategoryTag != null ? primaryCategoryTag
				.getTitle() : StringUtils.EMPTY);
		Node node = (Node) page.adaptTo(Node.class);
		try {
			Node jcrNode = node.getNode(JcrConstants.JCR_CONTENT);
			if(jcrNode.getNode("map").hasProperty("website"))
			website ="http://" +jcrNode.getNode("map").getProperty("website").getValue()
					.getString();

		} catch (PathNotFoundException e) {
			e.printStackTrace();
		} catch (RepositoryException e) {
			e.printStackTrace();
		}

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

	public String getTitle() {
		return title;
	}

	public String getPrimaryCategory() {
		return primaryCategory;
	}

	public String getLink() {
		return link;
	}

	public String getWebsite() {
		return website;
	}

}
