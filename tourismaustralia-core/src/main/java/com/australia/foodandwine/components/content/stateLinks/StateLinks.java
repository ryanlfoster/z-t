package com.australia.foodandwine.components.content.stateLinks;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;

import com.australia.utils.PathUtils;
import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;

@Component(value = "State Links", group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", disableTargeting = true)
public class StateLinks {

	@DialogField(fieldLabel = "Top Text", required = true)
	private final String topText;

	@DialogField(fieldLabel = "Bottom Text", required = true)
	private final String bottomText;

	private final String capital;
	private final String nsw;
	private final String northern;
	private final String queensland;
	private final String south;
	private final String tasmania;
	private final String victoria;
	private final String western;

	public StateLinks(SlingHttpServletRequest request) {
		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		if (properties != null) {
			topText = properties.get("topText", StringUtils.EMPTY);
			bottomText = properties.get("bottomText", StringUtils.EMPTY);
		} else {
			topText = "";
			bottomText = "";
		}
		capital = request.getResourceResolver().map(PathUtils.FOOD_AND_WINE_EXPLORE_AUSTRALIAN_CAPITAL_TERRITORY);
		nsw = request.getResourceResolver().map(PathUtils.FOOD_AND_WINE_EXPLORE_NEW_SOUTH_WALES);
		northern = request.getResourceResolver().map(PathUtils.FOOD_AND_WINE_EXPLORE_NORTHERN_TERRITORY);
		queensland = request.getResourceResolver().map(PathUtils.FOOD_AND_WINE_EXPLORE_QUEENSLAND);
		south = request.getResourceResolver().map(PathUtils.FOOD_AND_WINE_EXPLORE_SOUTH_AUSTRALIA);
		tasmania = request.getResourceResolver().map(PathUtils.FOOD_AND_WINE_EXPLORE_TASMANIA);
		victoria = request.getResourceResolver().map(PathUtils.FOOD_AND_WINE_EXPLORE_VICTORIA);
		western = request.getResourceResolver().map(PathUtils.FOOD_AND_WINE_EXPLORE_WESTERN_AUSTRALIA);
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

	public String getTopText() {
		return topText;
	}

	public String getBottomText() {
		return bottomText;
	}

}
