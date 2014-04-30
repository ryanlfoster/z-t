package com.australia.content.domain;

import java.util.List;


public class ContentSearchResult {

	private final long totalResultCount;
	private final List<Content> content;

	public ContentSearchResult(long totalResultCount, List<Content> content) {
		this.totalResultCount = totalResultCount;
		this.content = content;
	}

	public long getTotalResultCount() {
		return totalResultCount;
	}

	public List<Content> getContent() {
		return content;
	}
}
