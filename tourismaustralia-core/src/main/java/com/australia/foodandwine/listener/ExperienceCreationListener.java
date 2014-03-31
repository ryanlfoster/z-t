package com.australia.foodandwine.listener;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.jcr.observation.Event;
import javax.jcr.observation.EventIterator;
import javax.jcr.observation.EventListener;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.resource.ModifiableValueMap;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.api.resource.ValueMap;
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

public class ExperienceCreationListener implements EventListener {
	private static final Logger LOG = LoggerFactory.getLogger(ExperienceCreationListener.class);
	public static final int EVENTS = Event.NODE_ADDED;
	private final ResourceResolverFactory resourceResolverFactory;

	public ExperienceCreationListener(ResourceResolverFactory resourceResolverFactory) {
		this.resourceResolverFactory = resourceResolverFactory;
	}

	@Override
	public void onEvent(EventIterator eventIterator) {
		ResourceResolver resourceResolver = null;
		try {
			resourceResolver = resourceResolverFactory.getAdministrativeResourceResolver(null);
			PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
			while (eventIterator.hasNext()) {
				Event event = eventIterator.nextEvent();
				Page page = pageManager.getPage(event.getPath());
				if (page != null) {
					Resource formResource = page.getContentResource();
					ValueMap formProperties = formResource.adaptTo(ValueMap.class);
					String businessName = formProperties.get("businessName", String.class);
					String parentPath = PathUtils.FOOD_AND_WINE_EXPERIENCES + "/"
						+ StringUtils.lowerCase(Character.toString(businessName.charAt(0)));
					if (pageManager.getPage(parentPath) == null) {
						createIntermediatePage(pageManager, parentPath);
					}
					Page experiencePage = pageManager.create(parentPath, null,
						"/apps/foodandwine/templates/articlepage", businessName, true);
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
					Resource mainparsysResource = resourceResolver.create(contentResource, "mainparsys",
						mainparsysProperties);
					resourceResolver.commit();

					Resource fileResource = formResource.getChild("file");
					if (fileResource != null) {
						AssetManager assetManager = resourceResolver.adaptTo(AssetManager.class);
						InputStream imageInputStream = fileResource.adaptTo(InputStream.class);
						String mimeType = fileResource.getChild("jcr:content").adaptTo(ValueMap.class)
							.get("jcr:mimeType", String.class);
						String fileExtension = MimeTypes.getDefaultMimeTypes().forName(mimeType).getExtension();
						Asset imageAsset = assetManager.createAsset(
							"/content/dam/food-and-wine/" + experiencePage.getName() + fileExtension, imageInputStream,
							mimeType, true);

						Map<String, Object> imageProperties = new HashMap<String, Object>();
						imageProperties.put("sling:resourceType", "foodandwine/components/content/articleImage");
						imageProperties.put("imageCaption", formProperties.get("photoDescription", String.class));
						Resource imageResource = resourceResolver.create(mainparsysResource, "articleImage",
							imageProperties);
						resourceResolver.commit();

						Map<String, Object> backgroundImageProperties = new HashMap<String, Object>();
						backgroundImageProperties.put("fileReference", imageAsset.getPath());
						resourceResolver.create(imageResource, "backgroundImage", backgroundImageProperties);
						resourceResolver.commit();
					}
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

	private static synchronized void createIntermediatePage(PageManager pageManager, String pagePath)
		throws WCMException {
		String parentPath = pagePath.substring(0, pagePath.lastIndexOf("/"));
		if (pageManager.getPage(parentPath) == null) {
			createIntermediatePage(pageManager, parentPath);
		}
		String pageName = pagePath.substring(pagePath.lastIndexOf("/") + 1);
		pageManager.create(parentPath, pageName, null, null, true);
	}
}
