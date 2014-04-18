package com.australia.foodandwine.components.content.statemosaic;

public class StateMosaiacProperties {
	private String title;
	private String description;
	private String image;
	private String pagePath;
	private String stateTag;
	private String categoryTagName;
	private String cityTagName;
	public StateMosaiacProperties(String title, String description,String image, String pagePath, String stateTag, String categoryTagName, String cityTagName) {
		this.title=title;
		this.description=description;
		this.image=image;
		this.pagePath=pagePath;
		this.stateTag=stateTag;
		this.categoryTagName=categoryTagName;
		this.cityTagName=cityTagName;
	}

	public String getCityTagName() {
		return cityTagName;
	}

	public String getCategoryTagName() {
		return categoryTagName;
	}

	public String getStateTag() {
		return stateTag;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getImage() {
		return image;
	}

	public String getPagePath() {
		return pagePath;
	}
	
	

}
