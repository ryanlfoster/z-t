package com.australia.foodandwine.components.content.search;

import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.widgets.PathField;

public class SearchProperties {
	@DialogField(fieldLabel="Search Page Title",fieldDescription="Page title for common search results",name="searchPageTitle")
	private String searchPageTitle;
	@DialogField(fieldLabel="Search Page Path",fieldDescription="", name="searchPagePath")
	@PathField
	private String searchPagePath;

	public String getSearchPageTitle() {
		return searchPageTitle;
	}

	public void setSearchPageTitle(String searchPageTitle) {
		this.searchPageTitle = searchPageTitle;
	}

	public String getSearchPagePath() {
		return searchPagePath;
	}

	public void setSearchPagePath(String searchPagePath) {
		this.searchPagePath = searchPagePath;
	}

}
