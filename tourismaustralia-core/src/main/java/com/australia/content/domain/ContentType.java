package com.australia.content.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum ContentType {

	ARTICLE("/apps/tourismaustralia/templates/article"),
	PRODUCT("/apps/tourismaustralia/templates/atdw");

	private static final Map<String, ContentType> MAP = new HashMap<String, ContentType>();
	static {
		for (ContentType type : ContentType.values()) {
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
		out.add(ARTICLE.getTemplate());
		return out;
	}
}
