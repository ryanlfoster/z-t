package com.australia.www.components.page.atdwsearch;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.australia.atdw.domain.ATDWCategory;

public class Constants {

	public static final List<ATDWCategory> CATEGORY_ORDERING = Collections.unmodifiableList(Arrays.asList(
		ATDWCategory.ACCOMEDATIONS, ATDWCategory.ATTRACTION, ATDWCategory.RESTAURANT, ATDWCategory.TOUR,
		ATDWCategory.HIRE, ATDWCategory.EVENT, ATDWCategory.TRANSPORT));

	public static final String ICON_BASE_PATH = "/etc/designs/tourismaustralia/clientlibs/imgs/icons/";

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
		case ACCOMEDATIONS:
			return NAME_SHOW_ACCOMMODATIONS;
		case ATTRACTION:
			return NAME_SHOW_ATTRACTIONS;
		case RESTAURANT:
			return NAME_SHOW_RESTAURANTS;
		case TOUR:
			return NAME_SHOW_TOURS;
		case HIRE:
			return NAME_SHOW_HIRE;
		case EVENT:
			return NAME_SHOW_EVENTS;
		case TRANSPORT:
			return NAME_SHOW_TRANSPORT;
		default:
			return "";
		}
	}

	public static String getDisplayString(ATDWCategory category) {
		switch (category) {
		case ACCOMEDATIONS:
			return "Accommodation";
		case ATTRACTION:
			return "Attractions";
		case RESTAURANT:
			return "Restaurants";
		case TOUR:
			return "Tours";
		case HIRE:
			return "Hire";
		case EVENT:
			return "Events";
		case TRANSPORT:
			return "Transport";
		default:
			return "";
		}
	}

	public static String getImageString(ATDWCategory category) {
		switch (category) {
		case ACCOMEDATIONS:
			return "accommodation";
		case TOUR:
			return "tours";
		case EVENT:
			return "events";
		default:
			return category.name().toLowerCase();
		}
	}

}
