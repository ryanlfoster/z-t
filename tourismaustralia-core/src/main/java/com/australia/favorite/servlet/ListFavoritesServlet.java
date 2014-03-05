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

import com.australia.favorite.domain.UserFavorites;
import com.australia.favorite.service.FavoriteService;
import com.australia.utils.ServletUtils;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;

@SlingServlet(paths = "/bin/favorites/list", label = "List Favorites Servlet", methods = "GET", description = "Servlet to List Favorites", extensions = "json")
public class ListFavoritesServlet extends SlingAllMethodsServlet {
	private static final Logger LOG = LoggerFactory.getLogger(ListFavoritesServlet.class);
	private static final JsonFactory FACTORY = new JsonFactory();
	private static final ObjectMapper MAPPER = new ObjectMapper();

	@Reference
	private FavoriteService favoriteService;

	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException,
		IOException {
		String shareId = request.getParameter("shareId");
		UserFavorites userFavorites = new UserFavorites();
		Cookie cookie = ServletUtils.getCookieByName(request, ServletUtils.FAVORITES_COOKIE);
		if (StringUtils.isNotEmpty(shareId)) {
			userFavorites = favoriteService.getByShareId(shareId);
		} else if (cookie != null) {
			userFavorites = favoriteService.getByUserId(cookie.getValue());
		} else {
			response.sendError(SlingHttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		JsonGenerator generator = FACTORY.createGenerator(response.getWriter());
		MAPPER.writeValue(generator, userFavorites.getFavorites());
	}

}
