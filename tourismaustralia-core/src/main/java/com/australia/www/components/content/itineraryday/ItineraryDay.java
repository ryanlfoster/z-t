package com.australia.www.components.content.itineraryday;

import com.citytechinc.cq.component.annotations.*;
import com.citytechinc.cq.component.annotations.widgets.Html5SmartImage;
import com.citytechinc.cq.component.annotations.widgets.RichTextEditor;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing bean for the Itinerary Day component
 */
@Component(value = "Itinerary Day",
        tabs = {
            @Tab(title = Constants.TAB_TEXT_NAME),
            @Tab(title = Constants.TAB_HERO_NAME),
            @Tab(title = Constants.TAB_IMAGE_1_NAME),
            @Tab(title = Constants.TAB_IMAGE_2_NAME),
            @Tab(title = Constants.TAB_IMAGE_3_NAME),
            @Tab(title = Constants.TAB_IMAGE_4_NAME),
            @Tab(title = Constants.TAB_MAP_NAME)
        },
        listeners = {
            @Listener(name = "afteredit", value = "REFRESH_PARENT"),
			@Listener(name = "afterinsert", value = "REFRESH_PARENT"),
			@Listener(name = "aftermove", value = "REFRESH_PARENT"),
			@Listener(name = "afterremove", value = "REFRESH_PARENT")
        }
)
public final class ItineraryDay {

    /**
     * Backing bean representing a link to a sibling ItineraryDay, used for building the list of day links
     */
    public static class ItineraryDayLink {

		private final String anchor;
		private final String text;
		private final boolean currentDay;

        public ItineraryDayLink(final String anchor, final String text, final boolean currentDay) {
            this.anchor = anchor;
            this.text = text;
            this.currentDay = currentDay;
        }

        public final String getAnchor() {
            return anchor;
        }

        public final String getText() {
            return text;
        }

        public final boolean isCurrentDay() {
            return currentDay;
        }

		public static ItineraryDayLink fromResource(final Resource day, final Resource currentDay) {
			final ValueMap properties = day.adaptTo(ValueMap.class);
			return new ItineraryDayLink(day.getName(), properties.get(Constants.NAME_HERO_TITLE, ""),
				day.equals(currentDay));
		}
    }

    @DialogField(fieldLabel = "Text Title", tab = Constants.TAB_TEXT_INDEX)
    private final String textTitle;

    @DialogField(fieldLabel = "Text", tab = Constants.TAB_TEXT_INDEX)
    @RichTextEditor
    private final String text;

    @DialogField(fieldLabel = "Hero Image", tab = Constants.TAB_HERO_INDEX, required = true)
    @Html5SmartImage(tab = false, name = Constants.NAME_HERO_IMAGE, height = Constants.IMAGE_WIDGET_HEIGHT,
		fileReferenceParameter = Constants.FILE_REF_NAME)
    private final String heroImage;

    @DialogField(fieldLabel = "Hero Image Title", tab = Constants.TAB_HERO_INDEX, required = true)
    private final String heroTitle;

    @DialogField(fieldLabel = "Hero Image Alt Text", tab = Constants.TAB_HERO_INDEX, required = true,
		xtype = "textarea",
		additionalProperties = {@FieldProperty(name = "grow", value = "true")
		}
	)
    private final String heroImageAltText;

    @DialogField(fieldLabel = "Image 1 (16:9)", tab = Constants.TAB_IMAGE_1_INDEX)
    @Html5SmartImage(tab = false, name = Constants.NAME_IMAGE_1, height = Constants.IMAGE_WIDGET_HEIGHT,
		fileReferenceParameter = Constants.FILE_REF_NAME)
    private final String image1;

    @DialogField(fieldLabel = "Image 1 Alt Text", tab = Constants.TAB_IMAGE_1_INDEX, xtype = "textarea",
            additionalProperties = {@FieldProperty(name = "grow", value = "true")
			}
	)
    private final String image1AltText;

    @DialogField(fieldLabel = "Image 2 (16:9)", tab = Constants.TAB_IMAGE_2_INDEX)
    @Html5SmartImage(tab = false, name = Constants.NAME_IMAGE_2, height = Constants.IMAGE_WIDGET_HEIGHT,
		fileReferenceParameter = Constants.FILE_REF_NAME)
    private final String image2;

    @DialogField(fieldLabel = "Image 2 Alt Text", tab = Constants.TAB_IMAGE_2_INDEX, xtype = "textarea",
            additionalProperties = {@FieldProperty(name = "grow", value = "true")
			}
	)
    private final String image2AltText;
    
