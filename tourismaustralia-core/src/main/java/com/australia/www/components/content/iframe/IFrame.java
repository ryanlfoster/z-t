package com.australia.www.components.content.iframe;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Option;
import com.citytechinc.cq.component.annotations.widgets.NumberField;
import com.citytechinc.cq.component.annotations.widgets.Selection;

/**
 * Created by cchin on 20/02/14.
 */
@Component(value = "iFrame Control")
public class IFrame {

	@DialogField(fieldLabel = "Target Application", required = true)
	private String applicationUrl;

	@DialogField(fieldLabel = "Max Width (px)", required = true)
	@NumberField(allowNegative = false)
	private int maxWidth;

	@DialogField(fieldLabel = "Height (px)", required = true)
	@NumberField(allowNegative = false)
	private int height;

	@DialogField(fieldLabel = "Exclude from Mobile")
	@Selection(type = Selection.CHECKBOX, options = @Option(value = "true"))
	private boolean excludeFromMobile;

	@DialogField(fieldLabel = "Exclude from Tablet")
	@Selection(type = Selection.CHECKBOX, options = @Option(value = "true"))
	private boolean excludeFromTablet;

	public IFrame(SlingHttpServletRequest request) {
		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		applicationUrl = properties.get("applicationUrl", "");
		maxWidth = properties.get("maxWidth", 0);
		height = properties.get("height", 0);
		excludeFromMobile = properties.get("excludeFromMobile", false);
		excludeFromTablet = properties.get("excludeFromTablet", false);
	}

	public int getMaxWidth() {
		return maxWidth;
	}

	public int getHeight() {
		return height;
	}

	public boolean isExcludeFromMobile() {
		return excludeFromMobile;
	}

	public boolean isExcludeFromTablet() {
		return excludeFromTablet;
	}

	public String getApplicationUrl() {
		return applicationUrl;
	}
}
