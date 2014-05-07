package com.australia.utils;

import com.day.cq.tagging.Tag;
import com.day.cq.wcm.api.NameConstants;

import java.util.List;
import java.util.Map;

public class QueryUtils {
	private QueryUtils() {
	}

	public static final String PATH = "path";
	public static final String TYPE = "type";
	public static final String SEPERATOR = "_";
	public static final String FULLTEXT = "fulltext";
	public static final String TAG_LOCATION = NameConstants.NN_CONTENT + "/@" + NameConstants.PN_TAGS;
	public static final String ORDER_BY = "orderby";
	public static final String ORDER_BY_SORT = ORDER_BY + ".sort";
	public static final String DESC = "desc";
	public static final String OFFSET = "p.offset";
	public static final String LIMIT = "p.limit";
	public static final String PROPERTY = "property";
	public static final String TAGID = "tagid";
	public static final String VALUE = "value";
	public static final String WILDCARD = "*";
	public static final String RELPATH = ".relPath";
	public static final String AND = ".and";
	public static final String ASC = "asc";

	public static void addProperty(Map<String, String> queryMap, int propertyNumber, String property, String value) {
		queryMap.put(propertyNumber + SEPERATOR + PROPERTY, property);
		queryMap.put(propertyNumber + SEPERATOR + VALUE, value);
	}

	public static void addFullText(Map<String, String> queryMap, int propertyNumber, String text) {
		queryMap.put(propertyNumber + SEPERATOR + FULLTEXT, text + "*~");
		queryMap.put(propertyNumber + SEPERATOR + FULLTEXT + RELPATH, NameConstants.NN_CONTENT);
	}

	public static void addQueryForTags(Map<String, String> queryMap, List<Tag> tags, int propertyNumber) {
		String tagPrefix = propertyNumber + SEPERATOR + TAGID;
		queryMap.put(tagPrefix + ".property", TAG_LOCATION);
		int valueCount = 1;
		for (Tag tag : tags) {
			queryMap.put(tagPrefix + "." + valueCount + SEPERATOR + VALUE, tag.getTagID());
			valueCount++;
		}
	}

	public static void addProperty(final Map<String, String> queryMap, final int propertyNumber,
		final String property, final List<String> values) {
		final String prefix = propertyNumber + SEPERATOR + PROPERTY;
		queryMap.put(prefix, property);
		int valueNumber = 1;
		for (final String value: values) {
			final String valueIndicator = prefix + "." + valueNumber + SEPERATOR + VALUE;
			queryMap.put(valueIndicator, value);
			valueNumber++;
		}
	}
}
