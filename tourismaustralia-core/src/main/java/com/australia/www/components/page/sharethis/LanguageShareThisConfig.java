package com.australia.www.components.page.sharethis;

import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.FieldProperty;

public class LanguageShareThisConfig extends DefaultShareThisConfig {
	@DialogField(fieldLabel = "Country Code", additionalProperties = @FieldProperty(name = "width", value = "100"))
	private String country;

}
