package com.australia.utils;

import org.springframework.util.StringUtils;

import com.day.cq.tagging.Tag;
import com.day.cq.tagging.TagManager;

public class TagUtils {
	private TagUtils() {
	}

	public static final String TA_NAMESPACE = "ta";
	public static final String TA_PLACE_TAG = TA_NAMESPACE + ":place";

	public static final Tag getStateTag(TagManager tagManager, String[] tagStrings) {
		for (String tagString : tagStrings) {
			if (tagString.startsWith(TA_PLACE_TAG) && StringUtils.countOccurrencesOf(tagString, "/") >= 1) {
				return tagManager.resolve(getNthTagLevel(tagString, "/", 1));
			}
		}
		return null;
	}

	public static final Tag getCityTag(TagManager tagManager, String[] tagStrings) {
		for (String tagString : tagStrings) {
			if (tagString.startsWith(TA_PLACE_TAG) && StringUtils.countOccurrencesOf(tagString, "/") >= 2) {
				return tagManager.resolve(getNthTagLevel(tagString, "/", 2));
			}
		}
		return null;
	}

	private static final String getNthTagLevel(String string, String splitString, int level) {
		String[] split = string.split(splitString);
		StringBuilder sb = new StringBuilder();
		int joins = level + 1;
		for (int i = 0; i < joins; i++) {
			sb.append(split[i]);
			if (i < joins - 1) {
				sb.append(splitString);
			}
		}
		return sb.toString();
	}
}
