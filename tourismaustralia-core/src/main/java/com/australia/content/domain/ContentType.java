package com.australia.content.domain;

import java.util.*;

public enum ContentType {

	EVENT("/apps/tourismaustralia/templates/article"),
	ARTICLE("/apps/tourismaustralia/templates/article"),
	PRODUCT("/apps/tourismaustralia/templates/atdw");

	private static final Map<String, ContentType> MAP = new HashMap<String, ContentType>();
	static {
		for(ContentType type: ContentType.values()) {
			MAP.put(type.name(), type);
		}
	}

	private final String template;

	private ContentType(final String template) {
		this.template = template;
	}

	public String getTemplate() {
		return template;
	}

	public static ContentType fromName(final String name) {
		return MAP.get(name);
	}

	public static List<String> allTemplates() {
		final List<String> out = new ArrayList<String>();
		for (ContentType type: ContentType.values()) {
			out.add(type.getTemplate());
		}
		return out;
	}
}
