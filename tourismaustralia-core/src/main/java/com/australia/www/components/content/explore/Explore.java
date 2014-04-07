package com.australia.www.components.content.explore;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Tab;
import com.citytechinc.cq.component.annotations.widgets.DialogFieldSet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceUtil;
import org.apache.sling.api.resource.ValueMap;
import java.util.ArrayList;
import java.util.List;

@Component(value = "Explore" , disableTargeting = true,
		tabs = {@Tab(title = "Tab 1"),@Tab(title = "Tab 2"),@Tab(title = "Tab 3"),@Tab(title = "Tab 4"),@Tab(title = "Tab 5")})

public class Explore {

	@DialogField(tab = 1) @DialogFieldSet(border = false, namePrefix = "tab1/")
	private final Category tab1;
	@DialogField(fieldLabel = "Card 1", tab = 1) @DialogFieldSet(namePrefix = "./tab1/card1-", collapsible = true, collapseFirst = true)
	private final TabProperties tab1card1;
	@DialogField(fieldLabel = "Card 2", tab = 1) @DialogFieldSet(namePrefix = "./tab1/card1-", collapsible = true, collapseFirst = true)
	private final TabProperties tab1card2;
	@DialogField(fieldLabel = "Card 3", tab = 1) @DialogFieldSet(namePrefix = "./tab1/card1-", collapsible = true, collapseFirst = true)
	private final TabProperties tab1card3;

	@DialogField(tab = 2) @DialogFieldSet(border = false, namePrefix = "tab2/")
	private final Category tab2;
	@DialogField(fieldLabel = "Card 1", tab = 2) @DialogFieldSet(namePrefix = "./tab2/card1-", collapsible = true, collapseFirst = true)
	private final TabProperties tab2card1;
	@DialogField(fieldLabel = "Card 2", tab = 2) @DialogFieldSet(namePrefix = "./tab2/card2-", collapsible = true, collapseFirst = true)
	private final TabProperties tab2card2;
	@DialogField(fieldLabel = "Card 3", tab = 2) @DialogFieldSet(namePrefix = "./tab2/card3-", collapsible = true, collapseFirst = true)
	private final TabProperties tab2card3;

	@DialogField(tab = 3) @DialogFieldSet(border = false, namePrefix = "tab3/")
	private final Category tab3;
	@DialogField(fieldLabel = "Card 1", tab = 3) @DialogFieldSet(namePrefix = "./tab3/card1-", collapsible = true, collapseFirst = true)
	private final TabProperties tab3card1;
	@DialogField(fieldLabel = "Card 2", tab = 3) @DialogFieldSet(namePrefix = "./tab3/card2-", collapsible = true, collapseFirst = true)
	private final TabProperties tab3card2;
	@DialogField(fieldLabel = "Card 3", tab = 3) @DialogFieldSet(namePrefix = "./tab3/card3-", collapsible = true, collapseFirst = true)
	private final TabProperties tab3card3;

	@DialogField(tab = 4) @DialogFieldSet(border = false, namePrefix = "tab3/")
	private final Category tab4;
	@DialogField(fieldLabel = "Card 1", tab = 3) @DialogFieldSet(namePrefix = "./tab4/card1-", collapsible = true, collapseFirst = true)
	private final TabProperties tab4card1;
	@DialogField(fieldLabel = "Card 2", tab = 3) @DialogFieldSet(namePrefix = "./tab4/card2-", collapsible = true, collapseFirst = true)
	private final TabProperties tab4card2;
	@DialogField(fieldLabel = "Card 3", tab = 3) @DialogFieldSet(namePrefix = "./tab4/card3-", collapsible = true, collapseFirst = true)
	private final TabProperties tab4card3;

	@DialogField(tab = 5) @DialogFieldSet(border = false, namePrefix = "tab3/")
	private final Category tab5;
	@DialogField(fieldLabel = "Card 1", tab = 3) @DialogFieldSet(namePrefix = "./tab5/card1-", collapsible = true, collapseFirst = true)
	private final TabProperties tab5card1;
	@DialogField(fieldLabel = "Card 2", tab = 3) @DialogFieldSet(namePrefix = "./tab5/card2-", collapsible = true, collapseFirst = true)
	private final TabProperties tab5card2;
	@DialogField(fieldLabel = "Card 3", tab = 3) @DialogFieldSet(namePrefix = "./tab5/card3-", collapsible = true, collapseFirst = true)
	private final TabProperties tab5card3;

	private final List<Category> tabs;

	public Explore(SlingHttpServletRequest request) {
		tabs = new ArrayList<Category>();
		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		tab1 = initTab(1,properties);
		tab1card1 = initCard(1,1,properties);
		tab1card2 = initCard(1,2,properties);
		tab1card3 = initCard(1,3,properties);
		tab1.setCards(tab1card1,tab1card2,tab1card3);

		tab2 = initTab(2,properties);
		tab2card1 = initCard(2,1,properties);
		tab2card2 = initCard(2,2,properties);
		tab2card3 = initCard(2,3,properties);
		tab2.setCards(tab2card1,tab2card2,tab2card3);

		tab3 = initTab(3,properties);
		tab3card1 = initCard(3,1,properties);
		tab3card2 = initCard(3,2,properties);
		tab3card3 = initCard(3,3,properties);
		tab3.setCards(tab3card1,tab3card2,tab3card3);

		tab4 = initTab(4,properties);
		tab4card1 = initCard(4,1,properties);
		tab4card2 = initCard(4,2,properties);
		tab4card3 = initCard(4,3,properties);
		tab4.setCards(tab4card1,tab4card2,tab4card3);

		tab5 = initTab(5,properties);
		tab5card1 = initCard(5,1,properties);
		tab5card2 = initCard(5,2,properties);
		tab5card3 = initCard(5,3,properties);
		tab5.setCards(tab5card1,tab5card2,tab5card3);

		tabs.add(tab1);
		tabs.add(tab2);
		tabs.add(tab3);
		tabs.add(tab4);
		tabs.add(tab5);
	}

	private Category initTab(final int tabNum, final ValueMap properties) {
		Category returnCat = new Category();
		String pathPrefix = String.format("tab%d/", tabNum);
		returnCat.setIconImagePath(properties.get(pathPrefix+"iconImagePath", ""));
		returnCat.setSelectedImagePath(properties.get(pathPrefix + "selectedImagePath", ""));
		returnCat.setTitle(properties.get(pathPrefix + "title", ""));
		return returnCat;
	}

	private TabProperties initCard(final int tabNum, final int cardNum, final ValueMap properties){
		TabProperties returnProp = new TabProperties();
		String pathPrefix = String.format("tab%d/card%d-", tabNum, cardNum);
		returnProp.setBlank(properties.get(pathPrefix+"blank", ""));
		return returnProp;
	}

	public List<Category> getTabs(){
		return new ArrayList<Category>(tabs);
	}
}