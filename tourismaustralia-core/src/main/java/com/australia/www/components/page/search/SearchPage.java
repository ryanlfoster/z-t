package com.australia.www.components.page.search;

import com.australia.atdw.domain.ATDWProduct;
import com.australia.atdw.domain.ATDWProductSearchParameters;
import com.australia.atdw.domain.ATDWProductSearchParametersBuilder;
import com.australia.atdw.service.ATDWProductService;
import com.australia.content.domain.*;
import com.australia.content.service.ContentSearchException;
import com.australia.content.service.ContentSearchService;
import com.australia.mosaic.FourToOneGridMosaic;
import com.australia.utils.MosaicUtils;
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

@Component(value = "Search", path = "page", group = ".hidden", editConfig = false)
public final class SearchPage {

	private static final int DEFAULT_COUNT = 10;

	private static final String PARAM_Q = "searchinput";
	private static final String PARAM_TYPE = "type";
	private static final String PARAM_MODE = "mode";

	@DialogField(fieldLabel = "Results Per Page", fieldDescription = "The contentResults per page to display: "
		+ "defaults to 10, multiples of 5 are recommended.")
	@NumberField(allowNegative = false, allowDecimals = false)
	private final int count;

	private final ContentType type;

	private final String query;

	private final DisplayMode displayMode;

	private final List<Content> contentResults = new ArrayList<Content>();

	private final List<ATDWProduct> productResults = new ArrayList<ATDWProduct>();

	private long totalResultCount;

	private final String path;

	public SearchPage(final SlingHttpServletRequest request) {

		final SlingBindings bindings = (SlingBindings) request.getAttribute(SlingBindings.class.getName());
		final SlingScriptHelper slingScriptHelper = bindings.getSling();
		final ContentSearchService searchService = slingScriptHelper.getService(ContentSearchService.class);
		final ATDWProductService productService = slingScriptHelper.getService(ATDWProductService.class);

		final Resource resource = request.getResource();
		final ValueMap properties = resource.adaptTo(ValueMap.class);
		count = properties.get("./count", DEFAULT_COUNT);

		query = request.getParameter(PARAM_Q);

		final String typeString = request.getParameter(PARAM_TYPE);
		type = ContentType.fromName(typeString);

		final String mode = request.getParameter(PARAM_MODE);
		displayMode = DisplayMode.fromName(mode) != null ? DisplayMode.fromName(mode) : DisplayMode.GRID;

		final ContentSearchParametersBuilder builder = new ContentSearchParametersBuilder();
		final ContentSearchParameters params = builder.setContentType(type)
			.setLanguagePath(PathUtils.getLanguageResource(resource).getPath())
			.setCount(count)
			.setPage(1)
			.setText(query)
			.build();

		try {
			final ContentSearchResult result = searchService.search(params);
			contentResults.addAll(result.getContent());
			totalResultCount = result.getTotalResultCount();
		} catch (ContentSearchException e) {
			totalResultCount = 0;
		}

		final ATDWProductSearchParametersBuilder productBuilder = new ATDWProductSearchParametersBuilder();
		final ATDWProductSearchParameters productParams = productBuilder.setText(query)
			.setCount(6)
			.setPage(1)
			.build();
		productResults.addAll(productService.search(productParams).getResults());

		path = resource.getPath();
	}

	public ContentType getType() {
		return type;
	}

	public String getQuery() {
		return query == null ? "" : query;
	}

	public boolean isDisplayResults() {
		return query != null;
	}

	public DisplayMode getDisplayMode() {
		return displayMode;
	}

	public long getTotalResultCount() {
		return totalResultCount;
	}

	public boolean isListMode() {
		return displayMode == DisplayMode.LIST;
	}

	public boolean isGridMode() {
		return displayMode == DisplayMode.GRID;
	}

	public List<FourToOneGridMosaic<Content>> getContentResultsAsGrid() {
		return MosaicUtils.convertToMosaic(contentResults);
	}

	public List<Content> getContentResults() {
		return contentResults;
	}

	public List<ATDWProduct> getProductResults() {
		return productResults;
	}

	public String getListHref() {
		return path + ".html?" + PARAM_Q + "=" + query + "&mode=LIST";
	}

	public String getGridHref() {
		return path + ".html?" + PARAM_Q + "=" + query + "&mode=GRID";
	}
}
