package com.australia.foodandwine.components.content.exploreBy;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;

import com.australia.utils.PathUtils;
import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Listener;
import com.citytechinc.cq.component.annotations.Tab;
import com.citytechinc.cq.component.annotations.widgets.Html5SmartImage;
import com.day.cq.wcm.foundation.Image;

@Component(value = "Explore By", group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", disableTargeting = true, tabs = {
	@Tab(title = "Image"), @Tab(title = "Properties") }, listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class ExploreBy {

	@DialogField(fieldLabel = "Top Text", tab = 2)
	private final String topText;

	@DialogField(fieldLabel = "Bottom Text", tab = 2)
	private final String bottomText;

	@DialogField(fieldLabel = "Image Path", tab = 1, required = true)
	@Html5SmartImage(allowUpload = false, name = "backgroundImage")
	private String imagePath;

	@DialogField(fieldLabel = "Image Alt Tag", tab = 2, required = true)
	private final String imageAltTag;

	private final String capital;
	private final String nsw;
	private final String northern;
	private final String queensland;
	private final String south;
	private final String tasmania;
	private final String victoria;
	private final String western;

	public ExploreBy(SlingHttpServletRequest request) {
		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		Image image = new Image(request.getResource(), "backgroundImage");
		if (image != null && image.hasContent()) {
			imagePath = image.getPath();
		}
		topText = properties.get("topText", StringUtils.EMPTY);
		bottomText = properties.get("bottomText", StringUtils.EMPTY);
		imageAltTag = properties.get("imageAltTag", StringUtils.EMPTY);

		capital = PathUtils.FOOD_AND_WINE_EXPLORE_AUSTRALIAN_CAPITAL_TERRITORY;
		nsw = PathUtils.FOOD_AND_WINE_EXPLORE_NEW_SOUTH_WALES;
		northern = PathUtils.FOOD_AND_WINE_EXPLORE_NORTHERN_TERRITORY;
		queensland = PathUtils.FOOD_AND_WINE_EXPLORE_QUEENSLAND;
		south = PathUtils.FOOD_AND_WINE_EXPLORE_SOUTH_AUSTRALIA;
		tasmania = PathUtils.FOOD_AND_WINE_EXPLORE_TASMANIA;
		victoria = PathUtils.FOOD_AND_WINE_EXPLORE_VICTORIA;
		western = PathUtils.FOOD_AND_WINE_EXPLORE_WESTERN_AUSTRALIA;
	}

	public String getTopText() {
		return topText;
	}

	public String getBottomText() {
		return bottomText;
	}

	public String getImagePath() {
		return imagePath;
	}

	public String getImageAltTag() {
		return imageAltTag;
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
