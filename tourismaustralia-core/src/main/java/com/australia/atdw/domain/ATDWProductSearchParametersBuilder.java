package com.australia.atdw.domain;

import com.australia.search.domain.AbstractSeachParametersBuilder;

public class ATDWProductSearchParametersBuilder extends
	AbstractSeachParametersBuilder<ATDWProductSearchParametersBuilder> {
	private ATDWCategory category;

	public ATDWProductSearchParametersBuilder setCategory(ATDWCategory category) {
		this.category = category;
		return this;
	}

	public ATDWProductSearchParameters build() {
		ATDWProductSearchParameters params = new ATDWProductSearchParameters();
		super.setParameters(params);
		params.setCategory(category);
		return params;
	}
}
