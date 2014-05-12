package com.australia.cqimport.service;

import org.apache.sling.api.resource.ResourceResolver;

import com.day.cq.wcm.api.WCMException;

/**
 * Created by Viren Pushpanayagam on 27/03/2014.
 */
public abstract class PageBuilder {

	public static final String CRX_ROOT_PATH = "/content/australia/";
	public static final String CRX_DAM_PATH = "/content/dam/australia";

	public abstract void createPage(String oldPath, String newPath, String lang, ResourceResolver resourceResolver,
		boolean addMixin) throws WCMException;

	protected String getPath(String path, boolean isPageNameOnlyRequired) {
		String value;
		if (isPageNameOnlyRequired) {
			value = path.substring(path.lastIndexOf("/") + 1);
		} else {
			value = path.substring(0, path.lastIndexOf("/") + 1);
		}
		return value;
	}

}
