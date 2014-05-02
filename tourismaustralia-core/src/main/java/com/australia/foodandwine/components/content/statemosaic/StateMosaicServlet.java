package com.australia.foodandwine.components.content.statemosaic;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.query.Query;
import javax.jcr.query.QueryManager;
import javax.jcr.query.QueryResult;
import javax.jcr.query.Row;
import javax.jcr.query.RowIterator;

import org.apache.commons.lang3.StringUtils;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.australia.utils.LinkUtils;
import com.australia.utils.PathUtils;
import com.australia.utils.TagUtils;
import com.day.cq.commons.jcr.JcrConstants;
import com.day.cq.tagging.Tag;
import com.day.cq.tagging.TagManager;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.day.cq.wcm.foundation.Image;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;

@SlingServlet(paths = "/bin/fw/statemosaic", extensions = "json", methods = "GET")
public class StateMosaicServlet extends SlingAllMethodsServlet {
	private static final long serialVersionUID = 7522197786244532439L;
	private static final Logger LOG = LoggerFactory.getLogger(StateMosaicServlet.class);
	private static final JsonFactory FACTORY = new JsonFactory();
	private static final ObjectMapper MAPPER = new ObjectMapper();

	ImmutableMap<String, String> pathToLocationTag = ImmutableMap.<String, String> builder()
		.put(PathUtils.FOOD_AND_WINE_EXPLORE_AUSTRALIAN_CAPITAL_TERRITORY, TagUtils.AUSTRALIA_CAPITAL_TERRITORY_TAG)
		.put(PathUtils.FOOD_AND_WINE_EXPLORE_NEW_SOUTH_WALES, TagUtils.NEW_SOUTH_WALES_TAG)
		.put(PathUtils.FOOD_AND_WINE_EXPLORE_NORTHERN_TERRITORY, TagUtils.NORTHERN_TERRITORY_TAG)
		.put(PathUtils.FOOD_AND_WINE_EXPLORE_QUEENSLAND, TagUtils.QUEENSLAND_TAG)
		.put(PathUtils.FOOD_AND_WINE_EXPLORE_SOUTH_AUSTRALIA, TagUtils.SOUTH_AUSTRALIA_TAG)
		.put(PathUtils.FOOD_AND_WINE_EXPLORE_TASMANIA, TagUtils.TASMANIA_TAG)
		.put(PathUtils.FOOD_AND_WINE_EXPLORE_VICTORIA, TagUtils.VICTORIA_TAG)
		.put(PathUtils.FOOD_AND_WINE_EXPLORE_WESTERN_AUSTRALIA, TagUtils.WESTERN_AUSTRALIA_TAG).build();

	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) {
		process(request, response);
	}

	/**
	 * Process method to get 10 set of pages based on tags each time servlet
	 * called.
	 * 
	 * @param request
	 * @param response
	 */
	private void process(SlingHttpServletRequest request, SlingHttpServletResponse response) {
		List<StateMosaiacProperties> propertiesList = new LinkedList<StateMosaiacProperties>();
		String statePath = request.getParameter("stateTag").toLowerCase().replace(".html", "");
		String stateTags = pathToLocationTag.get(statePath);
		String flag = request.getParameter("flag");
		String pageTemplate = request.getParameter("pageTemplate");
		long limit = 10, offset = 0, count = 0; // default
		if (flag.equals("showMore")) {
			limit += 10;
			offset += 10;
			count += 10;
		}
		String[] categoryTags = request.getParameterValues("catogoryArray");
		TagManager tagManager = request.getResourceResolver().adaptTo(TagManager.class);
		PageManager pageManager = request.getResourceResolver().adaptTo(PageManager.class);
		Session session = request.getResourceResolver().adaptTo(Session.class);
		String queryString = "";
		if (categoryTags != null && categoryTags.length > 0) {
			if (categoryTags.length == 1) {
				queryString = "SELECT * FROM [nt:base] AS s WHERE ISDESCENDANTNODE([/content/food-and-wine]) and [cq:tags] like '%"
					+ StringUtils.trimToEmpty(stateTags)
					+ "%' and ( [cq:tags] like '%/"
					+ categoryTags[0].trim()
					+ "%') "
					+ " and ([cq:template]  LIKE '%/apps/foodandwine/templates/articlepage%' or [cq:template]  LIKE '%/apps/foodandwine/templates/facebookpage%' "
					+ "or [cq:template]  LIKE '%/apps/foodandwine/templates/twitterpage%' or [cq:template]  LIKE '%/apps/foodandwine/templates/instagrampage%') ";
			} else {
				queryString = "SELECT * FROM [nt:base] AS s WHERE ISDESCENDANTNODE([/content/food-and-wine]) and [cq:tags] like '%"
					+ StringUtils.trimToEmpty(stateTags) + "%' and( [cq:tags] like '%/" + categoryTags[0].trim() + "%'";
			}
		} else {
			queryString = "SELECT * FROM [nt:base] AS s WHERE ISDESCENDANTNODE([/content/food-and-wine]) and [cq:tags] like '%"
				+ StringUtils.trimToEmpty(stateTags) + "%'";
		}
		try {
			QueryManager queryManager = session.getWorkspace().getQueryManager();
			if (categoryTags != null) {
				for (int i = 1; i < categoryTags.length; i++) {
					queryString += "or [cq:tags] like '%/" + categoryTags[i] + "%' ";
					if (i == categoryTags.length - 1) {
						queryString += ")";
					}
				}
			}
			queryString += " and ([cq:template]  LIKE '%/apps/foodandwine/templates/articlepage%' or [cq:template]  LIKE '%/apps/foodandwine/templates/facebookpage%' "
				+ "or [cq:template]  LIKE '%/apps/foodandwine/templates/twitterpage%' or [cq:template]  LIKE '%/apps/foodandwine/templates/instagrampage%') order by [addToShortlist] DESC";
			Query query = queryManager.createQuery(queryString, Query.JCR_SQL2);
			QueryResult result1 = query.execute();
			long totalResults = result1.getRows().getSize() - count;
			query.setOffset(offset);
			query.setLimit(limit);
			QueryResult result = query.execute();
			RowIterator rowIterator = result.getRows();

			while (rowIterator != null && rowIterator.hasNext()) {
				Row row = rowIterator.nextRow();
				String path = row.getPath().replace("/jcr:content", "");
				Page articlePage = pageManager.getPage(path);
				String cityTagName = "";
				String categoryTagName = "";
				String postLink = "";
				String messageText = "";

				ValueMap pageProperties = articlePage.getProperties();
				String[] tagsArray = pageProperties.get("cq:tags", new String[0]);
				String categoryLogo = pageProperties.get("categoryLogoPath", "");
				String userName = pageProperties.get("userName", StringUtils.EMPTY);
				Tag stateTag = TagUtils.getStateTag(tagManager, tagsArray);
				String stateTitle = "";
				if (stateTag != null) {
					stateTitle = stateTag.getTitle().toString();
				}
				List<Tag> categoryTagList = TagUtils.getFoodAndWineCategoryTags(tagManager, tagsArray);
				for (Tag tag : categoryTagList) {
					if (tag != null) {
						if (!categoryTagName.equals("")) {
							categoryTagName += ", ";
						}
						if (!categoryTagName.contains(tag.getTitle())) {
							categoryTagName += tag.getTitle();
						}
					}

					if (StringUtils.countMatches(categoryTagName, ",") == 2) {
						categoryTagName += "...";
						break;
					}
				}
				Tag cityTag = TagUtils.getCityTag(tagManager, tagsArray);
				if (cityTag != null) {
					cityTagName = cityTag.getTitle().toString() + ",\n" + stateTitle;
				}

				String templateName = articlePage.getProperties().get("cq:template", "");
				templateName = templateName.substring(templateName.lastIndexOf("/") + 1);
				if (!templateName.equals("facebookpage") && (!templateName.equals("instagrampage"))
					&& (!templateName.equals("twitterpage"))) {
					templateName = null;
				} else {
					postLink = pageProperties.get("postLink", StringUtils.EMPTY);
					postLink = LinkUtils.getHrefFromPath(postLink);
					if (templateName.equals("facebookpage")) {
						messageText = pageProperties.get("postText", StringUtils.EMPTY);
					}
					if (templateName.equals("twitterpage")) {
						messageText = pageProperties.get("tweet", StringUtils.EMPTY);
					}
					if (templateName.equals("instagrampage")) {
						messageText = pageProperties.get("description", StringUtils.EMPTY);
					}
					templateName = templateName.replace("page", "");
				}
				String title = articlePage.getTitle();
				String description = articlePage.getDescription();
				String pagePth = LinkUtils.getHrefFromPath(articlePage.getPath());
				String image = null;
				Resource jcrResource = articlePage.adaptTo(Resource.class).getChild(JcrConstants.JCR_CONTENT);
				Image pageImage = new Image(jcrResource, "image");
				if (pageImage != null && pageImage.hasContent()) {
					image = pageImage.getPath() + ".img.jpg";
				}
				StateMosaiacProperties bean = new StateMosaiacProperties(title, description, image, pagePth,
					stateTitle, categoryTagName, cityTagName, categoryLogo, templateName);
				bean.setMessageText(messageText);
				bean.setPostLink(postLink);
				bean.setUserName(userName);
				if (StringUtils.endsWith(postLink, ".html")) {
					bean.setLinkChecker("true");
				}
				if (!StringUtils.equalsIgnoreCase(pageTemplate, "homepage")) {
					bean.setPageTemplate(pageTemplate);
				}
				if (StringUtils.isNotEmpty(templateName)) {
					bean.setSocialIconsWhite(this.resolveSocialIconPath(templateName, "white"));
					bean.setSocialIconsBlack(this.resolveSocialIconPath(templateName, "black"));
				}
				bean.setTotalResults(totalResults);
				propertiesList.add(bean);
			}
		} catch (RepositoryException e) {
			LOG.error("Exception in query execution {0}", e.getMessage());
		}

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		try {
			JsonGenerator generator = FACTORY.createGenerator(response.getWriter());
			MAPPER.writeValue(generator, propertiesList);
		} catch (IOException e) {
			LOG.error("Exception in StateMosaicServlet process method", e.getMessage());
		}
	}

	private String resolveSocialIconPath(String type, String color) {
		String soctype = StringUtils.replace(type, "facebook", "fb");
		return "/etc/designs/foodandwine/clientlibs/imgs/base/share/share-".concat(soctype).concat("-").concat(color)
			.concat(".png");
	}

}