package com.australia.geolocation;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;

import org.apache.commons.lang.StringUtils;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.australia.telize.domain.GeoLocation;
import com.australia.telize.service.TelizeService;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Splitter;

@SlingServlet(paths = "/bin/location.json", label = "Get Geolocation Servlet", methods = "GET", description = "Servlet to Get Geolocation", extensions = "json")
@SuppressWarnings("unchecked")
public class GetLocationServlet extends SlingAllMethodsServlet {
	private static final long serialVersionUID = 1571469224030962468L;
	private static final Logger LOG = LoggerFactory.getLogger(GetLocationServlet.class);
	private static final JsonFactory FACTORY = new JsonFactory();
	private static final ObjectMapper MAPPER = new ObjectMapper();

	private final String AKAMAI_HEADER = "X-Akamai-Edgescape";
	private final String X_FORWARDED_FOR_HEADER = "X-Forwarded-For";

	@Reference
	private TelizeService telizeService;

	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException,
		IOException {
		String callback = request.getParameter("callback");
		if (StringUtils.isEmpty(callback)) {
			response.sendError(SlingHttpServletResponse.SC_BAD_REQUEST);
			return;
		}

		Location location = new Location();
		Map<String, String> specHeader = getHeader(request);

		if (specHeader != null) {
			Iterator specHeaderIterator= specHeader.entrySet().iterator();
			if (specHeaderIterator.hasNext()) {
				Map.Entry<String, String> pairs = (Map.Entry)specHeaderIterator.next();
				LOG.debug("Header Key = " + pairs.getKey());
				if (StringUtils.equalsIgnoreCase(pairs.getKey(), AKAMAI_HEADER)) {
					location = getLocationFromAkamai(pairs.getValue());
				}
				else if (StringUtils.equalsIgnoreCase(pairs.getKey(), X_FORWARDED_FOR_HEADER)) {
					location = getLocationFromTelize(pairs.getValue());
				} else {
					location = getLocationFromTelize();
				}
			} else {
				location = getLocationFromTelize();
			}
		}

		response.setContentType("application/javascript");
		response.getWriter().write(callback + "(");
		JsonGenerator generator = FACTORY.createGenerator(response.getWriter());
		MAPPER.writeValue(generator, location);
		response.getWriter().write(")");
	}

	private Map<String, String> getHeader(SlingHttpServletRequest request) {
		String header = "";
		Map<String, String> headerMap = new Hashtable<String, String>();
		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String key = headerNames.nextElement();
			if (StringUtils.equalsIgnoreCase(AKAMAI_HEADER, key)) {
				header = request.getHeader(key);
				headerMap.put(key, header);
			}

			if (StringUtils.equalsIgnoreCase(X_FORWARDED_FOR_HEADER, key)) {
				header = request.getHeader(key);
				headerMap.put(key, header);
			}

		}
		return headerMap;
	}

	private Location getLocationFromTelize() {
		Location location = new Location();
		GeoLocation geoloc = telizeService.getLocation();
		location.setCity(geoloc.getCity());
		location.setState(geoloc.getRegion());
		location.setCountry(geoloc.getCountry());
		return location;
	}

	private Location getLocationFromTelize(String header) {
		Location location = new Location();
		GeoLocation geoloc = telizeService.getLocation(header);
		location.setCity(geoloc.getCity());
		location.setState(geoloc.getRegion());
		location.setCountry(geoloc.getCountry());
		return location;
	}

	private Location getLocationFromAkamai(String header) {
		Location location = new Location();
		Map<String, String> properties = Splitter.on(',').withKeyValueSeparator("=").split(header);
		location.setCity(properties.get("city"));
		location.setState(properties.get("region_code"));
		location.setCountry(properties.get("country_code"));
		return location;
	}

}
