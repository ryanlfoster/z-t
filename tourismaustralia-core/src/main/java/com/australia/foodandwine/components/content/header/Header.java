package com.australia.foodandwine.components.content.header;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;

import com.australia.foodandwine.link.TextLink;
import com.australia.utils.LinkUtils;
import com.australia.utils.PathUtils;
import com.australia.widgets.multicomposite.MultiCompositeField;
import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.FieldProperty;
import com.citytechinc.cq.component.annotations.Listener;
import com.citytechinc.cq.component.annotations.widgets.PathField;
import com.day.cq.wcm.api.WCMMode;

@Component(group = ".hidden", basePath = "jcr_root/apps/foodandwine/components", actions = { "text:Header", "-", "Edit" }, disableTargeting = true, value = "Header", dialogHeight = 500, dialogWidth = 700, listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class Header {
	@DialogField(fieldLabel = "Logo Image Path", name = "./imagePath", required = true)
	@PathField(rootPath = "/content/dam", rootTitle = "Assets")
	private String imagePath;

	@DialogField(fieldLabel = "Search Path", name = "./searchPath", required = true)
	@PathField(rootPath = "/content")
	private String searchPath;

	@DialogField(fieldLabel = "Logo Image Alt", required = true)
	private String imageAltTag;

	@DialogField(fieldLabel = "Header Text & Links", fieldDescription = "Only top 2 fields will be selected ", additionalProperties = @FieldProperty(name = "width", value = "400"))
	@MultiCompositeField
	private List<TextLink> headerDataList;

	private final String instanceModeName;

	private final String capital;
	private final String nsw;
	private final String northern;
	private final String queensland;
	private final String south;
	private final String tasmania;
	private final String victoria;
	private final String western;

	private static final String HEADERDATALIST = "headerDataList";
	private static final String IMAGEPATH = "imagePath";
	private static final String SEARCH_PATH = "searchPath";
	private static final String IMAGE_ALTTAG = "imageAltTag";
	private static final String HEADERLINKPATH = "pagePath";
	private static final String HEADERLINKTEXT = "linkText";

	public Header(SlingHttpServletRequest request) {
		WCMMode wcmMode = WCMMode.fromRequest(request);
		String name = wcmMode.name();
		instanceModeName = name.toLowerCase();

		String headerPath = PathUtils.FOOD_AND_WINE_ROOT_PATH + "/jcr:content/header";
		Resource headerResource = request.getResourceResolver().getResource(headerPath);
		if (headerResource != null) {
			ValueMap properties = headerResource.adaptTo(ValueMap.class);
			searchPath = LinkUtils.getHrefFromPath(properties.get(SEARCH_PATH, StringUtils.EMPTY));
			imagePath = properties.get(IMAGEPATH, StringUtils.EMPTY);
			imageAltTag = properties.get(IMAGE_ALTTAG, StringUtils.EMPTY);
			headerDataList = new ArrayList<TextLink>();
			headerData(headerDataList, headerResource, HEADERDATALIST);
		}
		capital = PathUtils.FOOD_AND_WINE_EXPLORE_AUSTRALIAN_CAPITAL_TERRITORY;
		nsw = PathUtils.FOOD_AND_WINE_EXPLORE_NEW_SOUTH_WALES;
		northern = PathUtils.FOOD_AND_WINE_EXPLORE_NORTHERN_TERRITORY;
		queensland = PathUtils.FOOD_AND_WINE_EXPLORE_QUEENSLAND;
		south = PathUtils.FOOD_AND_WINE_EXPLORE_SOUTH_AUSTRALIA;
		tasmania = PathUtils.FOOD_AND_WINE_EXPLORE_TASMANIA;
		victoria = PathUtils.FOOD_AND_WINE_EXPLORE_VICTORIA;
		western = PathUtils.FOOD_AND_WINE_EXPLORE_WESTERN_AUSTRALIA;
	}

	private void headerData(List<TextLink> headerDataList, Resource headerResource, String headrString) {
		if (headerResource.getChild(headrString) != null) {
			Iterable<Resource> resources = headerResource.getChild(headrString).getChildren();
			for (Resource r : resources) {
				ValueMap linkProps = r.adaptTo(ValueMap.class);
				String pagePath = linkProps.get(HEADERLINKPATH, StringUtils.EMPTY);
				pagePath = LinkUtils.getHrefFromPath(pagePath);
				String linkText = linkProps.get(HEADERLINKTEXT, StringUtils.EMPTY);
				TextLink headerBean = new TextLink();
				headerBean.setPagePath(pagePath);
				headerBean.setLinkText(linkText);
				if (headerDataList.size() < 2)
					headerDataList.add(headerBean);
			}
		}
	}

	public String getImagePath() {
		return imagePath;
	}

	public String getSearchPath() {
		return searchPath;
	}

	public String getLogoLinkPath() {
		return PathUtils.OZCOM_ROOT_PATH + ".html";
	}

	public List<TextLink> getHeaderDataList() {
		return headerDataList;
	}

	public String getImageAltTag() {
		return imageAltTag;
	}

	public String getInstanceModeName() {
		return instanceModeName;
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
