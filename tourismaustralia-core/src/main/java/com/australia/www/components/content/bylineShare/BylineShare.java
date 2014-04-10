package com.australia.www.components.content.bylineShare;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Listener;

@Component(value = "Byline With Share", listeners = { @Listener(name = "aftercopy", value = "REFRESH_PAGE"),
	@Listener(name = "afterdelete", value = "REFRESH_PAGE"), @Listener(name = "afteredit", value = "REFRESH_PAGE"),
	@Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class BylineShare {

	@DialogField(fieldLabel = "Author Name", required = true)
	private String authorName;

	@DialogField(fieldLabel = "Link", required = true)
	private String link;

	@DialogField(fieldLabel = "Link Text", required = true)
	private String linkText;

	public BylineShare(SlingHttpServletRequest request) {
		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		if (properties != null) {
			authorName = properties.get("authorName", "");
			link = properties.get("link", "");
			linkText = properties.get("linkText", "");
		}
	}

	public String getAuthorName() {
		return authorName;
	}

	public String getLink() {
		return link;
	}

	public String getLinkText() {
		return linkText;
	}

}
