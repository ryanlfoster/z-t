package com.australia.www.components.content.explore;

import org.apache.commons.lang.StringUtils;
import java.util.ArrayList;
import java.util.List;

import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.widgets.PathField;

public class Category {
	@DialogField(fieldLabel = "Icon Image Path")
	@PathField
	private String iconImagePath;

	@DialogField(fieldLabel = "Selected Icon Image Path")
	@PathField
	private String selectedImagePath;

	@DialogField(fieldLabel = "Tab Title")
	private String title;

	private final List<TabProperties> cards;

	public Category(){
		cards = new ArrayList<TabProperties>();
	}

	public String getIconImagePath() {
		return iconImagePath.replaceAll(" ","%20");
	}
	public String getSelectedImagePath() {
		return selectedImagePath.replaceAll(" ","%20");
	}
	public String getTitle() { return title; }
	public List<TabProperties> getCards(){ return new ArrayList<TabProperties>(cards); }
	public boolean getHasTitle(){ return StringUtils.isNotBlank(title); }

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
		if(cards.isEmpty()){
			cards.add(card1);
			cards.add(card2);
			cards.add(card3);
		}
	}
}
