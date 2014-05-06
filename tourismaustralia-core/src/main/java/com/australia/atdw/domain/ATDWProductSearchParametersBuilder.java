package com.australia.atdw.domain;

import com.australia.search.domain.AbstractSeachParametersBuilder;

public class ATDWProductSearchParametersBuilder extends
	AbstractSeachParametersBuilder<ATDWProductSearchParametersBuilder> {
	private ATDWCategory category;
	private String city;
	private String state;

	public ATDWProductSearchParametersBuilder setCategory(ATDWCategory category) {
		this.category = category;
		return this;
	}

	public ATDWProductSearchParametersBuilder setCity(String city) {
		this.city = city;
		return this;
	}

	public ATDWProductSearchParametersBuilder setState(String state) {
		this.state = state;
		return this;
	}

	public ATDWProductSearchParameters build() {
		ATDWProductSearchParameters params = new ATDWProductSearchParameters();
		super.setParameters(params);
		params.setCategory(category);
		params.setCity(city);
		params.setState(state);
		return params;
	}
}
