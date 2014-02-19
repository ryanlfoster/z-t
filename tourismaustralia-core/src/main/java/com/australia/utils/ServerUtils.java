package com.australia.utils;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.settings.SlingSettingsService;

import com.australia.server.ServerNameService;

public class ServerUtils {
	private ServerUtils() {
	}

	public static final String AUTHOR = "author";
	public static final String PUBLISH = "publish";

	public static String getServerURL(SlingSettingsService slingSettings, ServerNameService serverNameService,
		SlingHttpServletRequest request) {
		if (slingSettings.getRunModes().contains(AUTHOR)) {
			return serverNameService.getAuthorServerName();
		} else {
			if (serverNameService.getAustraliaComServerName().contains(request.getServerName())) {
				return serverNameService.getAustraliaComServerName();
			} else if (serverNameService.getFoodAndWineServerName().contains(request.getServerName())) {
				return serverNameService.getFoodAndWineServerName();
			} else {
				return null;
			}
		}
	}

	public static Site getSite(SlingSettingsService slingSettings, ServerNameService serverNameService,
		SlingHttpServletRequest request) {
		if (serverNameService.getAustraliaComServerName().contains(request.getServerName())) {
			return Site.OZCOM;
		} else if (serverNameService.getFoodAndWineServerName().contains(request.getServerName())) {
			return Site.FOOD_AND_WINE;
		} else {
			return null;
		}
	}
}
