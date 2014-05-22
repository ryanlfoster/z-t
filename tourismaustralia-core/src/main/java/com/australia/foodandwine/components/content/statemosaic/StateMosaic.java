package com.australia.foodandwine.components.content.statemosaic;

import java.util.ArrayList;
import java.util.List;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.query.Query;
import javax.jcr.query.QueryManager;
import javax.jcr.query.QueryResult;
import javax.jcr.query.Row;
import javax.jcr.query.RowIterator;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.australia.utils.PathUtils;
import com.australia.utils.TagUtils;
import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Listener;
import com.citytechinc.cq.component.annotations.widgets.TextArea;
import com.day.cq.tagging.Tag;
import com.day.cq.tagging.TagManager;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.google.common.collect.ImmutableMap;

@Component(disableTargeting = true, group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", value = "State Mosaic", listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class StateMosaic {

	@DialogField(fieldLabel = "Top Text", name = "./topText")
	private String topText;

	@DialogField(fieldLabel = "Center Text", tab = 1, name = "./centerText")
	private String centerText;

	@DialogField(fieldLabel = "Bottom text", name = "./bottomText")
	private String bottomText;

	@DialogField(fieldLabel = "Message", name = "./messageText", fieldDescription = "Message to be displayed when no article present")
	@TextArea
	private String messageText;
	private List<String> categoryTagList;
	private boolean produce;
	private boolean wine;
	private boolean people;
	private boolean restaurant;
	private boolean experiences;
	private boolean events;
	private boolean seafood;
	private String template;
	private static final String DEFAULT_MESSAGE = "There are no article(s) present for selected tag(s)";
	private static final Logger LOG = LoggerFactory.getLogger(StateMosaic.class);
	private String queryString;
	ImmutableMap<String, String> pathToLocationTag = ImmutableMap.<String, String> builder()
		.put(PathUtils.FOOD_AND_WINE_EXPLORE_AUSTRALIAN_CAPITAL_TERRITORY, TagUtils.AUSTRALIA_CAPITAL_TERRITORY_TAG)
		.put(PathUtils.FOOD_AND_WINE_EXPLORE_NEW_SOUTH_WALES, TagUtils.NEW_SOUTH_WALES_TAG)
		.put(PathUtils.FOOD_AND_WINE_EXPLORE_NORTHERN_TERRITORY, TagUtils.NORTHERN_TERRITORY_TAG)
		.put(PathUtils.FOOD_AND_WINE_EXPLORE_QUEENSLAND, TagUtils.QUEENSLAND_TAG)
		.put(PathUtils.FOOD_AND_WINE_EXPLORE_SOUTH_AUSTRALIA, TagUtils.SOUTH_AUSTRALIA_TAG)
		.put(PathUtils.FOOD_AND_WINE_EXPLORE_TASMANIA, TagUtils.TASMANIA_TAG)
		.put(PathUtils.FOOD_AND_WINE_EXPLORE_VICTORIA, TagUtils.VICTORIA_TAG)
		.put(PathUtils.FOOD_AND_WINE_EXPLORE_WESTERN_AUSTRALIA, TagUtils.WESTERN_AUSTRALIA_TAG).build();

	/**
	 * Constructor
	 * 
	 * @param request
	 */
	public StateMosaic(SlingHttpServletRequest request) {
		try {
			PageManager pageManager = request.getResourceResolver().adaptTo(PageManager.class);
			TagManager tagManager = request.getResourceResolver().adaptTo(TagManager.class);
			Session session = request.getResourceResolver().adaptTo(Session.class);
			QueryManager queryManager = session.getWorkspace().getQueryManager();
			Page currentPage = pageManager.getContainingPage(request.getResource());
			if (currentPage != null) {
				String templateName = currentPage.getProperties().get("cq:template", "");
				template = templateName.substring(templateName.lastIndexOf("/") + 1);
			}
			String path = currentPage.getPath();
			ValueMap properties = request.getResource().adaptTo(ValueMap.class);
			String stateTags = pathToLocationTag.get(path);
			if (properties != null) {
				topText = properties.get("topText", StringUtils.EMPTY);
				centerText = properties.get("centerText", StringUtils.EMPTY);
				bottomText = properties.get("bottomText", StringUtils.EMPTY);
				messageText = properties.get("messageText", DEFAULT_MESSAGE);
			}
			queryString = "SELECT * FROM [nt:base] AS s WHERE ISDESCENDANTNODE([/content/food-and-wine]) and [cq:tags] like '%"
				+ StringUtils.trimToEmpty(stateTags) + "%'";
			Query query = queryManager.createQuery(queryString, Query.JCR_SQL2);
			filterCategoryTags(query, pageManager, tagManager);
		} catch (RepositoryException e) {
			LOG.error("Exception in StateMosaic " + e.getMessage());
		}
	}

	private void filterCategoryTags(Query query, PageManager pageManager, TagManager tagManager)
		throws RepositoryException {
		QueryResult execute = query.execute();
		RowIterator rows = execute.getRows();
		categoryTagList = new ArrayList<String>();
		while (rows != null && rows.hasNext()) {
			Row row = rows.nextRow();
			String path = row.getPath().replace("/jcr:content", "");
			Page articlePage = pageManager.getPage(path);
			ValueMap pageProperties = articlePage.getProperties();
			String[] tagsArray = pageProperties.get("cq:tags", new String[0]);
			List<Tag> foodAndWineCategoryTags = TagUtils.getFoodAndWineCategoryTags(tagManager, tagsArray);
			for (Tag tag : foodAndWineCategoryTags) {
				String tagName = tag.getName();
				if (tagName.equalsIgnoreCase("wine")) {
					wine = true;
				}
				if (tagName.equalsIgnoreCase("people")) {
					people = true;
				}
				if (tagName.equalsIgnoreCase("restaurant")) {
					restaurant = true;
				}
				if (tagName.equalsIgnoreCase("experiences")) {
					experiences = true;
				}
				if (tagName.equalsIgnoreCase("events")) {
					events = true;
				}
				if (tagName.equalsIgnoreCase("seafood")) {
					seafood = true;
				}
				if (tagName.equalsIgnoreCase("produce")) {
					produce = true;
				}
			}
			foodAndWineCategoryTags.clear();
		}
	}

	/**
	 * 
	 * @return
	 */
	public String getTemplate() {
		return template;
	}

	public String getTopText() {
		return topText;
	}

	public String getCenterText() {
		return centerText;
	}

	public String getBottomText() {
		return bottomText;
	}

	public String getMessageText() {
		return messageText;
	}

	public List<String> getCategoryTagList() {
		return categoryTagList;
	}

	public boolean isProduce() {
		return produce;
	}

	public boolean isWine() {
		return wine;
	}

	public boolean isPeople() {
		return people;
	}

	public boolean isRestaurant() {
		return restaurant;
	}

	public boolean isExperiences() {
		return experiences;
	}

	public boolean isEvents() {
		return events;
	}

	public boolean isSeafood() {
		return seafood;
	}

}
