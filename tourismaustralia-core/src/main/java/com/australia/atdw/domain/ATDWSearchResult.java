package com.australia.atdw.domain;

import java.util.List;

public final class ATDWSearchResult {

	private final List<ATDWProduct> results;
	private final long totalResultCount;

	public ATDWSearchResult(final List<ATDWProduct> results, final long totalResultCount) {
		this.results = results;
		this.totalResultCount = totalResultCount;
	}

	public List<ATDWProduct> getResults() {
		return results;
	}

	public long getTotalResultCount() {
		return totalResultCount;
	}
}
