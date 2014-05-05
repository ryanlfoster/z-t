package com.australia.foodandwine.job;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.jcr.Session;
import javax.jcr.query.Query;
import javax.jcr.query.QueryManager;
import javax.jcr.query.QueryResult;
import javax.jcr.query.Row;
import javax.jcr.query.RowIterator;

import org.apache.commons.lang.StringUtils;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.resource.ModifiableValueMap;
import org.apache.sling.api.resource.PersistenceException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.settings.SlingSettingsService;
import org.apache.tika.Tika;
import org.apache.tika.detect.Detector;
import org.apache.tika.mime.MimeTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.australia.utils.PathUtils;
import com.australia.utils.ServerUtils;
import com.australia.utils.TagUtils;
import com.day.cq.commons.date.DateUtil;
import com.day.cq.commons.jcr.JcrConstants;
import com.day.cq.commons.jcr.JcrUtil;
import com.day.cq.dam.api.Asset;
import com.day.cq.dam.api.AssetManager;
import com.day.cq.tagging.Tag;
import com.day.cq.tagging.TagManager;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.day.cq.wcm.api.WCMException;

@Component(label = "Experience creation job", metatype = true)
@Service
@Properties({ @Property(name = "scheduler.expression", value = "0 0/10 * * * ?"),
	@Property(name = "scheduler.concurrent", propertyPrivate = true, boolValue = false) })
public class ExperienceCreationJob implements Runnable {
	private static final Logger LOG = LoggerFactory.getLogger(ExperienceCreationJob.class);
	private static final String QUERY_STRING = "SELECT * FROM [cq:Page] AS s WHERE ISDESCENDANTNODE(["
		+ PathUtils.FOOD_AND_WINE_USER_GENERATED + "]) AND [jcr:created] > '%s'";
	private static final String CATEGORY_PREFIX = "category-%s";

	private ResourceResolver resourceResolver;
	private Detector detector;

	@Reference
	private ResourceResolverFactory resourceResolverFactory;

	@Reference
	private SlingSettingsService slingSettings;

	@Override
	public void run() {
		if (!slingSettings.getRunModes().contains(ServerUtils.AUTHOR)) {
			return;
		}
		int article_found = 0;
		int article_created = 0;
		String path = "/etc/designs/foodandwine/jcr:content";

		try {
			resourceResolver = resourceResolverFactory.getAdministrativeResourceResolver(null);
			Resource resource = resourceResolver.getResource(path);
			final ModifiableValueMap map = resource.adaptTo(ModifiableValueMap.class);

			Date oldRunCronTime = map.get("lastRunCronTime", Date.class);
			if (oldRunCronTime == null) {
				oldRunCronTime = new Date(0);
			}

			String lastRunTime = DateUtil.getISO8601Date(new Date());

			map.put("lastRunCronTime", lastRunTime);
			resourceResolver.commit();
			PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
			Session session = resourceResolver.adaptTo(Session.class);
			QueryManager queryManager = session.getWorkspace().getQueryManager();

			Query query = queryManager.createQuery(
				String.format(QUERY_STRING, DateUtil.getISO8601Date(oldRunCronTime)), Query.JCR_SQL2);

			QueryResult result = query.execute();
			RowIterator rowIterator = result.getRows();
			while (rowIterator != null && rowIterator.hasNext()) {
				Row row = rowIterator.nextRow();
				Page usergenPage = pageManager.getPage(row.getNode().getPath());
				ValueMap pageProperties = usergenPage.getProperties();
				String businessName = pageProperties.get("businessName", String.class);
				// cannot use if node does not have businessName property
				if (StringUtils.isNotEmpty(businessName)) {
					String articleParent = "/content/food-and-wine/experiences/"
						+ StringUtils.lowerCase(Character.toString(businessName.charAt(0)));

					if (pageManager.getPage(articleParent) == null) {
						createIntermediatePage(pageManager, articleParent);
					}

					businessName = JcrUtil.createValidName(businessName, JcrUtil.HYPHEN_LABEL_CHAR_MAPPING, "_");
					String articlePath = articleParent + "/" + businessName;
					Page articlePage = pageManager.getPage(articlePath);
					if (articlePage == null) {
						try {
							generateArticle(usergenPage.getContentResource(), pageProperties, articleParent);
							LOG.debug("Article created: " + articlePath);
							article_created++;
						} catch (Exception e) {
							LOG.error("Error creating article page from usergenerated content: " + articlePath, e);
						}
					} else {
						article_found++;
					}
				}
			}
		} catch (Exception e) {
			LOG.error("Error creating article page from usergenerated content", e);
		} finally {
			if (resourceResolver != null && resourceResolver.isLive()) {
				resourceResolver.close();
			}
		}

		LOG.info("Job completed. " + article_found + " found, " + article_created + " created");
	}

