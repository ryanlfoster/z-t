package com.australia.www.components.page.breadcrumb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.sling.api.SlingHttpServletRequest;

import com.citytechinc.cq.component.annotations.Component;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

@Component(value = "Breadcrumb", actions = { "text:Breadcrumb", "-", "copymove", "delete", "-", "insert" })
public class Breadcrumb {

	private final Iterator<Page> predecessorPages;

	private final Page currentPage;

	public Breadcrumb(SlingHttpServletRequest slingRequest) {
		currentPage = slingRequest.getResourceResolver().adaptTo(PageManager.class)
			.getContainingPage(slingRequest.getResource());
		predecessorPages = buildPagesList();
	}

	private Iterator<Page> buildPagesList() {
		int localLevel = 3;
		List<Page> resultlist = new ArrayList<Page>();
		while ((currentPage.getDepth() > localLevel) && (localLevel <= (currentPage.getParent().getDepth()))) {
			resultlist.add(currentPage.getAbsoluteParent(localLevel - 1));
			localLevel++;
		}
		return resultlist.listIterator();
	}

	public Iterator<Page> getPredecessorPages() {
		return predecessorPages;
	}

}
