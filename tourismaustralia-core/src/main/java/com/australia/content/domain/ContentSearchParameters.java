package com.australia.content.domain;

import com.australia.search.domain.AbstractSearchParameters;

public class ContentSearchParameters extends AbstractSearchParameters {

	private ContentType contentType;
	private String languagePath;

	public ContentType getContentType() {
		return contentType;
	}

	public void setContentType(ContentType contentType) {
		this.contentType = contentType;
	}

	public String getLanguagePath() {
		return languagePath;
	}

	public void setLanguagePath(String languagePath) {
		this.languagePath = languagePath;
	}
}
