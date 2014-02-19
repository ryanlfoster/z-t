package com.australia.utils;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum Site {
	OZCOM(PathUtils.OZCOM_ROOT_PATH),
	FOOD_AND_WINE(PathUtils.FOOD_AND_WINE_ROOT_PATH);

	private String value;
	private static final Map<String, Site> lookup = new HashMap<String, Site>();

	static {
		for (Site s : EnumSet.allOf(Site.class)) {
			lookup.put(s.getValue(), s);
		}
	}

	private Site(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static Site get(String value) {
		return lookup.get(value);
	}

	@Override
	public String toString() {
		return value;
	}
}
