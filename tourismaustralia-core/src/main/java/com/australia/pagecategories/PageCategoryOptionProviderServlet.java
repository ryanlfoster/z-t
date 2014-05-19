package com.australia.pagecategories;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.codehaus.jackson.map.ObjectMapper;

@SlingServlet(label = "PageCategory Option Provider", methods = { "GET" }, metatype = false, name = "com.australia.pagecategories.PageCategoryOptionProviderServlet", paths = "/bin/australia/pageCategories")
public class PageCategoryOptionProviderServlet extends SlingAllMethodsServlet {

	private static final String TEXT = "text";
	private static final String VALUE = "value";
	private static final String ICON = "icon";

	private final ObjectMapper MAPPER = new ObjectMapper();

	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException,
		IOException {

		List<Map<String, String>> out = new ArrayList<Map<String, String>>();
		for (PageCategory pageCategory : PageCategory.values()) {
			Map<String, String> jsonObj = new HashMap<String, String>();
			jsonObj.put(TEXT, pageCategory.toString());
			jsonObj.put(VALUE, pageCategory.name());
			jsonObj.put(ICON, pageCategory.getStandardIcon());
			out.add(jsonObj);
		}

		Map<String, List<Map<String, String>>> wrapper = new HashMap<String, List<Map<String, String>>>();
		wrapper.put("data", out);

		response.setStatus(HttpServletResponse.SC_OK);
		response.setContentType("application/json");
		MAPPER.writeValue(response.getOutputStream(), wrapper);
	}

}
