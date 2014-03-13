package com.australia.www.components.content.sharethis;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.scripting.SlingBindings;
import org.apache.sling.api.scripting.SlingScriptHelper;

import com.australia.sharethis.service.ShareThisService;
import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Option;
import com.citytechinc.cq.component.annotations.widgets.PathField;
import com.citytechinc.cq.component.annotations.widgets.Selection;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

@Component(value = "Share This")
public class ShareThis {

	// @DialogField(fieldLabel = "Share URL", listeners = { @Listener(name =
	// "afteredit", value = "REFRESH_PAGE") })
	@DialogField(fieldLabel = "Share URL")
	@Selection(type = Selection.RADIO, options = { @Option(value = "current", text = "Current Page"),
		@Option(value = "share", text = "Share URL"), @Option(value = "custom", text = "Custom URL") })
	private final String shareType;

	@DialogField(fieldLabel = "", fieldDescription = "A custom URL to share")
	@PathField
	private String customUrl;

	private String shareUrl;

	private final String accountId;

	public ShareThis(SlingHttpServletRequest request) {
		SlingScriptHelper sling = ((SlingBindings) request.getAttribute(SlingBindings.class.getName())).getSling();
		ShareThisService shareThisService = sling.getService(ShareThisService.class);
		accountId = shareThisService.getAccountId();

		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		shareType = properties.get("shareType", "current");
		if ("share".equals(shareType)) {
			shareUrl = "???";
		} else if ("custom".equals(shareType)) {
			shareUrl = properties.get("customUrl", "");
		} else {
			// share type is current
			Page currentPage = request.getResourceResolver().adaptTo(PageManager.class)
				.getContainingPage(request.getResource());

			shareUrl = currentPage.getPath() + ".html";
		}
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

}
