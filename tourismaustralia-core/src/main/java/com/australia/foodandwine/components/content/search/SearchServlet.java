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

import com.australia.foodandwine.searchresults.domain.FAWSearch;
import com.australia.foodandwine.searchresults.domain.FAWSearchParametersBuilder;
import com.australia.foodandwine.searchresults.domain.FAWSearchResult;
import com.australia.foodandwine.searchresults.domain.SortOrderType;
import com.australia.foodandwine.searchresults.service.SearchReslutsService;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;

@SlingServlet(paths = "/bin/fw/search", methods = "GET")
public class SearchServlet extends SlingAllMethodsServlet {

	private static final long serialVersionUID = -4085955964503690676L;
	private static final JsonFactory FACTORY = new JsonFactory();
	private static final ObjectMapper MAPPER = new ObjectMapper();
	private static final Logger LOG = LoggerFactory.getLogger(SearchServlet.class);
	private FAWSearchResult searchResult;
	private String searchParameter;
	private String category;
	private String location;
	private final List<String> searchFilter = new ArrayList<String>();
	List<FAWSearch> fawSearchList = new ArrayList<FAWSearch>();
	private final int showMoreResultPerHit = 10;
	private String counter;
	@Reference
	private SearchReslutsService searchResultsService;

	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException,
		IOException {
		try {
			searchFilter.clear();
			counter = request.getParameter("counter");
			category = request.getParameter("category");
			location = request.getParameter("location");
			if (category != null && !category.equals(StringUtils.EMPTY))
				searchFilter.add(category);

			if (location != null && !location.equals(StringUtils.EMPTY))
				searchFilter.add(location);

			searchParameter = request.getParameter("searchParameter");
			if (searchParameter != null && !(searchParameter.equals(StringUtils.EMPTY))) {
				int page = Integer.parseInt(counter);
				SortOrderType sort = SortOrderType.ASC;
				FAWSearchParametersBuilder fawSearchParameterBuilder = new FAWSearchParametersBuilder();
				if (searchFilter.isEmpty()) {
					fawSearchParameterBuilder.setText(searchParameter).setPage(page).setCount(showMoreResultPerHit)
						.setSort(sort);
				} else {
					fawSearchParameterBuilder.setText(searchParameter).setPage(page).setTags(searchFilter)
						.setCount(showMoreResultPerHit).setSort(sort);
				}
				searchResult = searchResultsService.search(fawSearchParameterBuilder.build());
				fawSearchList = searchResult.getFawSearchList();

			}

		} catch (Exception e) {
			LOG.error("Error in SearchServlet", e);
		}
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		JsonGenerator generator = FACTORY.createGenerator(response.getWriter());
		MAPPER.writeValue(generator, fawSearchList);
	}
}
