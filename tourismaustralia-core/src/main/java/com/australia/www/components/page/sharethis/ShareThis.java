package com.australia.www.components.page.sharethis;

import org.apache.sling.api.SlingHttpServletRequest;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.FieldProperty;
import com.citytechinc.cq.component.annotations.Tab;
import com.citytechinc.cq.component.annotations.widgets.NumberField;

@Component(value = "ShareThis", path = "page", group = ".hidden", editConfig = false, fileName = "share_dialog", tabs = {
	@Tab(title = "Default"), @Tab(title = "Custom") })
public class ShareThis {

	@DialogField(fieldLabel = "Test Field1", tab = 1, additionalProperties = {
		@FieldProperty(name = "minValue", value = "-90"), @FieldProperty(name = "maxValue", value = "90") })
	@NumberField(decimalPrecision = 4)
	private final Double testfield1;

	// @DialogField
	// @MultiCompositeField
	// private final List links;

	@DialogField(fieldLabel = "Test Field2", tab = 2, additionalProperties = {
		@FieldProperty(name = "minValue", value = "-90"), @FieldProperty(name = "maxValue", value = "90") })
	@NumberField(decimalPrecision = 4)
	private final Double testfield2;

	public ShareThis(SlingHttpServletRequest request) {
		testfield1 = new Double(0);
		testfield2 = new Double(0);
	}

	public Double getTestfield1() {
		return testfield1;
	}

	public Double getTestfield2() {
		return testfield2;
	}

}
