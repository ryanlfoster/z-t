package com.australia.foodandwine.components.content.carousel;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.australia.foodandwine.components.constants.CQJCRConstants;
import com.australia.widgets.multicomposite.MultiCompositeField;
import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Listener;
import com.citytechinc.cq.component.annotations.Tab;
import com.citytechinc.cq.component.annotations.widgets.Html5SmartImage;
import com.day.cq.wcm.foundation.Image;

@Component(group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", value = "Carousel", tabs = {
	@Tab(title = "Background Image"), @Tab(title = "Slides") }, listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class Carousel {
	private static final Logger LOG = LoggerFactory.getLogger(Carousel.class);

	@DialogField(fieldLabel = "Carousel Background Image Path ", required = true, name = "./carouselBackgroundImagePath", tab = 1)
	@Html5SmartImage(allowUpload = false, name = "backgroundImage")
	private String carouselBackgroundImagePath;

	@DialogField(fieldLabel = "Carousel Data ", tab = 2)
	@MultiCompositeField
	private final List<CarouselProperties> carouselList;

	/**
	 * Constants
	 */
	private final static String SMALL_TITLE = "smallTitle";
	private final static String CAROUSEL_LIST = "carouselList";
	private final static String LARGE_TEXT = "largeTitle";
	private final static String DESCRIPTION = "description";
	private final static String BUTTON_TEXT = "buttonText";
	private final static String DEFAULT_BUTTON_TEXT = "Find Out More";
	private final static String BUTTON_TEXT_LINK = "buttonTextLink";

	public Carousel(SlingHttpServletRequest request) {
		carouselList = new ArrayList<CarouselProperties>();
		Image carouselBackgroundImage = new Image(request.getResource(), "backgroundImage");
		if (carouselBackgroundImage != null && carouselBackgroundImage.hasContent()) {
			carouselBackgroundImagePath = carouselBackgroundImage.getPath();
		}
		try {
			Iterable<Resource> resources = request.getResource().getChild(CAROUSEL_LIST).getChildren();
			for (Resource resource : resources) {
				ValueMap carouselProps = resource.adaptTo(ValueMap.class);
				CarouselProperties carouselProperties = new CarouselProperties();
				String carouselHeaderLockupSmallTitle = carouselProps.get(SMALL_TITLE, StringUtils.EMPTY);
				String carouselHeaderLockupLargeTitle = carouselProps.get(LARGE_TEXT, StringUtils.EMPTY);
				String carouselHeaderLockupDescription = carouselProps.get(DESCRIPTION, StringUtils.EMPTY);
				String carouselButtonText = carouselProps.get(BUTTON_TEXT, DEFAULT_BUTTON_TEXT);
				String carouselButtonTextLink = carouselProps.get(BUTTON_TEXT_LINK, StringUtils.EMPTY)
					+ CQJCRConstants.HTML_EXTENSION;

				carouselProperties.setCarouselHeaderLockupSmallTitle(carouselHeaderLockupSmallTitle);
				carouselProperties.setCarouselHeaderLockupLargeTitle(carouselHeaderLockupLargeTitle);
				carouselProperties.setCarouselHeaderLockupDescription(carouselHeaderLockupDescription);
				carouselProperties.setCarouselButtonText(carouselButtonText);
				carouselProperties.setCarouselButtonTextLink(carouselButtonTextLink);
				carouselList.add(carouselProperties);
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
	}

	public String getCarouselBackgroundImagePath() {
		return carouselBackgroundImagePath;
	}

	public List<CarouselProperties> getCarouselList() {
		return carouselList;
	}

}
