package com.australia.foodandwine.searchresults.domain;

import java.util.List;

public class FAWSearchResult {
	private final List<FAWSearch> fawSearch;
	private final long totalCount;
	private final int page;

	public FAWSearchResult(List<FAWSearch> experiences, long totalCount, int page) {
		this.fawSearch = experiences;
		this.totalCount = totalCount;
		this.page = page;
	}

	public List<FAWSearch> getExperiences() {
		return fawSearch;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public int getPage() {
		return page;
	}
}
