package com.australia.www.components.content.explore;

import java.util.ArrayList;
import java.util.List;

import com.citytechinc.cq.component.annotations.widgets.Html5SmartImage;
import org.apache.commons.lang.StringUtils;

import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.widgets.PathField;

public class Category {

	private static final String REQUIRED_FIELD_NOTE = "Field required for this tab to display";

	@DialogField(fieldLabel = "Icon Image Path", fieldDescription = REQUIRED_FIELD_NOTE)
	@Html5SmartImage(tab = false, height = 100, allowUpload = false, name = "iconImage")
	private String iconImagePath;

	@DialogField(fieldLabel = "Selected Icon Image Path", fieldDescription = REQUIRED_FIELD_NOTE)
	@Html5SmartImage(tab = false, height = 100, allowUpload = false, name = "selectImage")
	private String selectedImagePath;

	@DialogField(fieldLabel = "Tab Title", fieldDescription = REQUIRED_FIELD_NOTE)
	private String title;

	private final List<TabProperties> cards;

	public Category() {
		cards = new ArrayList<TabProperties>();
	}

	public String getIconImagePath() {
		return iconImagePath;
	}

	public String getSelectedImagePath() {
		return selectedImagePath;
	}

	public String getTitle() {
		return title;
	}

	public List<TabProperties> getCards() {
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

	public void setCards(TabProperties card1, TabProperties card2, TabProperties card3) {
		if (cards.isEmpty()) {
			cards.add(card1);
			cards.add(card2);
			cards.add(card3);
		}
	}

	public boolean isValid() {
		if (StringUtils.isBlank(iconImagePath) || StringUtils.isBlank(selectedImagePath) || StringUtils.isBlank(title)){
			return false;
		}
		for (TabProperties card: cards) {
			if (!card.isValid()) {
				return false;
			}
		}
		return !cards.isEmpty();
	}
}
