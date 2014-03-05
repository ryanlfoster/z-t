package com.australia.atdw.domain;

import org.apache.sling.api.resource.ValueMap;

import com.day.cq.wcm.api.Page;

public class ATDWProduct {
	private final String title;
	private final String description;
	private final String category;
	private final String image;
	private final boolean tqual;
	private final String city;
	private final String state;
	private final String region;
	private final String website;

	public ATDWProduct(Page page) {
		ValueMap properties = page.getProperties();
		title = properties.get("jcr:title", String.class);
		description = properties.get("jcr:description", String.class);
		category = properties.get("category", String.class);
		image = properties.get("atdwImage", String.class);
		tqual = properties.get("tqual", false);
		city = properties.get("city", String.class);
		state = properties.get("state", String.class);
		region = properties.get("region", String.class);
		website = properties.get("website", String.class);
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getCategory() {
		return category;
	}

	public String getImage() {
		return image;
	}

	public boolean isTqual() {
		return tqual;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getRegion() {
		return region;
	}

	public String getWebsite() {
		return website;
	}
}
