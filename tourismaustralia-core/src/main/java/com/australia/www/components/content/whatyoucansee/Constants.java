package com.australia.www.components.content.whatyoucansee;

final class Constants {

	public static final String NAME_TAG = "tag";
	public static final String NAME_TITLE = "title";
	public static final String NAME_TEXT = "text";
	public static final String NAME_TAB_3_TITLE = "optionalTabTitle";
	public static final String NAME_SHOW_THINGS_TO_DO = "showThingsToDo";
	public static final String NAME_SHOW_EVENTS = "showEvents";
	public static final String NAME_SHOW_OPTIONAL_TAB = "showOptionalTab";
	public static final String NAME_OPTIONAL_TAB_SIZE = "optionalTabSize";
	public static final String NAME_OPTIONAL_TAB_PATH_0 = "optionalTabPath0";
	public static final String NAME_OPTIONAL_TAB_PATH_1 = "optionalTabPath1";
	public static final String NAME_OPTIONAL_TAB_PATH_2 = "optionalTabPath2";
	public static final String NAME_OPTIONAL_TAB_PATH_3 = "optionalTabPath3";
	public static final String NAME_OPTIONAL_TAB_PATH_4 = "optionalTabPath4";
	public static final String NAME_OPTIONAL_TAB_PATH_5 = "optionalTabPath5";
	public static final String NAME_OPTIONAL_TAB_PATH_6 = "optionalTabPath6";
	public static final String NAME_OPTIONAL_TAB_PATH_7 = "optionalTabPath7";
	public static final String NAME_OPTIONAL_TAB_PATH_8 = "optionalTabPath8";
	public static final String NAME_OPTIONAL_TAB_PATH_9 = "optionalTabPath9";
	public static final String TAB_3_SIZE_5 = "5";
	public static final String TAB_3_SIZE_10 = "10";

	public static final String BASE_IMAGE_PATH = "/etc/designs/tourismaustralia/clientlibs/img/";
	public static final String TTD_IMAGE_PATH = BASE_IMAGE_PATH + "icons/menu.png";
	public static final String TTD_OUTLINE_IMAGE_PATH = BASE_IMAGE_PATH + "icons/menu_outline.png";
	public static final String EVENTS_IMAGE_PATH = BASE_IMAGE_PATH + "icons/events.png";
	public static final String EVENTS_OUTLINE_IMAGE_PATH = BASE_IMAGE_PATH + "icons/events_outline.png";
	public static final String OPTIONAL_IMAGE_PATH = BASE_IMAGE_PATH + "icons/star.png";
	public static final String OPTIONAL_OUTLINE_IMAGE_PATH = BASE_IMAGE_PATH + "icons/star_outline.png";

	public static final String TAB_GENERAL = "General";
	public static final String TAB_CATEGORIES = "Categories";
	public static final String TAB_TAB_3 = "Additional Tab";

	public static final String TTD_TAB_TITLE = "Things To Do";
	public static final String TTD_TAB_VIEW_MORE = "View All Highlights";

	public static final String EVENTS_TAB_TITLE = "What's Coming Up";
	public static final String EVENTS_TAB_VIEW_MORE = "View All Events";

	public static final String SIZE_CHANGE_LISTENER = "function(field){"
		+ "var value = field.getValue();"
		+ "var disable = (value === '5');"
		+ "var sibling = field.nextSibling();"
		+ "  while(sibling) {"
		+ "    var siblingName = sibling.getName();"
		+ "    var lastChar = siblingName.substr(siblingName.length - 1);"
		+ "    var index = parseInt(lastChar);"
		+ "    if(index >= 5) {"
		+ "      sibling.setDisabled(disable);"
		+ "      sibling.setVisible(!disable);"
		+ "    }"
		+ "    sibling = sibling.nextSibling();"
		+ "  }"
		+ "}";

	public static final String PATH_SELECT_LISTENER = "function(combo, record, index){"
		+ "  var value = record.data['path'];"
		+ "  combo.setValue(value);"
		+ "}";

	// Disallow instantiation of utility class
	private Constants() { }

}
