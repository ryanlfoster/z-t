package com.australia.foodandwine.components.content.hero;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Listener;
import com.citytechinc.cq.component.annotations.Tab;
import com.citytechinc.cq.component.annotations.widgets.PathField;

@Component(group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", value = "Hero Home", tabs = {
	@Tab(title = "Big Title"), @Tab(title = "Register Text"), @Tab(title = "Video Path") }, listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class Hero {
	@DialogField(fieldLabel = "Image Path", fieldDescription = "Image for the background(optional)")
	@PathField(rootPath = "/content/dam")
	private final String imagePath;
	@DialogField(fieldLabel = "Big Title", required = true)
	private final String bigTitle;

	@DialogField(fieldLabel = "Ovaerlay Small Text", fieldDescription = "Text to be displayed in small font", tab = 2)
	private final String smallFontText;

	@DialogField(fieldLabel = "Ovaerlay Large Text", fieldDescription = "Text to be displayed in large font", tab = 2)
	private final String largeFontText;

	@DialogField(fieldLabel = "Ovaerlay Small Text", fieldDescription = "Text to be displayed after large font", tab = 2)
	private final String smallFont;

	@DialogField(fieldLabel = "Register Button Text ", tab = 2)
	private final String buttonText;

	@DialogField(fieldLabel = "Byline", tab = 2)
	private final String byLineText;

	@DialogField(fieldLabel = "Overlay Text for Video", tab = 3)
	private final String textBeforePlayButton;

	@DialogField(fieldLabel = "Overlay Text for Video", tab = 3)
	private final String textAfterPlayButton;

	/**
	 * Constants
	 */
	private static final String IMAGEPATH = "imagePath";

	private static final String BIGTITLE = "bigTitle";
	private static final String SMALLFONTTEXT = "smallFontText";
	private static final String LARGEFONTTEXT = "largeFontText";

	public Hero(SlingHttpServletRequest request) {
		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		imagePath = properties.get(IMAGEPATH, StringUtils.EMPTY);
		bigTitle = properties.get(BIGTITLE, StringUtils.EMPTY);
		smallFontText = properties.get(SMALLFONTTEXT, StringUtils.EMPTY);
		largeFontText = properties.get(LARGEFONTTEXT, StringUtils.EMPTY);
		smallFont = properties.get("smallFont", StringUtils.EMPTY);
		buttonText = properties.get("buttonText", StringUtils.EMPTY);
		byLineText = properties.get("byLineText", StringUtils.EMPTY);
		textBeforePlayButton = properties.get("textBeforePlayButton", StringUtils.EMPTY);
		textAfterPlayButton = properties.get("textAfterPlayButton", StringUtils.EMPTY);

	}

	public String getImagePath() {
		return imagePath;
	}

	public String getBigTitle() {
		return bigTitle;
	}

	public String getSmallFontText() {
		return smallFontText;
	}

	public String getLargeFontText() {
		return largeFontText;
	}

	public String getSmallFont() {
		return smallFont;
	}

	public String getButtonText() {
		return buttonText;
	}

	public String getByLineText() {
		return byLineText;
	}

	public String getTextBeforePlayButton() {
		return textBeforePlayButton;
	}

	public String getTextAfterPlayButton() {
		return textAfterPlayButton;
	}

}
