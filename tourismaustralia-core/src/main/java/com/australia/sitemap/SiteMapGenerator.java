package com.australia.sitemap;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import com.day.cq.commons.Externalizer;
import org.apache.sling.api.resource.ResourceResolver;


/**
 * Created by cchin on 17/02/14.
 */
public class SiteMapGenerator {

    /**
     * Writes the sitemap xml file header.
     *
     * @param response
     * @return
     * @throws IOException
     */
    private static final Writer writeXmlHeader(SlingHttpServletResponse response) throws IOException {
        response.setContentType("text/xml");
        response.setCharacterEncoding("UTF-8");
        Writer writer = response.getWriter();
        writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        writer.write("<urlset xmlns=\"http://www.sitemaps.org/schemas/sitemap/0.9\">");
        return writer;
    }

    public static void generate(SlingHttpServletRequest request, SlingHttpServletResponse response, String path) throws IOException {
        Writer writer = writeXmlHeader(response);
        ResourceResolver resourceResolver = request.getResourceResolver();
        Page resRootPage = resourceResolver.adaptTo(PageManager.class).getPage(path);
        writePageUrls(writer, resourceResolver, resRootPage);
        writer.write("</urlset>");
    }

    private static void writePageUrls(Writer writer, ResourceResolver resourceResolver, Page resRootPage) throws IOException {
        Externalizer externalizer = resourceResolver.adaptTo(Externalizer.class);
        Iterator<Page> children = resRootPage.listChildren();
        while (children.hasNext())  {
            Page resourcePage = children.next();
            writer.write("<url><loc>");
            writer.write(externalizer.publishLink(resourceResolver, resourcePage.getPath()) + ".html");
            writer.write("</loc></url>");
            if (resourcePage.getDepth()>1) {
                writePageUrls(writer, resourceResolver, resourcePage);
            }
        }
    }

    public static void generateParent(SlingHttpServletRequest request, SlingHttpServletResponse response) {
        // TODO: yet to implement
    }

}
