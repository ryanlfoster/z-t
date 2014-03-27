package com.australia.foodandwine.components.content.map;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.scripting.SlingBindings;
import org.apache.sling.api.scripting.SlingScriptHelper;
import org.apache.sling.settings.SlingSettingsService;

import com.australia.utils.ServerUtils;
import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Listener;
import com.citytechinc.cq.component.annotations.Option;
import com.citytechinc.cq.component.annotations.widgets.Selection;
import com.day.cq.commons.Externalizer;

@Component(group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", value = "Google Map", listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class Map {
	private final String GOOGLE_MAP_URL = "http://maps.googleapis.com/maps/api/staticmap?center=-25.850033,135.6500523&zoom=4&size=500x400&maptype=roadmap&sensor=false&style=feature%3Aadministrative%7Celement%3Aall%7Cvisibility%3Aoff%7C&style=feature%3Alandscape%7Celement%3Aall%7Cvisibility%3Aoff%7C&style=feature%3Apoi%7Celement%3Aall%7Cvisibility%3Aoff%7C&style=feature%3Aroad%7Celement%3Aall%7Cvisibility%3Aoff%7C&style=feature%3Awater%7Celement%3Aall%7Cvisibility%3Aoff%7C&style=feature%3Alandscape%7Celement%3Aall%7Cvisibility%3Aon%7Ccolor%3A0xeeeeee%7C&style=feature%3Awater%7Celement%3Aall%7Cvisibility%3Aon%7Ccolor%3A0xffffff%7C&style=feature%3Aadministrative.province%7Celement%3Ageometry.stroke%7Cvisibility%3Aon%7Cweight%3A0.5%7Ccolor%3A0x555555%7C&markers={marker_image_url}|-";
	private final String MARKER_IMAGE = "/etc/designs/foodandwine/clientlibs/imgs/custommap/marker.png";

	@DialogField(fieldLabel = "Phone", required = true)
	private String phone;

	@DialogField(fieldLabel = "Address", required = true)
	private String address1;

	@DialogField(fieldLabel = "Suburb", required = true)
	private String suburb;

	@DialogField(fieldLabel = "State", required = true)
	@Selection(type = Selection.SELECT, options = { @Option(value = "Victoria"), @Option(value = "New South Wales"),
		@Option(value = "Queensland"), @Option(value = "South Australia"), @Option(value = "Northern Territory"),
		@Option(value = "Western Australia"), @Option(value = "Australian Capital Territory"),
		@Option(value = "Tasmania") })
	private String state;

	@DialogField(fieldLabel = "Postcode", required = true)
	private String postcode;

	@DialogField(fieldLabel = "Website")
	private String website;

	private String googleMapUrl;

	public Map(SlingHttpServletRequest request) {
		SlingScriptHelper sling = ((SlingBindings) request.getAttribute(SlingBindings.class.getName())).getSling();
		SlingSettingsService slingSettings = sling.getService(SlingSettingsService.class);
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
		// externalize the url for the marker image
		Resource markerImage = request.getResourceResolver().getResource(MARKER_IMAGE);
		Externalizer externalizer = request.getResourceResolver().adaptTo(Externalizer.class);
		googleMapUrl = GOOGLE_MAP_URL.concat(this.buildAustralianAddress());
		// cannot use marker image if in author mode (so use Google default)
		if (!ServerUtils.isAuthor(slingSettings) && !ServerUtils.isLocal(slingSettings)) {
			String markerImgUrl = externalizer.absoluteLink(request, request.getScheme(), markerImage.getPath());
			googleMapUrl = StringUtils.replace(googleMapUrl, "{marker_image_url}", "icon:" + markerImgUrl);
		}
	}

	private String buildAustralianAddress() {
		StringBuilder address = new StringBuilder();
		address.append(address1);
		address.append(" ");
		address.append(suburb);
		address.append(" ");
		address.append(state);
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
