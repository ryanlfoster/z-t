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
        return writer;
    }

    private static void writePageUrls(Writer writer, ResourceResolver resourceResolver, Page parent) throws IOException {
        Externalizer externalizer = resourceResolver.adaptTo(Externalizer.class);
        Iterator<Page> children = parent.listChildren();
        while (children.hasNext()) {
            Page child = children.next();
            writer.write("<url><loc>");
            writer.write(externalizer.publishLink(resourceResolver, child.getPath()) + ".html");
            writer.write("</loc></url>");
            if (child.getDepth()>1) {
                writePageUrls(writer, resourceResolver, child);
            }
        }
    }

    private static void writeSiteMaps(Writer writer, ResourceResolver resourceResolver, Page parent) throws IOException {
        Externalizer externalizer = resourceResolver.adaptTo(Externalizer.class);
        Iterator<Page> children = parent.listChildren();
        while (children.hasNext()) {
            Page child = children.next();
            writer.write("<sitemap><loc>");
            writer.write(externalizer.publishLink(resourceResolver, child.getPath()) + "/sitemap.xml");
            writer.write("</loc></sitemap>");
        }
    }

    public static void generate(SlingHttpServletRequest request, SlingHttpServletResponse response, String rootpath) throws IOException {
        Writer writer = writeXmlHeader(response);
        writer.write("<urlset xmlns=\"http://www.sitemaps.org/schemas/sitemap/0.9\">");
        ResourceResolver resourceResolver = request.getResourceResolver();
        Page resRootPage = resourceResolver.adaptTo(PageManager.class).getPage(rootpath);
        writePageUrls(writer, resourceResolver, resRootPage);
        writer.write("</urlset>");  // site map closing tag
    }

    public static void generateParent(SlingHttpServletRequest request, SlingHttpServletResponse response, String rootpath) throws IOException {
        Writer writer = writeXmlHeader(response);
        writer.write("<sitemapindex xmlns=\"http://www.sitemaps.org/schemas/sitemap/0.9\">");
        ResourceResolver resourceResolver = request.getResourceResolver();
        Page resRootPage = resourceResolver.adaptTo(PageManager.class).getPage(rootpath);
        writeSiteMaps(writer, resourceResolver, resRootPage);
        writer.write("</sitemapindex>");  // site map closing tag
    }

}
