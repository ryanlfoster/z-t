package com.australia.favorite.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;

import org.apache.commons.lang.StringUtils;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.australia.favorite.domain.UserFavorites;
import com.australia.favorite.service.FavoriteService;
import com.australia.utils.ServletUtils;

@SlingServlet(paths = "/bin/favorites/share/guid", label = "Get Public GUID Servlet", methods = "GET",
	description = "Servlet to get Public GUID", extensions = "json")
public class GetPublicGuidServlet extends SlingAllMethodsServlet {
	private static final Logger LOG = LoggerFactory.getLogger(GetPublicGuidServlet.class);

	@Reference
	private FavoriteService favoriteService;

	private UserFavorites userFavorites = new UserFavorites();

	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		Cookie cookie = ServletUtils.getCookieByName(request, ServletUtils.FAVORITES_COOKIE);
		String userId = (cookie != null ? cookie.getValue() : "");
		if (StringUtils.isNotEmpty(userId)) {
			userFavorites = favoriteService.getByUserId(userId);
		}
		try {
			JSONObject json = new JSONObject();
			json.putOpt("shareId", userFavorites.getShareId());
			response.setContentType("application/json");
			response.getWriter().write(json.toString());
		} catch (JSONException e) {
//			e.printStackTrace();
		}
	}

}
