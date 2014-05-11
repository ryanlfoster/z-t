package com.australia.www.components.content.mapWithLinks;

import java.util.ArrayList;
import java.util.List;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceUtil;

import com.australia.utils.LinkUtils;
import com.australia.widgets.multicomposite.MultiCompositeField;
import com.australia.www.components.content.mapwithparsys.MapWithParsys;
import com.australia.www.components.domain.Link;
import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.FieldProperty;
import com.citytechinc.cq.component.annotations.Tab;

/**
 * Backing Bean for CQ Component responsible Created by Lance Dolan 4/02/14.
 */
@Component(value = "Image Map With Links", disableTargeting = true, tabs = { @Tab(title = "Image"),
	@Tab(title = "Extra Information"), @Tab(title = "Links") }, dialogWidth = 700)
public class MapWithLinks extends MapWithParsys {

	@DialogField(fieldLabel = "Links", tab = 3, fieldDescription = "List of Links", additionalProperties = @FieldProperty(name = "width", value = "200"))
	@MultiCompositeField
	private List<Link> linksList;
	private static final String PROP_LINKS_LIST = "linksList";

	public MapWithLinks(SlingHttpServletRequest request) {
		super(request);
		Resource thisResource = request.getResource();
		if (ResourceUtil.isNonExistingResource(thisResource) || ResourceUtil.isSyntheticResource(thisResource)) {
			return;
		}
		linksList = LinkUtils.populateLinksFromMultiComposite(new ArrayList<Link>(), thisResource, PROP_LINKS_LIST,
			Link.PROP_PATH, Link.PROP_TITLE);
	}

	public List<Link> getLinksList() {
		return linksList;
	}

}
