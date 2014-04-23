package com.australia.foodandwine.listener;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.resource.ModifiableValueMap;
import org.apache.sling.api.resource.PersistenceException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.api.resource.ValueMap;
import org.apache.tika.Tika;
import org.apache.tika.detect.Detector;
import org.apache.tika.mime.MimeTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.australia.utils.PathUtils;
import com.day.cq.commons.jcr.JcrConstants;
import com.day.cq.dam.api.Asset;
import com.day.cq.dam.api.AssetManager;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.day.cq.wcm.api.WCMException;

@Component(immediate = true)
@Service(value = Runnable.class)
@Property(name = "scheduler.expression", value = "0 1 * * * *")
public class ExperienceCreationJob implements Runnable {
	private static final Logger LOG = LoggerFactory.getLogger(ExperienceCreationJob.class);
	private Detector detector;

	@Reference
	private ResourceResolverFactory resourceResolverFactory;

	@Override
	public void run() {
		ResourceResolver resourceResolver = null;
		LOG.error("******************************inside ExperienceCreationJob run method ");
		try {
			resourceResolver = resourceResolverFactory.getAdministrativeResourceResolver(null);
			PageManager pageManager = resourceResolver.adaptTo(PageManager.class);

			String path = PathUtils.FOOD_AND_WINE_USER_GENERATED + "/experiences";
			Resource resource = resourceResolver.getResource(path);
			Iterable<Resource> resources = resourceResolver.getChildren(resource);
			for (Resource res : resources) {
				ValueMap formProperties = res.adaptTo(ValueMap.class);
				String businessName = formProperties.get("businessName", String.class);

				String articleParent = "/content/foodandwine/experiences/"
					+ StringUtils.lowerCase(Character.toString(businessName.charAt(0)));

				String articlePath = articleParent + "/"
					+ StringUtils.lowerCase(businessName.replaceAll("[\\s'&]", "-"));

				Resource articleResource = resourceResolver.getResource(articlePath);

				if (articleResource == null) {
					generateArticle(resourceResolver, pageManager, res, formProperties, businessName, articleParent);
				}
			}

		} catch (Exception e) {
			LOG.error("Error creating page from form");
		} finally {
			if (resourceResolver != null && resourceResolver.isLive()) {
				resourceResolver.close();
			}
		}

	}

	private void generateArticle(ResourceResolver resourceResolver, PageManager pageManager, Resource res,
		ValueMap formProperties, String businessName, String articleParent) throws WCMException, PersistenceException {
		Page experiencePage = pageManager.create(articleParent, null, "/apps/foodandwine/templates/articlepage",
			businessName, true);
		Resource contentResource = experiencePage.getContentResource();
		ModifiableValueMap contentResourceProperties = contentResource.adaptTo(ModifiableValueMap.class);
		contentResourceProperties.put(JcrConstants.JCR_DESCRIPTION,
			formProperties.get("businessDescription", String.class));
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
		titleProperties.put("name", businessName);
		titleProperties.put("byline", formProperties.get("businessWebsite", String.class));
		resourceResolver.create(contentResource, "articleTitle", titleProperties);
		resourceResolver.commit();

		Map<String, Object> mainparsysProperties = new HashMap<String, Object>();
		mainparsysProperties.put("sling:resourceType", "foundation/components/parsys");
		Resource mainparsysResource = resourceResolver.create(contentResource, "mainparsys", mainparsysProperties);
		resourceResolver.commit();

		Resource fileResource = res.getChild("file");
		try {
			if (fileResource != null) {
				AssetManager assetManager = resourceResolver.adaptTo(AssetManager.class);
				InputStream imageInputStream = fileResource.adaptTo(InputStream.class);
				String mimeType = fileResource.getChild("jcr:content").adaptTo(ValueMap.class)
					.get("jcr:mimeType", String.class);
				if (mimeType == null) {
					Tika tika = new Tika(detector);
					mimeType = tika.detect(fileResource.adaptTo(InputStream.class));
				}
				String fileExtension = MimeTypes.getDefaultMimeTypes().forName(mimeType).getExtension();
				Asset imageAsset = assetManager.createAsset("/content/dam/food-and-wine/" + experiencePage.getName()
					+ fileExtension, imageInputStream, mimeType, true);

				Map<String, Object> imageProperties = new HashMap<String, Object>();
				imageProperties.put("sling:resourceType", "foodandwine/components/content/articleImage");
				imageProperties.put("imageCaption", formProperties.get("photoDescription", String.class));
				Resource imageResource = resourceResolver.create(mainparsysResource, "articleImage", imageProperties);
				resourceResolver.commit();

				Map<String, Object> backgroundImageProperties = new HashMap<String, Object>();
				backgroundImageProperties.put("fileReference", imageAsset.getPath());
				resourceResolver.create(imageResource, "backgroundImage", backgroundImageProperties);
				resourceResolver.commit();
			}
		} catch (Exception e) {
			LOG.error("Error creating asset for image", e);
		}
	}

}
