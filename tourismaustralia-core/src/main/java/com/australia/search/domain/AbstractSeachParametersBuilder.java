package com.australia.search.domain;

import java.util.List;

@SuppressWarnings({ "rawtypes", "unchecked" })
public abstract class AbstractSeachParametersBuilder<T extends AbstractSeachParametersBuilder> {
	private List<String> tags;
	private String text;
	private int count;
	private int page;

	public T setTags(List<String> tags) {
		this.tags = tags;
		return (T) this;
	}

	public T setText(String text) {
		this.text = text;
		return (T) this;
	}

	public T setCount(int count) {
		this.count = count;
		return (T) this;
	}

	public T setPage(int page) {
		this.page = page;
		return (T) this;
	}

	protected void setParameters(AbstractSearchParameters params) {
		params.setText(text);
		params.setTags(tags);
		if (count > 0) {
			params.setCount(count);
		} else {
			params.setCount(20);
		}
		if (page > 0) {
			params.setPage(page);
		} else {
			params.setPage(1);
		}
	}
}
