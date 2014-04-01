package com.australia.foodandwine.components.content.category;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Listener;
import com.citytechinc.cq.component.annotations.widgets.PathField;

@Component(disableTargeting = true, group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", value = "Category", dialogWidth = 700, listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class Category {

	private final List<Item> items;

	@DialogField(fieldLabel = "Image1", required = true)
	@PathField(rootPath = "/content/dam")
	private final String imagePath1;

	@DialogField(fieldLabel = "Caption 1", required = true)
	private final String caption1;

	@DialogField(fieldLabel = "Alt Tag 1", required = true)
	private final String imageAltTag1;

	@DialogField(fieldLabel = "Image2")
	@PathField(rootPath = "/content/dam")
	private final String imagePath2;

	@DialogField(fieldLabel = "Caption 2")
	private final String caption2;

	@DialogField(fieldLabel = "Alt Tag 2")
	private final String imageAltTag2;

	@DialogField(fieldLabel = "Image3")
	@PathField(rootPath = "/content/dam")
	private final String imagePath3;

	@DialogField(fieldLabel = "Caption 3")
	private final String caption3;

	@DialogField(fieldLabel = "Alt Tag 3")
	private final String imageAltTag3;

	@DialogField(fieldLabel = "Image4")
	@PathField(rootPath = "/content/dam")
	private final String imagePath4;

	@DialogField(fieldLabel = "Caption 4")
	private final String caption4;

	@DialogField(fieldLabel = "Alt Tag 4")
	private final String imageAltTag4;

	@DialogField(fieldLabel = "Image5")
	@PathField(rootPath = "/content/dam")
	private final String imagePath5;

	@DialogField(fieldLabel = "Caption 5")
	private final String caption5;

	@DialogField(fieldLabel = "Alt Tag 5")
	private final String imageAltTag5;

	public Category(SlingHttpServletRequest request) {
		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		items = new ArrayList<Item>();
		if (properties != null) {
			imagePath1 = properties.get("imagePath1", StringUtils.EMPTY);
			caption1 = properties.get("caption1", StringUtils.EMPTY);
			imageAltTag1 = properties.get("imageAltTag1", StringUtils.EMPTY);

			imagePath2 = properties.get("imagePath2", StringUtils.EMPTY);
			caption2 = properties.get("caption2", StringUtils.EMPTY);
			imageAltTag2 = properties.get("imageAltTag2", StringUtils.EMPTY);

			imagePath3 = properties.get("imagePath3", StringUtils.EMPTY);
			caption3 = properties.get("caption3", StringUtils.EMPTY);
			imageAltTag3 = properties.get("imageAltTag3", StringUtils.EMPTY);

			imagePath4 = properties.get("imagePath4", StringUtils.EMPTY);
			caption4 = properties.get("caption4", StringUtils.EMPTY);
			imageAltTag4 = properties.get("imageAltTag4", StringUtils.EMPTY);

			imagePath5 = properties.get("imagePath5", StringUtils.EMPTY);
			caption5 = properties.get("caption5", StringUtils.EMPTY);
			imageAltTag5 = properties.get("imageAltTag5", StringUtils.EMPTY);

			add(imagePath1, caption1, imageAltTag1, items);
			add(imagePath2, caption2, imageAltTag2, items);
			add(imagePath3, caption3, imageAltTag3, items);
			add(imagePath4, caption4, imageAltTag4, items);
			add(imagePath5, caption5, imageAltTag5, items);

		} else {
			imagePath1 = StringUtils.EMPTY;
			caption1 = StringUtils.EMPTY;
			imageAltTag1 = StringUtils.EMPTY;

			imagePath2 = StringUtils.EMPTY;
			caption2 = StringUtils.EMPTY;
			imageAltTag2 = StringUtils.EMPTY;

			imagePath3 = StringUtils.EMPTY;
			caption3 = StringUtils.EMPTY;
			imageAltTag3 = StringUtils.EMPTY;

			imagePath4 = StringUtils.EMPTY;
			caption4 = StringUtils.EMPTY;
			imageAltTag4 = StringUtils.EMPTY;

			imagePath5 = StringUtils.EMPTY;
			caption5 = StringUtils.EMPTY;
			imageAltTag5 = StringUtils.EMPTY;
		}

	}

	private void add(String imagePath, String caption, String imageAltTag, List<Item> myItems) {
		if (StringUtils.isNotEmpty(imagePath)) {
			myItems.add(new Item(imagePath, caption, imageAltTag));
		}
	}

	public List<Item> getItems() {
		return items;
	}

}
