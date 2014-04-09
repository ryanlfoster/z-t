package com.australia.www.components.page.sharethis;

import org.apache.sling.api.resource.ValueMap;

import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.FieldProperty;

public class LanguageShareThisConfig extends DefaultShareThisConfig {

	@DialogField(fieldLabel = "Country Code", additionalProperties = @FieldProperty(name = "width", value = "100"))
	private final String country;

	public LanguageShareThisConfig(ValueMap props) {
		super(props);
		this.country = (props.containsKey("country") ? props.get("country").toString() : "");
	}

	public String getCountry() {
		return country;
	}

}
