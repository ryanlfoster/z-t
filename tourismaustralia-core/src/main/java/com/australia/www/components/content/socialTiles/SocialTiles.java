package com.australia.www.components.content.socialTiles;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.FieldProperty;
import com.citytechinc.cq.component.annotations.Listener;
import com.citytechinc.cq.component.annotations.Tab;
import com.citytechinc.cq.component.annotations.widgets.DialogFieldSet;

@Component(value = "Social Tiles", tabs = { @Tab(title = "Description"),
		@Tab(title = "Tile 1"), @Tab(title = "Tile 2"), @Tab(title = "Tile 3"),
		@Tab(title = "Tile 4"), @Tab(title = "Tile 5"), @Tab(title = "Tile 6"),
		@Tab(title = "Tile 7"), @Tab(title = "Tile 8"), @Tab(title = "Tile 9"),
		@Tab(title = "Tile 10"), @Tab(title = "Tile 11") }, listeners = {
		@Listener(name = "afteredit", value = "REFRESH_PAGE"),
		@Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class SocialTiles {

	@DialogField(xtype = "static", additionalProperties = {
			@FieldProperty(name = "text", value = "This component will display 3 or 11 "
					+ "tiles depending on the amount filled out. Anything less than 11 "
					+ "will default to 3."),
			@FieldProperty(name = "bold", value = "true") })
	@SuppressWarnings("unused")
	private String tab1;

	@DialogFieldSet(border = false, namePrefix = "tab2/")
	@DialogField(tab = 2)
	private TileField tab2;

	@DialogFieldSet(border = false, namePrefix = "tab3/")
	@DialogField(tab = 3)
	private TileField tab3;

	@DialogFieldSet(border = false, namePrefix = "tab4/")
	@DialogField(tab = 4)
	private TileField tab4;

	@DialogFieldSet(border = false, namePrefix = "tab5/")
	@DialogField(tab = 5)
	private TileField tab5;

	@DialogFieldSet(border = false, namePrefix = "tab6/")
	@DialogField(tab = 6)
	private TileField tab6;

	@DialogFieldSet(border = false, namePrefix = "tab7/")
	@DialogField(tab = 7)
	private TileField tab7;

	@DialogFieldSet(border = false, namePrefix = "tab8/")
	@DialogField(tab = 8)
	private TileField tab8;

	@DialogFieldSet(border = false, namePrefix = "tab9/")
	@DialogField(tab = 9)
	private TileField tab9;

	@DialogFieldSet(border = false, namePrefix = "tab10/")
	@DialogField(tab = 10)
	private TileField tab10;

	@DialogFieldSet(border = false, namePrefix = "tab11/")
	@DialogField(tab = 11)
	private TileField tab11;

	@DialogFieldSet(border = false, namePrefix = "tab12/")
	@DialogField(tab = 12)
	private TileField tab12;

	public List<TileField> tilesList;

	public SocialTiles(SlingHttpServletRequest request) {
		Resource thisResource = request.getResource();
		ValueMap properties = thisResource.adaptTo(ValueMap.class);

		tilesList = new ArrayList<TileField>();

		tab2 = new TileField();
		tab2.setIconPath(properties.get("tab2/iconPath", StringUtils.EMPTY));
		tab2.setImagePath(properties.get("tab2/imagePath", StringUtils.EMPTY));
		tab2.setTitle(properties.get("tab2/title", StringUtils.EMPTY));
		tab2.setText(properties.get("tab2/text", StringUtils.EMPTY));
		tab2.setLink(properties.get("tab2/link", StringUtils.EMPTY));
		if (tab2.getIsValid())
			tilesList.add(tab2);

		tab3 = new TileField();
		tab3.setIconPath(properties.get("tab3/iconPath", StringUtils.EMPTY));
		tab3.setImagePath(properties.get("tab3/imagePath", StringUtils.EMPTY));
		tab3.setTitle(properties.get("tab3/title", StringUtils.EMPTY));
		tab3.setText(properties.get("tab3/text", StringUtils.EMPTY));
		tab3.setLink(properties.get("tab3/link", StringUtils.EMPTY));
		if (tab3.getIsValid())
			tilesList.add(tab3);

		tab4 = new TileField();
		tab4.setIconPath(properties.get("tab4/iconPath", StringUtils.EMPTY));
		tab4.setImagePath(properties.get("tab4/imagePath", StringUtils.EMPTY));
		tab4.setTitle(properties.get("tab4/title", StringUtils.EMPTY));
		tab4.setText(properties.get("tab4/text", StringUtils.EMPTY));
		tab4.setLink(properties.get("tab4/link", StringUtils.EMPTY));
		if (tab4.getIsValid())
			tilesList.add(tab4);

		tab5 = new TileField();
		tab5.setIconPath(properties.get("tab5/iconPath", StringUtils.EMPTY));
		tab5.setImagePath(properties.get("tab5/imagePath", StringUtils.EMPTY));
		tab5.setTitle(properties.get("tab5/title", StringUtils.EMPTY));
		tab5.setText(properties.get("tab5/text", StringUtils.EMPTY));
		tab5.setLink(properties.get("tab5/link", StringUtils.EMPTY));
		if (tab5.getIsValid())
			tilesList.add(tab5);

		tab6 = new TileField();
		tab6.setIconPath(properties.get("tab6/iconPath", StringUtils.EMPTY));
		tab6.setImagePath(properties.get("tab6/imagePath", StringUtils.EMPTY));
		tab6.setTitle(properties.get("tab6/title", StringUtils.EMPTY));
		tab6.setText(properties.get("tab6/text", StringUtils.EMPTY));
		tab6.setLink(properties.get("tab6/link", StringUtils.EMPTY));
		if (tab6.getIsValid())
			tilesList.add(tab6);

		tab7 = new TileField();
		tab7.setIconPath(properties.get("tab7/iconPath", StringUtils.EMPTY));
		tab7.setImagePath(properties.get("tab7/imagePath", StringUtils.EMPTY));
		tab7.setTitle(properties.get("tab7/title", StringUtils.EMPTY));
		tab7.setText(properties.get("tab7/text", StringUtils.EMPTY));
		tab7.setLink(properties.get("tab7/link", StringUtils.EMPTY));
		if (tab7.getIsValid())
			tilesList.add(tab7);

		tab8 = new TileField();
		tab8.setIconPath(properties.get("tab8/iconPath", StringUtils.EMPTY));
		tab8.setImagePath(properties.get("tab8/imagePath", StringUtils.EMPTY));
		tab8.setTitle(properties.get("tab8/title", StringUtils.EMPTY));
		tab8.setText(properties.get("tab8/text", StringUtils.EMPTY));
		tab8.setLink(properties.get("tab8/link", StringUtils.EMPTY));
		if (tab8.getIsValid())
			tilesList.add(tab8);

		tab9 = new TileField();
		tab9.setIconPath(properties.get("tab9/iconPath", StringUtils.EMPTY));
		tab9.setImagePath(properties.get("tab9/imagePath", StringUtils.EMPTY));
		tab9.setTitle(properties.get("tab9/title", StringUtils.EMPTY));
		tab9.setText(properties.get("tab9/text", StringUtils.EMPTY));
		tab9.setLink(properties.get("tab9/link", StringUtils.EMPTY));
		if (tab9.getIsValid())
			tilesList.add(tab9);

		tab10 = new TileField();
		tab10.setIconPath(properties.get("tab10/iconPath", StringUtils.EMPTY));
		tab10.setImagePath(properties.get("tab10/imagePath", StringUtils.EMPTY));
		tab10.setTitle(properties.get("tab10/title", StringUtils.EMPTY));
		tab10.setText(properties.get("tab10/text", StringUtils.EMPTY));
		tab10.setLink(properties.get("tab10/link", StringUtils.EMPTY));
		if (tab10.getIsValid())
			tilesList.add(tab10);

		tab11 = new TileField();
		tab11.setIconPath(properties.get("tab11/iconPath", StringUtils.EMPTY));
		tab11.setImagePath(properties.get("tab11/imagePath", StringUtils.EMPTY));
		tab11.setTitle(properties.get("tab11/title", StringUtils.EMPTY));
		tab11.setText(properties.get("tab11/text", StringUtils.EMPTY));
		tab11.setLink(properties.get("tab11/link", StringUtils.EMPTY));
		if (tab11.getIsValid())
			tilesList.add(tab11);

		tab12 = new TileField();
		tab12.setIconPath(properties.get("tab12/iconPath", StringUtils.EMPTY));
		tab12.setImagePath(properties.get("tab12/imagePath", StringUtils.EMPTY));
		tab12.setTitle(properties.get("tab12/title", StringUtils.EMPTY));
		tab12.setText(properties.get("tab12/text", StringUtils.EMPTY));
		tab12.setLink(properties.get("tab12/link", StringUtils.EMPTY));
		if (tab12.getIsValid())
			tilesList.add(tab12);
	}

	public List<TileField> getTilesList() {
		return tilesList;
	}

	// Boolean used to switch from 3 tile or 11 tile format
	public boolean getHasEleven() {
		return (tilesList.size() == 11);
	}
}
