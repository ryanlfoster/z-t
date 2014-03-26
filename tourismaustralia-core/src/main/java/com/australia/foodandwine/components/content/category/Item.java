package com.australia.foodandwine.components.content.category;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.ValueMap;

import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.widgets.PathField;

public class Item {	
	@DialogField(fieldLabel = "Image Path", required = true)
	@PathField(rootPath = "/content/dam")
	private final String imagePath;

	@DialogField(fieldLabel = "Caption text", required = true)
	private final String caption;
	
	private final static String IMAGE_PATH = "imagePath";

	public Item(ValueMap properties) { 
		caption = properties.get("caption", StringUtils.EMPTY);
		imagePath = properties.get(IMAGE_PATH, StringUtils.EMPTY);		
	}
	
	public String getCaption() {
		return caption;
	}
	public String getImagePath() {
		return imagePath;
	}



}


