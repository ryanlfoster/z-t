package com.australia.sitemap;

import com.australia.server.ServerNameService;
import com.australia.utils.ServerUtils;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by cchin on 17/02/14.
 */
@SlingServlet(paths = "/bin/sitemap.xml", label = "Generic Sitemap Servlet", methods="GET", description = "Servlet to Generate sitemap.xml", extensions = "xml", resourceTypes = "sling/servlet/default", metatype = true)
public class GenericSiteMapServlet extends SlingAllMethodsServlet {

    @Reference
    private ServerNameService serverNameService;

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException,
            IOException {

        if(serverNameService.getAustraliaComServerName().contains(request.getServerName())){
            //SiteMapGenerator.generateParent(request, response, ServerUtils.SITE_NAME_OZCOM);
            SiteMapGenerator.generate(request, response, "/content/" + ServerUtils.SITE_NAME_OZCOM);
        }else if(serverNameService.getFoodAndWineServerName().contains(request.getServerName())){
            SiteMapGenerator.generate(request, response, "/content/" + ServerUtils.SITE_NAME_FOODWINE);
        } else {
            // for testing only in author instance
            SiteMapGenerator.generate(request, response, "/content/" + ServerUtils.SITE_NAME_FOODWINE);
        }
    }

}
