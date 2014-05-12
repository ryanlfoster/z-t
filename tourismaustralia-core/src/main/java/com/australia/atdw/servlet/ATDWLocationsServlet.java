package com.australia.atdw.servlet;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.MediaType;

import com.australia.atdw.service.ATDWProductService;

@SlingServlet(label = "ATDW Locations Servlet", methods = "GET", metatype = false, name = "com.australia.atdw.servlet.ATDWLocationsServlet", paths = "/bin/ta/atdwlocations", extensions = "json")
public class ATDWLocationsServlet extends SlingAllMethodsServlet {

	private static final ObjectMapper MAPPER = new ObjectMapper();

	@Reference
	private ATDWProductService service;

	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException,
		IOException {

		Map<String, Map<String, Set<String>>> locations = service.getLocationMap();
		trimBlanks(locations);
		response.setStatus(HttpServletResponse.SC_OK);
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		MAPPER.writeValue(response.getOutputStream(), locations);
	}

	private void trimBlanks(Map<String, Map<String, Set<String>>> locations) {
		locations.remove("");
		for (Map.Entry<String, Map<String, Set<String>>> e : locations.entrySet()) {
			e.getValue().remove("");
			for (Set<String> cities : e.getValue().values()) {
				cities.remove("");
			}
		}
	}

}
