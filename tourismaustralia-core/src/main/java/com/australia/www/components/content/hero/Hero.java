package com.australia.www.components.content.hero;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Tab;
import com.citytechinc.cq.component.annotations.widgets.Html5SmartImage;
import com.day.cq.wcm.foundation.Image;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;


@Component(value = "Hero Banner", tabs = {@Tab(title = "General"),@Tab(title = "Image")})
public class Hero {

	@DialogField(fieldLabel = "Title", required = true, tab = 1)
	private String title;

	@DialogField(fieldLabel = "Sub Title", tab = 1)
	private String subTitle;

	@DialogField(fieldLabel = "Alt Text", required = true, tab = 1)
	private String altText;


	@Html5SmartImage(tab = false, height = 400, allowUpload = false, name = "image")
	@DialogField(fieldLabel = "Image", required = true, tab = 2)
	private String imageSelection;




	public Hero(SlingHttpServletRequest request){
		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		title = properties.get("title", "");
		subTitle = properties.get("subTitle","");
		altText = properties.get("altText", "");
		Image imageObj = new Image(request.getResource(), "image");
		if (imageObj != null && imageObj.hasContent()) {
			imageSelection = imageObj.getPath();
		}
	}

	public String getTitle(){
		return title;
	}

	public String getSubTitle(){
		return subTitle;
	}

	public String getImageSelection(){
		return imageSelection;
	}

	public String getAltText(){
		return altText;
	}
}