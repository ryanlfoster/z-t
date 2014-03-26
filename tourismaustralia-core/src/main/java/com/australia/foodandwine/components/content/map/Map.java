package com.australia.foodandwine.components.content.map;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Listener;

@Component(group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", value = "Google Map", listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class Map {
	private final String GOOGLE_MAP_URL = "http://maps.googleapis.com/maps/api/staticmap?center=-25.850033,135.6500523&zoom=4&size=500x400&maptype=roadmap&sensor=false&style=feature%3Aadministrative%7Celement%3Aall%7Cvisibility%3Aoff%7C&style=feature%3Alandscape%7Celement%3Aall%7Cvisibility%3Aoff%7C&style=feature%3Apoi%7Celement%3Aall%7Cvisibility%3Aoff%7C&style=feature%3Aroad%7Celement%3Aall%7Cvisibility%3Aoff%7C&style=feature%3Awater%7Celement%3Aall%7Cvisibility%3Aoff%7C&style=feature%3Alandscape%7Celement%3Aall%7Cvisibility%3Aon%7Ccolor%3A0xeeeeee%7C&style=feature%3Awater%7Celement%3Aall%7Cvisibility%3Aon%7Ccolor%3A0xffffff%7C&style=feature%3Aadministrative.province%7Celement%3Ageometry.stroke%7Cvisibility%3Aon%7Cweight%3A0.5%7Ccolor%3A0x555555%7C&markers=icon:http://extranet.ogilvy.com.au/TA/Styleguide/imgs/custommap/marker.png|-";

	@DialogField(fieldLabel = "Phone", required = true)
	private String phone;

	@DialogField(fieldLabel = "Address", required = true)
	private String address1;

	@DialogField(fieldLabel = "Suburb", required = true)
	private String suburb;

	@DialogField(fieldLabel = "State", required = true)
	private String state;

	@DialogField(fieldLabel = "Postcode", required = true)
	private String postcode;

	@DialogField(fieldLabel = "Website")
	private String website;

	private final String googleMapUrl;

	public Map(SlingHttpServletRequest request) {
		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		if (properties != null) {
			phone = properties.get("phone", "");
			address1 = properties.get("address1", "");
			suburb = properties.get("suburb", "");
			state = properties.get("state", "");
			postcode = properties.get("postcode", "");
			website = properties.get("website", "");
		} else {
			address1 = "";
			suburb = "";
			state = "";
			postcode = "";
		}
		googleMapUrl = GOOGLE_MAP_URL.concat(this.buildAustralianAddress());
	}

	private String buildAustralianAddress() {
		StringBuilder address = new StringBuilder();
		address.append(address1);
		address.append(" ");
		address.append(suburb);
		address.append(" ");
		address.append(state);
		address.append(" ");
		address.append(postcode);
		return StringUtils.trim(address.toString());
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress1() {
		return address1;
	}

	public String getWebsite() {
		return website;
	}

	public String getGoogleMapUrl() {
		return googleMapUrl;
	}

	public String getSuburb() {
		return suburb;
	}

	public String getState() {
		return state.toUpperCase();
	}

	public String getPostcode() {
		return postcode;
	}

}
