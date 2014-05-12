package com.australia.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.resource.Resource;

public final class PathUtils {

	private PathUtils() {
	}

	private static final String UTF8 = "UTF-8";

	private static final String HTML_EXT = ".html";

	public static final String OZCOM_ROOT_PATH = "/content/australia";
	public static final String FOOD_AND_WINE_ROOT_PATH = "/content/food-and-wine";

	public static final String FOOD_AND_WINE_404 = "/content/food-and-wine/404.html";
	public static final String OZCOM_404 = "/content/australia/%s/404.html";

	public static final String ATDW_DATA_PATH = OZCOM_ROOT_PATH + "/atdw";

	public static final String USER_GENERATED_PATH = "/content/usergenerated/";

	public static final String SHARE_ID_URL = OZCOM_ROOT_PATH + "/{lang}/share.html?id={id}";

	public static final String FOOD_AND_WINE_EXPERIENCES = FOOD_AND_WINE_ROOT_PATH + "/experiences";

	public static final String FOOD_AND_WINE_USER_GENERATED = "/content/usergenerated/food-and-wine";

	public static final String DETAILED_MAP_PAGE_NAME = "detailedMap";

	public static final String ATDW_SEARCH_LOCALE_REL_PATH = "/atdwsearch.html";
	public static final String CATEGORY_PARAM = "category";
	public static final String STATE_PARAM = "state";
	public static final String REGION_PARAM = "region";
	public static final String CITY_PARAM = "city";
	public static final String TERM_PARAM = "term";
	public static final String PAGE_PARAM = "page";

	public static final String SEARCH_LOCALE_REL_PATH = "/search.html";
	public static final String SEARCHINPUT_PARAM = "searchinput";
	public static final String TAGID_PARAM = "tagid";

	public static final String FOOD_AND_WINE_EXPLORE = FOOD_AND_WINE_ROOT_PATH + "/explore/";
	public static final String FOOD_AND_WINE_EXPLORE_AUSTRALIAN_CAPITAL_TERRITORY = FOOD_AND_WINE_EXPLORE
		+ "australian-capital-territory";
	public static final String FOOD_AND_WINE_EXPLORE_NEW_SOUTH_WALES = FOOD_AND_WINE_EXPLORE + "new-south-wales";
	public static final String FOOD_AND_WINE_EXPLORE_NORTHERN_TERRITORY = FOOD_AND_WINE_EXPLORE + "northern-territory";
	public static final String FOOD_AND_WINE_EXPLORE_QUEENSLAND = FOOD_AND_WINE_EXPLORE + "queensland";
	public static final String FOOD_AND_WINE_EXPLORE_SOUTH_AUSTRALIA = FOOD_AND_WINE_EXPLORE + "south-australia";
	public static final String FOOD_AND_WINE_EXPLORE_TASMANIA = FOOD_AND_WINE_EXPLORE + "tasmania";
	public static final String FOOD_AND_WINE_EXPLORE_VICTORIA = FOOD_AND_WINE_EXPLORE + "victoria";
	public static final String FOOD_AND_WINE_EXPLORE_WESTERN_AUSTRALIA = FOOD_AND_WINE_EXPLORE + "western-australia";

	/**
	 * Will get the language resource for the resource passed in. For example,
	 * if resource at /content/en/mypage is passed in, then the resource at
	 * /content/en will be returned. Currently operated on assumption that
	 * language exists as direct child of OZCOM_ROOT_PATH.
	 * 
	 * @param resource the resource who's containing language resource we want
	 *            to find.
	 * @return The resource representing the parent resource representing the
	 *         language resource, or null if one could not be found.
	 */
	public static Resource getLanguageResource(final Resource resource) {
		Resource currentResource = resource;
		Resource parent;
		while ((parent = currentResource.getParent()) != null) {
			if (StringUtils.equals(parent.getPath(), OZCOM_ROOT_PATH)) {
				return currentResource;
			} else {
				currentResource = parent;
			}
		}
		return null;
	}

	public static String getAtdwSearchPath(Resource locale, String category, String state, String region, String city,
		String term, int page) {
		StringBuilder sb = new StringBuilder();
		sb.append(locale.getPath());
		sb.append(ATDW_SEARCH_LOCALE_REL_PATH).append("?");
		try {
			if (category != null) {
				sb.append(CATEGORY_PARAM).append("=").append(URLEncoder.encode(category, UTF8));
			}
			if (state != null) {
				sb.append("&").append(STATE_PARAM).append("=").append(URLEncoder.encode(state, UTF8));
			}
			if (region != null) {
				sb.append("&").append(REGION_PARAM).append("=").append(URLEncoder.encode(region, UTF8));
			}
			if (city != null) {
				sb.append("&").append(CITY_PARAM).append("=").append(URLEncoder.encode(city, UTF8));
			}
			if (term != null) {
				sb.append("&").append(TERM_PARAM).append("=").append(URLEncoder.encode(term, UTF8));
			}
		} catch (UnsupportedEncodingException e) {
			throw new IllegalStateException(e);
		}
		sb.append("&").append(PAGE_PARAM).append("=").append(page);
		return sb.toString();
	}

	public static String getSearchResultsPage(Resource locale, String searchInput, String tagId) {
		final StringBuilder path = new StringBuilder();
		path.append(locale.getPath());
		path.append(SEARCH_LOCALE_REL_PATH);
		path.append("?");
		boolean needAmp = false;
		try {
			if (searchInput != null) {
				path.append(SEARCHINPUT_PARAM).append("=").append(URLEncoder.encode(searchInput, UTF8));
				needAmp = true;
			}
			if (tagId != null) {
				path.append(needAmp ? "&" : "").append(TAGID_PARAM).append("=").append(URLEncoder.encode(tagId, UTF8));
			}
		} catch (UnsupportedEncodingException e) {
			throw new IllegalStateException(e);
		}
		return path.toString();
	}

}
