package com.australia.foodandwine.components.content.contributorslist;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.scripting.SlingBindings;
import org.apache.sling.api.scripting.SlingScriptHelper;

import com.australia.foodandwine.experience.domain.ExperienceSearchParametersBuilder;
import com.australia.foodandwine.experience.domain.ExperienceSearchResult;
import com.australia.foodandwine.experience.domain.SortOrderType;
import com.australia.foodandwine.experience.service.ExperienceService;
import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.Listener;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

@Component(disableTargeting = true, group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", name = "contributorsList", value = "Contributers List", listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class ContributorsList {
	private static final int RESULTS_PER_PAGE = 25;
	private final ExperienceSearchResult searchResult;
	private final long totalExperiencesCount;
	private final String searchParameter;
	private final String searchPath;
	private final long pages;
	private String paginationPath;

	public ContributorsList(SlingHttpServletRequest request) throws UnsupportedEncodingException {
		SlingScriptHelper sling = ((SlingBindings) request.getAttribute(SlingBindings.class.getName())).getSling();
		ExperienceService experienceService = sling.getService(ExperienceService.class);
		searchParameter = request.getParameter("q");
		String[] selectors = request.getRequestPathInfo().getSelectors();
		int page = 1;
		SortOrderType sort = SortOrderType.ASC;
		if (selectors.length == 1) {
			page = Integer.parseInt(selectors[0]);
			if (page < 1) {
				page = 1;
			}
		}
		ExperienceSearchParametersBuilder experienceSearchParameterBuilder = new ExperienceSearchParametersBuilder();
		experienceSearchParameterBuilder.setText(searchParameter).setPage(page).setCount(RESULTS_PER_PAGE)
			.setSort(sort);
		searchResult = experienceService.search(experienceSearchParameterBuilder.build());
		pages = (long) Math.ceil(searchResult.getTotalCount() / (double) RESULTS_PER_PAGE);

		ExperienceSearchParametersBuilder totalExperiences = new ExperienceSearchParametersBuilder();
		totalExperiences.setCount(1);
		totalExperiencesCount = experienceService.search(totalExperiences.build()).getTotalCount();

		PageManager pageManager = request.getResourceResolver().adaptTo(PageManager.class);
		Page searchPage = pageManager.getContainingPage(request.getResource());
		searchPath = request.getResourceResolver().map(searchPage.getPath()) + ".html";

		paginationPath = request.getResourceResolver().map(searchPage.getPath()) + ".{0}.html";
		if (StringUtils.isNotEmpty(searchParameter)) {
			paginationPath = paginationPath + "?q=" + URLEncoder.encode(searchParameter, "UTF-8");
		}
	}

	public ExperienceSearchResult getSearchResult() {
		return searchResult;
	}

	public long getTotalExperiencesCount() {
		return totalExperiencesCount;
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

	public String getPaginationPath() {
		return paginationPath;
	}
}
