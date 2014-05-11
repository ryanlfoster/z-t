package com.australia.pagecategories;

import java.util.HashMap;
import java.util.Map;

public enum PageCategory {

	ABORIGINAL_AUSTRALIA,
	ADVENTURE,
	ART_CULTURE,
	BEACHES,
	FOOD_WINE,
	ISLAND,
	NATURE_WILDLIFE,
	OUTBACK,
	SPORTS;

	private static final String ICON_BASE_PATH = "/etc/designs/tourismaustralia/clientlibs/imgs/icons/";
	private static final String OUTLINE_POSTFIX = "_outline";
	private static final String WHITE_OUTLINE_POSTFIX = "_white_outline";
	private static final String STROKE_POSTFIX = "_stroke";
	private static final String ICON_EXTENSION = ".png";

	private static final Map<String, PageCategory> DISPLAY_MAP = new HashMap<String, PageCategory>();
	static {
		for (PageCategory pc : PageCategory.values()) {
			DISPLAY_MAP.put(pc.toDisplayString(), pc);
		}
	}

	public static PageCategory fromDisplayString(String display) {
		return DISPLAY_MAP.get(display);
	}

	public String getStandardIcon() {
		return ICON_BASE_PATH + this.getIconId() + ICON_EXTENSION;
	}

	public String getOutlineIcon() {
		return ICON_BASE_PATH + this.getIconId() + OUTLINE_POSTFIX + ICON_EXTENSION;
	}

	public String getWhiteOutlineIcon() {
		return ICON_BASE_PATH + this.getIconId() + WHITE_OUTLINE_POSTFIX + ICON_EXTENSION;
	}

	public String getStrokeIcon() {
		return ICON_BASE_PATH + this.getIconId() + STROKE_POSTFIX + ICON_EXTENSION;
	}

	public String getCssClass() {
		switch (this) {
		case ABORIGINAL_AUSTRALIA:
			return "aboriginal";
		case ADVENTURE:
			return "adventure";
		case ART_CULTURE:
			return "arts";
		case BEACHES:
			return "beaches";
		case FOOD_WINE:
			return "food";
		case ISLAND:
			return "islands";
		case NATURE_WILDLIFE:
			return "nature";
		case OUTBACK:
			return "outback";
		case SPORTS:
			return "sports";
		default:
			return "";
		}
	}

	public String getThemeCssClass() {
		return "theme-" + this.getCssClass();
	}

	private String getIconId() {
		return this.name().toLowerCase();
	}

	public String toDisplayString() {
		return this.name().replace("_", " ").toLowerCase();
	}

	@Override
	public String toString() {
		return toDisplayString();
	}

}
