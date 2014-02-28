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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.australia.favorite.domain.Favorite;
import com.australia.favorite.domain.UserFavorites;
import com.australia.favorite.service.FavoriteService;
import com.australia.utils.ServletUtils;

@SlingServlet(paths = "/bin/favorites/remove", label = "Remove Favorite Servlet", methods = "GET",
	description = "Servlet to Remove Favorite", extensions = "json")
public class RemoveFavoriteServlet extends SlingAllMethodsServlet {
	private static final Logger LOG = LoggerFactory.getLogger(RemoveFavoriteServlet.class);
	private final String REMOVE_ALL_FAVORITES = "*";

	@Reference
	private FavoriteService favoriteService;

	private UserFavorites userFavorites;

	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
		throws ServletException, IOException {
		String page = request.getParameter("page");
		if (StringUtils.isEmpty(page)) {
			response.sendError(SlingHttpServletResponse.SC_NOT_FOUND);
		}
		Cookie cookie = ServletUtils.getCookieByName(request, ServletUtils.FAVORITES_COOKIE);
		String userId = (cookie != null ? cookie.getValue() : "");
		if (StringUtils.isNotEmpty(userId)) {
			userFavorites = favoriteService.getByUserId(userId);
		}
		removeFavorite(page);
		response.setContentType("application/json");
		response.getWriter().write(ServletUtils.toSimpleJson(
			"favoritesCount", userFavorites.getFavorites().size()).toString());
	}

	/**
	 * Removes the page favourite from the favourites list.
	 * If asterix(*) is specified, remove all favourites.
	 * @param page - uri of page to remove or asterix to remove all
	 */
	private void removeFavorite(String page) {
		if (REMOVE_ALL_FAVORITES.equals(page)) {
			userFavorites.getFavorites().clear();
		} else {
			userFavorites.removeFavorite(new Favorite(page));
		}
		favoriteService.save(userFavorites);
	}

}
