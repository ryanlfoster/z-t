package com.australia.utils;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.settings.SlingSettingsService;

import com.australia.server.ServerNameService;

public class ServerUtils {
	private ServerUtils() {
	}

	public static final String AUTHOR = "author";
	public static final String PUBLISH = "publish";

	public static final String SITE_NAME_OZCOM = "australia";
	public static final String SITE_NAME_FOODWINE = "food-and-wine";

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
}
