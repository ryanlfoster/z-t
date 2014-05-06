package com.australia.foodandwine.searchresults.domain;

import com.australia.search.domain.AbstractSeachParametersBuilder;

public class FAWSearchParametersBuilder extends AbstractSeachParametersBuilder<FAWSearchParametersBuilder> {
	private String place;

	public FAWSearchParametersBuilder setPlace(String place) {
		this.place = place;
		return this;
	}

	public FAWSearchParameters build() {
		FAWSearchParameters params = new FAWSearchParameters();
		super.setParameters(params);
		params.setPlace(place);
		return params;
	}
}
