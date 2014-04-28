package com.australia.foodandwine.components.content.statemosaic;

public class StateMosaiacProperties {
	private String title;
	private String description;
	private String image;
	private String pagePath;
	
	public StateMosaiacProperties(String title, String description,String image, String pagePath) {
		this.title=title;
		this.description=description;
		this.image=image;
		this.pagePath=pagePath;
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
