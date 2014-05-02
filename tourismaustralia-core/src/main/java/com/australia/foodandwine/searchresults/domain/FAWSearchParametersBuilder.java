package com.australia.foodandwine.searchresults.domain;

import java.util.ArrayList;
import java.util.List;

import com.australia.search.domain.AbstractSeachParametersBuilder;

public class FAWSearchParametersBuilder extends AbstractSeachParametersBuilder<FAWSearchParametersBuilder> {
	private String place;
	private final List<String> searchFilter = new ArrayList<String>();

	public FAWSearchParametersBuilder setPlace(String place) {
		this.place = place;
		return this;
	}

	public FAWSearchParameters build() {
		FAWSearchParameters params = new FAWSearchParameters();
		super.setParameters(params);
		params.setPlace(place);
		params.setTags(searchFilter);
		return params;
	}
}
