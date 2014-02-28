package com.australia.favorite.servlet;

import java.io.IOException;
import java.util.Comparator;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;

import org.apache.commons.lang.StringUtils;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.commons.json.JSONArray;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.australia.favorite.domain.Favorite;
import com.australia.favorite.domain.UserFavorites;
import com.australia.favorite.service.FavoriteService;
import com.australia.utils.ServletUtils;

@SlingServlet(paths = "/bin/favorites/list", label = "List Favorites Servlet", methods = "GET",
	description = "Servlet to List Favorites", extensions = "json")
public class ListFavoritesServlet extends SlingAllMethodsServlet {
	private static final Logger LOG = LoggerFactory.getLogger(ListFavoritesServlet.class);

	@Reference
	private FavoriteService favoriteService;

	private UserFavorites userFavorites = new UserFavorites();

	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		String shareId = request.getParameter("shareId");
		Cookie cookie = ServletUtils.getCookieByName(request, ServletUtils.FAVORITES_COOKIE);
		String userId = (cookie != null ? cookie.getValue() : "");

		if (StringUtils.isNotEmpty(userId)) {
			userFavorites = favoriteService.getByUserId(userId);
		} else
		if (StringUtils.isNotEmpty(shareId)) {
			userFavorites = favoriteService.getByShareId(shareId);
			ServletUtils.addCookie(response, ServletUtils.FAVORITES_COOKIE, userFavorites.getUserId());
		}

		JSONObject favoritesList = generateFavoritesList();
		response.setContentType("application/json");
		response.getWriter().write(favoritesList.toString());
	}

	/**
	 * Generates the list of favorites as a json object.
	 * @return favorites list as a json object
	 */
	private JSONObject generateFavoritesList() {
		JSONObject json = new JSONObject();
		JSONArray favorites = new JSONArray();
		try {
			for (Favorite fav: userFavorites.getFavorites()) {
				JSONObject favorite = new JSONObject();
				favorite.put("page", fav.getPage());
				favorites.put(favorite);
			}
			json.put("favorites", favorites);
		} catch (JSONException e) {
			//e.printStackTrace();
		}
		return json;
	}

}
