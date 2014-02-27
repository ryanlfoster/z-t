package com.australia.utils;

import javax.servlet.http.Cookie;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;

/**
 * Created by cchin on 26/02/14.
 */
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

}
