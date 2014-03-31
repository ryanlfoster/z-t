package com.australia.foodandwine.components.content.linksList;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;

import com.australia.widgets.multicomposite.MultiCompositeField;
import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.FieldProperty;
import com.citytechinc.cq.component.annotations.Listener;

@Component(group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", value = "Links List", dialogHeight = 400, dialogWidth = 700, listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class LinksList {

	@DialogField(fieldLabel = "Links", additionalProperties = @FieldProperty(name = "anchor", value = "100%"), fieldDescription = "For external links please use prefix http:// or https:// (eg. http://www.google.com)")
	@MultiCompositeField
	private final List<AnchorLink> links;

	public LinksList(SlingHttpServletRequest request) {
		links = new ArrayList<AnchorLink>();
		Resource resource = request.getResource().getChild("links");
		if (resource != null) {
			for (Resource r : resource.getChildren()) {
				ValueMap properties = r.adaptTo(ValueMap.class);
				if (properties != null) {
					String displayText = properties.get("displayText", StringUtils.EMPTY);
					String url = properties.get("url", StringUtils.EMPTY);
					AnchorLink link = new AnchorLink();
					link.setDisplayText(displayText);
					link.setUrl(url);
					links.add(link);
				}
			}
		}
	}

	public List<AnchorLink> getLinks() {
		return links;
	}

}
