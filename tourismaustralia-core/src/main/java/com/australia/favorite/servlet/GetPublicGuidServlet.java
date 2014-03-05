package com.australia.favorite.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;

import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.australia.favorite.domain.UserFavorites;
import com.australia.favorite.service.FavoriteService;
import com.australia.utils.ServletUtils;

@SlingServlet(paths = "/bin/favorites/share/guid", label = "Get Public GUID Servlet", methods = "GET", description = "Servlet to get Public GUID", extensions = "json")
public class GetPublicGuidServlet extends SlingAllMethodsServlet {
	private static final Logger LOG = LoggerFactory.getLogger(GetPublicGuidServlet.class);

	@Reference
	private FavoriteService favoriteService;

	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException,
		IOException {
		Cookie cookie = ServletUtils.getCookieByName(request, ServletUtils.FAVORITES_COOKIE);
		if (cookie != null) {
			UserFavorites userFavorites = favoriteService.getByUserId(cookie.getValue());
			response.setContentType("application/json");
			response.getWriter().write(ServletUtils.toSimpleJson("shareId", userFavorites.getShareId()).toString());
		} else {
			response.sendError(SlingHttpServletResponse.SC_BAD_REQUEST);
		}
	}

}
