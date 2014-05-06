package com.australia.www.components.page.atdwsearch;

import com.australia.atdw.domain.ATDWCategory;
import com.australia.atdw.domain.ATDWProductSearchParameters;
import com.australia.atdw.domain.ATDWProductSearchParametersBuilder;
import com.australia.atdw.domain.ATDWSearchResult;
import com.australia.atdw.service.ATDWProductService;
import com.australia.utils.PathUtils;
import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.widgets.NumberField;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.scripting.SlingBindings;
import org.apache.sling.api.scripting.SlingScriptHelper;

import java.util.ArrayList;
import java.util.List;

@Component(value = "AtdwSearch", path = "page", group = ".hidden", editConfig = false)
public final class AtdwSearchPage {

	private static final ATDWCategory DEFAULT_CATEGORY = ATDWCategory.ACCOMEDATIONS;
	private static final Integer DEFAULT_RESULTS_PER_PAGE = 12;
	private static final Integer INITIAL_PAGE = 1;

	@DialogField(fieldLabel = "Results Per Page",
		fieldDescription = "Controls the number of search results listed per page. Multiples of 3 are recommended. "
			+ "(Default 12)")
	@NumberField(allowDecimals = false, allowNegative = false)
	private final Integer count;

	private final ATDWCategory category;

	private final int page;

	private final int lastPage;

	private final ATDWSearchResult results;

	private String term;

	private String state;

	private String region;

	private String city;

	private final Resource localeResource;

	private final List<Category> categories = new ArrayList<Category>();

	private final List<Page> pages = new ArrayList<Page>();

	public AtdwSearchPage(final SlingHttpServletRequest request) {

		final SlingBindings bindings = (SlingBindings) request.getAttribute(SlingBindings.class.getName());
		final SlingScriptHelper slingScriptHelper = bindings.getSling();
		final ATDWProductService productService = slingScriptHelper.getService(ATDWProductService.class);

		final Resource resource = request.getResource();
		final ValueMap properties = resource.adaptTo(ValueMap.class);
		count = properties.get("./count", DEFAULT_RESULTS_PER_PAGE);

		final String categoryId = request.getParameter(PathUtils.CATEGORY_PARAM);
		if(ATDWCategory.get(categoryId) != null) {
			category = ATDWCategory.get(categoryId);
		} else {
			category = DEFAULT_CATEGORY;
		}

		term = request.getParameter(PathUtils.TERM_PARAM);
		if(term == null || term.trim().isEmpty()) {
			term = null;
		}

		state = request.getParameter(PathUtils.STATE_PARAM);
		if(state == null || state.trim().isEmpty() || state.equals(".")) {
			state = null;
		}

		region = request.getParameter(PathUtils.REGION_PARAM);
		if(region == null || region.trim().isEmpty() || region.equals(".")) {
			region = null;
		}

		city = request.getParameter(PathUtils.CITY_PARAM);
		if(city == null || city.trim().isEmpty() || city.equals(".")) {
			city = null;
		}


		final String pageString = request.getParameter(PathUtils.PAGE_PARAM);
		int p;
		try {
			p = Integer.parseInt(pageString);
		} catch (NumberFormatException e) {
			p = INITIAL_PAGE;
		}
		page = p;

		// Build parameters
		final ATDWProductSearchParametersBuilder builder = new ATDWProductSearchParametersBuilder();
		final ATDWProductSearchParameters params = builder.setText(term)
			.setCategory(category)
			.setState(state)
			.setRegion(region)
			.setCity(city)
			.setPage(page)
			.setCount(count)
			.build();

		// Perform search
		results = productService.search(params);

		localeResource = PathUtils.getLanguageResource(resource);

		for (ATDWCategory cat: Constants.CATEGORY_ORDERING) {
			categories.add(new Category(cat));
		}

		lastPage = (int) Math.ceil(((double) results.getTotalResultCount()) / (double) count);
		for(int i = 1; i <= lastPage; i++) {
			pages.add(new Page(i));
		}

	}

	public String getTerm() {
		return term;
	}

	public ATDWSearchResult getResults() {
		return results;
	}

	public ATDWCategory getCategory() {
		return category;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public int getPage() {
		return page;
	}

	public int getLastPage() {
		return lastPage;
	}

	public List<Page> getPages() {
		return pages;
	}

	public boolean isShowResults() {
		return term != null;
	}

	public Page getNextPage() {
		return page < lastPage ? pages.get(page) : null;
	}

	public Page getPrevPage() {
		return page > 1 ? pages.get(page - 2) : null;
	}

	public class Page {

		private final int pageNumber;

		private final String path;

		private final boolean selected;

		public Page(int pageNumber) {
			this.pageNumber = pageNumber;
			this.path = PathUtils.getAtdwSearchPath(localeResource, category.toString(), state, region,
				city, term, pageNumber);
			this.selected = pageNumber == page;
		}

		public int getPageNumber() {
			return pageNumber;
		}

		public String getPath() {
			return path;
		}

		public boolean isSelected() {
			return selected;
		}
	}

	public class Category {

		private final ATDWCategory category;

		public Category(ATDWCategory category) {
			this.category = category;
		}

		public String getId() {
			return category.name();
		}

		public String getDisplay() {
			return Constants.getDisplayString(category);
		}

		public String getStandardIconPath() {
			return Constants.getStandardIconPath(category);
		}

		public String getActiveIconPath() {
			return Constants.getActiveIconPath(category);
		}

		public boolean isActive() {
			return this.category == AtdwSearchPage.this.category;
		}

		public String getSearchPath() {
			return PathUtils.getAtdwSearchPath(localeResource, category.toString(), state, region, city,
				term, 1);
		}

	}

}
