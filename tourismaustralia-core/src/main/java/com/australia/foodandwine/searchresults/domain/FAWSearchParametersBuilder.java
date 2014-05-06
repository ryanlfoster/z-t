package com.australia.foodandwine.searchresults.domain;

import com.australia.search.domain.AbstractSeachParametersBuilder;

public class FAWSearchParametersBuilder extends
	AbstractSeachParametersBuilder<FAWSearchParametersBuilder> {
	private SortOrderType sort;

	public FAWSearchParametersBuilder setSort(SortOrderType sort) {
		this.sort = sort;
		return this;
	}

	public FAWSearchParameters build() {
		FAWSearchParameters params = new FAWSearchParameters();
		super.setParameters(params);
		params.setSort(sort);
		return params;
	}
}
