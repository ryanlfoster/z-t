package com.australia.errorhandler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.scripting.SlingBindings;
import org.apache.sling.api.scripting.SlingScriptHelper;
import org.apache.sling.settings.SlingSettingsService;

import com.australia.server.ServerNameService;
import com.australia.utils.PathUtils;
import com.australia.utils.ServerUtils;
import com.australia.utils.Site;

public class Sling404ErrorHandler {
	private static final String DEFAULT_ERROR_HANDLER_PATH = "/libs/sling/servlet/errorhandler/default.jsp";
	private static final String DEFAULT_LANGAUGE = "en";
	private final String pageLocation;

	public Sling404ErrorHandler(SlingHttpServletRequest request) {
		SlingScriptHelper sling = ((SlingBindings) request.getAttribute(SlingBindings.class.getName())).getSling();
		SlingSettingsService slingSettings = sling.getService(SlingSettingsService.class);
		ServerNameService serverNameService = sling.getService(ServerNameService.class);

		Site site = ServerUtils.getSite(slingSettings, serverNameService, request);
		switch (site) {
		case OZCOM:
			String tempLoc = PathUtils.OZCOM_404;
			String lang = DEFAULT_LANGAUGE;
			Pattern p = Pattern.compile("/([a-z]{2})/.*");
			Matcher m = p.matcher(request.getPathInfo());
			if (m.find()) {
				String tempLang = m.group(1);
				if (request.getResourceResolver().resolve(String.format(tempLoc, tempLang)) != null) {
					lang = tempLang;
				}
			}
			pageLocation = String.format(tempLoc, lang);
			break;
		case FOOD_AND_WINE:
			pageLocation = PathUtils.FOOD_AND_WINE_404;
			break;
		default:
			pageLocation = DEFAULT_ERROR_HANDLER_PATH;
			break;
		}
	}

	public String getPageLocation() {
		return pageLocation;
	}
}
