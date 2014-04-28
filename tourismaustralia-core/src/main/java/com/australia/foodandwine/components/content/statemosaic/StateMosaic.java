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

@Component(disableTargeting = true, group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", value = "State Mosaic", listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class StateMosaic {

	@DialogField(fieldLabel = "Top Text",name="./topText")
	private String topText;

	@DialogField(fieldLabel = "Center Text", tab = 1,name="./centerText")
	private String centerText;

	@DialogField(fieldLabel = "Bottom text",name="./bottomText")
	private String bottomText;

	
	private String template;


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

	

}
