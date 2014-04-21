package com.australia.content.domain;

public enum ContentType {

	EVENT("/apps/tourismaustralia/templates/article"),
	ARTICLE("/apps/tourismaustralia/templates/article"),
	PRODUCT("/apps/tourismaustralia/templates/atdw");

	private final String template;

	private ContentType(final String template) {
		this.template = template;
	}

	public String getTemplate() {
		return template;
	}
}
