package com.australia.www.components.content.mapwithparsys;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Listener;
import com.citytechinc.cq.component.annotations.Tab;
import com.citytechinc.cq.component.annotations.widgets.Html5SmartImage;
import com.day.cq.wcm.foundation.Image;

/**
 * Created by wma on 12/03/14.
 */
@Component(value = "Image Map", group = ".hidden", tabs = { @Tab(title = "Image"), @Tab(title = "Extra Information") }, listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class MapWithParsys {

	@DialogField(fieldLabel = "Image", required = true, hideLabel = true, tab = 1)
	@Html5SmartImage(name = "image", disableZoom = true, allowUpload = false, tab = true, height = 400)
	private String image;

	@DialogField(fieldLabel = "Alt Text", required = true, tab = 2)
	private String altText;

	@DialogField(fieldLabel = "Title", required = false, tab = 2)
	private String title;

	@DialogField(fieldLabel = "Text", required = false, tab = 2)
	private String text;

	public MapWithParsys(SlingHttpServletRequest request) {
		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		altText = properties.get("altText", StringUtils.EMPTY);
		title = properties.get("title", StringUtils.EMPTY);
		text = properties.get("text", StringUtils.EMPTY);
		Image imageObj = new Image(request.getResource(), "image");
		if (imageObj != null && imageObj.hasContent()) {
			image = imageObj.getPath();
		}
	}

	public String getImage() {
		return image;
	}

	public String getAltText() {
		return altText;
	}

	public String getTitle() {
		return title;
	}

	public String getText() {
		return text;
	}

}
