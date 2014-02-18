package com.australia.www.components.page.global;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.FieldProperty;
import com.citytechinc.cq.component.annotations.Option;
import com.citytechinc.cq.component.annotations.widgets.NumberField;
import com.citytechinc.cq.component.annotations.widgets.Selection;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

@Component(value = "Global", path = "page", group = ".hidden", editConfig = false, fileName = "extra_dialog")
public class Global {
	@DialogField(fieldLabel = "Hide from Search", fieldDescription = "Removes the page from the site search")
	@Selection(type = Selection.CHECKBOX, options = @Option(value = "true"))
	private final boolean removeFromSearch;

	@DialogField(fieldLabel = "Latitude", additionalProperties = { @FieldProperty(name = "minValue", value = "-90"),
		@FieldProperty(name = "maxValue", value = "90") })
	@NumberField(decimalPrecision = 4)
	private final Double latitude;

	@DialogField(fieldLabel = "Longitude", additionalProperties = { @FieldProperty(name = "minValue", value = "-180"),
		@FieldProperty(name = "maxValue", value = "180") })
	@NumberField(decimalPrecision = 4)
	private final Double longitude;

	public Global(SlingHttpServletRequest request) {
		Page currentPage = request.getResourceResolver().adaptTo(PageManager.class)
			.getContainingPage(request.getResource());
		ValueMap properties = currentPage.getProperties();
		removeFromSearch = properties.get("removeFromSearch", false);
		latitude = properties.get("latitude", Double.class);
		longitude = properties.get("longitude", Double.class);
	}

	public boolean getRemoveFromSearch() {
		return removeFromSearch;
	}

	public Double getLatitude() {
		return latitude;
	}

	public Double getLongitude() {
		return longitude;
	}
}
