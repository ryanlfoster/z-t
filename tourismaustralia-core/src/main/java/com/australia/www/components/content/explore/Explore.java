package com.australia.www.components.content.explore;

import java.util.ArrayList;
import java.util.List;

import com.citytechinc.cq.component.annotations.*;
import com.citytechinc.cq.component.annotations.widgets.TextArea;
import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;

import com.citytechinc.cq.component.annotations.widgets.DialogFieldSet;

@Component(value = "Explore", disableTargeting = true, dialogHeight = 500, dialogWidth = 600,
	tabs = { @Tab(title = "Explore Summary"), @Tab(title = "Tab 1"),
		@Tab(title = "Tab 2"), @Tab(title = "Tab 3"), @Tab(title = "Tab 4"), @Tab(title = "Tab 5") }, listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })

public class Explore {

	private static final String TABx = "tab%d/";
	private static final String TAB1 = "tab1/";
	private static final String TAB2 = "tab2/";
	private static final String TAB3 = "tab3/";
	private static final String TAB4 = "tab4/";
	private static final String TAB5 = "tab5/";
	private static final String CARDx = "card%d-";
	private static final String CARD1 = "card1-";
	private static final String CARD2 = "card2-";
	private static final String CARD3 = "card3-";
	private static final String CARD_LABEL1 = "Card 1";
	private static final String CARD_LABEL2 = "Card 2";
	private static final String CARD_LABEL3 = "Card 3";
	private static final String REQUIRED_FIELD = "Field required for this tab to display";


	@DialogField(fieldLabel = "Title", tab = 1)
	private String title;
	@DialogField(fieldLabel = "Description", tab = 1)
	@TextArea
	private String description;

	@DialogField(xtype = "static", tab = 1, additionalProperties = {
		@FieldProperty(name = "text", value = "This component will display between 1 to 5 "
			+ "tabs depending on the number of valid tabs filled out."
			+ "Invalid tabs will not display. Fields are marked as required for this purpose." + "\n"),
		@FieldProperty(name = "bold", value = "true") })
	private String notice;

	@DialogField(tab = 2)
	@DialogFieldSet(border = false, namePrefix = TAB1)
	private final Category tab1;
	@DialogField(fieldLabel = CARD_LABEL1, fieldDescription = REQUIRED_FIELD, tab = 2)
	@DialogFieldSet(namePrefix = TAB1 + CARD1, collapsible = true, collapsed = true)
	private final TabProperties tab1card1;
	@DialogField(fieldLabel = CARD_LABEL2, fieldDescription = REQUIRED_FIELD, tab = 2)
	@DialogFieldSet(namePrefix = TAB1 + CARD2, collapsible = true, collapsed = true)
	private final TabProperties tab1card2;
	@DialogField(fieldLabel = CARD_LABEL3, fieldDescription = REQUIRED_FIELD, tab = 2)
	@DialogFieldSet(namePrefix = TAB1 + CARD3, collapsible = true, collapsed = true)
	private final TabProperties tab1card3;

	@DialogField(tab = 3)
	@DialogFieldSet(border = false, namePrefix = TAB2)
	private final Category tab2;
	@DialogField(fieldLabel = CARD_LABEL1, fieldDescription = REQUIRED_FIELD, tab = 3)
	@DialogFieldSet(namePrefix = TAB2 + CARD1, collapsible = true, collapsed = true)
	private final TabProperties tab2card1;
	@DialogField(fieldLabel = CARD_LABEL2, fieldDescription = REQUIRED_FIELD, tab = 3)
	@DialogFieldSet(namePrefix = TAB2 + CARD2, collapsible = true, collapsed = true)
	private final TabProperties tab2card2;
	@DialogField(fieldLabel = CARD_LABEL3, fieldDescription = REQUIRED_FIELD, tab = 3)
	@DialogFieldSet(namePrefix = TAB2 + CARD3, collapsible = true, collapsed = true)
	private final TabProperties tab2card3;

	@DialogField(tab = 4)
	@DialogFieldSet(border = false, namePrefix = TAB3)
	private final Category tab3;
	@DialogField(fieldLabel = CARD_LABEL1, fieldDescription = REQUIRED_FIELD, tab = 4)
	@DialogFieldSet(namePrefix = TAB3 + CARD1, collapsible = true, collapsed = true)
	private final TabProperties tab3card1;
	@DialogField(fieldLabel = CARD_LABEL2, fieldDescription = REQUIRED_FIELD, tab = 4)
	@DialogFieldSet(namePrefix = TAB3 + CARD2, collapsible = true, collapsed = true)
	private final TabProperties tab3card2;
	@DialogField(fieldLabel = CARD_LABEL3, fieldDescription = REQUIRED_FIELD, tab = 4)
	@DialogFieldSet(namePrefix = TAB3 + CARD3, collapsible = true, collapsed = true)
	private final TabProperties tab3card3;

