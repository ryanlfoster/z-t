package com.australia.www.components.content.explore;

import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.widgets.DialogFieldSet;
import com.citytechinc.cq.component.annotations.widgets.PathField;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;

import java.util.ArrayList;
import java.util.List;

public class Category {
	@DialogField(fieldLabel = "Icon Image Path")
	@PathField
	private String iconImagePath;

	@DialogField(fieldLabel = "Icon Selected Image Path")
	@PathField
	private String selectedImagePath;

	@DialogField(fieldLabel = "Tab Title")
	private String title;

	private final List<TabProperties> cards;

	public Category(){
		cards = new ArrayList<TabProperties>();
	}

	public String getIconImagePath() {
		return iconImagePath;
	}
	public String getSelectedImagePath() {
		return selectedImagePath;
	}
	public String getTitle() { return title; }
	public List<TabProperties> getCards(){
		return new ArrayList<TabProperties>(cards);
	}

	public void setIconImagePath(String path) {
		this.iconImagePath = path;
	}
	public void setSelectedImagePath(String path) {
		this.selectedImagePath = path;
	}
	public void setTitle(String text) {
		this.title = text;
	}
	public void setCards(TabProperties card1, TabProperties card2, TabProperties card3){
		if(!cards.isEmpty()){
			cards.add(card1);
			cards.add(card2);
			cards.add(card3);
		}
	}


}
