package com.australia.www.components.content.explore;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Tab;
import com.citytechinc.cq.component.annotations.widgets.DialogFieldSet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;

import java.util.ArrayList;
import java.util.List;

@Component(value = "Explore" , disableTargeting = true,
		tabs = { @Tab(title = "Tab 1"),
				@Tab(title = "Tab 2"),
				@Tab(title = "Tab 3")//,
				// @Tab(title = "Tab 4"),
				// @Tab(title = "Tab 5")
		})
public class Explore {



	@DialogField(tab = 1) @DialogFieldSet(border = false, namePrefix = "tab1/")
	private final Category tab1;

	@DialogField(fieldLabel = "Property 1", tab = 1) @DialogFieldSet(namePrefix = "./tab1/Props1-")
	private final TabProperties tab1Props1;
	@DialogField(fieldLabel = "Property 2", tab = 1) @DialogFieldSet(namePrefix = "./tab1/Props2-")
	private final TabProperties tab1Props2;
	@DialogField(fieldLabel = "Property 3", tab = 1) @DialogFieldSet(namePrefix = "./tab1/Props3-")
	private final TabProperties tab1Props3;

	@DialogField(tab = 2) @DialogFieldSet(border = false, namePrefix = "tab2/")
	private final Category tab2;

	@DialogField(fieldLabel = "Property 1", tab = 2) @DialogFieldSet(namePrefix = "./tab2/Props1-")
	private final TabProperties tab2Props1;
	@DialogField(fieldLabel = "Property 2", tab = 2) @DialogFieldSet(namePrefix = "./tab2/Props2-")
	private final TabProperties tab2Props2;
	@DialogField(fieldLabel = "Property 3", tab = 2) @DialogFieldSet(namePrefix = "./tab2/Props3-")
	private final TabProperties tab2Props3;

	@DialogField(tab = 3) @DialogFieldSet(border = false, namePrefix = "tab3/")
	private final Category tab3;

	@DialogField(fieldLabel = "Property 1", tab = 3) @DialogFieldSet(namePrefix = "./tab3Props1/")
	private final TabProperties tab3Props1;
	@DialogField(fieldLabel = "Property 2", tab = 3) @DialogFieldSet(namePrefix = "./tab3Props2/")
	private final TabProperties tab3Props2;
	@DialogField(fieldLabel = "Property 3", tab = 3) @DialogFieldSet(namePrefix = "./tab3Props3/")
	private final TabProperties tab3Props3;

	private final List<Category> tabs;

	public Explore(SlingHttpServletRequest request) {
		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		tabs = new ArrayList<Category>();

		//TODO : Do the boilerplate stuff for all them tabs
		tab1 = new Category();
		tab1.setIconImagePath(properties.get("tab1/iconImagePath", ""));
		tab1.setSelectedImagePath(properties.get("tab1/selectedImagePath", ""));
		tab1.setTitle(properties.get("tab1/title", ""));
		tabs.add(tab1);
		tab1Props1 = new TabProperties();
		tab1Props1.setBlank(properties.get("tab1/Props1-blank", ""));
		tab1Props2 = new TabProperties();
		tab1Props2.setBlank(properties.get("tab1/Props2-blank", ""));
		tab1Props3 = new TabProperties();
		tab1Props3.setBlank(properties.get("tab1/Props3-blank", ""));


		tab2 = new Category();
		tab2.setIconImagePath(properties.get("tab2/iconImagePath", ""));
		tab2.setSelectedImagePath(properties.get("tab2/selectedImagePath", ""));
		tab2.setTitle(properties.get("tab2/title", ""));
		tabs.add(tab2);
		tab2Props1 = new TabProperties();
		tab2Props1.setBlank(properties.get("tab2/Props1-blank", ""));
		tab2Props2 = new TabProperties();
		tab2Props2.setBlank(properties.get("tab2/Props2-blank", ""));
		tab2Props3 = new TabProperties();
		tab2Props3.setBlank(properties.get("tab2/Props3-blank", ""));


		tab3 = new Category();
		tab3.setIconImagePath(properties.get("tab3/iconImagePath", ""));
		tab3.setSelectedImagePath(properties.get("tab3/selectedImagePath", ""));
		tab3.setTitle(properties.get("tab3/title", ""));
		tabs.add(tab3);
		tab3Props1 = new TabProperties();
		tab3Props1.setBlank(properties.get("tab3Props1/blank", ""));
		tab3Props2 = new TabProperties();
		tab3Props2.setBlank(properties.get("tab3Props2/blank", ""));
		tab3Props3 = new TabProperties();
		tab3Props3.setBlank(properties.get("tab3Props3/blank", ""));
	}
}