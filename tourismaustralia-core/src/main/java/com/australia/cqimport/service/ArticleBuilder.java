package com.australia.cqimport.service;

import java.util.HashMap;
import java.util.Map;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

import org.apache.sling.api.resource.PersistenceException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.jcr.resource.JcrResourceConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.australia.cqimport.domain.ConsumerBaseFoundationType;
import com.day.cq.commons.jcr.JcrConstants;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.day.cq.wcm.api.WCMException;

/**
 * Created by Viren Pushpanayagam on 1/04/2014.
 */
public class ArticleBuilder extends PageBuilder {
	private static final Logger LOG = LoggerFactory.getLogger(ArticleBuilder.class);
	private static final String TEMPLATE = "/apps/tourismaustralia/templates/cityState";

	@Override
	public void createPage(String oldPath, String newPath, ResourceResolver resourceResolver, boolean addMixin)
		throws WCMException {
		PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
		Page page = pageManager.getPage(PageBuilder.CRX_ROOT_PATH + newPath);

		Resource pageResource;

		if (page == null) {
			LOG.debug("Importing: " + PageBuilder.CRX_ROOT_PATH + oldPath);
			DefaultConsumerBaseFoundationService service = new DefaultConsumerBaseFoundationService();
			ConsumerBaseFoundationType cbf = service.getByPath(oldPath);

			page = pageManager.create(getPath(PageBuilder.CRX_ROOT_PATH + newPath, false),
				getPath(PageBuilder.CRX_ROOT_PATH + newPath, true), TEMPLATE, null, true);

            pageResource = page.adaptTo(Resource.class);
            Resource jcrContentResource = pageResource.getChild(JcrConstants.JCR_CONTENT);
            Node pageNode = jcrContentResource.adaptTo(Node.class);

            try {
                pageNode.setProperty(JcrConstants.JCR_DESCRIPTION, cbf.getStfDescription());
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
            }

            if (addMixin) {
                try {
                    pageNode.addMixin("cq:LiveSync");
                } catch (RepositoryException e) {
                    LOG.error(e.getMessage(), e);
                }
            }

			createHero(page, resourceResolver, cbf);
			createSummery(page, resourceResolver, cbf);

		}
	}

	private void createHero(Page page, ResourceResolver resourceResolver, ConsumerBaseFoundationType cbf) {
        Resource pageResource = page.adaptTo(Resource.class);
        Resource jcrContentResource = pageResource.getChild(JcrConstants.JCR_CONTENT);
        try {

            Map<String, Object> params = new HashMap<String, Object>();
            params.put("title", cbf.getHdlTitle());
            params.put("altText", cbf.getStfImageLocation());
            params.put("subTitle", cbf.getStfDescription());
            params.put(JcrResourceConstants.SLING_RESOURCE_TYPE_PROPERTY, "tourismaustralia/components/content/hero");

            Resource heroResource = resourceResolver.create(jcrContentResource, "hero", params);
            Node heroNode = heroResource.adaptTo(Node.class);
            heroNode.addMixin("cq:LiveRelationship");
            heroNode.addMixin("cq:LiveSyncCancelled");

            params = new HashMap<String, Object>();
            params.put("fileReference", PageBuilder.CRX_DAM_PATH + cbf.getImgBackground());
            resourceResolver.create(heroResource, "image", params);
            resourceResolver.commit();

        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }

	}

	private void createSummery(Page page, ResourceResolver resourceResolver, ConsumerBaseFoundationType cbf) {
        Resource pageResource = page.adaptTo(Resource.class);
        Resource jcrContentResource = pageResource.getChild(JcrConstants.JCR_CONTENT);
        try {

            Map<String, Object> params = new HashMap<String, Object>();
            params.put("text", cbf.getConBody().getSubPageLayout().getConBody().getTopCategoryHighlights().get(0).getTxtInformation());
            params.put(JcrResourceConstants.SLING_RESOURCE_TYPE_PROPERTY, "tourismaustralia/components/content/summery");

            Resource summaryResource = resourceResolver.create(jcrContentResource, "summary", params);
            Node summaryNode = summaryResource.adaptTo(Node.class);
            summaryNode.addMixin("cq:LiveRelationship");
            summaryNode.addMixin("cq:LiveSyncCancelled");
            resourceResolver.commit();
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }

	}
}
