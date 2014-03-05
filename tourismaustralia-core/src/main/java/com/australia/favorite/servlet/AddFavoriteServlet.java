package com.australia.favorite.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;

import org.apache.commons.lang.StringUtils;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.australia.favorite.domain.Favorite;
import com.australia.favorite.domain.UserFavorites;
import com.australia.favorite.service.FavoriteService;
import com.australia.utils.ServletUtils;

@SlingServlet(paths = "/bin/favorites/add", label = "Add Favorites Servlet", methods = "POST", description = "Servlet to Add Favorite", extensions = "json")
public class AddFavoriteServlet extends SlingAllMethodsServlet {
	private static final Logger LOG = LoggerFactory.getLogger(AddFavoriteServlet.class);

	@Reference
	private FavoriteService favoriteService;

	@Override
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException,
		IOException {
		String page = request.getParameter("page");
		UserFavorites userFavorites = null;
		if (StringUtils.isEmpty(page)
			&& !request.getResourceResolver().resolve(page).isResourceType(Resource.RESOURCE_TYPE_NON_EXISTING)) {
			response.sendError(SlingHttpServletResponse.SC_BAD_REQUEST);
			return;
		}

		Cookie cookie = ServletUtils.getCookieByName(request, ServletUtils.FAVORITES_COOKIE);
		if (cookie != null) {
			userFavorites = favoriteService.getByUserId(cookie.getValue());
		}
		persistFavorite(userFavorites, page);
		ServletUtils.addCookie(response, ServletUtils.FAVORITES_COOKIE, userFavorites.getUserId());
		response.setContentType("application/json");
		response.getWriter().write(
			ServletUtils.toSimpleJson("favoritesCount", userFavorites.getFavorites().size()).toString());
	}

	/**
	 * Saves the favorite by adding it to the userFavorites list. Checks first
	 * if it exists to avoid duplicates.
	 * 
	 * @param page - the uri of the favorites page
	 */
	private void persistFavorite(UserFavorites userFavorites, String page) {
		// if userFavorites not found via cookie create new one
		if (userFavorites == null) {
			userFavorites = new UserFavorites();
			favoriteService.save(userFavorites);
		}
		// now create the Favorite and save it
		Favorite favorite = new Favorite(page);
		if (!userFavorites.findFavorite(favorite)) {
			userFavorites.addFavorite(favorite);
			favoriteService.save(userFavorites);
		}
	}

}
