package com.australia.content.domain;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;

import com.australia.pagecategories.PageCategory;

/**
 * A View Model that models various types of content as a tile representation
 * (As used by What You Can See) with a title, image, text, and link
 */
public class Content {

	public static final String ARTICLE_RESOURCE_TEMPLATE = "/apps/tourismaustralia/templates/article";
	public static final String PRODUCT_RESOURCE_TEMPLATE = "/apps/tourismaustralia/templates/atdw";

	private final String path;
	private final String title;
	private final String text;
	private final String imagePath;
	private final PageCategory pageCategory;

	/**
	 * Builds a Content object with no date information
	 * 
	 * @param path
	 * @param title
	 * @param text
	 * @param imagePath
	 */
	public Content(final String path, final String title, final String text, final String imagePath,
		final PageCategory pageCategory) {
		this.path = path + ".html";
		this.title = title;
		this.text = text;
		this.imagePath = imagePath;
		this.pageCategory = pageCategory;
	}

	public String getPath() {
		return path;
	}

	public String getTitle() {
		return title;
	}

	public String getText() {
		return text;
	}

	public String getImagePath() {
		return imagePath;
	}

	public PageCategory getPageCategory() {
		return pageCategory;
	}

	public static Content fromResource(final Resource resource) {
		final ValueMap properties = resource.adaptTo(ValueMap.class);
		final String templateType = properties.get("jcr:content/cq:template", String.class);
		Content out;
		if (PRODUCT_RESOURCE_TEMPLATE.equals(templateType)) {
			out = fromProductResource(resource);
		} else {
			out = fromArticleResource(resource);
		}
		return out;
	}

	private static Content fromArticleResource(final Resource resource) {
		final String path = resource.getPath();
		final ValueMap properties = resource.adaptTo(ValueMap.class);
		final String title = properties.get("jcr:content/jcr:title", String.class);
		final String text = properties.get("jcr:content/jcr:description", String.class);
		final String imagePath = properties.get("jcr:content/image/fileReference", String.class);
		final String pageCategoryString = properties.get("jcr:content/ausPageCategory", String.class);
		return new Content(path, title, text, imagePath, PageCategory.fromDisplayString(pageCategoryString));
	}

	private static Content fromProductResource(final Resource resource) {
		final String path = resource.getPath();
		final ValueMap properties = resource.adaptTo(ValueMap.class);
		final String title = properties.get("jcr:content/jcr:title", String.class);
		final String text = properties.get("jcr:content/jcr:description", String.class);
		final String imagePath = properties.get("jcr:content/atdwImage", String.class);
		return new Content(path, title, text, imagePath, null);
	}
}