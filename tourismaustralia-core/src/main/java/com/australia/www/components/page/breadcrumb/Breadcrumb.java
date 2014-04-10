package com.australia.www.components.page.breadcrumb;

import com.citytechinc.cq.component.annotations.Component;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import org.apache.sling.api.SlingHttpServletRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by myeasmin on 25/03/14.
 * 
 * This component is responsible for constructing the breadcrumb for the current
 * page.
 */
@Component(value = "Breadcrumb", path = "page", group = ".hidden", editConfig = false)
public class Breadcrumb {

	private final Page currentPage;

	// private boolean homePage;

	public Breadcrumb(SlingHttpServletRequest slingRequest) {
		currentPage = slingRequest.getResourceResolver().adaptTo(PageManager.class)
			.getContainingPage(slingRequest.getResource());
	}

	public Page getCurrentPage() {
		return currentPage;
	}

	public Iterator<Page> getPredecessorPages() {
		List<Page> predecessorList = new ArrayList<Page>();
		int localLevel = 3;

		while ((currentPage.getDepth() > localLevel) && (localLevel <= (currentPage.getParent().getDepth()))) {
			predecessorList.add(localLevel - 3, currentPage.getAbsoluteParent(localLevel - 1));
			localLevel++;
		}

		Iterator<Page> predecessorListIterator = predecessorList.listIterator();

		return predecessorListIterator;
	}

	/*
	 * public boolean isHomePage() { return homePage; }
	 * 
	 * public void setHomePage(Page thisPage) { if
	 * (StringUtils.equalsIgnoreCase(thisPage.getNavigationTitle(),
	 * "Australia")) { this.homePage = true; } else if
	 * (StringUtils.equalsIgnoreCase(thisPage.getTitle(), "Australia")) {
	 * this.homePage = true; } else if
	 * (StringUtils.equalsIgnoreCase(thisPage.getName(), "Australia")) {
	 * this.homePage = true; } else { this.homePage = false; } }
	 */

}
