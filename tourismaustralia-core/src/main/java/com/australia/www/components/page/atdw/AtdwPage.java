package com.australia.www.components.page.atdw;

import org.apache.sling.api.SlingHttpServletRequest;

import com.australia.atdw.domain.ATDWProduct;
import com.citytechinc.cq.component.annotations.Component;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

@Component(value = "Atdw", path = "page", group = ".hidden", editConfig = false)
public class AtdwPage {
	private final ATDWProduct atdwProduct;

	public AtdwPage(SlingHttpServletRequest request) {
		this(request.getResourceResolver().adaptTo(PageManager.class).getContainingPage(request.getResource()));
	}

	public AtdwPage(Page currentPage) {
		atdwProduct = new ATDWProduct(currentPage);
	}

	public ATDWProduct getAtdwProduct() {
		return atdwProduct;
	}
}
