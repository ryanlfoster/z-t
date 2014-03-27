package com.australia.servlets;

import com.australia.cqimport.service.PageBuilder;
import com.australia.cqimport.service.StateBuilder;
import com.day.cq.wcm.api.WCMException;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;


import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Viren Pushpanayagam on 27/03/2014.
 */

@SlingServlet(methods = {"POST"}, paths = "/apps/ta/servlets/ContentImporter")

@Properties({
        @Property(name = "service.pid", value = "au.com.dtdigital.ta.servlets.ContentImporter",
                propertyPrivate = false),
        @Property(name = "service.description", value = "Content Importer", propertyPrivate = false),
        @Property(name = "service.vendor", value = "DT Digital", propertyPrivate = false)})

public class ContentImporter extends SlingAllMethodsServlet {
    private static final String emailSubscriptionsRootPath = "/content/ta/emailSubscriptions";

    @Reference
    private ResourceResolverFactory resourceResolverFactory;

    @Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException,
            IOException {
        ResourceResolver resourceResolver = null;
        try {
            resourceResolver= resourceResolverFactory.getAdministrativeResourceResolver(null);
        } catch (LoginException e) {
            e.printStackTrace();
        }
        System.out.println("Inside Servlet viren11");
        PageBuilder pageBuilder = new StateBuilder();
        System.out.println("before");
        try {
            pageBuilder.createPage("/content/australia/explore/states/nsw", "/content/australia/explore/states/nsw",
                    resourceResolver);
            System.out.println("After");
        } catch (WCMException e) {
            System.out.println(e);
            e.printStackTrace();
        }

        System.out.println("End");
    }
}
