package com.australia.www.components.content.sharethis;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.scripting.SlingBindings;
import org.apache.sling.api.scripting.SlingScriptHelper;

import com.australia.sharethis.service.ShareThisService;
import com.australia.utils.LinkUtils;
import com.australia.utils.PathUtils;
import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Listener;
import com.citytechinc.cq.component.annotations.Option;
import com.citytechinc.cq.component.annotations.widgets.PathField;
import com.citytechinc.cq.component.annotations.widgets.Selection;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

@Component(value = "ShareThis", listeners = { @Listener(name = "aftercopy", value = "REFRESH_PAGE"),
	@Listener(name = "afterdelete", value = "REFRESH_PAGE"), @Listener(name = "afteredit", value = "REFRESH_PAGE"),
	@Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class ShareThis {
	@DialogField(fieldLabel = "Share URL", listeners = { @Listener(name = "selectionchanged", value = "function(){var customurl = this.findParentByType('dialog').getField('./customUrl'); this.getValue()=='custom'?customurl.show():customurl.hide()}") })
	@Selection(type = Selection.RADIO, options = { @Option(value = "current", text = "Current Page"),
		@Option(value = "share", text = "Share URL"), @Option(value = "custom", text = "Custom URL") })
	private String shareType;

	@DialogField(fieldLabel = "")
	@PathField
	private String customUrl;

	private String shareUrl;

	private final String accountId;

	public ShareThis(SlingHttpServletRequest request) {
		SlingScriptHelper sling = ((SlingBindings) request.getAttribute(SlingBindings.class.getName())).getSling();
		ShareThisService shareThisService = sling.getService(ShareThisService.class);
		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		accountId = shareThisService.getAccountId();
		if (properties != null) {
			shareType = properties.get("shareType", "current");
		}
		if ("share".equals(shareType)) {
			shareUrl = PathUtils.SHARE_ID_URL;
		} else if ("custom".equals(shareType)) {
			shareUrl = properties.get("customUrl", StringUtils.EMPTY);
		} else {
			// share type is current
			Page currentPage = request.getResourceResolver().adaptTo(PageManager.class)
				.getContainingPage(request.getResource());

			shareUrl = currentPage.getPath();
		}
		shareUrl = LinkUtils.getHrefFromPath(shareUrl);
		if (!LinkUtils.isExternal(shareUrl)) {
			shareUrl = request.getResourceResolver().map(shareUrl);
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
