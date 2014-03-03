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

@SlingServlet(paths = "/bin/favorites/remove", label = "Remove Favorite Servlet", methods = "POST",
	description = "Servlet to Remove Favorite", extensions = "json")
public class RemoveFavoriteServlet extends SlingAllMethodsServlet {
	private static final Logger LOG = LoggerFactory.getLogger(RemoveFavoriteServlet.class);

	@Reference
	private FavoriteService favoriteService;


	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
		throws ServletException, IOException {
		UserFavorites userFavorites = null;
		String page = request.getParameter("page");
		if (StringUtils.isEmpty(page)) {
			response.sendError(SlingHttpServletResponse.SC_NOT_FOUND);
		}
		Cookie cookie = ServletUtils.getCookieByName(request, ServletUtils.FAVORITES_COOKIE);
		if (cookie!=null) {
			userFavorites = favoriteService.getByUserId(cookie.getValue());
			removeFavorite(userFavorites, page);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(ServletUtils.toSimpleJson(
				"favoritesCount", userFavorites.getFavorites().size()).toString());
		} else {
			response.sendError(SlingHttpServletResponse.SC_BAD_REQUEST);
		}
	}

	/**
	 * Removes the page favourite from the favourites list.
	 *
	 * @param page - uri of page to remove or asterix to remove all
	 */
	private void removeFavorite(UserFavorites userFavorites, String page) {
		userFavorites.removeFavorite(new Favorite(page));
		favoriteService.save(userFavorites);
	}

}
