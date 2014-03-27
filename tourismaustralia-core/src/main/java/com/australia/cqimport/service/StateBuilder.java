package com.australia.cqimport.service;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.day.cq.wcm.api.WCMException;
import org.apache.sling.api.resource.ResourceResolver;

/**
 * Created by Viren Pushpanayagam on 27/03/2014.
 */
public class StateBuilder extends PageBuilder{

    @Override
    public void createPage(String oldPath, String newPath, ResourceResolver resourceResolver) throws WCMException {
        PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
        Page page = pageManager.getPage(newPath);

        if (page == null) {
           pageManager.create(getPath(newPath,false), getPath(newPath,true), null, null, true);
        }
    }
}
