package com.australia.google.service;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Modified;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.commons.osgi.PropertiesUtil;

@Component(label = "Default Google Service", description = "Default Google Service", immediate = true)
@Service
public class DefaultGoogleService implements GoogleService {

	@Property(label = "Google Maps API Key", description = "Google Static Maps API Key")
	private static final String STATIC_MAPS_API_KEY = "staticMapsAPIKey";
	private String mapsAPIKey;

	@Activate
	@Modified
	protected void activate(final Map<String, Object> properties) throws Exception {
		mapsAPIKey = PropertiesUtil.toString(properties.get(STATIC_MAPS_API_KEY), StringUtils.EMPTY);
	}

	@Override
	public String getMapsAPIKey() {
		return mapsAPIKey;
	}

}
