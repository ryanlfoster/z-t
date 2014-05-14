package com.australia.www.components.content.breadcrumb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.sling.api.SlingHttpServletRequest;

import com.citytechinc.cq.component.annotations.Component;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

@Component(value = "Breadcrumb", actions = { "text:Breadcrumb", "-", "copymove", "delete", "-", "insert" })
public class Breadcrumb {
	private final Iterator<Page> predecessorPages;

	public Breadcrumb(SlingHttpServletRequest slingRequest) {
		Page currentPage = slingRequest.getResourceResolver().adaptTo(PageManager.class)
			.getContainingPage(slingRequest.getResource());

		List<Page> pagelist = new ArrayList<Page>();
		for (int i = currentPage.getDepth() - 1; i > 1; i--) {
			pagelist.add(currentPage.getAbsoluteParent(i));
		}
		Collections.reverse(pagelist);
		predecessorPages = pagelist.listIterator();
	}

	public Iterator<Page> getPredecessorPages() {
		return predecessorPages;
	}

}
