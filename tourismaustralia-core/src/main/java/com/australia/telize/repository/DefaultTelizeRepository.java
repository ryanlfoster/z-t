package com.australia.telize.repository;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Modified;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.sling.commons.osgi.PropertiesUtil;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.australia.telize.domain.GeoLocation;

@Component(label = "Default Telize Repository", description = "Default Telize Repository", immediate = true, metatype = true)
@Service
public class DefaultTelizeRepository implements TelizeRepository {

	private static final String DEFAULT_TELIZE_LOCATION = "http://www.telize.com/geoip";

	@Property(label = "Telize Service Location", description = "The external location of the Telize Service", value = DEFAULT_TELIZE_LOCATION)
	private static final String TELIZE_LOCATION = "telizeLocation";
	private String telizeLocation = "";
	private RestTemplate rest;

	@Override
	public GeoLocation getGeoLocation() {
		setTelizeLocation(DEFAULT_TELIZE_LOCATION);
		return rest.getForObject(telizeLocation, GeoLocation.class);
	}
	@Override
	public GeoLocation getGeoLocation(String xForwardedIP) {
		setTelizeLocation(DEFAULT_TELIZE_LOCATION + "/" + xForwardedIP);
		return rest.getForObject(telizeLocation, GeoLocation.class);
	}

	@Activate
	@Modified
	protected void activate(final Map<String, Object> properties) throws Exception {
		telizeLocation = PropertiesUtil.toString(properties.get(TELIZE_LOCATION), getTelizeLocation());
		ThreadSafeClientConnManager cm = new ThreadSafeClientConnManager();
		cm.setMaxTotal(50);
		cm.setDefaultMaxPerRoute(50);
		rest = new RestTemplate(new HttpComponentsClientHttpRequestFactory(new DefaultHttpClient(cm, null)));
	}

	private void setTelizeLocation(String telLoc) {
		telizeLocation  = telLoc;
	}

	private String getTelizeLocation() {
		if (StringUtils.isEmpty(telizeLocation)) {
			telizeLocation = DEFAULT_TELIZE_LOCATION;
		}

		return telizeLocation;
	}


}
