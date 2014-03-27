package com.australia.foodandwine.components.content.other;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;

import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.widgets.PathField;

public class Article {
	@DialogField(fieldLabel = "Image Path", required = true, name = "./imagePath")
	@PathField(rootPath = "/content/dam")
	private final String imagePath;

	
	@DialogField(fieldLabel = "Large Text", required = true)
	private final String largeText;

	@DialogField(fieldLabel = "Small Text", required = true)
	private final String smallText;
	

	@DialogField(fieldLabel = "Tags", required = true)
	private final String tags;

	private final static String IMAGE_PATH = "imagePath";
	
	public Article(Resource resource) {
		ValueMap properties = resource.adaptTo(ValueMap.class);
		largeText = properties.get("largeText", StringUtils.EMPTY);
		smallText = properties.get("smallText", StringUtils.EMPTY);
		imagePath = properties.get(IMAGE_PATH, StringUtils.EMPTY);		
		tags = properties.get("tags", StringUtils.EMPTY);
		
	}

	public String getImagePath() {
		return imagePath;
	}


	public String getLargeText() {
		return largeText;
	}


	public String getSmallText() {
		return smallText;
	}


	public String getTags() {
		return tags;
	}
	
}