    @DialogField(fieldLabel = "Image 3 (1:1)", tab = Constants.TAB_IMAGE_3_INDEX)
    @Html5SmartImage(tab = false, name = Constants.NAME_IMAGE_3, height = Constants.IMAGE_WIDGET_HEIGHT,
		fileReferenceParameter = Constants.FILE_REF_NAME)
    private final String image3;

    @DialogField(fieldLabel = "Image 3 Alt Text", tab = Constants.TAB_IMAGE_3_INDEX, xtype = "textarea",
            additionalProperties = {@FieldProperty(name = "grow", value = "true")
			}
	)
    private final String image3AltText;

    @DialogField(fieldLabel = "Image 4 ", tab = Constants.TAB_IMAGE_4_INDEX)
    @Html5SmartImage(tab = false, name = Constants.NAME_IMAGE_4, height = Constants.IMAGE_WIDGET_HEIGHT,
		fileReferenceParameter = Constants.FILE_REF_NAME)
    private final String image4;

    @DialogField(fieldLabel = "Image 4 Alt Text", tab = Constants.TAB_IMAGE_4_INDEX, xtype = "textarea",
            additionalProperties = {@FieldProperty(name = "grow", value = "true")
			}
	)
    private final String image4AltText;

    @DialogField(fieldLabel = "Map Image", tab = Constants.TAB_MAP_INDEX)
    @Html5SmartImage(tab = false, name = Constants.NAME_MAP_IMAGE, height = Constants.IMAGE_WIDGET_HEIGHT,
		fileReferenceParameter = Constants.FILE_REF_NAME)
    private final String mapImage;

    private final String anchorId;

    private final List<ItineraryDayLink> dayLinks = new ArrayList<ItineraryDayLink>();

    public ItineraryDay(final SlingHttpServletRequest request) {

        final Resource resource = request.getResource();
        final ValueMap properties = resource.adaptTo(ValueMap.class);

        textTitle = properties.get(Constants.NAME_TEXT_TITLE, "");
        text = properties.get(Constants.NAME_TEXT, "");

        heroImage = properties.get(Constants.NAME_HERO_IMAGE + "/" + Constants.FILE_REF_NAME, String.class);
        heroImageAltText = properties.get(Constants.NAME_HERO_IMAGE_ALT_TEXT, "");
        heroTitle = properties.get(Constants.NAME_HERO_TITLE, "");

		image1 = properties.get(Constants.NAME_IMAGE_1 + "/" + Constants.FILE_REF_NAME, String.class);
        image1AltText = properties.get(Constants.NAME_IMAGE_1_ALT_TEXT, "");

		image2 = properties.get(Constants.NAME_IMAGE_2 + "/" + Constants.FILE_REF_NAME, String.class);
        image2AltText = properties.get(Constants.NAME_IMAGE_2_ALT_TEXT, "");

		image3 = properties.get(Constants.NAME_IMAGE_3 + "/" + Constants.FILE_REF_NAME, String.class);
        image3AltText = properties.get(Constants.NAME_IMAGE_3_ALT_TEXT, "");

		image4 = properties.get(Constants.NAME_IMAGE_4 + "/" + Constants.FILE_REF_NAME, String.class);
        image4AltText = properties.get(Constants.NAME_IMAGE_4_ALT_TEXT, "");

		mapImage = properties.get(Constants.NAME_MAP_IMAGE + "/" + Constants.FILE_REF_NAME, String.class);

        anchorId = resource.getName();

        final Resource parent = resource.getParent();
        for (final Resource child: parent.getChildren()) {
            if (child.isResourceType(Constants.RESOURCE_TYPE)) {
                dayLinks.add(ItineraryDayLink.fromResource(child, resource));
            }
        }
    }

    public String getTextTitle() {
        return textTitle;
    }

    public String getText() {
        return text;
    }

    public String getHeroImage() {
        return heroImage;
    }

    public String getHeroTitle() {
        return heroTitle;
    }

    public String getHeroImageAltText() {
        return heroImageAltText;
    }

    public String getImage1() {
        return image1;
    }

    public String getImage1AltText() {
        return image1AltText;
    }

    public String getImage2() {
        return image2;
    }

    public String getImage2AltText() {
        return image2AltText;
    }

    public String getImage3() {
        return image3;
    }

    public String getImage3AltText() {
        return image3AltText;
    }

    public String getImage4() {
        return image4;
    }

    public String getImage4AltText() {
        return image4AltText;
    }

    public String getMapImage() {
        return mapImage;
    }

    public String getAnchorId() {
        return anchorId;
    }

    public List<ItineraryDayLink> getDayLinks() {
        return dayLinks;
    }
}
