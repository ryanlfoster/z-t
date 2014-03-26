package com.australia.foodandwine.components.content.category;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;

import com.australia.widgets.multicomposite.MultiCompositeField;
import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Listener;

@Component(group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", value = "Category", dialogWidth=700, listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class Category {
	@DialogField(tab = 1, fieldLabel = "Images")
	@MultiCompositeField
	private final List<Item> items;

	public Category(SlingHttpServletRequest request) {
		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		String myPath = request.getResource().getPath();
		String itemPath = myPath + "/items";
		Resource itemsResource = request.getResourceResolver().resolve(itemPath);
		List<Item> myItems=null;
		if ( itemsResource != null ) { 
			Iterable<Resource> children = itemsResource.getChildren(); 
			myItems=Collections.synchronizedList(new ArrayList<Item>());
			Iterator<Resource> myIter = children.iterator();
			while (myIter.hasNext()) { 
				Resource child = myIter.next();
				ValueMap vm = child.adaptTo(ValueMap.class);
				myItems.add(new Item(vm));
			}
		}
		items = myItems; 
	}
	public List<Item> getItems() {
		return items;
	}

}


