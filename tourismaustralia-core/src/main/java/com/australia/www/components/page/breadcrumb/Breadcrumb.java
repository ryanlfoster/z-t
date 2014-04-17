package com.australia.www.components.page.breadcrumb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.australia.utils.PathUtils;
import com.australia.utils.ServerUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;

import com.citytechinc.cq.component.annotations.Component;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import org.apache.sling.api.resource.ValueMap;

/**
 * Created by myeasmin on 25/03/14.
 * 
 * This component is responsible for constructing the breadcrumb for the current
 * page.
 */
@Component(value = "Breadcrumb", path = "page", group = ".hidden", editConfig = false)
public class Breadcrumb {

	private Page currentPage;

	private boolean localeRootPage;

	private boolean homePage4Aus;

	public boolean isHomePage4Aus() {
		return homePage4Aus;
	}

	public Breadcrumb(SlingHttpServletRequest slingRequest) {
		currentPage = slingRequest.getResourceResolver().adaptTo(PageManager.class)
			.getContainingPage(slingRequest.getResource());
		ValueMap properties = currentPage.getProperties();
		localeRootPage = setLocalePage(slingRequest);
		homePage4Aus = currentPage.getPath().equals(PathUtils.OZCOM_ROOT_PATH);
	}

	public Page getCurrentPage() {
		return currentPage;
	}

	public boolean isLocaleRootPage() {
	   return localeRootPage;
	}

	public boolean setLocalePage(SlingHttpServletRequest slingRequest) {
		if(!(StringUtils.isEmpty(ServerUtils.getLanguageCode(slingRequest))) &&
			(currentPage.getDepth() > 2) &&
			(currentPage.getAbsoluteParent(2).getPath().endsWith(ServerUtils.getLanguageCode(slingRequest)))) {
				localeRootPage = true;
		} else {
			localeRootPage = false;
		}
		return localeRootPage;
	}

	public Iterator<Page> getPredecessorPages() {
		Iterator<Page> predecessorListIterator = null;
		if (localeRootPage) {
			predecessorListIterator = buildPagesList(3);
		} else {
			predecessorListIterator = buildPagesList(2);
		}


		return predecessorListIterator;
	}

	private Iterator<Page> buildPagesList (int localLevel) {
		List<Page> predecessorList = new ArrayList<Page>();
		int startIndex = 0;

		while ((currentPage.getDepth() > localLevel) && (localLevel <= (currentPage.getParent().getDepth()))) {
			predecessorList.add(startIndex, currentPage.getAbsoluteParent(localLevel - 1));
			localLevel++;
			startIndex++;
		}

		return predecessorList.listIterator();
	}
}
