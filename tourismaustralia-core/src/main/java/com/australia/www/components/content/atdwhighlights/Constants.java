package com.australia.www.components.content.atdwhighlights;

import com.australia.atdw.domain.ATDWCategory;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by gsnyder on 4/1/14.
 */
class Constants {

    public static final List<ATDWCategory> CATEGORY_ORDERING = Collections.unmodifiableList(Arrays.asList(
            ATDWCategory.ACCOMEDATIONS,
            ATDWCategory.ATTRACTION,
            ATDWCategory.RESTAURANT,
            ATDWCategory.TOUR,
            ATDWCategory.HIRE,
            ATDWCategory.EVENT,
            ATDWCategory.TRANSPORT
    ));

    public static final String PLACE_TAG_PREFIX = "ta:places/";
    public static final String STATE_TAG_REGEX = "^" + PLACE_TAG_PREFIX + "[^/]+$";
    public static final String CITY_TAG_REGEX = "^" + PLACE_TAG_PREFIX + "[^/]+/[^/]+$";

    public static final String ICON_BASE_PATH = "/etc/designs/tourismaustralia/clientlibs/img/icons/";

    public static final String TAB_GENERAL = "General";
    public static final String TAB_CATEGORIES = "Categories";

    public static final String NAME_TITLE = "title";
    public static final String NAME_TEXT = "text";
    public static final String NAME_STRATEGY = "strategy";

    public static final String TYPE_TAG = "Tag";
    public static final String TYPE_CITY = "City";
    public static final String TYPE_STATE = "State";
    public static final String TYPE_TERM = "Term";

    public static final String NAME_SHOW_ACCOMMODATIONS = "showAccommodations";
    public static final String NAME_SHOW_ATTRACTIONS = "showAttractions";
    public static final String NAME_SHOW_RESTAURANTS = "showRestaurants";
    public static final String NAME_SHOW_TOURS = "showTours";
    public static final String NAME_SHOW_HIRE = "showHire";
    public static final String NAME_SHOW_EVENTS = "showEvents";
    public static final String NAME_SHOW_TRANSPORT = "showTransport";

    public static final int MOSAIC_COLUMN_COUNT = 3;

    public static String getStandardIconPath(ATDWCategory category) {
        return ICON_BASE_PATH + getImageString(category) + "_outline.png";
    }

    public static String getActiveIconPath(ATDWCategory category) {
        return ICON_BASE_PATH + getImageString(category) + ".png";
    }

    public static String getShowPropertyName(ATDWCategory category) {
        switch (category) {
            case ACCOMEDATIONS: return NAME_SHOW_ACCOMMODATIONS;
            case ATTRACTION: return NAME_SHOW_ATTRACTIONS;
            case RESTAURANT: return NAME_SHOW_RESTAURANTS;
            case TOUR: return NAME_SHOW_TOURS;
            case HIRE: return NAME_SHOW_HIRE;
            case EVENT: return NAME_SHOW_EVENTS;
            case TRANSPORT: return NAME_SHOW_TRANSPORT;
            default:
                return "";
        }
    }

    public static String getDisplayString(ATDWCategory category) {
        switch (category) {
            case ACCOMEDATIONS: return "Accommodation";
            case ATTRACTION: return "Attractions";
            case RESTAURANT: return "Restaurants";
            case TOUR: return "Tours";
            case HIRE: return "Hire";
            case EVENT: return "Events";
            case TRANSPORT: return "Transport";
            default:
                return "";
        }
    }

    public static String getImageString(ATDWCategory category) {
        switch (category) {
            case ACCOMEDATIONS: return "accommodation";
            case TOUR: return "tours";
            case EVENT: return "events";
            default:
                return category.name().toLowerCase();
        }
    }

    /**
     * This class is uninstantiable
     */
    private Constants(){}

}
