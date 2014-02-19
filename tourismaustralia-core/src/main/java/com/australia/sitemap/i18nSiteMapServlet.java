package com.australia.sitemap;

import com.australia.utils.PathUtils;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.OptingServlet;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * Created by cchin on 19/02/14.
 */
@SlingServlet(paths = "/bin/lang/sitemap.xml", label = "Internationalization Sitemap Servlet", methods="GET", description = "Servlet to Generate language specific sitemap.xml", extensions = "xml", resourceTypes = "sling/servlet/default", metatype = true)
public class i18nSiteMapServlet extends SlingAllMethodsServlet implements OptingServlet {

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException,
            IOException {
        String lang = "en";
        SiteMapGenerator.generate(request, response, PathUtils.SITE_NAME_OZCOM + "/" + lang);
    }

    @Override
    public boolean accepts(SlingHttpServletRequest request) {
        return false;
    }
}
