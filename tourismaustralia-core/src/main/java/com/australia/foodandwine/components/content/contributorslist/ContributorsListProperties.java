package com.australia.foodandwine.components.content.contributorslist;

public class ContributorsListProperties {

	private String businessName;
	private String businessWebsite;
	private String primaryCategory;
	private String state;
	private int artileCount;
	private int pageCount;

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getArtileCount() {
		return artileCount;
	}

	public void setArtileCount(int artileCount) {
		this.artileCount = artileCount;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getBusinessWebsite() {
		return businessWebsite;
	}

	public void setBusinessWebsite(String businessWebsite) {
		this.businessWebsite = businessWebsite;
	}

	public String getPrimaryCategory() {
		return primaryCategory;
	}

	public void setPrimaryCategory(String primaryCategory) {
		this.primaryCategory = primaryCategory;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
