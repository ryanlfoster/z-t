package com.australia.utils;

public class LinkUtils {
	private LinkUtils() {
	}

	public static final String getHrefFromPath(String path) {
		if (path.startsWith("/")) {
			return path + ".html";
		} else {
			return path;
		}
	}

	public static final boolean isExternal(String path) {
		return !path.startsWith("/");
	}
}
