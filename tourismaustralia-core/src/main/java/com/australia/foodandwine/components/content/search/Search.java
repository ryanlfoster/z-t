package com.australia.foodandwine.components.content.search;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Listener;
import com.citytechinc.cq.component.annotations.widgets.MultiField;

@Component(disableTargeting = true, group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", name = "search", value = "Search", listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class Search {
	@DialogField(fieldLabel = "Head Line", name = "./headLine")
	private String headLine;

	@DialogField(fieldLabel = "Search Keywords" , name="./interestedSearchList")
	@MultiField
	private List<String> interestedSearchList;

	public Search(SlingHttpServletRequest request) throws UnsupportedEncodingException {
		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		interestedSearchList = new ArrayList<String>();
		headLine = properties.get("headLine", StringUtils.EMPTY);
		this.interestedSearchList = Arrays.asList(properties.get("interestedSearchList", new String[0]));
	}

	public String getHeadLine() {
		return headLine;
	}

	public List<String> getInterestedSearchList() {
		return interestedSearchList;
	}
}
