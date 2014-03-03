package com.australia.sitemap;

import java.io.IOException;

import javax.servlet.ServletException;

import org.apache.commons.lang.StringUtils;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.OptingServlet;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;

import com.australia.errorhandler.Sling404ErrorHandler;
import com.australia.server.ServerNameService;
import com.australia.utils.PathUtils;
import com.australia.utils.ServerUtils;

/**
 * Created by cchin on 19/02/14.
 */
@SlingServlet(label = "Internationalization Sitemap Servlet", methods = "GET", description = "Servlet to Generate language specific sitemap.xml", extensions = "xml", resourceTypes = "sling/servlet/default")
public class LanguageSiteMapServlet extends SlingAllMethodsServlet implements OptingServlet {

	@Reference
	private ServerNameService serverNameService;

	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException,
		IOException {
		String lang = ServerUtils.getLanguageCode(request);
		if (StringUtils.isNotEmpty(lang)) {
			SiteMapGenerator.generate(request, response, PathUtils.OZCOM_ROOT_PATH + "/" + lang);
		} else {
			response.sendError(SlingHttpServletResponse.SC_NOT_FOUND);
		}
	}

	@Override
	public boolean accepts(SlingHttpServletRequest request) {
		return serverNameService.getAustraliaComServerName().contains(request.getServerName())
			&& request.getPathInfo().matches("/[a-z]{2}/sitemap.xml");
	}

}
