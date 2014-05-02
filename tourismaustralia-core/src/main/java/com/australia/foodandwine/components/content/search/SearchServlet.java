package com.australia.foodandwine.components.content.search;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import org.apache.commons.lang.StringUtils;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.australia.foodandwine.searchresults.domain.FAWSearchParametersBuilder;
import com.australia.foodandwine.searchresults.domain.FAWSearchResult;
import com.australia.foodandwine.searchresults.service.SearchReslutsService;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;

@SlingServlet(paths = "/bin/fw/search", methods = "GET")
public class SearchServlet extends SlingAllMethodsServlet {

	private static final int showMoreResultPerHit = 10;
	private static final long serialVersionUID = -4085955964503690676L;
	private static final JsonFactory FACTORY = new JsonFactory();
	private static final ObjectMapper MAPPER = new ObjectMapper();
	private static final Logger LOG = LoggerFactory.getLogger(SearchServlet.class);

	@Reference
	private SearchReslutsService searchResultsService;

	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException,
		IOException {
		try {
			List<String> categoryTags = new ArrayList<String>();
			String counter = request.getParameter("counter");
			String category = request.getParameter("category");
			String location = request.getParameter("location");
			if (category != null && !category.equals(StringUtils.EMPTY)) {
				categoryTags.add(category);
			}

			String searchParameter = request.getParameter("searchParameter");
			if (searchParameter != null && !(searchParameter.equals(StringUtils.EMPTY))) {
				int page = Integer.parseInt(counter);
				FAWSearchParametersBuilder fawSearchParameterBuilder = new FAWSearchParametersBuilder();
				fawSearchParameterBuilder.setText(searchParameter).setPage(page).setTags(categoryTags)
					.setCount(showMoreResultPerHit).setPlace(location);
				FAWSearchResult searchResult = searchResultsService.search(fawSearchParameterBuilder.build());
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				JsonGenerator generator = FACTORY.createGenerator(response.getWriter());
				MAPPER.writeValue(generator, searchResult.getFawSearchList());
			}

		} catch (Exception e) {
			LOG.error("Error in SearchServlet", e);
		}
	}
}
