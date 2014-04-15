package com.australia.www.components.content.whatyoucansee;

import com.australia.utils.TagUtils;
import com.citytechinc.cq.component.annotations.*;
import com.citytechinc.cq.component.annotations.widgets.Selection;
import com.citytechinc.cq.component.annotations.widgets.TagInputField;
import com.day.cq.tagging.Tag;
import com.day.cq.tagging.TagManager;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gsnyder on 4/15/14.
 */
@Component(value = "ATDW Highlights", tabs = { @Tab(title = Constants.TAB_GENERAL),
	@Tab(title = Constants.TAB_CATEGORIES) }, listeners = { @Listener(name = "afteredit", value = "REFRESH_PAGE"),
	@Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public final class WhatYouCanSee {

	@DialogField(fieldLabel = "Tag")
	@TagInputField(namespaces = @TagNameSpace("ta"))
	private Tag tag;

	@DialogField(fieldLabel = "Title")
	private final String title;

	@DialogField(fieldLabel = "Text")
	private final String text;

	@DialogField(fieldLabel = "Things To Do", fieldDescription = "When checked, 'Things To Do' will be displayed",
		defaultValue = "true", tab = 2)
	@Selection(type = Selection.CHECKBOX, options = @Option(value = "true"))
	private final boolean showThingsToDo;

	@DialogField(fieldLabel = "Events", fieldDescription = "When checked, 'Events' will be displayed",
		defaultValue = "true", tab = 2)
	@Selection(type = Selection.CHECKBOX, options = @Option(value = "true"))
	private final boolean showEvents;

	@DialogField(fieldLabel = "Tab 3", fieldDescription = "When checked, an authorable 3rd tab will be displayed",
		defaultValue = "true", tab = 2)
	@Selection(type = Selection.CHECKBOX, options = @Option(value = "true"))
	private final boolean showTab3;

	@DialogField(fieldLabel = "Tab 3 Title", tab = 3)
	private final String tab3Title;

	@DialogField(fieldLabel = "Tab 3 Size", defaultValue = Constants.TAB_3_SIZE_5, tab = 3)
	@Selection(options = {
			@Option(text = "5 Links", value = Constants.TAB_3_SIZE_5),
			@Option(text = "10 Links", value = Constants.TAB_3_SIZE_10)
		}
	)
	private final String tab3Size;

	@DialogField(fieldLabel = "Tab 3 Paths", tab = 3)

	private final List<String> tab3Paths;

	public WhatYouCanSee(SlingHttpServletRequest request) {

		final Resource resource = request.getResource();
		final ValueMap properties = resource.adaptTo(ValueMap.class);
		final ResourceResolver resourceResolver = resource.getResourceResolver();
		final TagManager tagManager = resourceResolver.adaptTo(TagManager.class);

		final String tagId = properties.get(Constants.NAME_TAG, String.class);
		tag = tagId == null ? null : tagManager.resolve(tagId);

		// When no tag is selected, attempt to find a city or state tag, in that order
		if(tag == null) {
			final Resource pageResource = resource.getParent();
			final ValueMap pageProperties = pageResource.adaptTo(ValueMap.class);
			final String[] tags = pageProperties.get("cq:tags", String[].class);
			tag = TagUtils.getCityTag(tagManager, tags);
			if (tag == null) {
				tag = TagUtils.getStateTag(tagManager, tags);
			}
		}

		title = properties.get(Constants.NAME_TITLE, "");
		text = properties.get(Constants.NAME_TEXT, "");
		showThingsToDo = properties.get(Constants.NAME_SHOW_THINGS_TO_DO, false);
		showEvents = properties.get(Constants.NAME_SHOW_EVENTS, false);
		showTab3 = properties.get(Constants.NAME_SHOW_TAB_3, false);
		tab3Title = properties.get(Constants.NAME_TAB_3_TITLE, "");
		tab3Paths = properties.get(Constants.NAME_TAB_3_PATHS, new ArrayList<String>());
		tab3Size = properties.get(Constants.NAME_TAB_3_SIZE, Constants.TAB_3_SIZE_5);

	}

	public Tag getTag() {
		return tag;
	}

	public String getTitle() {
		return title;
	}

	public String getText() {
		return text;
	}

	public boolean isShowThingsToDo() {
		return showThingsToDo;
	}

	public boolean isShowEvents() {
		return showEvents;
	}

	public boolean isShowTab3() {
		return showTab3;
	}

	public String getTab3Title() {
		return tab3Title;
	}
}
