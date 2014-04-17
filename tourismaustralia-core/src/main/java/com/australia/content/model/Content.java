package com.australia.content.model;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;

public class Content {

	public static final String ARTICLE_RESOURCE_TEMPLATE = "/apps/tourismaustralia/templates/article";
	public static final String EVENT_RESOURCE_TEMPLATE = "/apps/tourismaustralia/templates/article"; //TODO update
	public static final String PRODUCT_RESOURCE_TEMPLATE = "/apps/tourismaustralia/templates/atdw";

	private final String path;
	private final String title;
	private final String text;
	private final String imagePath;

	public Content(String path, String title, String text, String imagePath) {
		this.path = path + ".html";
		this.title = title;
		this.text = text;
		this.imagePath = imagePath;
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

	public static Content fromResource(final Resource resource) {
		final String path = resource.getPath();
		final ValueMap properties = resource.adaptTo(ValueMap.class);
		final String templateType = properties.get("jcr:content/cq:template", String.class);
		if (PRODUCT_RESOURCE_TEMPLATE.equals(templateType)) {
			return fromProductResource(resource);
		}
		if (EVENT_RESOURCE_TEMPLATE.equals(templateType)) {
			return fromEventResource(resource);
		}
		return fromArticleResource(resource);
	}

	private static Content fromArticleResource(final Resource resource) {
		final String path = resource.getPath();
		final ValueMap properties = resource.adaptTo(ValueMap.class);
		final String title = properties.get("jcr:content/jcr:title", String.class);
		final String text = properties.get("jcr:content/summary/text", String.class);
		final String imagePath = properties.get("jcr:content/image/fileReference", String.class);
		return new Content(path, title, text, imagePath);
	}

	private static Content fromEventResource(final Resource resource) {
		final String path = resource.getPath();
		final ValueMap properties = resource.adaptTo(ValueMap.class);
		final String title = properties.get("jcr:content/jcr:title", String.class);
		final String text = properties.get("jcr:content/summary/text", String.class);
		final String imagePath = properties.get("jcr:content/image/fileReference", String.class);
		return new Content(path, title, text, imagePath);
	}

	private static Content fromProductResource(final Resource resource) {
		final String path = resource.getPath();
		final ValueMap properties = resource.adaptTo(ValueMap.class);
		final String title = properties.get("jcr:content/jcr:title", String.class);
		final String text = properties.get("jcr:content/jcr:description", String.class);
		final String imagePath = properties.get("jcr:content/atdwImage", String.class);
		return new Content(path, title, text, imagePath);
	}
}
