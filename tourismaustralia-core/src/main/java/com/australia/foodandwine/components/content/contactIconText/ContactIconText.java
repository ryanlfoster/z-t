package com.australia.foodandwine.components.content.contactIconText;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;

import com.australia.widgets.multicomposite.MultiCompositeField;
import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Listener;

@Component(group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", value = "Contact Icon with Text", dialogHeight = 500, dialogWidth = 700, listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class ContactIconText {

	@DialogField(fieldLabel = "Title", required = true)
	private final String title;

	@DialogField(fieldLabel = "Description")
	private final String description;

	@DialogField(fieldLabel = "Icon Item")
	@MultiCompositeField
	private final List<IconTitleText> ittList;

	@DialogField(fieldLabel = "Small Print")
	private final String smallPrint;

	public ContactIconText(SlingHttpServletRequest request) {
		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		title = properties.get("title", StringUtils.EMPTY);
		description = properties.get("description", StringUtils.EMPTY);
		smallPrint = properties.get("smallPrint", StringUtils.EMPTY);
		ittList = new ArrayList<IconTitleText>();
		Resource childResource = request.getResource().getChild("ittList");
		if (childResource != null) {
			for (Resource r : childResource.getChildren()) {
				ValueMap props = r.adaptTo(ValueMap.class);
				if (props != null) {
					String iconTitle = props.get("iconTitle", StringUtils.EMPTY);
					String iconImage = props.get("iconImage", StringUtils.EMPTY);
					String iconText = props.get("iconText", StringUtils.EMPTY);
					IconTitleText iconTitleText = new IconTitleText();
					iconTitleText.setIconImage(iconImage);
					iconTitleText.setIconTitle(iconTitle);
					iconTitleText.setIconText(iconText);
					ittList.add(iconTitleText);
				}
			}
		}
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public List<IconTitleText> getIttList() {
		return ittList;
	}

	public String getSmallPrint() {
		return smallPrint;
	}

}
