package com.australia.cqimport.servlet;

import java.io.IOException;

import javax.servlet.ServletException;

import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;

import com.australia.cqimport.service.ContentImporterService;

/**
 * Created by Viren Pushpanayagam on 27/03/2014.
 */

/**
 * Paths to be created before you can call this servlet
 * /content/australia/places /content/australia/articles
 * /content/australia/facts /content/australia/facts/australias-seasons
 * /content/australia/planning
 */

@SlingServlet(methods = { "POST" }, paths = "/apps/ta/servlets/ContentImporter")
@Properties({
	@Property(name = "service.pid", value = "com.australia.cqimport.servlet.ContentImporter", propertyPrivate = false),
	@Property(name = "service.description", value = "Content Importer", propertyPrivate = false),
	@Property(name = "service.vendor", value = "DT Digital", propertyPrivate = false) })
public class ContentImporter extends SlingAllMethodsServlet {
	private static final long serialVersionUID = 1L;

	@Reference
	private ContentImporterService contentImporter;

	@Override
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException,
		IOException {
		String lang = request.getParameter("lang");
		contentImporter.importLanguage(lang);

	}
}
