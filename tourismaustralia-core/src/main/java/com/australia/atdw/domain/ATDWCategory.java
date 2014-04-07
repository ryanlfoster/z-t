package com.australia.atdw.domain;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum ATDWCategory {
	EVENT("event"),
	ACCOMEDATIONS("accomm"),
	ATTRACTION("attraction"),
	TRANSPORT("transport"),
	RESTAURANT("restaurant"),
	TOUR("tour"),
	INFO("info"),
	HIRE("hire"),
	GENERAL_SERVICE("genservice"),
	DESTINATION_INFORMATION("destinfo"),
	JOURNEY("journey");

	private String category;
	private static final Map<String, ATDWCategory> lookup = new HashMap<String, ATDWCategory>();

	static {
		for (ATDWCategory s : EnumSet.allOf(ATDWCategory.class)) {
			lookup.put(s.getCategory(), s);
		}
	}

	private ATDWCategory(String category) {
		this.category = category;
	}

	public String getCategory() {
		return category;
	}

	public static ATDWCategory get(String category) {
		return lookup.get(category);
	}

	@Override
	public String toString() {
		return category;
	}
}
