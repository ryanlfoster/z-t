package com.australia.foodandwine.components.content.sharethis;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.scripting.SlingBindings;
import org.apache.sling.api.scripting.SlingScriptHelper;
import org.apache.sling.commons.json.JSONArray;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.apache.sling.commons.osgi.PropertiesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.australia.sharethis.service.ShareThisService;
import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.Listener;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

@Component(disableTargeting = true, group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", value = "ShareThis", listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class ShareThis {
	private static final Logger LOG = LoggerFactory.getLogger(ShareThis.class);
	private final String[] socnets = { "FACEBOOK", "TWITTER", "EMAIL" };

	private final String shareType;
	private final String shareUrl;
	private final String socialNetworks;
	private final String accountId;

	public ShareThis(SlingHttpServletRequest request) {
		SlingScriptHelper sling = ((SlingBindings) request.getAttribute(SlingBindings.class.getName())).getSling();
		ShareThisService shareThisService = sling.getService(ShareThisService.class);
		accountId = shareThisService.getAccountId();

		Page currentPage = request.getResourceResolver().adaptTo(PageManager.class)
			.getContainingPage(request.getResource());

		shareType = "current"; // default11;
		shareUrl = currentPage.getPath() + ".html";
		socialNetworks = this.getSocialNetworks(request).toString();
	}

	private JSONArray getSocialNetworks(SlingHttpServletRequest request) {
		JSONArray jsonarray = new JSONArray();
		try {
			JSONObject json = new JSONObject();
			json.accumulate("country", "default");
			json.accumulate("types", StringUtils.join(PropertiesUtil.toStringArray(socnets), ","));
			jsonarray.put(json);
		} catch (JSONException e) {
			LOG.error("There was an error generating the json for SocialNetworks", e);
		}
		return jsonarray;
	}

	public String getShareType() {
		return shareType;
	}

	public String getShareUrl() {
		return shareUrl;
	}

	public String getAccountId() {
		return accountId;
	}

	public String getSocialNetworks() {
		return socialNetworks;
	}

}
