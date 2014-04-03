package com.australia.foodandwine.components.content.accolade;

import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.FieldProperty;
import com.citytechinc.cq.component.annotations.widgets.NumberField;

public class AccoladeItem {

	@DialogField(fieldLabel = "Year", required = true, additionalProperties = {
		@FieldProperty(name = "minValue", value = "1800"), @FieldProperty(name = "maxValue", value = "2100") })
	@NumberField(allowDecimals = false, allowNegative = false)
	private String year;

	@DialogField(fieldLabel = "Title", required = true)
	private String title;

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
