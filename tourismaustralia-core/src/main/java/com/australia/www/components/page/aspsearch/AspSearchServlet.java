package com.australia.www.components.page.aspsearch;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import org.apache.commons.lang3.StringUtils;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;

import com.australia.asp.domain.Specialist;
import com.australia.asp.service.AspService;
import com.citytechinc.cq.component.annotations.Component;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;

@SlingServlet(resourceTypes = "tourismaustralia/components/content/aspSearch", selectors = "aspsearch", extensions = "json")
@Component(name = "aspSearch", value = "Asp Search")
public class AspSearchServlet extends SlingAllMethodsServlet {
	private static final long serialVersionUID = 2961282167685862613L;
	private static final JsonFactory FACTORY = new JsonFactory();
	private static final ObjectMapper MAPPER = new ObjectMapper();

	@Reference
	private AspService aspService;

	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException,
		IOException {
		List<Specialist> specialists;
		String country = request.getParameter("country");
		String state = request.getParameter("state");
		String city = request.getParameter("city");
		if (StringUtils.isNotEmpty(country) && StringUtils.isNotEmpty(state) && StringUtils.isNotEmpty(city)) {
			specialists = aspService.getSpecialistsByCountryAndStateAndCity(country, state, city);
		} else if (StringUtils.isNotEmpty(country) && StringUtils.isNotEmpty(state)) {
			specialists = aspService.getSpecialistsByCountryAndState(country, state);
		} else if (StringUtils.isNotEmpty(country)) {
			specialists = aspService.getSpecialistsByCountry(country);
		} else {
			specialists = aspService.getSpecialists();
		}
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		JsonGenerator generator = FACTORY.createGenerator(response.getWriter());
		MAPPER.writeValue(generator, specialists);
	}
}
