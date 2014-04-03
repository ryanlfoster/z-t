package com.australia.foodandwine.components.content.otherExperiences;

public class OtherExperiencesArticleListProperties {

	private final String title;
	private final String path;
	private final String image;
	private final String city;
	private final String state;
	private final String[] tags;
	private final String icon;

	public OtherExperiencesArticleListProperties(String title, String path, String image, String city, String state,
		String[] tags, String icon) {
		this.title = title;
		this.path = path;
		this.image = image;
		this.city = city;
		this.state = state;
		this.tags = tags;
		this.icon = icon;
	}

	public String getTitle() {
		return title;
	}

	public String getPath() {
		return path;
	}

	public String getImage() {
		return image;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String[] getTags() {
		return tags;
	}

	public String getIcon() {
		return icon;
	}

}
