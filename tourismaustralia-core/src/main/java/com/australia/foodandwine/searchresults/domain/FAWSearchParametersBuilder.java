package com.australia.foodandwine.searchresults.domain;

import java.util.ArrayList;
import java.util.List;

import com.australia.search.domain.AbstractSeachParametersBuilder;

public class FAWSearchParametersBuilder extends
	AbstractSeachParametersBuilder<FAWSearchParametersBuilder> {
	private SortOrderType sort;
	private List<String> searchFilter = new ArrayList<String>();

	public FAWSearchParametersBuilder setSort(SortOrderType sort) {
		this.sort = sort;
		return this;
	}
	public FAWSearchParametersBuilder setTags(List<String> searchFilter) {
		this.searchFilter =searchFilter;
		return this;
	}
	public FAWSearchParameters build() {
		FAWSearchParameters params = new FAWSearchParameters();
		super.setParameters(params);
		params.setSort(sort);
		params.setTags(searchFilter);
		return params;
	}
}
