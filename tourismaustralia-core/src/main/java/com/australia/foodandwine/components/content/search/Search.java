package com.australia.foodandwine.components.content.search;

import java.util.ArrayList;
import java.util.List;

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
	
	private FAWSearchResult searchResult;
	private long totalSearchResultsCount = 0;
	private String searchParameter;
	private String category;
	private String location;
	private List<String> searchFilter = new ArrayList<String>();
	private String searchPath;
	private final long pages = 0;
	private String showmore;
	private int showMoreResultPerHit = 10;
	

	public Search(SlingHttpServletRequest request) {

		try {
			 
				try{
			 	searchParameter = request.getParameter("q");
				category = request.getParameter("category").toString();
				location = request.getParameter("location").toString();
				showmore = request.getParameter("showmore").toString();
				}catch(NullPointerException e){
					
				}
				if(showmore != null && !showmore.equals("")){
					showMoreResultPerHit=Integer.parseInt(showmore);
				}
			if (category != null && !category.equals("")) {
				searchFilter.add(category);
			}
			if (location != null && !location.equals("")) {
				searchFilter.add(location);
			}
			if (searchParameter != null && !searchParameter.equals("")) {
				SlingScriptHelper sling = ((SlingBindings) request.getAttribute(SlingBindings.class.getName()))
					.getSling();
				SearchReslutsService searchResultsService = sling.getService(SearchReslutsService.class);
				int page = 1;
				SortOrderType sort = SortOrderType.ASC;
				FAWSearchParametersBuilder fawSearchParameterBuilder = new FAWSearchParametersBuilder();
				fawSearchParameterBuilder.setText(searchParameter).setPage(page).setTags(searchFilter).setCount(showMoreResultPerHit).setSort(sort);
				searchResult = searchResultsService.search(fawSearchParameterBuilder.build());

				PageManager pageManager = request.getResourceResolver().adaptTo(PageManager.class);
				Page searchPage = pageManager.getContainingPage(request.getResource());
				searchPath = request.getResourceResolver().map(searchPage.getPath()) + ".html";
			}
		} catch (Exception e) {
		}
	}

	public FAWSearchResult getSearchResult() {
		return searchResult;
	}

	public long getTotalSearchResultsCount() {
		return totalSearchResultsCount;
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
	public int getShowMoreResultPerHit() {
		return showMoreResultPerHit;
	}

	
}
