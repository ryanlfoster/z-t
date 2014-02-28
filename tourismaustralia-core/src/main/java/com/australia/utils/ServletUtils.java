package com.australia.utils;

import java.util.List;

import javax.servlet.http.Cookie;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.commons.json.JSONArray;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;

import com.australia.favorite.domain.Favorite;

public class ServletUtils {

	public static final String FAVORITES_COOKIE = "userFavoritesUserId";

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
		response.addCookie(cookie);
	}
	public static JSONObject toSimpleJson(String name, String value) {
		JSONObject json = new JSONObject();
		try {
			json.putOpt(name, value);
		} catch (JSONException e) {
			//	e.printStackTrace();
		}
		return json;
	}

	public static JSONObject toSimpleJson(String name, Integer value) {
		return toSimpleJson(name, value.toString());
	}

}