	@DialogField(tab = 5)
	@DialogFieldSet(border = false, namePrefix = TAB4)
	private final Category tab4;
	@DialogField(fieldLabel = CARD_LABEL1, fieldDescription = REQUIRED_FIELD, tab = 5)
	@DialogFieldSet(namePrefix = TAB4 + CARD1, collapsible = true, collapsed = true)
	private final TabProperties tab4card1;
	@DialogField(fieldLabel = CARD_LABEL2, fieldDescription = REQUIRED_FIELD, tab = 5)
	@DialogFieldSet(namePrefix = TAB4 + CARD2, collapsible = true, collapsed = true)
	private final TabProperties tab4card2;
	@DialogField(fieldLabel = CARD_LABEL3, fieldDescription = REQUIRED_FIELD, tab = 5)
	@DialogFieldSet(namePrefix = TAB4 + CARD3, collapsible = true, collapsed = true)
	private final TabProperties tab4card3;

	@DialogField(tab = 6)
	@DialogFieldSet(border = false, namePrefix = TAB5)
	private final Category tab5;
	@DialogField(fieldLabel = CARD_LABEL1, fieldDescription = REQUIRED_FIELD, tab = 6)
	@DialogFieldSet(namePrefix = TAB5 + CARD1, collapsible = true, collapsed = true)
	private final TabProperties tab5card1;
	@DialogField(fieldLabel = CARD_LABEL2, fieldDescription = REQUIRED_FIELD, tab = 6)
	@DialogFieldSet(namePrefix = TAB5 + CARD2, collapsible = true, collapsed = true)
	private final TabProperties tab5card2;
	@DialogField(fieldLabel = CARD_LABEL3, fieldDescription = REQUIRED_FIELD, tab = 6)
	@DialogFieldSet(namePrefix = TAB5 + CARD3, collapsible = true, collapsed = true)
	private final TabProperties tab5card3;

	private final List<Category> tabs;

	public Explore(SlingHttpServletRequest request) {

		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		if (properties != null) {
			title = properties.get("title", StringUtils.EMPTY);
			description = properties.get("description", StringUtils.EMPTY);
		}

		tabs = new ArrayList<Category>();
		tab1 = initTab(1, request);
		tab1card1 = initCard(1, 1, request);
		tab1card2 = initCard(1, 2, request);
		tab1card3 = initCard(1, 3, request);
		tab1.setCards(tab1card1, tab1card2, tab1card3);
		if (tab1.isValid()) {
			tabs.add(tab1);
		}

		tab2 = initTab(2, request);
		tab2card1 = initCard(2, 1, request);
		tab2card2 = initCard(2, 2, request);
		tab2card3 = initCard(2, 3, request);
		tab2.setCards(tab2card1, tab2card2, tab2card3);
		if (tab2.isValid()) {
			tabs.add(tab2);
		}

		tab3 = initTab(3, request);
		tab3card1 = initCard(3, 1, request);
		tab3card2 = initCard(3, 2, request);
		tab3card3 = initCard(3, 3, request);
		tab3.setCards(tab3card1, tab3card2, tab3card3);
		if (tab3.isValid()) {
			tabs.add(tab3);
		}

		tab4 = initTab(4, request);
		tab4card1 = initCard(4, 1, request);
		tab4card2 = initCard(4, 2, request);
		tab4card3 = initCard(4, 3, request);
		tab4.setCards(tab4card1, tab4card2, tab4card3);
		if (tab4.isValid()) {
			tabs.add(tab4);
		}

		tab5 = initTab(5, request);
		tab5card1 = initCard(5, 1, request);
		tab5card2 = initCard(5, 2, request);
		tab5card3 = initCard(5, 3, request);
		tab5.setCards(tab5card1, tab5card2, tab5card3);
		if (tab5.isValid()) {
			tabs.add(tab5);
		}
	}

	private Category initTab(final int tabNum, SlingHttpServletRequest request) {
		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		Category returnCat = new Category();
		if (properties != null) {
			String pathPrefix = String.format(TABx, tabNum);
			returnCat.setIconImagePath(properties.get(pathPrefix + "iconImagePath", ""));
			returnCat.setSelectedImagePath(properties.get(pathPrefix + "selectedImagePath", ""));
			returnCat.setTitle(properties.get(pathPrefix + "title", ""));
		}
		return returnCat;
	}

	private TabProperties initCard(final int tabNum, final int cardNum, SlingHttpServletRequest request) {
		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		TabProperties returnProp = new TabProperties();
		if (properties != null) {
			String pathPrefix = String.format(TABx + CARDx, tabNum, cardNum);
			returnProp.setAltTextBack(properties.get(pathPrefix + "altTextBack", ""));
			returnProp.setTextBack(properties.get(pathPrefix + "textBack", ""));
			returnProp.setImageBack(properties.get(pathPrefix + "imageBack", ""));
			returnProp.setPage(properties.get(pathPrefix + "pagePath", ""), request.getResource());
		}
		return returnProp;
	}

	public List<Category> getTabs() {
		return new ArrayList<Category>(tabs);
	}

	public Category getTab(int index) {
		return tabs.get(index);
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}
}