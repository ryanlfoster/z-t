package com.australia.sitemap;

import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;


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
		Iterator<Page> children = parent.listChildren();
		while (children.hasNext()) {
			Page child = children.next();
			writer.write("<url><loc>");
			writer.write(resourceResolver.map(child.getPath()) + ".html");
			writer.write("</loc></url>");
			if (child.getDepth() > 1) {
				writePageUrls(writer, resourceResolver, child);
			}
		}
	}

	private static void writeSiteMaps(Writer writer, ResourceResolver resourceResolver, Page parent) throws IOException {
		Iterator<Page> children = parent.listChildren();
		while (children.hasNext()) {
			Page child = children.next();
			writer.write("<sitemap><loc>");
			writer.write(resourceResolver.map(child.getPath()) + "/sitemap.xml");
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
