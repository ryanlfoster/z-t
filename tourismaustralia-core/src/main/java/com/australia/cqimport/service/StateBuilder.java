package com.australia.cqimport.service;

import com.australia.cqimport.domain.ConsumerBaseFoundationType;
import com.day.cq.commons.jcr.JcrConstants;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.day.cq.wcm.api.WCMException;
import org.apache.sling.api.resource.PersistenceException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Viren Pushpanayagam on 27/03/2014.
 */
public class StateBuilder extends PageBuilder {

    @Override
    public void createPage(String oldPath, String newPath, ResourceResolver resourceResolver) throws WCMException {
        PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
        Page page = pageManager.getPage(PageBuilder.CRX_ROOT_PATH + newPath);

        if (page == null) {
            DefaultConsumerBaseFoundationService service = new DefaultConsumerBaseFoundationService();
            ConsumerBaseFoundationType cbf = service.getByPath(oldPath);

            page = pageManager.create(getPath(PageBuilder.CRX_ROOT_PATH + newPath, false), getPath(PageBuilder.CRX_ROOT_PATH
                            + newPath, true), null, null, true);

            createHero(page,resourceResolver,cbf);
            System.out.println(cbf.getHdlTitle());

        }
    }

    private void createHero(Page page, ResourceResolver resourceResolver, ConsumerBaseFoundationType cbf) {
        Resource pageResource = page.adaptTo(Resource.class);
        Resource jcrContentResource = pageResource.getChild(JcrConstants.JCR_CONTENT);
        try {

            Map params = new HashMap<String,String>();
            params.put("title",cbf.getHdlTitle());
            params.put("image",cbf.getImgBackground());
            //params.put("imageBanner",cbf.getStfIntroTitle());
            resourceResolver.create(jcrContentResource, "hero", params);
            resourceResolver.commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
        }

    }
}
