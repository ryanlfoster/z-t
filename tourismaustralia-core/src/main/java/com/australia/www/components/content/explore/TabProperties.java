package com.australia.www.components.content.explore;

import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.widgets.PathField;
import com.day.cq.wcm.api.Page;

public class TabProperties {
	@DialogField(name = "Blank")
	private String blank;

	public String getBlank() {
		return blank;
	}
	public void setBlank(String text) {
		blank = text;
	}
}

/*
	@DialogField
	@PathField
	private Page page;
	@DialogField
	@PathField
	private String image;
*/
