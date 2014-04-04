package com.australia.www.components.content.buttons;

import java.util.ArrayList;
import java.util.List;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceUtil;
import org.apache.sling.api.resource.ValueMap;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Tab;
import com.citytechinc.cq.component.annotations.widgets.DialogFieldSet;

@Component(value = "Buttons", group = ".hidden",
tabs = {@Tab(title = "Button 1" ), @Tab(title = "Button 2" ), @Tab(title = "Button 3" ), @Tab(title = "Button 4" )}, 
dialogWidth = 700)
public class Buttons {
	
	@DialogFieldSet(border = false, namePrefix = "tab1/")
	@DialogField(tab = 1)
	private ButtonField tab1;
	
	@DialogFieldSet(border = false, namePrefix = "tab2/")
	@DialogField(tab = 2)
	private ButtonField tab2;
	
	@DialogFieldSet(border = false, namePrefix = "tab3/")
	@DialogField(tab = 3)
	private ButtonField tab3;
	
	@DialogFieldSet(border = false, namePrefix = "tab4/")
	@DialogField(tab = 4)
	private ButtonField tab4;
	
	public List<ButtonField> buttonsList;
	
	public Buttons(SlingHttpServletRequest request) {
		Resource thisResource = request.getResource();
        if (ResourceUtil.isNonExistingResource(thisResource)
                || ResourceUtil.isSyntheticResource(thisResource)) {
            return;
        }
        
        buttonsList = new ArrayList<ButtonField>();
        
        ValueMap properties = request.getResource().adaptTo(ValueMap.class);
        tab1 = new ButtonField();
        tab1.setTitle(properties.get("tab1/title", ""));
        tab1.setText(properties.get("tab1/text", ""));
        buttonsList.add(tab1);
        
        tab2 = new ButtonField();
        tab2.setTitle(properties.get("tab2/title", ""));
        tab2.setText(properties.get("tab2/text", ""));
        buttonsList.add(tab2);
        
        tab3 = new ButtonField();
        tab3.setTitle(properties.get("tab3/title", ""));
        tab3.setText(properties.get("tab3/text", ""));
        buttonsList.add(tab3);
        
        tab4 = new ButtonField();
        tab4.setTitle(properties.get("tab4/title", ""));
        tab4.setText(properties.get("tab4/text", ""));
        buttonsList.add(tab4);
        
	}
	
	public List<ButtonField> getButtonsList() {
		return buttonsList;
	}

}
