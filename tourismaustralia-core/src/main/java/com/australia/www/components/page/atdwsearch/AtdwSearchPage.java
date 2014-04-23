package com.australia.www.components.page.atdwsearch;

import com.australia.atdw.domain.ATDWCategory;
import com.australia.atdw.domain.ATDWProductSearchParameters;
import com.australia.atdw.domain.ATDWProductSearchParametersBuilder;
import com.australia.atdw.domain.ATDWSearchResult;
import com.australia.atdw.service.ATDWProductService;
import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.widgets.NumberField;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.scripting.SlingBindings;
import org.apache.sling.api.scripting.SlingScriptHelper;

@Component(value = "AtdwSearch", path = "page", group = ".hidden", editConfig = false)
public final class AtdwSearchPage {

	public static final String CATEGORY_NAME = "category";
	public static final String TERM_NAME = "term";
	public static final String STATE_NAME = "state";
	public static final String REGION_NAME = "region";
	public static final String CITY_NAME = "city";
	public static final String PAGE_NAME = "page";

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

	private final ATDWSearchResult results;

	public AtdwSearchPage(final SlingHttpServletRequest request) {

		final SlingBindings bindings = (SlingBindings) request.getAttribute(SlingBindings.class.getName());
		final SlingScriptHelper slingScriptHelper = bindings.getSling();
		final ATDWProductService productService = slingScriptHelper.getService(ATDWProductService.class);

		final Resource resource = request.getResource();
		final ValueMap properties = resource.adaptTo(ValueMap.class);
		count = properties.get("./count", DEFAULT_RESULTS_PER_PAGE);

		final String categoryId = request.getParameter(CATEGORY_NAME);
		if(ATDWCategory.get(categoryId) != null) {
			category = ATDWCategory.get(categoryId);
		} else {
			category = DEFAULT_CATEGORY;
		}

		final String term = request.getParameter(TERM_NAME);
		final String state = request.getParameter(STATE_NAME);
		final String region = request.getParameter(REGION_NAME);
		final String city = request.getParameter(CITY_NAME);

		final String pageString = request.getParameter(PAGE_NAME);
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
	}

	public ATDWSearchResult getResults() {
		return results;
	}

	public ATDWCategory getCategory() {
		return category;
	}

	public int getPage() {
		return page;
	}

}
