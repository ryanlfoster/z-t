package com.australia.www.components.content.mapimagewithicons;

import com.australia.widgets.multicomposite.MultiCompositeField;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.commons.lang.StringUtils;

import com.australia.www.link.MapIconTitleDescription;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.FieldProperty;
import com.citytechinc.cq.component.annotations.Listener;
import com.citytechinc.cq.component.annotations.Tab;
import com.citytechinc.cq.component.annotations.widgets.Html5SmartImage;
import com.citytechinc.cq.component.annotations.widgets.TextArea;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing bean for the Itinerary component
 */
@Component(value = "Map Image With Icons", dialogWidth = 700, tabs = { @Tab(title = Constants.TAB_GENERAL),
	@Tab(title = Constants.TAB_MAP_IMAGE), @Tab(title = Constants.TAB_BUTTONS) },
	listeners = { @Listener(name = "aftercopy", value = "REFRESH_PAGE"),
		@Listener(name = "afterdelete", value = "REFRESH_PAGE"), @Listener(name = "afteredit", value = "REFRESH_PAGE"),
		@Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public final class MapImageWithIcons {

	@DialogField(fieldLabel = "Title", tab = Constants.TAB_INDEX_GENERAL)
	private final String title;

	@DialogField(fieldLabel = "Text", tab = Constants.TAB_INDEX_GENERAL,
		additionalProperties = @FieldProperty(name = "grow", value = "true"))
	@TextArea
	private final String text;

	@DialogField(fieldLabel = "Map alt text", required = true, tab = Constants.TAB_INDEX_GENERAL)
	private final String mapAltText;

	@DialogField(fieldLabel = "Map Image", required = true, tab = Constants.TAB_INDEX_MAP_IMAGE)
	@Html5SmartImage(tab = false, name = Constants.NAME_MAP_IMAGE, height = Constants.IMAGE_WIDGET_HEIGHT)
	private final String mapImage;

	@DialogField(fieldLabel = "Information", fieldDescription = "Maximum of 5 items allowed. Only 5 items will be shown.", tab = Constants.TAB_INDEX_BUTTONS)
	@MultiCompositeField
	private List<MapIconTitleDescription> mapIconTitleDescriptionItems;

	public MapImageWithIcons(final SlingHttpServletRequest request) {

		final Resource resource = request.getResource();
		final ValueMap properties = resource.adaptTo(ValueMap.class);

		title = properties.get(Constants.NAME_TITLE, "");
		text = properties.get(Constants.NAME_TEXT, "");
		mapAltText = properties.get(Constants.NAME_MAP_ALT_TEXT, "");

		mapImage = properties.get(Constants.NAME_MAP_IMAGE + "/fileReference", "");

		mapIconTitleDescriptionItems = new ArrayList<MapIconTitleDescription>();
		buildMapIconTitleDescriptionItems(mapIconTitleDescriptionItems, resource, "mapIconTitleDescriptionItems");

	}

	public void buildMapIconTitleDescriptionItems(List links, Resource mapIconTitleDescriptionItemsResource,
		String linksColumn) {
		if (mapIconTitleDescriptionItemsResource.getChild(linksColumn) != null) {
			Iterable<Resource> resources = mapIconTitleDescriptionItemsResource.getChild(linksColumn).getChildren();
			for (Resource r : resources) {
				ValueMap linkProps = r.adaptTo(ValueMap.class);
				String title = linkProps.get("title", StringUtils.EMPTY);
				String description = linkProps.get("description", StringUtils.EMPTY);
				String icon = linkProps.get("icon", StringUtils.EMPTY);
				MapIconTitleDescription item = new MapIconTitleDescription();
				item.setTitle(title);
				item.setDescription(description);
				item.setIcon(icon);
				links.add(item);
			}
		}
	}

	public String getTitle() {
		return title;
	}

	public String getText() {
		return text;
	}

	public String getMapAltText() {
		return mapAltText;
	}

	public String getMapImage() {
		return mapImage;
	}

	public List<MapIconTitleDescription> getMapIconTitleDescriptionItems() {
		return mapIconTitleDescriptionItems;
	}

}
