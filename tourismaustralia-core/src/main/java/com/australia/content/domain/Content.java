package com.australia.content.domain;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A View Model that models various types of content as a tile representation (As used by What You Can See) with a
 * title, image, text, and link
 */
public class Content {

	private static final SimpleDateFormat MONTH_DAY = new SimpleDateFormat("MMMM d");
	private static final SimpleDateFormat MONTH = new SimpleDateFormat("MMMM");
	private static final SimpleDateFormat DAY = new SimpleDateFormat("d");
	private static final String SEPARATOR = " - ";

	public static final String ARTICLE_RESOURCE_TEMPLATE = "/apps/tourismaustralia/templates/article";
	public static final String EVENT_RESOURCE_TEMPLATE = "/apps/tourismaustralia/templates/article"; //TODO update
	public static final String PRODUCT_RESOURCE_TEMPLATE = "/apps/tourismaustralia/templates/atdw";

	private final String path;
	private final String title;
	private final String text;
	private final String imagePath;
	private final Date startDate;
	private final Date endDate;

	/**
	 * Builds a Content object with no date information
	 *
	 * @param path
	 * @param title
	 * @param text
	 * @param imagePath
	 */
	public Content(final String path, final String title, final String text, final String imagePath) {
		this(path, title, text, imagePath, null, null);
	}

	/**
	 * Builds a Content object with a date range
	 *
	 * @param path
	 * @param title
	 * @param text
	 * @param imagePath
	 * @param startDate
	 * @param endDate
	 */
	public Content(final String path, final String title, final String text, final String imagePath,
		final Date startDate, final Date endDate) {
		this.path = path + ".html";
		this.title = title;
		this.text = text;
		this.imagePath = imagePath;
		this.startDate = startDate;
		this.endDate = endDate;
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

	public final Date getStartDate() {
		return startDate;
	}

	public final Date getEndDate() {
		return endDate;
	}

	public final boolean isEvent() {
		return startDate != null;
	}

	public final String getDateString() {
		final StringBuilder out = new StringBuilder();
		out.append(MONTH_DAY.format(startDate));
		if (endDate != null) {
			out.append(SEPARATOR);
			if (MONTH.format(startDate).equals(MONTH.format(endDate))) {
				out.append(DAY.format(endDate));
			} else {
				out.append(MONTH_DAY.format(endDate));
			}
		}
		return out.toString();
	}

	public final String getStartDateMonth() {
		return MONTH.format(startDate);
	}

	public final String getStartDateDay() {
		return DAY.format(startDate);
	}

	public static Content fromResource(final Resource resource) {
		final ValueMap properties = resource.adaptTo(ValueMap.class);
		final String templateType = properties.get("jcr:content/cq:template", String.class);
		Content out;
		if (PRODUCT_RESOURCE_TEMPLATE.equals(templateType)) {
			out =  fromProductResource(resource);
		} else if (EVENT_RESOURCE_TEMPLATE.equals(templateType)) {
			out = fromEventResource(resource);
		} else {
			out = fromArticleResource(resource);
		}
		return out;
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
		final Date startDate = properties.get("jcr:content/startDate", Date.class);
		final Date endDate = properties.get("jcr:content/endDate", Date.class);
		return new Content(path, title, text, imagePath, startDate, endDate);
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