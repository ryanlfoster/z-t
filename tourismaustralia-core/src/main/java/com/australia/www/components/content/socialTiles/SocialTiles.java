package com.australia.www.components.content.socialTiles;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;

import com.australia.utils.LinkUtils;
import com.australia.www.components.domain.Link;
import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.FieldProperty;
import com.citytechinc.cq.component.annotations.Listener;
import com.citytechinc.cq.component.annotations.Tab;
import com.citytechinc.cq.component.annotations.widgets.DialogFieldSet;
import com.day.cq.wcm.foundation.Image;

@Component(value = "Social Tiles", disableTargeting = true, dialogHeight = 800, tabs = { @Tab(title = "Description"),
	@Tab(title = "Tile 1"), @Tab(title = "Tile 2"), @Tab(title = "Tile 3"), @Tab(title = "Tile 4"),
	@Tab(title = "Tile 5"), @Tab(title = "Tile 6"), @Tab(title = "Tile 7"), @Tab(title = "Tile 8"),
	@Tab(title = "Tile 9") }, listeners = { @Listener(name = "afteredit", value = "REFRESH_PAGE"),
	@Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class SocialTiles {

	@DialogField(xtype = "static", additionalProperties = {
		@FieldProperty(name = "text", value = "This component will display 3 or 9 "
			+ "tiles depending on the amount filled out. Anything less than 9 " + "will default to 3." + "\n"),
		@FieldProperty(name = "bold", value = "true") })
	private String tab1;

	@DialogField(fieldLabel = "Title")
	private String title;

	@DialogField(fieldLabel = "Bottom Text")
	private String subTitle;

	@DialogFieldSet(namePrefix = "link/")
	@DialogField(fieldLabel = "link")
	private Link link;

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

	public TileField tile;
	public List<TileField> tilesList;

	public SocialTiles(SlingHttpServletRequest request) {
		Resource thisResource = request.getResource();
		ResourceResolver resolver = request.getResourceResolver();
		ValueMap properties = thisResource.adaptTo(ValueMap.class);
		tilesList = new ArrayList<TileField>();

		if (properties != null) {
			title = properties.get("title", StringUtils.EMPTY);
			subTitle = properties.get("subTitle", StringUtils.EMPTY);
			link = new Link(LinkUtils.getHrefFromPath(properties.get("link/" + Link.PROP_PATH, StringUtils.EMPTY)),
				properties.get("link/" + Link.PROP_TITLE, StringUtils.EMPTY));

			for (int tabNum = 2; tabNum <= 10; tabNum++) {
				tile = new TileField();

				Resource imageRes = resolver.getResource(thisResource, "tab" + tabNum + "/");
				if (imageRes != null) {
					Image imageObj = new Image(imageRes, "image");
					if (imageObj != null && imageObj.hasContent()) {
						tile.setImagePath(imageObj.getFileReference());
					}
				}
				if (imageRes != null) {
					Image imageObj = new Image(imageRes, "smallImage");
					if (imageObj != null && imageObj.hasContent()) {
						tile.setIconPath(imageObj.getFileReference());
					}
				}

				tile.setTitle(properties.get("tab" + tabNum + "/title", StringUtils.EMPTY));
				tile.setText(properties.get("tab" + tabNum + "/text", StringUtils.EMPTY));
				if (tile.getIsValid()) {
					tilesList.add(tile);
				}
			}
		}
	}

	public List<TileField> getTilesList() {
		return tilesList;
	}

	public String getTitle() {
		return title;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public Link getLink() {
		return link;
	}

	// Boolean used to switch from 3 tile or 9 tile format
	public boolean getHasNine() {
		return (tilesList.size() == 9);
	}

	// Boolean used to switch from blank or 3 tile format
	public boolean getHasThree() {
		return (tilesList.size() >= 3);
	}

	public boolean getHasSubTitle() {
		return StringUtils.isNotBlank(subTitle);
	}
}
