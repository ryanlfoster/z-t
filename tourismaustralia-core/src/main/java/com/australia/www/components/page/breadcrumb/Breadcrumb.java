package com.australia.www.components.page.breadcrumb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;

import com.australia.utils.PathUtils;
import com.australia.utils.ServerUtils;
import com.citytechinc.cq.component.annotations.Component;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

@Component(value = "Breadcrumb", actions = { "text:Breadcrumb", "-", "copymove", "delete", "-", "insert" })
public class Breadcrumb {

	private final Page currentPage;

	private boolean localeRootPage;

	private final boolean homePage4Aus;

	public Breadcrumb(SlingHttpServletRequest slingRequest) {
		currentPage = slingRequest.getResourceResolver().adaptTo(PageManager.class)
			.getContainingPage(slingRequest.getResource());
		localeRootPage = setLocalePage(slingRequest);
		homePage4Aus = currentPage.getPath().equals(PathUtils.OZCOM_ROOT_PATH);
	}

	private boolean setLocalePage(SlingHttpServletRequest slingRequest) {
		String lang = ServerUtils.getLanguageCode(slingRequest);
		localeRootPage = (StringUtils.isNotEmpty(lang)) && (currentPage.getDepth() > 2)
			&& (currentPage.getAbsoluteParent(2).getPath().endsWith(lang));
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

	private Iterator<Page> buildPagesList(int localLevel) {
		List<Page> predecessorList = new ArrayList<Page>();
		int startIndex = 0;
		while ((currentPage.getDepth() > localLevel) && (localLevel <= (currentPage.getParent().getDepth()))) {
			predecessorList.add(startIndex, currentPage.getAbsoluteParent(localLevel - 1));
			localLevel++;
			startIndex++;
		}
		return predecessorList.listIterator();
	}

	public Page getCurrentPage() {
		return currentPage;
	}

	public boolean isLocaleRootPage() {
		return localeRootPage;
	}

	public boolean isHomePage4Aus() {
		return homePage4Aus;
	}

}
