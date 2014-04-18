package com.australia.www.components.page.search;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.widgets.NumberField;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;

@Component(value = "Search", path = "page", group = ".hidden", editConfig = false)
public class SearchPage {

	private static final int DEFAULT_COUNT = 10;

	@DialogField(fieldLabel = "Results Per Page", fieldDescription = "The results per page to display: "
		+ "defaults to 10, multiples of 5 are recommended.")
	@NumberField(allowNegative = false, allowDecimals = false)
	private int count;

	public SearchPage(final SlingHttpServletRequest request) {

		final Resource resource = request.getResource();
		final ValueMap properties = resource.adaptTo(ValueMap.class);
		count = properties.get("./count", DEFAULT_COUNT);


	}

}
