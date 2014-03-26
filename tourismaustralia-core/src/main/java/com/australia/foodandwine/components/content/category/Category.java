package com.australia.foodandwine.components.content.category;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Listener;
import com.citytechinc.cq.component.annotations.widgets.PathField;

@Component(group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", value = "Category", dialogWidth=700, listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class Category {
	
	private final List<Item> items;

	@DialogField(fieldLabel = "Image1", required = true)
	@PathField(rootPath = "/content/dam")
	private final String imagePath1;
	

	@DialogField(fieldLabel = "Caption 1", required = true)
	private final String caption1;

	@DialogField(fieldLabel = "Image2")
	@PathField(rootPath = "/content/dam")
	private final String imagePath2;
	

	@DialogField(fieldLabel = "Caption 2")
	private final String caption2;

	@DialogField(fieldLabel = "Image3")
	@PathField(rootPath = "/content/dam")
	private final String imagePath3;
	

	@DialogField(fieldLabel = "Caption 3")
	private final String caption3;

	@DialogField(fieldLabel = "Image4")
	@PathField(rootPath = "/content/dam")
	private final String imagePath4;
	

	@DialogField(fieldLabel = "Caption 4")
	private final String caption4;
	
	@DialogField(fieldLabel = "Image5")
	@PathField(rootPath = "/content/dam")
	private final String imagePath5;
	

	@DialogField(fieldLabel = "Caption 5")
	private final String caption5;

	
	private final ValueMap valueMap;
	public Category(SlingHttpServletRequest request) {
		String myPath = request.getResource().getPath();
		Resource itemResource = request.getResourceResolver().resolve(myPath);
		valueMap = itemResource.adaptTo(ValueMap.class);
		
		imagePath1 = valueMap.get("imagePath1", StringUtils.EMPTY);
		caption1 = valueMap.get("caption1", StringUtils.EMPTY);

		imagePath2 = valueMap.get("imagePath2", StringUtils.EMPTY);
		caption2 = valueMap.get("caption2", StringUtils.EMPTY);

		imagePath3 = valueMap.get("imagePath3", StringUtils.EMPTY);
		caption3 = valueMap.get("caption3", StringUtils.EMPTY);

		imagePath4 = valueMap.get("imagePath4", StringUtils.EMPTY);
		caption4 = valueMap.get("caption4", StringUtils.EMPTY);

		imagePath5 = valueMap.get("imagePath5", StringUtils.EMPTY);
		caption5 = valueMap.get("caption5", StringUtils.EMPTY);


		items=Collections.synchronizedList(new ArrayList<Item>());
		add(imagePath1,caption1,items);
		add(imagePath2,caption2,items);
		add(imagePath3,caption3,items);
		add(imagePath4,caption4,items);
		add(imagePath5,caption5,items);
		
	}
	private void add(String imagePath, String caption, List<Item> myItems) {
		if (!imagePath.equals(StringUtils.EMPTY)) { 
			myItems.add(new Item(imagePath,caption));
		}
		
	}
	public List<Item> getItems() {
		return items;
	}

}


