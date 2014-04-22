package com.australia.foodandwine.experience.domain;

import java.util.List;

public class DefaultSearchRepository {
	private final List<Experience> experiences;
	private final long totalCount;
	private final int page;

	public DefaultSearchRepository(List<Experience> experiences, long totalCount, int page) {
		this.experiences = experiences;
		this.totalCount = totalCount;
		this.page = page;
	}

	public List<Experience> getExperiences() {
		return experiences;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public int getPage() {
		return page;
	}
}
