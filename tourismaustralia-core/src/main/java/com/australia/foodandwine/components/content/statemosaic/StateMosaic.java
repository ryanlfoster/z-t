package com.australia.foodandwine.components.content.statemosaic;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;

import com.australia.utils.LinkUtils;
import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.FieldProperty;
import com.citytechinc.cq.component.annotations.Listener;
import com.citytechinc.cq.component.annotations.Tab;
import com.citytechinc.cq.component.annotations.widgets.PathField;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

@Component(disableTargeting = true, group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", value = "State Mosaic", tabs = {
	@Tab(title = "Mosaic Header"), @Tab(title = "Register") }, listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class StateMosaic {

	@DialogField(fieldLabel = "Top Text", tab = 1)
	private String topText;

	@DialogField(fieldLabel = "Center Text", tab = 1, required = true)
	private String centerText;

	@DialogField(fieldLabel = "Bottom text", tab = 1)
	private String bottomText;

	@DialogField(fieldLabel = "", tab = 2, xtype = "static", additionalProperties = @FieldProperty(name = "html", value = "<b>This only works on the homepage.  All fields MUST be filled out for this to work.</b><br/>"))
	private String staticText;

	@DialogField(fieldLabel = "Top Text", tab = 2)
	private String registerTopText;

	@DialogField(fieldLabel = "Center Text", tab = 2)
	private String registerCenterText;

	@DialogField(fieldLabel = "Bottom text", tab = 2)
	private String registerBottomText;

	@DialogField(fieldLabel = "Button Text ", tab = 2)
	private String buttonText;

	@DialogField(fieldLabel = "Button Link ", tab = 2)
	@PathField
	private String buttonLink;

	@DialogField(fieldLabel = "Text below Button", tab = 2)
	private String belowButtonText;
	private String template;

	private boolean external;

	/**
	 * Constructor
	 * 
	 * @param request
	 */
	public StateMosaic(SlingHttpServletRequest request) {
		// TODO: Load first set server side so it can be indexed by google
		PageManager pageManager = request.getResourceResolver().adaptTo(PageManager.class);
		Page currentPage = pageManager.getContainingPage(request.getResource());
		if (currentPage != null)
			template = currentPage.getTemplate().getName();
		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		if (properties != null) {
			topText = properties.get("topText", StringUtils.EMPTY);
			centerText = properties.get("centerText", StringUtils.EMPTY);
			bottomText = properties.get("bottomText", StringUtils.EMPTY);
			registerTopText = properties.get("registerTopText", StringUtils.EMPTY);
			registerCenterText = properties.get("registerCenterText", StringUtils.EMPTY);
			registerBottomText = properties.get("registerBottomText", StringUtils.EMPTY);
			buttonText = properties.get("buttonText", StringUtils.EMPTY);
			buttonLink = properties.get("buttonLink", StringUtils.EMPTY);
			buttonLink = LinkUtils.getHrefFromPath(buttonLink);
			external = LinkUtils.isExternal(buttonLink);
			belowButtonText = properties.get("belowButtonText", StringUtils.EMPTY);
		}
	}

	/**
	 * 
	 * @return
	 */
	public String getTemplate() {
		return template;
	}

	public String getTopText() {
		return topText;
	}

	public String getCenterText() {
		return centerText;
	}

	public String getBottomText() {
		return bottomText;
	}

	public String getRegisterTopText() {
		return registerTopText;
	}

	public String getRegisterCenterText() {
		return registerCenterText;
	}

	public String getRegisterBottomText() {
		return registerBottomText;
	}

	public String getButtonText() {
		return buttonText;
	}

	public String getButtonLink() {
		return buttonLink;
	}

	public String getBelowButtonText() {
		return belowButtonText;
	}

	public boolean isExternal() {
		return external;
	}

}
