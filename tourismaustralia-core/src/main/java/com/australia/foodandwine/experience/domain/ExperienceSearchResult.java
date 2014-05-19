package com.australia.foodandwine.experience.domain;

import java.util.List;
import java.util.Map;

public class ExperienceSearchResult {
	private final List<Experience> experiences;
	private final Map<String, List<Experience>> articleMap;
	private final long totalCount;
	private final int page;

	public ExperienceSearchResult(List<Experience> experiences, Map<String, List<Experience>> articleMap,
		long totalCount, int page) {
		this.experiences = experiences;
		this.totalCount = totalCount;
		this.page = page;
		this.articleMap = articleMap;

	}

	public Map<String, List<Experience>> getArticleMap() {
		return articleMap;
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
