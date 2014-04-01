package com.australia.foodandwine.components.content.sponsorsSpace;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;

import com.australia.utils.LinkUtils;
import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Listener;
import com.citytechinc.cq.component.annotations.Tab;
import com.citytechinc.cq.component.annotations.widgets.DialogFieldSet;

/**
 * This class sets the values obtained in the dialog , adds it to the list.
 * 
 */
@Component(disableTargeting = true, group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", value = "Sponsors Space", tabs = {
	@Tab(title = "Sponsor 1"), @Tab(title = "Sponsor 2"), @Tab(title = "Sponsor 3") }, listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class SponsorsSpace {
	@DialogField(tab = 1)
	@DialogFieldSet(border = false, collapsible = false, namePrefix = "./sponsor1/")
	private final SponsorsSpaceProperties sponsor1;

	@DialogField(tab = 2)
	@DialogFieldSet(border = false, collapsible = false, namePrefix = "./sponsor2/")
	private final SponsorsSpaceProperties sponsor2;

	@DialogField(tab = 3)
	@DialogFieldSet(border = false, collapsible = false, namePrefix = "./sponsor3/")
	private final SponsorsSpaceProperties sponsor3;

	/**
	 * constants
	 */
	private static final String SPONSORS_BIG_TITLE = "bigTitle";
	private static final String SPONSORS_IMAGE_PATH = "imagePath";
	private static final String SPONSORS_IMAGE_TITLE = "imageTitle";
	private static final String SPONSORS_IMAGE_ALTTAG = "imageAltTag";
	private static final String SPONSORS_LINK_TEXT = "linkText";
	private static final String SPONSORS_LINK_TEXT_PATH = "linkTextPath";

	/**
	 * 
	 * @param request
	 */
	public SponsorsSpace(SlingHttpServletRequest request) {
		Resource resource = request.getResource();
		sponsor1 = buildSponsorsSpaceProperties(resource.getChild("sponsor1"));
		sponsor2 = buildSponsorsSpaceProperties(resource.getChild("sponsor2"));
		sponsor3 = buildSponsorsSpaceProperties(resource.getChild("sponsor3"));
	}

	private SponsorsSpaceProperties buildSponsorsSpaceProperties(Resource resource) {
		if (resource != null) {
			ValueMap linkProps = resource.adaptTo(ValueMap.class);
			String bigTitle = linkProps.get(SPONSORS_BIG_TITLE, StringUtils.EMPTY);
			String imagePath = linkProps.get(SPONSORS_IMAGE_PATH, StringUtils.EMPTY);
			String imageTitle = linkProps.get(SPONSORS_IMAGE_TITLE, StringUtils.EMPTY);
			String imageAltTag = linkProps.get(SPONSORS_IMAGE_ALTTAG, StringUtils.EMPTY);
			String linkText = linkProps.get(SPONSORS_LINK_TEXT, StringUtils.EMPTY);
			String linkTextPath = LinkUtils.getHrefFromPath(linkProps.get(SPONSORS_LINK_TEXT_PATH, StringUtils.EMPTY));
			SponsorsSpaceProperties sponsorsSpaceProperties = new SponsorsSpaceProperties(bigTitle, imagePath,
				imageTitle, linkText, linkTextPath, imageAltTag);
			return sponsorsSpaceProperties;
		}
		return null;
	}

	public SponsorsSpaceProperties getSponsor1() {
		return sponsor1;
	}

	public SponsorsSpaceProperties getSponsor2() {
		return sponsor2;
	}

	public SponsorsSpaceProperties getSponsor3() {
		return sponsor3;
	}
}
