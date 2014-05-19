package com.australia.foodandwine.searchresults.domain;

import java.util.List;

public class FAWSearchResult {
	private final List<FAWSearch> fawSearchList;
	private final long totalCount;
	private final int page;

	public FAWSearchResult(List<FAWSearch> experiences, long totalCount, int page) {
		this.fawSearchList = experiences;
		this.totalCount = totalCount;
		this.page = page;
	}

	public List<FAWSearch> getFawSearchList() {
		return fawSearchList;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public int getPage() {
		return page;
	}
}