	private void generateArticle(Resource res, ValueMap formProperties, String articleParent) throws WCMException,
		PersistenceException {

		PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
		Page experiencePage = pageManager.create(articleParent, null, "/apps/foodandwine/templates/articlepage",
			formProperties.get("businessName", String.class), true);
		Resource contentResource = experiencePage.getContentResource();
		ModifiableValueMap contentResourceProperties = contentResource.adaptTo(ModifiableValueMap.class);
		contentResourceProperties.put(JcrConstants.JCR_DESCRIPTION,
			formProperties.get("businessDescription", String.class));
		contentResourceProperties.put("articleDescription",formProperties.get("businessDescription", String.class));
		resourceResolver.commit();

		Map<String, Object> mapProperties = new HashMap<String, Object>();
		mapProperties.put("sling:resourceType", "foodandwine/components/content/map");
		mapProperties.put("phone", formProperties.get("phoneNumber", String.class));
		mapProperties.put("suburb", formProperties.get("location", String.class));
		mapProperties.put("state", formProperties.get("selectTerritory", String.class));
		mapProperties.put("website", formProperties.get("businessWebsite", String.class));
		resourceResolver.create(contentResource, "map", mapProperties);
		resourceResolver.commit();

		Map<String, Object> titleProperties = new HashMap<String, Object>();
		titleProperties.put("sling:resourceType", "foodandwine/components/content/articleTitle");
		titleProperties.put("name", formProperties.get("businessName"));
		titleProperties.put("byline", formProperties.get("businessWebsite", String.class));
		resourceResolver.create(contentResource, "articleTitle", titleProperties);
		resourceResolver.commit();

		Map<String, Object> mainparsysProperties = new HashMap<String, Object>();
		mainparsysProperties.put("sling:resourceType", "foundation/components/parsys");
		Resource mainparsysResource = resourceResolver.create(contentResource, "mainparsys", mainparsysProperties);
		resourceResolver.commit();

		String primaryCategory = formProperties.get("primaryCategory", String.class);
		String secondayCategory = formProperties.get("secondaryCategory", String.class);
		List<String> tagIds = new ArrayList<String>();
		tagIds.add(TagUtils.TA_PLACE_TAG
			+ "/"
			+ JcrUtil.createValidName(formProperties.get("selectTerritory", StringUtils.EMPTY),
				JcrUtil.HYPHEN_LABEL_CHAR_MAPPING, "_"));
		if (StringUtils.isNotEmpty(primaryCategory) || StringUtils.isNotEmpty(secondayCategory)) {
			Tag primaryTag = null;
			Tag secondaryTag = null;
			for (Tag tag : getCategoryTags(resourceResolver.adaptTo(TagManager.class))) {
				if (String.format(CATEGORY_PREFIX, tag.getTitle()).toLowerCase().equals(primaryCategory)) {
					primaryTag = tag;
				}
				if (String.format(CATEGORY_PREFIX, tag.getTitle()).toLowerCase().equals(secondayCategory)) {
					secondaryTag = tag;
				}
			}
			if (primaryTag != null || secondaryTag != null) {
				Map<String, Object> categoryProperties = new HashMap<String, Object>();
				int count = 1;
				if (primaryTag != null) {
					String imagePath = "/content/dam/food-and-wine/icons/categories/category-icon-"
						+ primaryTag.getTitle().toLowerCase() + "-white.png";
					categoryProperties.put("caption" + count, primaryTag.getTitle());
					categoryProperties.put("imagePath" + count, imagePath);
					count++;
					tagIds.add(primaryTag.getTagID());
				}
				if (secondaryTag != null) {
					String imagePath = "/content/dam/food-and-wine/icons/categories/category-icon-"
						+ secondaryTag.getTitle().toLowerCase() + "-white.png";
					categoryProperties.put("caption" + count, secondaryTag.getTitle());
					categoryProperties.put("imagePath" + count, imagePath);
					tagIds.add(secondaryTag.getTagID());
				}
				resourceResolver.create(contentResource, "category", categoryProperties);
				resourceResolver.commit();
			}
		}
		contentResourceProperties.put("cq:tags", tagIds.toArray(new String[tagIds.size()]));
		resourceResolver.commit();

		int imagecount = 0;
		for (Resource imageResource : res.getChildren()) {
			try {
				if (imageResource != null && imageResource.getName().startsWith("image")) {
					String count = imageResource.getName().substring(5);
					AssetManager assetManager = resourceResolver.adaptTo(AssetManager.class);
					InputStream imageInputStream = imageResource.adaptTo(InputStream.class);
					String mimeType = imageResource.getChild("jcr:content").adaptTo(ValueMap.class)
						.get("jcr:mimeType", String.class);
					if (mimeType == null) {
						Tika tika = new Tika(detector);
						mimeType = tika.detect(imageResource.adaptTo(InputStream.class));
					}
					String fileExtension = MimeTypes.getDefaultMimeTypes().forName(mimeType).getExtension();
					Asset imageAsset = assetManager.createAsset(
						"/content/dam/food-and-wine/" + experiencePage.getName() + imagecount + fileExtension,
						imageInputStream, mimeType, true);

					Map<String, Object> imageProperties = new HashMap<String, Object>();
					imageProperties.put("sling:resourceType", "foodandwine/components/content/articleImage");
					String description = formProperties.get("photoDescription" + count, String.class);
					if (StringUtils.isNotEmpty(description)) {
						imageProperties.put("imageCaption",
							formProperties.get("photoDescription" + count, String.class));
					}
					Resource newImageResource = resourceResolver.create(mainparsysResource,
						"articleImage" + imagecount, imageProperties);
					resourceResolver.commit();

					Map<String, Object> backgroundImageProperties = new HashMap<String, Object>();
					backgroundImageProperties.put("fileReference", imageAsset.getPath());
					resourceResolver.create(newImageResource, "backgroundImage", backgroundImageProperties);
					resourceResolver.commit();
					imagecount++;
				}
			} catch (Exception e) {
				LOG.error("Error creating asset for image", e);
			}
		}
	}

	private static synchronized void createIntermediatePage(PageManager pageManager, String pagePath)
		throws WCMException {
		String parentPath = pagePath.substring(0, pagePath.lastIndexOf("/"));
		if (pageManager.getPage(parentPath) == null) {
			createIntermediatePage(pageManager, parentPath);
		}
		String pageName = pagePath.substring(pagePath.lastIndexOf("/") + 1);
		pageManager.create(parentPath, pageName, null, null, true);
	}

	private List<Tag> getCategoryTags(TagManager tagManager) {
		List<Tag> categoryTags = new ArrayList<Tag>();
		Tag categoryTag = tagManager.resolve(TagUtils.FOOD_AND_WINE_CATEGORY);
		if (categoryTag != null) {
			Iterator<Tag> childTags = categoryTag.listChildren();
			while (childTags.hasNext()) {
				categoryTags.add(childTags.next());
			}
		}
		return categoryTags;
	}

}
