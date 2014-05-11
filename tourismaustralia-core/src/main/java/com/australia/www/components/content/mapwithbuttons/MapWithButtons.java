package com.australia.www.components.content.mapwithbuttons;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceUtil;
import org.apache.sling.api.resource.ValueMap;

import com.australia.www.components.content.mapwithparsys.MapWithParsys;
import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Tab;
import com.citytechinc.cq.component.annotations.widgets.DialogFieldSet;
import com.day.cq.wcm.foundation.Image;

@Component(value = "Image Map With Buttons", disableTargeting = true, dialogHeight = 500, tabs = {
	@Tab(title = "Image"), @Tab(title = "Extra Information"), @Tab(title = "Button 1"), @Tab(title = "Button 2"),
	@Tab(title = "Button 3"), @Tab(title = "Button 4") }, dialogWidth = 700)
public class MapWithButtons extends MapWithParsys {

	@DialogFieldSet(border = false, namePrefix = "tab1/")
	@DialogField(tab = 3)
	private ButtonField tab1;

	@DialogFieldSet(border = false, namePrefix = "tab2/")
	@DialogField(tab = 4)
	private ButtonField tab2;

	@DialogFieldSet(border = false, namePrefix = "tab3/")
	@DialogField(tab = 5)
	private ButtonField tab3;

	@DialogFieldSet(border = false, namePrefix = "tab4/")
	@DialogField(tab = 6)
	private ButtonField tab4;

	public List<ButtonField> buttonsList;

	public MapWithButtons(SlingHttpServletRequest request) {

		super(request);

		Resource thisResource = request.getResource();
		ResourceResolver resolver = request.getResourceResolver();
		if (ResourceUtil.isNonExistingResource(thisResource) || ResourceUtil.isSyntheticResource(thisResource)) {
			return;
		}

		buttonsList = new ArrayList<ButtonField>();

		ValueMap properties = request.getResource().adaptTo(ValueMap.class);

		for (int tabNum = 1; tabNum <= 4; tabNum++) {
			ButtonField tab = new ButtonField();
			Resource imageRes = resolver.getResource(thisResource, "tab" + tabNum + "/");
			if (imageRes != null) {
				Image imageObj = new Image(imageRes, "image");
				if (imageObj != null && imageObj.hasContent()) {
					tab.setImagePath(imageObj.getFileReference());
				}
			}
			tab.setTitle(properties.get("tab" + tabNum + "/title", StringUtils.EMPTY));
			tab.setText(properties.get("tab" + tabNum + "/text", StringUtils.EMPTY));
			buttonsList.add(tab);
		}

	}

	public List<ButtonField> getButtonsList() {
		return buttonsList;
	}

}
