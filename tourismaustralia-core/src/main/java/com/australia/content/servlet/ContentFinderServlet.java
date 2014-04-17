package com.australia.content.servlet;

import com.australia.content.model.Content;
import com.australia.content.service.ContentFinderException;
import com.australia.content.service.ContentFinderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@SlingServlet(label = "Content Finder Servlet",
	methods = { "GET" },
	metatype = false,
	name = "com.australia.content.servlet.ContentFinderServlet",
	paths = "/bin/australia/contentFinder")
public class ContentFinderServlet extends SlingAllMethodsServlet {

	private final ObjectMapper mapper = new ObjectMapper();

	@Reference
	private ContentFinderService service;

	@Override protected void doGet(final SlingHttpServletRequest request, final SlingHttpServletResponse response)
		throws ServletException, IOException {

		final String path = request.getParameter("path");
		final String tagId = request.getParameter("tagId");
		final String template = request.getParameter("template");
		final String limitString = request.getParameter("limit");
		int limit;
		try {
			limit = limitString == null ? 0 : Integer.parseInt(limitString);
		} catch (NumberFormatException e) {
			limit = 0;
		}

		try {

			final List<Content> content = service.findContent(path, tagId, template, limit);

			response.setContentType("application/json");
			response.setStatus(HttpServletResponse.SC_OK);
			mapper.writeValue(response.getWriter(), content);

		} catch (ContentFinderException e) {

			response.getWriter().append(e.getMessage());
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

		}
	}

}
