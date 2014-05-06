package com.australia.www.components.page.search;

import com.australia.atdw.domain.ATDWCategory;
import com.australia.atdw.domain.ATDWProduct;
import com.australia.atdw.domain.ATDWProductSearchParameters;
import com.australia.atdw.domain.ATDWProductSearchParametersBuilder;
import com.australia.atdw.service.ATDWProductService;
import com.australia.content.domain.Content;
import com.australia.content.domain.ContentSearchParameters;
import com.australia.content.domain.ContentSearchParametersBuilder;
import com.australia.content.domain.ContentSearchResult;
import com.australia.content.domain.ContentType;
import com.australia.content.service.ContentSearchException;
import com.australia.content.service.ContentSearchService;
import com.australia.mosaic.FourToOneGridMosaic;
import com.australia.utils.MosaicUtils;
import com.australia.utils.PathUtils;
import com.citytechinc.cq.component.annotations.Component;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.scripting.SlingBindings;
import org.apache.sling.api.scripting.SlingScriptHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component(value = "Search", path = "page", group = ".hidden", editConfig = false)
public final class SearchPage {

	private static final int COUNT = 10;

	private static final String PARAM_Q = "searchinput";
	private static final String PARAM_TAGID = "tagid";
	private static final String PARAM_TYPE = "type";
	private static final String PARAM_MODE = "mode";

	private final ContentType type;

	private final String query;

	private final String tagId;

	private final DisplayMode displayMode;

	private final List<Content> contentResults = new ArrayList<Content>();

	private final List<ATDWProduct> productResults = new ArrayList<ATDWProduct>();

	private long totalResultCount;

	private final String path;

	private final String atdwSearchUrl;

	public SearchPage(final SlingHttpServletRequest request) {

		final SlingBindings bindings = (SlingBindings) request.getAttribute(SlingBindings.class.getName());
		final SlingScriptHelper slingScriptHelper = bindings.getSling();
		final ContentSearchService searchService = slingScriptHelper.getService(ContentSearchService.class);
		final ATDWProductService productService = slingScriptHelper.getService(ATDWProductService.class);

		final Resource resource = request.getResource();

		query = request.getParameter(PARAM_Q);

		tagId = request.getParameter(PARAM_TAGID);

		final String typeString = request.getParameter(PARAM_TYPE);
		type = ContentType.fromName(typeString);

		final String mode = request.getParameter(PARAM_MODE);
		displayMode = DisplayMode.fromName(mode) != null ? DisplayMode.fromName(mode) : DisplayMode.GRID;

		final ContentSearchParametersBuilder builder = new ContentSearchParametersBuilder();
		final ContentSearchParameters params = builder
			.setContentType(type)
			.setLanguagePath(PathUtils.getLanguageResource(resource).getPath())
			.setCount(COUNT)
			.setPage(1)
			.setText(query == null || query.trim().isEmpty() ? null : query)
			.setTags(tagId == null || tagId.isEmpty() ? null : Arrays.asList(tagId))
			.build();

		try {
			final ContentSearchResult result = searchService.search(params);
			contentResults.addAll(result.getContent());
			totalResultCount = result.getTotalResultCount();
		} catch (ContentSearchException e) {
			totalResultCount = 0;
		}

		final ATDWProductSearchParametersBuilder productBuilder = new ATDWProductSearchParametersBuilder();
		final ATDWProductSearchParameters productParams = productBuilder
			.setCount(6)
			.setPage(1)
			.setText(query == null || query.trim().isEmpty() ? null : query)
			.setTags(tagId == null || tagId.isEmpty() ? null : Arrays.asList(tagId))
			.build();
		productResults.addAll(productService.search(productParams).getResults());

		path = resource.getParent().getPath();

		Resource languageResource = PathUtils.getLanguageResource(resource);
		atdwSearchUrl = PathUtils.getAtdwSearchPath(languageResource,
			ATDWCategory.ACCOMEDATIONS.toString(),
			null,
			null,
			null,
			query,
			1);
	}

	public ContentType getType() {
		return type;
	}

	public String getQuery() {
		return query == null ? "" : query;
	}

	public boolean isDisplayResults() {
		return query != null || tagId != null;
	}

	public DisplayMode getDisplayMode() {
		return displayMode;
	}

	public String getTagId() {
		return tagId;
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
		StringBuilder sb = new StringBuilder();
		sb.append(path).append(".html?mode=LIST");
		if(query != null) {
			sb.append("&").append(PARAM_Q).append("=").append(query);
		}
		if(tagId != null) {
			sb.append("&").append(PARAM_TAGID).append("=").append(tagId);
		}
		return sb.toString();
	}

	public String getGridHref() {
		StringBuilder sb = new StringBuilder();
		sb.append(path).append(".html?mode=GRID");
		if(query != null) {
			sb.append("&").append(PARAM_Q).append("=").append(query);
		}
		if(tagId != null) {
			sb.append("&").append(PARAM_TAGID).append("=").append(tagId);
		}
		return sb.toString();
	}

	public String getAtdwSearchUrl() {
		return atdwSearchUrl;
	}

}
