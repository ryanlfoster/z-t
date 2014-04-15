package com.australia.foodandwine.components.content.carouselState;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Listener;
import com.citytechinc.cq.component.annotations.Tab;
import com.citytechinc.cq.component.annotations.widgets.DialogFieldSet;
import com.citytechinc.cq.component.annotations.widgets.Html5SmartImage;
import com.day.cq.wcm.foundation.Image;

@Component(value = "Carousel State", group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", dialogHeight = 600, disableTargeting = true, tabs = {
	@Tab(title = "General"), @Tab(title = "ACT"), @Tab(title = "NSW"), @Tab(title = "NT"), @Tab(title = "QLD"),
	@Tab(title = "SA"), @Tab(title = "TAS"), @Tab(title = "VIC"), @Tab(title = "WA") }, listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class CarouselState {

	@DialogField(fieldLabel = "Circle Top Text", tab = 1)
	private final String circleTopText;

	@DialogField(fieldLabel = "Circle Middle Text", tab = 1, required = true)
	private final String circleMiddleText;

	@DialogField(fieldLabel = "Circle Bottom Text", tab = 1)
	private final String circleBottomText;

	@DialogField(fieldLabel = "Image Alt Tag", tab = 1, required = true)
	private final String imageAltTag;

	@DialogField(fieldLabel = "Image", tab = 1, required = true)
	@Html5SmartImage(allowUpload = false, name = "backgroundImage", tab = false, height = 400)
	private String imagePath;

	@DialogField(tab = 2)
	@DialogFieldSet(border = false, collapsible = false, namePrefix = "capital/")
	private final StateItem capital;

	@DialogField(tab = 3)
	@DialogFieldSet(border = false, collapsible = false, namePrefix = "nsw/")
	private final StateItem nsw;

	@DialogField(tab = 4)
	@DialogFieldSet(border = false, collapsible = false, namePrefix = "northern/")
	private final StateItem northern;

	@DialogField(tab = 5)
	@DialogFieldSet(border = false, collapsible = false, namePrefix = "queensland/")
	private final StateItem queensland;

	@DialogField(tab = 6)
	@DialogFieldSet(border = false, collapsible = false, namePrefix = "south/")
	private final StateItem south;

	@DialogField(tab = 7)
	@DialogFieldSet(border = false, collapsible = false, namePrefix = "tasmania/")
	private final StateItem tasmania;

	@DialogField(tab = 8)
	@DialogFieldSet(border = false, collapsible = false, namePrefix = "victoria/")
	private final StateItem victoria;

	@DialogField(tab = 9)
	@DialogFieldSet(border = false, collapsible = false, namePrefix = "western/")
	private final StateItem western;

	public CarouselState(SlingHttpServletRequest request) {
		Resource resource = request.getResource();
		ValueMap properties = resource.adaptTo(ValueMap.class);
		Image image = new Image(resource, "backgroundImage");
		if (image != null && image.hasContent()) {
			imagePath = image.getPath();
		}
		imageAltTag = properties.get("imageAltTag", StringUtils.EMPTY);
		circleTopText = properties.get("circleTopText", StringUtils.EMPTY);
		circleMiddleText = properties.get("circleMiddleText", StringUtils.EMPTY);
		circleBottomText = properties.get("circleBottomText", StringUtils.EMPTY);

		this.capital = buildStateItem(resource.getChild("capital"));
		this.nsw = buildStateItem(resource.getChild("nsw"));
		this.northern = buildStateItem(resource.getChild("northern"));
		this.queensland = buildStateItem(resource.getChild("queensland"));
		this.south = buildStateItem(resource.getChild("south"));
		this.tasmania = buildStateItem(resource.getChild("tasmania"));
		this.victoria = buildStateItem(resource.getChild("victoria"));
		this.western = buildStateItem(resource.getChild("western"));
	}

	private StateItem buildStateItem(Resource resource) {
		return (resource != null ? new StateItem(resource) : null);
	}

	public String getImagePath() {
		return imagePath;
	}

	public String getImageAltTag() {
		return imageAltTag;
	}

	public String getCircleTopText() {
		return circleTopText;
	}

	public String getCircleMiddleText() {
		return circleMiddleText;
	}

	public String getCircleBottomText() {
		return circleBottomText;
	}

	public StateItem getCapital() {
		return capital;
	}

	public StateItem getNsw() {
		return nsw;
	}

	public StateItem getNorthern() {
		return northern;
	}

	public StateItem getQueensland() {
		return queensland;
	}

	public StateItem getSouth() {
		return south;
	}

	public StateItem getTasmania() {
		return tasmania;
	}

	public StateItem getVictoria() {
		return victoria;
	}

	public StateItem getWestern() {
		return western;
	}

}
