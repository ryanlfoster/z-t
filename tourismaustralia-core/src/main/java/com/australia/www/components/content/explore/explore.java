package com.australia.www.components.content.explore;


import com.australia.widgets.multicomposite.MultiCompositeField;
import com.australia.www.components.domain.Link;
import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.FieldProperty;

import com.citytechinc.cq.component.annotations.widgets.MultiField;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;

import java.util.ArrayList;
import java.util.List;

@Component(value = "Explore" , disableTargeting = true)
public class Explore {


	@DialogField(fieldLabel = "Categories")
	@MultiField()
	private final List<Tab> tabs;

	public Explore(SlingHttpServletRequest request) {
		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		tabs = new ArrayList<Tab>();

		Iterable<Resource> resources = request.getResource().getChild("tabs").getChildren();
		for (Resource res : resources) {
			ValueMap linkProps = res.adaptTo(ValueMap.class);
			String iconPath = linkProps.get("tabIconImagePath", "");
			String selectionPath = linkProps.get("tabSelectedImagePath", "");
			String title = linkProps.get("tabTitle", "");
			Tab tabItem = new Tab();
			tabItem.setIconImagePath(iconPath);
			tabItem.setSelectedImagePath(selectionPath);
			tabItem.setTitle(title);
			tabs.add(tabItem);

		}
	}
}