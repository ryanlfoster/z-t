package com.australia.foodandwine.components.content.accolade;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;

import com.australia.widgets.multicomposite.MultiCompositeField;
import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Listener;

@Component(group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", value = "Accolade", listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class Accolade {

	@DialogField(fieldLabel = "Accolade")
	@MultiCompositeField
	private final List<AccoladeItem> accoladeList;

	public Accolade(SlingHttpServletRequest request) {
		accoladeList = new ArrayList<AccoladeItem>();
		Resource accoladeResource = request.getResource().getChild("accoladeList");
		if (accoladeResource != null) {
			for (Resource r : accoladeResource.getChildren()) {
				ValueMap linkProps = r.adaptTo(ValueMap.class);
				if (linkProps != null) {
					String year = linkProps.get("year", StringUtils.EMPTY);
					String title = linkProps.get("title", StringUtils.EMPTY);
					AccoladeItem accolade = new AccoladeItem();
					accolade.setYear(year);
					accolade.setTitle(title);
					accoladeList.add(accolade);
				}
			}
		}
	}

	public List<AccoladeItem> getAccoladeList() {
		return accoladeList;
	}

}
