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

import com.australia.errorhandler.Sling404ErrorHandler;
import com.australia.favorite.domain.Favorite;
import com.australia.favorite.domain.UserFavorites;
import com.australia.favorite.service.FavoriteService;
import com.australia.utils.ServletUtils;

@SlingServlet(paths = "/bin/favorites/add", label = "Add Favorites Servlet", methods = "GET",
	description = "Servlet to Add Favorite", extensions = "json")
public class AddFavoriteServlet extends SlingAllMethodsServlet {
	private static final Logger LOG = LoggerFactory.getLogger(AddFavoriteServlet.class);

	@Reference
	private FavoriteService favoriteService;

	private UserFavorites userFavorites;

	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
		throws ServletException, IOException {
		String page = request.getParameter("page");
		if (StringUtils.isEmpty(page)) {
			response.sendRedirect(new Sling404ErrorHandler(request).getPageLocation());
		}
		Cookie cookie = ServletUtils.getCookieByName(request, ServletUtils.FAVORITES_COOKIE);
		String userId = (cookie != null ? cookie.getValue() : "");
		if (StringUtils.isNotEmpty(userId)) {
			userFavorites = favoriteService.getByUserId(userId);
		}
		persistFavorite(page);
		ServletUtils.addCookie(response, ServletUtils.FAVORITES_COOKIE, userId);
		response.getWriter().write("Favorite saved!");
	}

	/**
	 * Saves the favorite by adding it to the userFavorites list.
	 * Checks first if it exists to avoid duplicates.
	 *
	 * @param page - the uri of the favorites page
	 */
	private void persistFavorite(String page) {
		Favorite favorite = new Favorite();
		favorite.setPage(page);
		// if userFavorites was not found via cookie create a new one
		if (userFavorites == null) {
			userFavorites = new UserFavorites();
			favoriteService.save(userFavorites);
		}
		if (!userFavorites.findFavorite(favorite)) {
			userFavorites.addFavorite(favorite);
			favoriteService.save(userFavorites);
		}
	}

}
