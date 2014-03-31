package com.australia.foodandwine.components.content.map;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.scripting.SlingBindings;
import org.apache.sling.api.scripting.SlingScriptHelper;
import org.apache.sling.settings.SlingSettingsService;

import com.australia.google.service.GoogleService;
import com.australia.server.ServerNameService;
import com.australia.utils.ServerUtils;
import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Listener;
import com.citytechinc.cq.component.annotations.Option;
import com.citytechinc.cq.component.annotations.widgets.Selection;

@Component(disableTargeting = true, group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", value = "Google Map", listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class Map {
	private final String GOOGLE_MAP_URL = "http://maps.googleapis.com/maps/api/staticmap?center=-29.850033,135.6500523&zoom=4&size=500x450&maptype=roadmap&sensor=false&style=feature%3Aadministrative%7Celement%3Aall%7Cvisibility%3Aoff%7C&style=feature%3Alandscape%7Celement%3Aall%7Cvisibility%3Aoff%7C&style=feature%3Apoi%7Celement%3Aall%7Cvisibility%3Aoff%7C&style=feature%3Aroad%7Celement%3Aall%7Cvisibility%3Aoff%7C&style=feature%3Awater%7Celement%3Aall%7Cvisibility%3Aoff%7C&style=feature%3Alandscape%7Celement%3Aall%7Cvisibility%3Aon%7Ccolor%3A0xeeeeee%7C&style=feature%3Awater%7Celement%3Aall%7Cvisibility%3Aon%7Ccolor%3A0xffffff%7C&style=feature%3Aadministrative.province%7Celement%3Ageometry.stroke%7Cvisibility%3Aon%7Cweight%3A0.5%7Ccolor%3A0x555555%7C&markers={marker_image_url}|-";
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

	@DialogField(fieldLabel = "Image Alt Tag", fieldDescription = "Image Alt Tag for map image", required = true)
	private String imageAltTag;

	private String googleMapUrl;

	public Map(SlingHttpServletRequest request) {
		SlingScriptHelper sling = ((SlingBindings) request.getAttribute(SlingBindings.class.getName())).getSling();
		GoogleService googleService = sling.getService(GoogleService.class);
		SlingSettingsService slingSettings = sling.getService(SlingSettingsService.class);
		ServerNameService serverNameService = sling.getService(ServerNameService.class);
		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		if (properties != null) {
			phone = properties.get("phone", StringUtils.EMPTY);
			address1 = properties.get("address1", StringUtils.EMPTY);
			suburb = properties.get("suburb", StringUtils.EMPTY);
			state = properties.get("state", StringUtils.EMPTY);
			postcode = properties.get("postcode", StringUtils.EMPTY);
			website = properties.get("website", StringUtils.EMPTY);
			imageAltTag = properties.get("imageAltTag", StringUtils.EMPTY);
		} else {
			address1 = "";
			suburb = "";
			state = "";
			postcode = "";
		}
		prepareGoogleMapsUrl(request, slingSettings, googleService, serverNameService);
	}

	/**
	 * Prepares the Google Maps URL by inserting the API key and also the
	 * customized marker image. Use default Google marker image if not found.
	 * 
	 * @param request - the Sling request object
	 * @param slingSettings
	 * @parm googleService - Google Service used to retrieve the API key
	 */
	private void prepareGoogleMapsUrl(SlingHttpServletRequest request, SlingSettingsService slingSettings,
		GoogleService googleService, ServerNameService serverNameService) {
		String markerImgUrl = "";
		googleMapUrl = GOOGLE_MAP_URL.concat(this.buildAustralianAddress());
		// cannot use marker image if in author mode (so use Google default)
		if (!ServerUtils.isLocal(slingSettings)) {
			markerImgUrl = "icon:" + serverNameService.getFoodAndWineServerName() + MARKER_IMAGE;
		}
		// TODO: refactor better way to replace parameters
		googleMapUrl = StringUtils.replace(googleMapUrl, "{marker_image_url}", markerImgUrl);
		googleMapUrl = googleMapUrl + "&key=" + googleService.getMapsAPIKey();
	}

	private String buildAustralianAddress() {
		StringBuilder address = new StringBuilder();
		address.append(address1);
		address.append(", ");
		address.append(suburb);
		address.append(", ");
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

	public String getImageAltTag() {
		return imageAltTag;
	}

}
