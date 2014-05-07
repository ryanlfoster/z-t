package com.australia.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.day.cq.tagging.Tag;
import com.day.cq.tagging.TagManager;

public class TagUtils {
	private TagUtils() {
	}

	public static final String TA_NAMESPACE = "ta";
	public static final String TA_PLACE_TAG = TA_NAMESPACE + ":place";
	public static final String AUSTRALIA_CAPITAL_TERRITORY_TAG = TA_PLACE_TAG + "/australia-capital-territory";
	public static final String NEW_SOUTH_WALES_TAG = TA_PLACE_TAG + "/new-south-wales";
	public static final String NORTHERN_TERRITORY_TAG = TA_PLACE_TAG + "/northern-territory";
	public static final String QUEENSLAND_TAG = TA_PLACE_TAG + "/queensland";
	public static final String SOUTH_AUSTRALIA_TAG = TA_PLACE_TAG + "/south-australia";
	public static final String TASMANIA_TAG = TA_PLACE_TAG + "/tasmania";
	public static final String VICTORIA_TAG = TA_PLACE_TAG + "/victoria";
	public static final String WESTERN_AUSTRALIA_TAG = TA_PLACE_TAG + "/western-australia";
	public static final String FOOD_AND_WINE_TAG = TA_NAMESPACE + ":food-and-wine";
	public static final String FOOD_AND_WINE_CATEGORY = FOOD_AND_WINE_TAG + "/category";

	public static final Tag getStateTag(TagManager tagManager, String[] tagStrings) {
		for (String tagString : tagStrings) {
			if (tagString.startsWith(TA_PLACE_TAG) && StringUtils.countOccurrencesOf(tagString, "/") >= 1) {
				return tagManager.resolve(getNthTagLevel(tagString, 1));
			}
		}
		return null;
	}

	public static final Tag getCityTag(TagManager tagManager, String[] tagStrings) {
		for (String tagString : tagStrings) {
			if (tagString.startsWith(TA_PLACE_TAG) && StringUtils.countOccurrencesOf(tagString, "/") >= 2) {
				return tagManager.resolve(getNthTagLevel(tagString, 2));
			}
		}
		return null;
	}

	public static final List<Tag> getFoodAndWineCategoryTags(TagManager tagManager, String[] tagStrings) {
		List<Tag> tags = new ArrayList<Tag>();
		for (String tagString : tagStrings) {
			if (tagString.startsWith(FOOD_AND_WINE_CATEGORY)) {
				Tag tag = tagManager.resolve(tagString);
				if (tag != null) {
					tags.add(tag);
				}
			}
		}
		return tags;
	}

	public static final Tag getFoodAndWinePrimaryCategory(TagManager tagManager, String[] tagStrings) {
		for (String tagString : tagStrings) {
			if (tagString.startsWith(FOOD_AND_WINE_CATEGORY)) {
				Tag tag = tagManager.resolve(tagString);
				if (tag != null) {
					return tag;
				}
			}
		}
		return null;
	}

	private static final String getNthTagLevel(String string, int level) {
		String[] split = string.split("/");
		StringBuilder sb = new StringBuilder();
		int joins = level + 1;
		for (int i = 0; i < joins; i++) {
			sb.append(split[i]);
			if (i < joins - 1) {
				sb.append("/");
			}
		}
		return sb.toString();
	}
}
