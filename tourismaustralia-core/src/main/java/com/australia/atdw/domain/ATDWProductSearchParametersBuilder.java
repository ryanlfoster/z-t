package com.australia.atdw.domain;

import com.australia.search.domain.AbstractSeachParametersBuilder;

public class ATDWProductSearchParametersBuilder extends
	AbstractSeachParametersBuilder<ATDWProductSearchParametersBuilder> {

	public ATDWProductSearchParameters build() {
		ATDWProductSearchParameters params = new ATDWProductSearchParameters();
		super.setParameters(params);
		return params;
	}
}
