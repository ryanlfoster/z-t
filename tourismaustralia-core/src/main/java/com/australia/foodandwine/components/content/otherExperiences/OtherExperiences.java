package com.australia.foodandwine.components.content.otherExperiences;

import java.util.ArrayList;
import java.util.List;

import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.query.Query;
import javax.jcr.query.QueryManager;
import javax.jcr.query.QueryResult;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.australia.foodandwine.components.constants.CQJCRConstants;
import com.australia.utils.LinkUtils;
import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.FieldProperty;
import com.citytechinc.cq.component.annotations.Listener;
import com.citytechinc.cq.component.annotations.widgets.PathField;

@Component(group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", value = "Other Experiences", listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class OtherExperiences {

	@DialogField(fieldLabel = "Heading Logo Path", name = "./logoPath")
	@PathField(rootPath = "/content/dam/")
	private final String logoPath;

	@DialogField(fieldLabel = "Small Text Title", name = "./smallTextTitle", fieldDescription = " The Maximum characters for this field is 200", additionalProperties = @FieldProperty(name = "maxLength", value = "200"))
	private final String smallTextTitle;

	@DialogField(fieldLabel = "Large Text Title", name = "./largeTextTitle", fieldDescription = " The Maximum characters for this field is 200", additionalProperties = @FieldProperty(name = "maxLength", value = "200"))
	private final String largeTextTitle;

	@DialogField(fieldLabel = "List Articles Based on Tags", name = "./articleTagBasedList", xtype = "tags")
	private final String[] articleTagBasedList;
	private Session session;
	private static final Logger LOG = LoggerFactory.getLogger(OtherExperiences.class);

	private List<OtherExperiencesArticleListProperties> articlesList;

	/**
	 * Constants
	 */
	private final static String LOGO_PATH = "logoPath";
	private final static String SMALL_TEXT_TITLE = "smallTextTitle";
	private final static String LARGE_TEXT_TITLE = "largeTextTitle";
	private final static String ARTICLE_TAG_BASED_LIST = "articleTagBasedList";

	private String articleTitle;
	private String articleImage;
	private String articlePath;
	private String hrefFromPath;
	private String articleSubTitle;
	private String articleDescription;
	private String categoryLogoPath;
	private String overlayCategoryInfo;

	public OtherExperiences(SlingHttpServletRequest request) {
		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		logoPath = properties.get(LOGO_PATH, "/etc/designs/foodandwine/clientlibs/imgs/base/header-map-icon.png");
		smallTextTitle = properties.get(SMALL_TEXT_TITLE, StringUtils.EMPTY);
		largeTextTitle = properties.get(LARGE_TEXT_TITLE, StringUtils.EMPTY);
		articleTagBasedList = properties.get(ARTICLE_TAG_BASED_LIST, new String[0]);
		session = request.getResourceResolver().adaptTo(Session.class);
		articlesList = new ArrayList<OtherExperiencesArticleListProperties>();
		QueryManager queryManager;
		try {
			queryManager = session.getWorkspace().getQueryManager();

			for (String tags : articleTagBasedList) {
				String queryString = "select * from cq:PageContent where cq:tags like '" + tags
					+ "' order by cq:lastModified desc";
				Query query = queryManager.createQuery(queryString, Query.SQL);
				QueryResult result = query.execute();

				NodeIterator nodeIterator = result.getNodes();

				while (nodeIterator.hasNext() && null != nodeIterator) {
					OtherExperiencesArticleListProperties articlesPropertiesList = new OtherExperiencesArticleListProperties();
					Node nextNode = nodeIterator.nextNode();
					if (nextNode.hasProperty(CQJCRConstants.PAGE_TITLE)) {
						articleTitle = nextNode.getProperty(CQJCRConstants.PAGE_TITLE).getValue().getString();
						articlesPropertiesList.setArticleTitle(articleTitle);
					} else {
						articleTitle = nextNode.getProperty(CQJCRConstants.JCRTITLE).getValue().getString();
						articlesPropertiesList.setArticleTitle(articleTitle);
					}

					if (nextNode.hasNode(CQJCRConstants.IMAGENODE)) {
						articleImage = nextNode.getNode(CQJCRConstants.IMAGENODE)
							.getProperty(CQJCRConstants.FILEREFERENCEPROPERTY).getValue().getString();
						articlesPropertiesList.setArticleImage(articleImage);
					}

					articlePath = nextNode.getPath();
					if (articlePath.endsWith("/jcr:content")) {
						articlePath = articlePath.replace("/jcr:content", "");
					}
					hrefFromPath = LinkUtils.getHrefFromPath(articlePath);
					articlesPropertiesList.setArticlePath(hrefFromPath);
					if (nextNode.hasProperty(CQJCRConstants.SUB_TITLE)) {
						articleSubTitle = nextNode.getProperty(CQJCRConstants.SUB_TITLE).getValue().getString();
						articlesPropertiesList.setArticleSubTitle(articleSubTitle);
					}
					if (nextNode.hasProperty(CQJCRConstants.JCRDESCRIPTION)) {
						articleDescription = nextNode.getProperty(CQJCRConstants.JCRDESCRIPTION).getValue().getString();
						articlesPropertiesList.setArticleDescription(articleDescription);
					}
					if (nextNode.hasProperty("categoryLogoPath")) {
						categoryLogoPath = nextNode.getProperty("categoryLogoPath").getValue().getString();
						articlesPropertiesList.setArticleOverLayLogoPath(categoryLogoPath);
					}
					if (nextNode.hasProperty("overlayCategoryInfo")) {
						overlayCategoryInfo = nextNode.getProperty("overlayCategoryInfo").getValue().getString();
						articlesPropertiesList.setArticleOverLayLogoPath(overlayCategoryInfo);
					}

					int size = articlesList.size();
					if (!(size > 3)) {
						articlesList.add(articlesPropertiesList);
					}

				}

			}

		} catch (RepositoryException e) {
			LOG.error(e.getMessage());
		}

	}

	public List<OtherExperiencesArticleListProperties> getArticlesList() {
		return articlesList;
	}

	public String getLogoPath() {
		return logoPath;
	}

	public String getSmallTextTitle() {
		return smallTextTitle;
	}

	public String getLargeTextTitle() {
		return largeTextTitle;
	}

}
