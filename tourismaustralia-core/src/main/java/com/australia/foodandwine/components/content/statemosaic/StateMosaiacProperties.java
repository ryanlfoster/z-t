package com.australia.foodandwine.components.content.statemosaic;

public class StateMosaiacProperties {
	private final String title;
	private final String description;
	private final String image;
	private final String pagePath;
	private final String stateTag;
	private final String categoryTagName;
	private final String cityTagName;
	private final String categoryLogo;
	private final String templateName;
	private String userName, messageText, postLink;
	private String linkChecker;
	private String pageTemplate;
	private String socialIconsWhite;
	private String socialIconsBlack;
	private long totalResults;

	public StateMosaiacProperties(String title, String description, String image, String pagePath, String stateTag,
		String categoryTagName, String cityTagName, String categoryLogo, String templateName) {
		this.title = title;
		this.description = description;
		this.image = image;
		this.pagePath = pagePath;
		this.stateTag = stateTag;
		this.categoryTagName = categoryTagName;
		this.cityTagName = cityTagName;
		this.categoryLogo = categoryLogo;
		this.templateName = templateName;
	}

	public long getTotalResults() {
		return totalResults;
	}

	public void setTotalResults(long totalResults) {
		this.totalResults = totalResults;
	}

	public String getSocialIconsWhite() {
		return socialIconsWhite;
	}

	public void setSocialIconsWhite(String socialIconsWhite) {
		this.socialIconsWhite = socialIconsWhite;
	}

	public String getSocialIconsBlack() {
		return socialIconsBlack;
	}

	public void setSocialIconsBlack(String socialIconsBlack) {
		this.socialIconsBlack = socialIconsBlack;
	}

	public String getPageTemplate() {
		return pageTemplate;
	}

	public void setPageTemplate(String pageTemplate) {
		this.pageTemplate = pageTemplate;
	}

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
