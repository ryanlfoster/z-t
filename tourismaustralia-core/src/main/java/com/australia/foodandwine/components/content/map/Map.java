package com.australia.foodandwine.components.content.map;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Listener;

@Component(group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", value = "Google Map", listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class Map {
	@DialogField(fieldLabel = "Title", required = true)
	private String title;

	@DialogField(fieldLabel = "Phone", required = true)
	private String phone;

	@DialogField(fieldLabel = "Latitude", required = true)
	private double latitude;

	@DialogField(fieldLabel = "Longitude", required = true)
	private double longitude;

	public Map(SlingHttpServletRequest request) {
		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		if (properties != null) {
			title = properties.get("title", "Google Maps");
			phone = properties.get("phone", "02 9440 1634");
			latitude = properties.get("latitude", 44.5403);
			longitude = properties.get("longitude", -78.5463);
		}
	}

	public String getTitle() {
		return title;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public String getPhone() {
		return phone;
	}

}
