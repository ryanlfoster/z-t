package com.australia.foodandwine.components.content.accolade;

import com.citytechinc.cq.component.annotations.DialogField;

public class AccoladeItem {

	@DialogField(fieldLabel = "Year", required = true)
	private String year;

	@DialogField(fieldLabel = "Title", required = true)
	private String title;

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
