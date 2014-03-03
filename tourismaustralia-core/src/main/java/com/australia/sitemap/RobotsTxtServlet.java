package com.australia.sitemap;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

import javax.servlet.ServletException;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Modified;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.commons.osgi.PropertiesUtil;
import org.apache.sling.settings.SlingSettingsService;

import com.australia.server.ServerNameService;
import com.australia.utils.ServerUtils;
import com.australia.utils.Site;

@SlingServlet(paths = "/robots", label = "Robots Servlet", description = "Servlet to Generate Robots.txt", extensions = "txt", metatype = true)
public class RobotsTxtServlet extends SlingAllMethodsServlet {
	private static final long serialVersionUID = 1L;

	@Reference
	private SlingSettingsService slingSettings;

	@Reference
	private ServerNameService serverNameService;

	@Property(label = "On", description = "If checked the robots.txt will contain the location of the sitemap.xml", boolValue = false)
	private static final String PROPERTY_ON = "sitemap.on";
	private boolean on;

	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException,
		IOException {
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		Writer writer = response.getWriter();
		writer.write("User-agent: * \n");
		if (on) {
			StringBuilder sitemapBuilder = new StringBuilder();
			sitemapBuilder.append("Sitemap:");
			String server = "";
			if (slingSettings.getRunModes().contains(ServerUtils.AUTHOR)) {
				server = serverNameService.getAuthorServerName();
			} else {
				Site site = ServerUtils.getSite(slingSettings, serverNameService, request);
				switch (site) {
				case OZCOM:
					server = serverNameService.getAustraliaComServerName();
					break;
				case FOOD_AND_WINE:
					server = serverNameService.getFoodAndWineServerName();
					break;
				}
			}
			sitemapBuilder.append(server).append("/sitemap.xml");

			writer.write(sitemapBuilder.toString());
		} else {
			writer.write("Disallow: /");
		}
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		on = PropertiesUtil.toBoolean(properties.get(PROPERTY_ON), false);
	}
}
