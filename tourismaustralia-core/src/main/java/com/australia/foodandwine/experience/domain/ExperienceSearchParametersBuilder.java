package com.australia.foodandwine.experience.domain;

import com.australia.search.domain.AbstractSeachParametersBuilder;

public class ExperienceSearchParametersBuilder extends
	AbstractSeachParametersBuilder<ExperienceSearchParametersBuilder> {
	private SortOrderType sort;

	public ExperienceSearchParametersBuilder setSort(SortOrderType sort) {
		this.sort = sort;
		return this;
	}

	public ExperienceSearchParameters build() {
		ExperienceSearchParameters params = new ExperienceSearchParameters();
		super.setParameters(params);
		params.setSort(sort);
		return params;
	}
}
