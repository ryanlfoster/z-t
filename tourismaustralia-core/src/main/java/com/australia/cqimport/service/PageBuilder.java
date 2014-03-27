package com.australia.cqimport.service;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.WCMException;
import org.apache.sling.api.resource.ResourceResolver;

/**
 * Created by Viren Pushpanayagam on 27/03/2014.
 */
public abstract class PageBuilder {
    public abstract void createPage(String oldPath, String newPath, ResourceResolver resourceResolver)
            throws WCMException;

    protected String getPath(String path, boolean isPageNameOnlyRequired){
        String value = null;
        if(isPageNameOnlyRequired){
            value = path.substring(path.lastIndexOf("/")+1);
        } else {
            value = path.substring(0,path.lastIndexOf("/")+1);
        }
        System.out.println("Value=="+value);
        return value;
    }

}
