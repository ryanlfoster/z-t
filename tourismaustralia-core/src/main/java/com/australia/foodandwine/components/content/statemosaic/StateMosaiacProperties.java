package com.australia.foodandwine.components.content.statemosaic;

public class StateMosaiacProperties {
	/**
	 * Instance variables
	 */
	private String title;
	private String description;
	private String image;
	private String pagePath;
	private String stateTag;
	private String categoryTagName;
	private String cityTagName;
	private String categoryLogo;
	private String templateName;
	private String userName,messageText,postLink;
	private String linkChecker;
	public String getLinkChecker() {
		return linkChecker;
	}

	public void setLinkChecker(String linkChecker) {
		this.linkChecker = linkChecker;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

	public String getPostLink() {
		return postLink;
	}

	public void setPostLink(String postLink) {
		this.postLink = postLink;
	}

	/**
	 * 
	 * @param title
	 * @param description
	 * @param image
	 * @param pagePath
	 * @param stateTag
	 * @param categoryTagName
	 * @param cityTagName
	 * @param categoryLogo
	 * @param templateName
	 */
	public StateMosaiacProperties(String title, String description,String image, String pagePath, String stateTag, String categoryTagName, String cityTagName, String categoryLogo, String templateName) {
		this.title=title;
		this.description=description;
		this.image=image;
		this.pagePath=pagePath;
		this.stateTag=stateTag;
		this.categoryTagName=categoryTagName;
		this.cityTagName=cityTagName;
		this.categoryLogo=categoryLogo;
		this.templateName=templateName;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getCategoryLogo() {
		return categoryLogo;
	}
	

	public String getTemplateName() {
		return templateName;
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
