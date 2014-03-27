package com.australia.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.settings.SlingSettingsService;

import com.australia.server.ServerNameService;

public class ServerUtils {
	private ServerUtils() {
	}

	public static final String AUTHOR = "author";
	public static final String PUBLISH = "publish";
	public static final String LOCAL = "local";

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

	public static String getLanguageCode(SlingHttpServletRequest request) {
		Pattern p = Pattern.compile("/([a-z]{2})/.*");
		Matcher m = p.matcher(request.getPathInfo());
		if (m.find()) {
			String tempLang = m.group(1);
			if (!request.getResourceResolver().resolve(PathUtils.OZCOM_ROOT_PATH.concat("/" + tempLang))
				.isResourceType(Resource.RESOURCE_TYPE_NON_EXISTING)) {
				return tempLang;
			}
		}
		return "";
	}

	public static boolean isAuthor(SlingSettingsService slingSettings) {
		return slingSettings.getRunModes().contains(AUTHOR);
	}

	public static boolean isLocal(SlingSettingsService slingSettings) {
		return slingSettings.getRunModes().contains(LOCAL);
	}

}
