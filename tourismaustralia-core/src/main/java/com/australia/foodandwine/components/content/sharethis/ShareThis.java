package com.australia.foodandwine.components.content.sharethis;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.scripting.SlingBindings;
import org.apache.sling.api.scripting.SlingScriptHelper;
import org.apache.sling.commons.json.JSONArray;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.apache.sling.commons.osgi.PropertiesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.australia.sharethis.service.ShareThisService;
import com.australia.www.components.page.sharethis.DefaultShareThisConfig;
import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Listener;
import com.citytechinc.cq.component.annotations.Option;
import com.citytechinc.cq.component.annotations.Tab;
import com.citytechinc.cq.component.annotations.widgets.DialogFieldSet;
import com.citytechinc.cq.component.annotations.widgets.PathField;
import com.citytechinc.cq.component.annotations.widgets.Selection;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

@Component(group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", value = "ShareThis", tabs = {
	@Tab(title = "Path Info"), @Tab(title = "Social Networks") }, listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class ShareThis {
	private static final Logger LOG = LoggerFactory.getLogger(ShareThis.class);

	@DialogField(tab = 2, hideLabel = true)
	@DialogFieldSet(border = false, collapsible = false)
	private DefaultShareThisConfig defaultConfig;

	@DialogField(fieldLabel = "Share URL", tab = 1, listeners = { @Listener(name = "selectionchanged", value = "function(){var customurl = this.findParentByType('dialog').getField('./customUrl'); this.getValue()=='custom'?customurl.show():customurl.hide()}") })
	@Selection(type = Selection.RADIO, options = { @Option(value = "current", text = "Current Page"),
		@Option(value = "custom", text = "Custom URL") })
	private String shareType;

	@DialogField(fieldLabel = "")
	@PathField
	private String customUrl;

	private String shareUrl;

	private String socialNetworks;

	private final String accountId;

	public ShareThis(SlingHttpServletRequest request) {
		SlingScriptHelper sling = ((SlingBindings) request.getAttribute(SlingBindings.class.getName())).getSling();
		ShareThisService shareThisService = sling.getService(ShareThisService.class);
		accountId = shareThisService.getAccountId();
		shareType = "current"; // default;
		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		if (properties != null) {
			shareType = properties.get("shareType", "current");
			if ("share".equals(shareType)) {
				// shareUrl = PathUtils.SHARE_ID_URL;
			} else if ("custom".equals(shareType)) {
				shareUrl = properties.get("customUrl", "");
			} else {
				// share type is current
				Page currentPage = request.getResourceResolver().adaptTo(PageManager.class)
					.getContainingPage(request.getResource());

				shareUrl = currentPage.getPath() + ".html";
			}

			socialNetworks = this.getSocialNetworks(request).toString();
		}
	}

	/**
	 * Gets the social networks to be used by ShareThis. The list of social
	 * networks is available by country, but if the country code is not found a
	 * default set is used.
	 * 
	 * @param request - used to get the resolve resolver
	 * @return the social networks as a json array
	 */
	private JSONArray getSocialNetworks(SlingHttpServletRequest request) {
		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		JSONArray jsonarray = new JSONArray();
		JSONObject json = new JSONObject();
		try {
			// write the DEFAULT social networks
			json.accumulate("country", "default");
			json.accumulate("types",
				StringUtils.join(PropertiesUtil.toStringArray(properties.get("socialNetworks"), new String[0]), ","));
			jsonarray.put(json);
		} catch (JSONException e) {
			LOG.error("There was an error generating the json for SocialNetworks", e);
		}
		return jsonarray;
	}

	public String getShareType() {
		return shareType;
	}

	public String getCustomUrl() {
		return customUrl;
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
