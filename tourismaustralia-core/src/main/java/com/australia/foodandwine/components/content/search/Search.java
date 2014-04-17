package com.australia.foodandwine.components.content.search;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.scripting.SlingBindings;
import org.apache.sling.api.scripting.SlingScriptHelper;

import com.australia.foodandwine.searchresults.domain.FAWSearchParametersBuilder;
import com.australia.foodandwine.searchresults.domain.FAWSearchResult;
import com.australia.foodandwine.searchresults.domain.SortOrderType;
import com.australia.foodandwine.searchresults.service.SearchReslutsService;
import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.Listener;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

@Component(disableTargeting = true, group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", name = "search", value = "Search", listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class Search {
	private static final int RESULTS_PER_PAGE = 25;
	private FAWSearchResult searchResult;
	private long totalSearchResultsCount = 0;
	private String searchParameter;
	private String searchPath;
	private final long pages = 0;

	public Search(SlingHttpServletRequest request) {
		searchParameter = request.getParameter("q");
		SlingScriptHelper sling = ((SlingBindings) request.getAttribute(SlingBindings.class.getName())).getSling();
		SearchReslutsService searchResultsService = sling.getService(SearchReslutsService.class);
		int page = 1;
		SortOrderType sort = SortOrderType.ASC;
		FAWSearchParametersBuilder fawSearchParameterBuilder = new FAWSearchParametersBuilder();
		fawSearchParameterBuilder.setText(searchParameter).setPage(page).setCount(RESULTS_PER_PAGE).setSort(sort);
		searchResult = searchResultsService.search(fawSearchParameterBuilder.build());

		FAWSearchParametersBuilder totalExperiences = new FAWSearchParametersBuilder();
		totalExperiences.setCount(1);
		totalSearchResultsCount = searchResultsService.search(totalExperiences.build()).getTotalCount();

		PageManager pageManager = request.getResourceResolver().adaptTo(PageManager.class);
		Page searchPage = pageManager.getContainingPage(request.getResource());
		searchPath = request.getResourceResolver().map(searchPage.getPath()) + ".html";
	}

	public FAWSearchResult getSearchResult() {
		return searchResult;
	}

	public long getTotalSearchResultsCount() {
		return totalSearchResultsCount;
	}

	public int getResultsPerPage() {
		return RESULTS_PER_PAGE;
	}

	public String getSearchParameter() {
		return searchParameter;
	}

	public String getSearchPath() {
		return searchPath;
	}

	public long getPages() {
		return pages;
	}
}
