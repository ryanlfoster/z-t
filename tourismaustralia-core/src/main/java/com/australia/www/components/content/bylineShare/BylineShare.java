package com.australia.www.components.content.bylineShare;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;

import com.australia.utils.LinkUtils;
import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Listener;
import com.citytechinc.cq.component.annotations.Tab;
import com.citytechinc.cq.component.annotations.widgets.Html5SmartImage;
import com.citytechinc.cq.component.annotations.widgets.PathField;
import com.day.cq.wcm.foundation.Image;
import com.day.cq.wcm.foundation.forms.MergedValueMap;

@Component(value = "Byline With Share", tabs = { @Tab(title = "Image"), @Tab(title = "Properties") }, listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class BylineShare {

	@DialogField(hideLabel = true, tab = 1)
	@Html5SmartImage(name = "imageSrc")
	private final String imageSrc;

	@DialogField(fieldLabel = "Author Name", tab = 2)
	private final String authorName;

	@DialogField(fieldLabel = "Link Text", tab = 2)
	private final String linkText;

	@DialogField(fieldLabel = "Link", tab = 2, fieldDescription = "For external links please use prefix http:// or https:// (eg. http://www.google.com)")
	@PathField(rootPath = "/content")
	private final String link;

	private final boolean external;

	public BylineShare(SlingHttpServletRequest request) {
		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		properties = properties == null ? new MergedValueMap(new ArrayList<Resource>()) : properties;
		Image image = new Image(request.getResource(), "imageSrc");
		imageSrc = image.getSrc();
		authorName = properties.get("authorName", StringUtils.EMPTY);
		linkText = properties.get("linkText", StringUtils.EMPTY);
		link = LinkUtils.getHrefFromPath(properties.get("link", StringUtils.EMPTY));
		external = LinkUtils.isExternal(link);
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

	public String getImageSrc() {
		return imageSrc;
	}

	public boolean isExternal() {
		return external;
	}

}
