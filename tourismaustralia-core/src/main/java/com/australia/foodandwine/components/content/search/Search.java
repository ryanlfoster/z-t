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
import com.citytechinc.cq.component.annotations.widgets.RichTextEditor;
import com.citytechinc.cq.component.annotations.widgets.rte.Format;
import com.citytechinc.cq.component.annotations.widgets.rte.Justify;
import com.citytechinc.cq.component.annotations.widgets.rte.Lists;
import com.citytechinc.cq.component.annotations.widgets.rte.Style;
import com.citytechinc.cq.component.annotations.widgets.rte.Styles;

@Component(disableTargeting = true, group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", name = "search", value = "Search", listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class Search {
	@DialogField(fieldLabel = "Head Line", name = "./headLine")
	private String headLine;

	@DialogField(fieldLabel = "Search Keywords", name = "./interestedSearchList")
	@MultiField
	private List<String> interestedSearchList;

    @DialogField(fieldLabel = "No results message", name = "./noResultsMessage")
    @RichTextEditor(lists = @Lists(indent = false, ordered = false, outdent = false, unordered = false), justify = @Justify(justifycenter = false, justifyleft = false, justifyright = false), format = @Format(bold = true, underline = true, italic = false))
    private String noResultsMessage;

	public Search(SlingHttpServletRequest request) throws UnsupportedEncodingException {
		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		interestedSearchList = new ArrayList<String>();
		headLine = properties.get("headLine", StringUtils.EMPTY);
        noResultsMessage = properties.get("noResultsMessage", StringUtils.EMPTY);
		this.interestedSearchList = Arrays.asList(properties.get("interestedSearchList", new String[0]));
	}

	public String getHeadLine() {
		return headLine;
	}

    public String getNoResultsMessage() {
        return noResultsMessage;
    }

	public List<String> getInterestedSearchList() {
		return interestedSearchList;
	}
}
