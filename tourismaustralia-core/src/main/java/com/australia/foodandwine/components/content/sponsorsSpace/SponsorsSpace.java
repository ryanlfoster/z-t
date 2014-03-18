package com.australia.foodandwine.components.content.sponsorsSpace;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.australia.widgets.multicomposite.MultiCompositeField;
import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Listener;

/**
 * This class sets the values obtained in the dialog , adds it to the list.
 * 
 */
@Component(group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", value = "Sponsors Space", listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class SponsorsSpace {

	@DialogField(fieldLabel = "Sponsor's Configuration")
	@MultiCompositeField
	private final List<SponsorsSpaceProperties> sponsorsList;
	private static final Logger LOG = LoggerFactory.getLogger(SponsorsSpace.class);

	/**
	 * constants
	 */
	private static final String SPONSORS_LIST = "sponsorsList";
	private static final String SPONSORS_BIG_TITLE = "bigTitle";
	private static final String SPONSORS_IMAGE_PATH = "imagePath";
	private static final String SPONSORS_IMAGE_TITLE = "imageTitle";
	private static final String SPONSORS_LINK_TEXT = "linkText";
	private static final String SPONSORS_LINK_TEXT_PATH = "linkTextPath";
	private static final String NULL_POINTER_MESSAGE = "Null Pointer in SponsorsSpace.java";
	private static final String HTML_EXTENSION = ".html";

	/**
	 * 
	 * @param request
	 */
	public SponsorsSpace(SlingHttpServletRequest request) {

		sponsorsList = new ArrayList<SponsorsSpaceProperties>();
		try {
			Iterable<Resource> resources = request.getResource().getChild(SPONSORS_LIST).getChildren();
			for (Resource resource : resources) {
				ValueMap linkProps = resource.adaptTo(ValueMap.class);
				SponsorsSpaceProperties sponsorsSpaceProperties = new SponsorsSpaceProperties();
				String bigTitle = linkProps.get(SPONSORS_BIG_TITLE, StringUtils.EMPTY);
				String imagePath = linkProps.get(SPONSORS_IMAGE_PATH, StringUtils.EMPTY);
				String imageTitle = linkProps.get(SPONSORS_IMAGE_TITLE, StringUtils.EMPTY);
				String linkText = linkProps.get(SPONSORS_LINK_TEXT, StringUtils.EMPTY);
				String linkTextPath = linkProps.get(SPONSORS_LINK_TEXT_PATH, StringUtils.EMPTY) + HTML_EXTENSION;

				sponsorsSpaceProperties.setBigTitle(bigTitle);
				sponsorsSpaceProperties.setImagePath(imagePath);
				sponsorsSpaceProperties.setImageTitle(imageTitle);
				sponsorsSpaceProperties.setLinkText(linkText);
				sponsorsSpaceProperties.setLinkTextPath(linkTextPath);

				sponsorsList.add(sponsorsSpaceProperties);

			}
		} catch (NullPointerException e) {
			LOG.error(NULL_POINTER_MESSAGE, e.getMessage());
		}

	}

	/**
	 * 
	 * @return
	 */
	public List<SponsorsSpaceProperties> getSponsorsList() {
		return sponsorsList;
	}
}
