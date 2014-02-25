package com.australia.sitemap;

import java.io.IOException;

import javax.servlet.ServletException;

import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;

import com.australia.server.ServerNameService;
import com.australia.utils.PathUtils;

@SlingServlet(paths = "/bin/sitemap.xml", label = "Generic Sitemap Servlet", methods = "GET", description = "Servlet to Generate sitemap.xml", extensions = "xml", resourceTypes = "sling/servlet/default", metatype = true)
public class GenericSiteMapServlet extends SlingAllMethodsServlet {
	private static final long serialVersionUID = 8454228227434152487L;

	@Reference
	private ServerNameService serverNameService;

	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException,
		IOException {

		if (serverNameService.getAustraliaComServerName().contains(request.getServerName())) {
			SiteMapGenerator.generateParent(request, response, PathUtils.OZCOM_ROOT_PATH);
		} else if (serverNameService.getFoodAndWineServerName().contains(request.getServerName())) {
			SiteMapGenerator.generate(request, response, PathUtils.FOOD_AND_WINE_ROOT_PATH);
		}
	}

}
