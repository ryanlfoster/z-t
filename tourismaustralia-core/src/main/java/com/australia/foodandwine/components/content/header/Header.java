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

@Component(group = ".hidden", basePath = "jcr_root/apps/foodandwine/components", actions = { "text:Header", "-", "Edit" }, disableTargeting = true, value = "Header", dialogWidth = 700, listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class Header {
	@DialogField(fieldLabel = "Logo Image Path", name = "./imagePath", required = true)
	@PathField(rootPath = "/content/dam", rootTitle = "Assets")
	private String imagePath;

	@DialogField(fieldLabel = "Logo Image Alt", required = true)
	private String imageAltTag;

	@DialogField(fieldLabel = "Header Text and Links", fieldDescription = "Only top 2 fields will be selected ", additionalProperties = @FieldProperty(name = "width", value = "400"))
	@MultiCompositeField
	private List<TextLink> headerDataList;

	private static final String HEADERDATALIST = "headerDataList";
	private static final String IMAGEPATH = "imagePath";
	private static final String IMAGE_ALTTAG = "imageAltTag";
	private static final String HEADERLINKPATH = "pagePath";
	private static final String HEADERLINKTEXT = "linkText";

	public Header(SlingHttpServletRequest request) {
		String headerPath = PathUtils.FOOD_AND_WINE_ROOT_PATH + "/jcr:content/header";
		Resource headerResource = request.getResourceResolver().getResource(headerPath);
		if (headerResource != null) {
			ValueMap properties = headerResource.adaptTo(ValueMap.class);
			imagePath = properties.get(IMAGEPATH, StringUtils.EMPTY);
			imageAltTag = properties.get(IMAGE_ALTTAG, StringUtils.EMPTY);
			headerDataList = new ArrayList<TextLink>();
			headerData(headerDataList, headerResource, HEADERDATALIST);
		}
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

	public String getLogoLinkPath() {
		return PathUtils.OZCOM_ROOT_PATH + ".html";
	}

	public List<TextLink> getHeaderDataList() {
		return headerDataList;
	}

	public String getImageAltTag() {
		return imageAltTag;
	}

}
