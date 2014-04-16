package com.australia.foodandwine.components.content.stateLinks;

import org.apache.sling.api.SlingHttpServletRequest;

import com.australia.utils.PathUtils;
import com.citytechinc.cq.component.annotations.Component;

@Component(value = "State Links", group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", disableTargeting = true)
public class StateLinks {
	private final String capital;
	private final String nsw;
	private final String northern;
	private final String queensland;
	private final String south;
	private final String tasmania;
	private final String victoria;
	private final String western;

	public StateLinks(SlingHttpServletRequest request) {
		capital = PathUtils.FOOD_AND_WINE_EXPLORE_AUSTRALIAN_CAPITAL_TERRITORY;
		nsw = PathUtils.FOOD_AND_WINE_EXPLORE_NEW_SOUTH_WALES;
		northern = PathUtils.FOOD_AND_WINE_EXPLORE_NORTHERN_TERRITORY;
		queensland = PathUtils.FOOD_AND_WINE_EXPLORE_QUEENSLAND;
		south = PathUtils.FOOD_AND_WINE_EXPLORE_SOUTH_AUSTRALIA;
		tasmania = PathUtils.FOOD_AND_WINE_EXPLORE_TASMANIA;
		victoria = PathUtils.FOOD_AND_WINE_EXPLORE_VICTORIA;
		western = PathUtils.FOOD_AND_WINE_EXPLORE_WESTERN_AUSTRALIA;
	}

	public String getCapital() {
		return capital;
	}

	public String getNsw() {
		return nsw;
	}

	public String getNorthern() {
		return northern;
	}

	public String getQueensland() {
		return queensland;
	}

	public String getSouth() {
		return south;
	}

	public String getTasmania() {
		return tasmania;
	}

	public String getVictoria() {
		return victoria;
	}

	public String getWestern() {
		return western;
	}

}
