package com.australia.foodandwine.components.content.numberIconText;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;

import com.australia.widgets.multicomposite.MultiCompositeField;
import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Listener;

@Component(group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", value = "Number with Icon & Text", dialogWidth = 850, dialogHeight = 500, listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class NumberIconText {

	@DialogField(fieldLabel = "Item")
	@MultiCompositeField
	private final List<IconText> iconTextList;

	public NumberIconText(SlingHttpServletRequest request) {
		int counter = 0;
		iconTextList = new ArrayList<IconText>();
		Resource iconTextResource = request.getResource().getChild("iconTextList");
		if (iconTextResource != null) {
			for (Resource r : iconTextResource.getChildren()) {
				ValueMap properties = r.adaptTo(ValueMap.class);
				if (properties != null) {
					counter++;
					List<String> iconImages = Arrays.asList(properties.get("iconImages", new String[0]));
					String richText = properties.get("richText", StringUtils.EMPTY);
					IconText iconText = new IconText();
					iconText.setIconImages(iconImages);
					iconText.setRichText(richText);
					iconText.setNumber(counter);
					iconTextList.add(iconText);
				}
			}
		}
	}

	public List<IconText> getIconTextList() {
		return iconTextList;
	}

}
