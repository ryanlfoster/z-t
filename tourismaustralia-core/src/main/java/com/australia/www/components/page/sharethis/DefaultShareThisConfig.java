package com.australia.www.components.page.sharethis;

import java.util.List;

import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.FieldProperty;
import com.citytechinc.cq.component.annotations.widgets.Selection;

public class DefaultShareThisConfig {
	@DialogField(fieldLabel = "Social Networks", additionalProperties = @FieldProperty(name = "width", value = "200"))
	@Selection(type = Selection.CHECKBOX)
	private List<SocialNetworkType> socialNetworks;
}
