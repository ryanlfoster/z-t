package com.australia.www.components.content.itineraryday;

import com.citytechinc.cq.component.annotations.*;
import com.citytechinc.cq.component.annotations.widgets.Html5SmartImage;
import com.citytechinc.cq.component.annotations.widgets.RichTextEditor;
import com.day.cq.wcm.foundation.Image;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing bean for the Itinerary Day component
 */
@Component(value="Itinerary Day",
        tabs={
            @Tab(title= Constants.TAB_GENERAL),
            @Tab(title=Constants.TAB_HERO),
            @Tab(title=Constants.TAB_IMAGE_1),
            @Tab(title=Constants.TAB_IMAGE_2),
            @Tab(title=Constants.TAB_IMAGE_3),
            @Tab(title=Constants.TAB_IMAGE_4),
            @Tab(title=Constants.TAB_MAP)
        },
        listeners = {
            @Listener(name="afteredit", value="REFRESH_PAGE"),
            @Listener(name="afterinsert", value="REFRESH_PAGE")
        }
)
public class ItineraryDay {

    /**
     * Backing bean representing a link to a sibling ItineraryDay, used for building the list of day links
     */
    public static class ItineraryDayLink {

        public static ItineraryDayLink fromResource(Resource day, Resource currentDay) {
            ValueMap properties = day.adaptTo(ValueMap.class);
            return new ItineraryDayLink(day.getName(), properties.get(Constants.NAME_HERO_TITLE, ""), day.equals(currentDay));
        }

        private final String anchor;
        private final String text;
        private final boolean currentDay;

        public ItineraryDayLink(String anchor, String text, boolean currentDay) {
            this.anchor = anchor;
            this.text = text;
            this.currentDay = currentDay;
        }

        public String getAnchor() {
            return anchor;
        }

        public String getText() {
            return text;
        }

        public boolean isCurrentDay() {
            return currentDay;
        }
    }

    @DialogField(fieldLabel="Text Title", tab=1)
    private final String textTitle;

    @DialogField(fieldLabel="Text", tab=1)
    @RichTextEditor
    private final String text;

    @DialogField(fieldLabel="Hero Image", tab=2, required=true)
    @Html5SmartImage(tab=false, name=Constants.NAME_HERO_IMAGE, height=400)
    private final String heroImage;

    @DialogField(fieldLabel="Hero Image Title", tab=2, required=true)
    private final String heroTitle;

    @DialogField(fieldLabel="Hero Image Alt Text", tab=2, required=true, xtype="textarea",
            additionalProperties={@FieldProperty(name="grow", value="true")})
    private final String heroImageAltText;

    @DialogField(fieldLabel="Image 1 (16:9)", tab=3)
    @Html5SmartImage(tab=false, name=Constants.NAME_IMAGE_1, height=400)
    private final String image1;

    @DialogField(fieldLabel="Image 1 Alt Text", tab=3, xtype="textarea",
            additionalProperties={@FieldProperty(name="grow", value="true")})
    private final String image1AltText;

    @DialogField(fieldLabel="Image 2 (16:9)", tab=4)
    @Html5SmartImage(tab=false, name=Constants.NAME_IMAGE_2, height=400)
    private final String image2;

    @DialogField(fieldLabel="Image 2 Alt Text", tab=4, xtype="textarea",
            additionalProperties={@FieldProperty(name="grow", value="true")})
    private final String image2AltText;
    
    @DialogField(fieldLabel="Image 3 (1:1)", tab=5)
    @Html5SmartImage(tab=false, name=Constants.NAME_IMAGE_3, height=400)
    private final String image3;

    @DialogField(fieldLabel="Image 3 Alt Text", tab=5, xtype="textarea",
            additionalProperties={@FieldProperty(name="grow", value="true")})
    private final String image3AltText;

    @DialogField(fieldLabel="Image 4 ", tab=6)
    @Html5SmartImage(tab=false, name=Constants.NAME_IMAGE_4, height=400)
    private final String image4;

    @DialogField(fieldLabel="Image 4 Alt Text", tab=6, xtype="textarea",
            additionalProperties={@FieldProperty(name="grow", value="true")})
    private final String image4AltText;

    @DialogField(fieldLabel="Map Image", tab=7)
    @Html5SmartImage(tab=false, name=Constants.NAME_MAP_IMAGE, height=400)
    private final String mapImage;

    private final String anchorId;

    private final List<ItineraryDayLink> dayLinks = new ArrayList<ItineraryDayLink>();

    public ItineraryDay(SlingHttpServletRequest request) {

        Resource resource = request.getResource();
        ValueMap properties = resource.adaptTo(ValueMap.class);

        textTitle = properties.get(Constants.NAME_TEXT_TITLE, "");
        text = properties.get(Constants.NAME_TEXT, "");

        Image imageObj = new Image(request.getResource(), Constants.NAME_HERO_IMAGE);
        heroImage = imageObj.hasContent() ? imageObj.getPath() : null;
        heroImageAltText = properties.get(Constants.NAME_HERO_IMAGE_ALT_TEXT, "");
        heroTitle = properties.get(Constants.NAME_HERO_TITLE, "");

        imageObj = new Image(request.getResource(), Constants.NAME_IMAGE_1);
        image1 = imageObj.hasContent() ? imageObj.getPath() : null;
        image1AltText = properties.get(Constants.NAME_IMAGE_1_ALT_TEXT, "");

        imageObj = new Image(request.getResource(), Constants.NAME_IMAGE_2);
        image2 = imageObj.hasContent() ? imageObj.getPath() : null;
        image2AltText = properties.get(Constants.NAME_IMAGE_2_ALT_TEXT, "");

        imageObj = new Image(request.getResource(), Constants.NAME_IMAGE_3);
        image3 = imageObj.hasContent() ? imageObj.getPath() : null;
        image3AltText = properties.get(Constants.NAME_IMAGE_3_ALT_TEXT, "");

        imageObj = new Image(request.getResource(), Constants.NAME_IMAGE_4);
        image4 = imageObj.hasContent() ? imageObj.getPath() : null;
        image4AltText = properties.get(Constants.NAME_IMAGE_4_ALT_TEXT, "");

        imageObj = new Image(request.getResource(), Constants.NAME_MAP_IMAGE);
        mapImage = imageObj.hasContent() ? imageObj.getPath() : null;

        anchorId = resource.getName();

        Resource parent = resource.getParent();
        for(Resource child: parent.getChildren()) {
            if(child.isResourceType(Constants.RESOURCE_TYPE)) {
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
