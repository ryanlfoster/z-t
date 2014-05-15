package com.australia.foodandwine.components.content.otherExperiences;

import java.util.ArrayList;
import java.util.List;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.query.Query;
import javax.jcr.query.QueryManager;
import javax.jcr.query.QueryResult;
import javax.jcr.query.Row;
import javax.jcr.query.RowIterator;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.australia.utils.LinkUtils;
import com.australia.utils.PathUtils;
import com.australia.utils.TagUtils;
import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.Listener;
import com.day.cq.commons.jcr.JcrConstants;
import com.day.cq.tagging.Tag;
import com.day.cq.tagging.TagManager;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.day.cq.wcm.foundation.Image;

@Component(disableTargeting = true, actions = { "text:Other Experiences", "-" }, group = ".hidden", basePath = "jcr_root/apps/foodandwine/components", value = "Other Experiences", listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class OtherExperiences {
	private static final Logger LOG = LoggerFactory.getLogger(OtherExperiences.class);
	private static final String QUERY_STRING = "SELECT * FROM [cq:Page] AS page INNER JOIN [nt:unstructured] AS pageContent ON ISCHILDNODE(pageContent,page) WHERE ISDESCENDANTNODE(page,["
		+ PathUtils.FOOD_AND_WINE_ROOT_PATH
		+ "]) and pageContent.[cq:tags] like '%s%%' and not issamenode(page,'%s') order by pageContent.[cq:lastReplicated] DESC";

	private final List<OtherExperiencesArticleListProperties> articlesList = new ArrayList<OtherExperiencesArticleListProperties>();
	private String stateTitle;

	public OtherExperiences(SlingHttpServletRequest request) {
		PageManager pageManager = request.getResourceResolver().adaptTo(PageManager.class);
		Page currentPage = pageManager.getContainingPage(request.getResource());
		String[] pageTags = currentPage.getProperties().get("cq:tags", new String[0]);
		TagManager tagManager = request.getResourceResolver().adaptTo(TagManager.class);
		Tag stateTag = TagUtils.getStateTag(tagManager, pageTags);
		if (stateTag != null) {
			stateTitle = stateTag.getTitle();
			Session session = request.getResourceResolver().adaptTo(Session.class);
			try {
				QueryManager queryManager = session.getWorkspace().getQueryManager();
				Query query = queryManager.createQuery(
					String.format(QUERY_STRING, stateTag.getTagID(), currentPage.getPath()), Query.JCR_SQL2);
				query.setLimit(4);
				QueryResult result = query.execute();
				RowIterator rowIterator = result.getRows();
				while (rowIterator != null && rowIterator.hasNext()) {
					Row row = rowIterator.nextRow();
					Page articlePage = pageManager.getPage(row.getPath("page"));
					ValueMap pageProperties = articlePage.getProperties();
					String title = articlePage.getTitle();
					String image = null;
					Resource jcrResource = articlePage.adaptTo(Resource.class).getChild(JcrConstants.JCR_CONTENT);
					Image pageImage = new Image(jcrResource, "image");
					if (pageImage != null && pageImage.hasContent()) {
						image = pageImage.getPath() + ".img.jpg";
					}
					String[] tags = pageProperties.get("cq:tags", new String[0]);
					List<String> tagTitles = new ArrayList<String>();
					for (Tag tag : TagUtils.getFoodAndWineCategoryTags(tagManager, tags)) {
						tagTitles.add(tag.getTitle());
					}
					String city = null;
					Tag cityTag = TagUtils.getCityTag(tagManager, tags);
					if (cityTag != null) {
						city = cityTag.getTitle();
					}
					String state = stateTag.getTitle();
					String icon = pageProperties.get("categoryLogoPath", String.class);
					articlesList.add(new OtherExperiencesArticleListProperties(title, LinkUtils
						.getHrefFromPath(articlePage.getPath()), image, city, state, tagTitles.toArray(new String[0]),
						icon));
				}
			} catch (RepositoryException e) {
				LOG.error("Error using query manager", e);
			}
		}

	}

	public List<OtherExperiencesArticleListProperties> getArticlesList() {
		return articlesList;
	}

	public String getStateTitle() {
		return stateTitle;
	}

}
