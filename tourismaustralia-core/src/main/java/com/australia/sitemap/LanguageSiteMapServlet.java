package com.australia.sitemap;

import com.australia.server.ServerNameService;
import com.australia.utils.PathUtils;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.OptingServlet;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by cchin on 19/02/14.
 */
@SlingServlet(label = "Internationalization Sitemap Servlet", methods="GET", description = "Servlet to Generate language specific sitemap.xml", extensions = "xml", resourceTypes = "sling/servlet/default")
public class LanguageSiteMapServlet extends SlingAllMethodsServlet implements OptingServlet {

    @Reference
    private ServerNameService serverNameService;

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
            throws ServletException, IOException {
        String lang = "en";
        SiteMapGenerator.generate(request, response, PathUtils.OZCOM_ROOT_PATH + "/" + lang);
    }

    @Override
    public boolean accepts(SlingHttpServletRequest request) {
        return serverNameService.getAustraliaComServerName().contains(request.getServerName())
                && request.getPathInfo().matches("/[a-z]{2}/sitemap.xml");
    }

}