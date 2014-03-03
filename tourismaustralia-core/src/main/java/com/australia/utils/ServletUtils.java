package com.australia.utils;

import javax.servlet.http.Cookie;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServletUtils {
	private static final Logger LOG = LoggerFactory.getLogger(ServletUtils.class);
	public static final String FAVORITES_COOKIE = "userFavoritesUserId";
	public static final int EXPIRY_FIVE_YEARS = 5 * 365 * 24 * 60 * 60;

	private ServletUtils() {}

	public static Cookie getCookieByName(SlingHttpServletRequest request, String name) {
		// look for the favorites cookie and if found get the userId
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if (FAVORITES_COOKIE.equals(cookie.getName())) {
				return cookie;
			}
		}
		return null;
	}

	public static void addCookie(SlingHttpServletResponse response, String name, String value) {
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(EXPIRY_FIVE_YEARS);
		response.addCookie(cookie);
	}

	public static JSONObject toSimpleJson(String name, String value) {
		JSONObject json = new JSONObject();
		try {
			json.putOpt(name, value);
		} catch (JSONException e) {
			LOG.error("Error creating json object", e);
		}
		return json;
	}

	public static JSONObject toSimpleJson(String name, Integer value) {
		return toSimpleJson(name, value.toString());
	}

}
