package com.australia.foodandwine.components.content.search;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;

import com.australia.utils.LinkUtils;
import com.australia.widgets.multicomposite.MultiCompositeField;
import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Listener;

@Component(disableTargeting = true, group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", name = "search", value = "Search", listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class Search {
	@DialogField(fieldLabel="Head Line",name="./headLine")
	private String headLine;

	@DialogField
	@MultiCompositeField
	private List<SearchProperties> interestedSearchList;

	public Search(SlingHttpServletRequest request) throws UnsupportedEncodingException {
		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		interestedSearchList = new ArrayList<SearchProperties>();
		headLine = properties.get("headLine", StringUtils.EMPTY);
		try {
			Iterable<Resource> resources = request.getResource().getChild("interestedSearchList").getChildren();
			for (Resource resource : resources) {
				ValueMap carouselProps = resource.adaptTo(ValueMap.class);
				SearchProperties searchProperties = new SearchProperties();
				String searchPageTitle = carouselProps.get("searchPageTitle", StringUtils.EMPTY);
				String searchPagePath = LinkUtils.getHrefFromPath(carouselProps
					.get("searchPagePath", StringUtils.EMPTY));
				searchProperties.setSearchPageTitle(searchPageTitle);
				searchProperties.setSearchPagePath(searchPagePath);
				interestedSearchList.add(searchProperties);
			}
		} catch (Exception e) {
		}
	}

	public String getHeadLine() {
		return headLine;
	}

	public List<SearchProperties> getInterestedSearchList() {
		return interestedSearchList;
	}
}
