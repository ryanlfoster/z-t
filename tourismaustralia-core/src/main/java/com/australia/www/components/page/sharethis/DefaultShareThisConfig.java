package com.australia.www.components.page.sharethis;

import java.util.ArrayList;
import java.util.List;

import org.apache.sling.api.resource.ValueMap;

import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.FieldProperty;
import com.citytechinc.cq.component.annotations.widgets.Selection;

public class DefaultShareThisConfig {
	@DialogField(fieldLabel = "Social Networks", required = true, additionalProperties = @FieldProperty(name = "anchor", value = "100%"))
	@Selection(type = Selection.COMBOBOX)
	private final List<SocialNetworkType> socialNetwork1;

	@DialogField(fieldLabel = "", required = true, additionalProperties = @FieldProperty(name = "anchor", value = "100%"))
	@Selection(type = Selection.COMBOBOX)
	private final List<SocialNetworkType> socialNetwork2;

	public DefaultShareThisConfig(ValueMap properties) {
		this.socialNetwork1 = new ArrayList<SocialNetworkType>();
		this.socialNetwork2 = new ArrayList<SocialNetworkType>();

		if (properties.containsKey("socialNetwork1")) {
			String socnet1 = properties.get("socialNetwork1").toString();
			this.socialNetwork1.add(SocialNetworkType.get(socnet1.toLowerCase()));
		}
		if (properties.containsKey("socialNetwork2")) {
			String socnet2 = properties.get("socialNetwork2").toString();
			this.socialNetwork2.add(SocialNetworkType.get(socnet2.toLowerCase()));
		}
	}

	public List<SocialNetworkType> getSocialNetwork1() {
		return socialNetwork1;
	}

	public List<SocialNetworkType> getSocialNetwork2() {
		return socialNetwork2;
	}

}
