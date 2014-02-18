package com.australia.www.components.page.global;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Option;
import com.citytechinc.cq.component.annotations.widgets.Selection;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

@Component(value = "Global", path = "page", group = ".hidden", editConfig = false, fileName = "extra_dialog")
public class Global {
	@DialogField(fieldLabel = "Hide from Search", fieldDescription = "Removes the page from the site search")
	@Selection(type = Selection.CHECKBOX, options = @Option(value = "true"))
	private final boolean removeFromSearch;

	public Global(SlingHttpServletRequest request) {
		Page currentPage = request.getResourceResolver().adaptTo(PageManager.class)
			.getContainingPage(request.getResource());
		ValueMap properties = currentPage.getProperties();
		removeFromSearch = properties.get("removeFromSearch", false);
	}

	public boolean getRemoveFromSearch() {
		return removeFromSearch;
	}
}
