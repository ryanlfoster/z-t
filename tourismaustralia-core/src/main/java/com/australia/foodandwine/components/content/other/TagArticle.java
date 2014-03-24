package com.australia.foodandwine.components.content.other;

import java.util.List;

public class TagArticle {
	private final String tag; 
	private final List<Article> articles;
	public TagArticle(String tag, List<Article> articles) { 
		this.tag=tag;
		this.articles=articles;
	}
	public String getTag() {
		return tag;
	}
	public List<Article> getArticles() {
		return articles;
	}
}
