package com.australia.foodandwine.components.content.footer;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;

import com.australia.foodandwine.link.IconTextLink;
import com.australia.foodandwine.link.TextLink;
import com.australia.utils.LinkUtils;
import com.australia.utils.PathUtils;
import com.australia.widgets.multicomposite.MultiCompositeField;
import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.FieldProperty;
import com.citytechinc.cq.component.annotations.Listener;
import com.citytechinc.cq.component.annotations.Tab;
import com.citytechinc.cq.component.annotations.widgets.PathField;

@Component(group = ".hidden", basePath = "jcr_root/apps/foodandwine/components", actions = { "text:Footer", "-", "Edit" }, disableTargeting = true, value = "Footer", dialogWidth = 700, tabs = {
	@Tab(title = "Top & Bottom"), @Tab(title = "Left"), @Tab(title = "Middle"), @Tab(title = "Social Links") }, listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class Footer {
	@DialogField(fieldLabel = "Top Image Path", tab = 1)
	@PathField(rootPath = "/content/dam", rootTitle = "Assets")
	private String imageTopLogoPath;

	@DialogField(fieldLabel = "Bottom Image Path", tab = 1)
	@PathField(rootPath = "/content/dam", rootTitle = "Assets")
	private String imageBottomLogoPath;

	@DialogField(fieldLabel = "URL Title", tab = 1, required = false)
	private String urlTitle;

	@DialogField(fieldLabel = "Byline", tab = 1, required = true)
	private String byline;

	@DialogField(fieldLabel = "Heading", tab = 2, required = true)
	private String headingLeft;

	@DialogField(fieldLabel = "Heading", tab = 3, required = true)
	private String headingMiddle;

	@DialogField(fieldLabel = "Heading", tab = 4, required = true)
	private String headingRight;

	@DialogField(fieldLabel = "Links", tab = 2, additionalProperties = @FieldProperty(name = "anchor", value = "100%"))
	@MultiCompositeField
	private List<TextLink> linksLeft;

	@DialogField(fieldLabel = "Links", tab = 3)
	@MultiCompositeField
	private List<TextLink> linksMiddle;

	@DialogField(fieldLabel = "Links", tab = 4)
	@MultiCompositeField
	private List<IconTextLink> linksRight;

	private final String copyrightYear;

	public Footer(SlingHttpServletRequest request) {
		Calendar now = Calendar.getInstance();
		copyrightYear = String.valueOf(now.get(Calendar.YEAR));

		String footerPath = PathUtils.FOOD_AND_WINE_ROOT_PATH + "/jcr:content/footer";
		Resource footerResource = request.getResourceResolver().getResource(footerPath);
		if (footerResource != null) {
			ValueMap properties = footerResource.adaptTo(ValueMap.class);
			imageTopLogoPath = properties.get("imageTopLogoPath", "");
			imageBottomLogoPath = properties.get("imageBottomLogoPath", "");
			urlTitle = properties.get("urlTitle", "restaurantAUS.COM");
			byline = properties.get("byline", "proudly brought to you by Tourism Australia");
			headingLeft = properties.get("headingLeft", "");
			headingMiddle = properties.get("headingMiddle", "");
			headingRight = properties.get("headingRight", "");

			linksLeft = new ArrayList<TextLink>();
			buildTextLinks(linksLeft, footerResource, "linksLeft");

			linksMiddle = new ArrayList<TextLink>();
			buildTextLinks(linksMiddle, footerResource, "linksMiddle");

			linksRight = new ArrayList<IconTextLink>();
			buildTextIconLinks(linksRight, footerResource, "linksRight");
		}
	}

	private void buildTextLinks(List links, Resource footerResource, String linksColumn) {
		if (footerResource.getChild(linksColumn) != null) {
			Iterable<Resource> resources = footerResource.getChild(linksColumn).getChildren();
			for (Resource r : resources) {
				ValueMap linkProps = r.adaptTo(ValueMap.class);
				String pagePath = linkProps.get("pagePath", StringUtils.EMPTY);
				String linkText = linkProps.get("linkText", StringUtils.EMPTY);
				TextLink link = new TextLink();
				link.setPagePath(pagePath);
				link.setLinkText(linkText);
				links.add(link);
			}
		}
	}

	private void buildTextIconLinks(List links, Resource footerResource, String linksColumn) {
		if (footerResource.getChild(linksColumn) != null) {
			Iterable<Resource> resources = footerResource.getChild(linksColumn).getChildren();
			for (Resource r : resources) {
				ValueMap linkProps = r.adaptTo(ValueMap.class);
				String pagePath = LinkUtils.getHrefFromPath(linkProps.get("pagePath", StringUtils.EMPTY));
				String linkText = linkProps.get("linkText", StringUtils.EMPTY);
				String iconImage = linkProps.get("iconImage", StringUtils.EMPTY);
				IconTextLink link = new IconTextLink();
				link.setPagePath(pagePath);
				link.setLinkText(linkText);
				link.setIconImage(iconImage);
				links.add(link);
			}
		}
	}

	public String getImageTopLogoPath() {
		return imageTopLogoPath;
	}

	public String getImageTopLogoLink() {
		return PathUtils.FOOD_AND_WINE_ROOT_PATH + ".html";
	}

	public String getUrlTitle() {
		return urlTitle;
	}

	public String getByline() {
		return byline;
	}

	public String getHeadingLeft() {
		return headingLeft;
	}

	public String getHeadingMiddle() {
		return headingMiddle;
	}

	public String getHeadingRight() {
		return headingRight;
	}

	public String getImageBottomLogoPath() {
		return imageBottomLogoPath;
	}

	public String getImageBottomLogoLink() {
		return PathUtils.OZCOM_ROOT_PATH + ".html";
	}

	public String getCopyrightYear() {
		return copyrightYear;
	}

	public List<TextLink> getLinksLeft() {
		return linksLeft;
	}

	public List<TextLink> getLinksMiddle() {
		return linksMiddle;
	}

	public List<IconTextLink> getLinksRight() {
		return linksRight;
	}

}
