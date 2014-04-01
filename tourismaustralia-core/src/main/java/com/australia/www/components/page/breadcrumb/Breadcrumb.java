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
 * This component is responsible for constructing the breadcrumb for the current page.
 */
@Component(value = "Breadcrumb", path = "page", group = ".hidden", editConfig = false)
public class Breadcrumb {

	private final Page currentPage;

	public Breadcrumb(SlingHttpServletRequest slingRequest) {
		currentPage = slingRequest.getResourceResolver().adaptTo(PageManager.class)
			.getContainingPage(slingRequest.getResource());
	}

	public Page getCurrentPage() {
			return currentPage;
		}

	public Iterator<Page> getPredecessorPages() {
		List<Page> predecessorList = new ArrayList<Page>();
		int level = 1;
		while ((currentPage.getDepth() > 2) && (level < (currentPage.getParent().getDepth()))) {
			predecessorList.add(level-1, currentPage.getAbsoluteParent(level));
			level++;
		}

		Iterator<Page> predecessorListIterator = predecessorList.listIterator();
		return predecessorListIterator;
	}





}
