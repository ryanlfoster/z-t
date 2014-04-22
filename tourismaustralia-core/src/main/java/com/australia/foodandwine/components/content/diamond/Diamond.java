package com.australia.foodandwine.components.content.diamond;

import java.text.NumberFormat;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.FieldProperty;
import com.citytechinc.cq.component.annotations.Listener;
import com.citytechinc.cq.component.annotations.widgets.NumberField;

@Component(disableTargeting = true, group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", value = "Diamond", listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class Diamond {
	private final String numberFormat;
	NumberFormat numberFormatter;

	@DialogField(fieldLabel = "Number", fieldDescription = "Maximum 7 digit limit", required = true, additionalProperties = @FieldProperty(name = "maxLength", value = "7"))
	@NumberField(allowDecimals = false, allowNegative = false)
	private final long number;

	@DialogField(fieldLabel = "Center Text", fieldDescription = "Maximum 20 character limit", additionalProperties = @FieldProperty(name = "maxLength", value = "20"))
	private final String centerText;

	@DialogField(fieldLabel = "Bottom Text", fieldDescription = "Maximum 15 character limit", additionalProperties = @FieldProperty(name = "maxLength", value = "15"))
	private final String bottomText;

	public Diamond(SlingHttpServletRequest request) {
		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		number = properties.get("number", 0);
		numberFormatter = NumberFormat.getNumberInstance();
		numberFormat = numberFormatter.format(number);
		centerText = properties.get("centerText", StringUtils.EMPTY);
		bottomText = properties.get("bottomText", StringUtils.EMPTY);
	}

	public String getNumberFormat() {
		return numberFormat;
	}

	public String getBottomText() {
		return bottomText;
	}

	public String getCenterText() {
		return centerText;
	}

}
