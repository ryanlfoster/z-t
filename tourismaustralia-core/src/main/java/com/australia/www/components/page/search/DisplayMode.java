package com.australia.www.components.page.search;

import java.util.HashMap;
import java.util.Map;

public enum DisplayMode {

	GRID,
	LIST;

	private static final Map<String, DisplayMode> MAP = new HashMap<String, DisplayMode>();
	static {
		for(DisplayMode mode: DisplayMode.values()) {
			MAP.put(mode.name(), mode);
		}
	}

	public static DisplayMode fromName(String name) {
		return MAP.get(name);
	}

}
