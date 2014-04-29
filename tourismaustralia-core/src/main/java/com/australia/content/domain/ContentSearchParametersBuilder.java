package com.australia.content.domain;

import com.australia.search.domain.AbstractSeachParametersBuilder;

public class ContentSearchParametersBuilder extends AbstractSeachParametersBuilder<ContentSearchParametersBuilder> {

	private ContentType contentType;
	private String languagePath;

	public ContentSearchParametersBuilder setContentType(ContentType contentType) {
		this.contentType = contentType;
		return this;
	}

	public ContentSearchParametersBuilder setLanguagePath(String languagePath) {
		this.languagePath = languagePath;
		return this;
	}

	public ContentSearchParameters build() {
		ContentSearchParameters params = new ContentSearchParameters();
		super.setParameters(params);
		params.setContentType(contentType);
		params.setLanguagePath(languagePath);
		return params;
	}
}
