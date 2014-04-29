package com.australia.www.components.content.whatyoucansee;

import com.australia.content.domain.Content;
import com.australia.content.domain.ContentSearchParametersBuilder;
import com.australia.content.domain.ContentSearchResult;
import com.australia.content.domain.ContentType;
import com.australia.content.service.ContentSearchException;
import com.australia.content.service.ContentSearchService;
import com.australia.utils.PathUtils;
import com.australia.utils.TagUtils;
import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.FieldProperty;
import com.citytechinc.cq.component.annotations.Listener;
import com.citytechinc.cq.component.annotations.Option;
import com.citytechinc.cq.component.annotations.Tab;
import com.citytechinc.cq.component.annotations.widgets.Selection;
import com.citytechinc.cq.component.annotations.widgets.TagInputField;
import com.day.cq.tagging.Tag;
import com.day.cq.tagging.TagManager;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.scripting.SlingBindings;
import org.apache.sling.api.scripting.SlingScriptHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component(value = "What You Can See",
		tabs = {
			@Tab(title = Constants.TAB_GENERAL),
			@Tab(title = Constants.TAB_CATEGORIES),
			@Tab(title = Constants.TAB_TAB_3)
		},
		listeners = {
			@Listener(name = "afteredit", value = "REFRESH_PAGE"),
			@Listener(name = "afterinsert", value = "REFRESH_PAGE")
		}
)
public final class WhatYouCanSee {

	private static final int ROW_SIZE = 5;

	@DialogField(fieldLabel = "Tag", tab = 1)
	@TagInputField
	private final String tagId;
	private Tag tag;

	@DialogField(fieldLabel = "Title", tab = 1)
	private final String title;

	@DialogField(fieldLabel = "Text", tab = 1)
	private final String text;

	@DialogField(fieldLabel = "Things To Do", fieldDescription = "When checked, 'Things To Do' will be displayed",
		defaultValue = "true", tab = 2)
	@Selection(type = Selection.CHECKBOX, options = @Option(value = "true"))
	private boolean showThingsToDo;

	@Selection(options = {@Option(value = "5", text = "5 Items"), @Option(value = "10", text = "10 Items") },
		type = Selection.SELECT
	)
	@DialogField(fieldLabel = "Things To Do Tab Size", defaultValue = Constants.TAB_SIZE_10, tab = 2)
	private final String thingsToDoTabSize;

	@DialogField(fieldLabel = "Events", fieldDescription = "When checked, 'Events' will be displayed",
		defaultValue = "true", tab = 2)
	@Selection(type = Selection.CHECKBOX, options = @Option(value = "true"))
	private boolean showEvents;

	@Selection(options = {@Option(value = "5", text = "5 Items"), @Option(value = "10", text = "10 Items") },
		type = Selection.SELECT
	)
	@DialogField(fieldLabel = "Events Tab Size", defaultValue = Constants.TAB_SIZE_10, tab = 2)
	private final String eventsTabSize;

	@DialogField(fieldLabel = "Optional Tab", fieldDescription = "When checked, an authorable 3rd tab will be displayed",
		tab = 3, listeners = {
			@Listener(name = "selectionchanged", value = Constants.OPTIONAL_SHOW_LISTENER),
			@Listener(name = "afterlayout", value = Constants.OPTIONAL_SHOW_LISTENER)
		})
	@Selection(type = Selection.CHECKBOX, options = @Option(value = "true"))
	private final boolean showOptionalTab;

	@DialogField(fieldLabel = "Optional Tab Title", tab = 3)
	private final String optionalTabTitle;

	@Selection(options = {@Option(value = "5", text = "5 Items"), @Option(value = "10", text = "10 Items") },
		type = Selection.SELECT
	)
	@DialogField(fieldLabel = "Optional Tab Size", defaultValue = Constants.TAB_SIZE_10, tab = 3,
		listeners = {
			@Listener(name = "selectionchanged", value = Constants.SIZE_CHANGE_LISTENER),
			@Listener(name = "afterlayout", value = Constants.SIZE_CHANGE_LISTENER)
		}
	)
	private final String optionalTabSize;

	@DialogField(fieldLabel = "Optional Tab Paths", tab = 3, required = true, xtype = "searchfield",
		additionalProperties = {
			@FieldProperty(name = "url", value = PathUtils.OZCOM_ROOT_PATH + ".search.json"),
			@FieldProperty(name = "forceSelection", value = "{Boolean}true"),
			@FieldProperty(name = "triggerAction", value = "all"),
			@FieldProperty(name = "selectOnFocus", value = "{Boolean}true")
		},
		listeners = @Listener(name = "select", value = Constants.PATH_SELECT_LISTENER))
	private final String optionalTabPath0;

	@DialogField(fieldLabel = "&nbsp;", tab = 3, required = true, xtype = "searchfield",
		additionalProperties = {
			@FieldProperty(name = "url", value = PathUtils.OZCOM_ROOT_PATH + ".search.json"),
			@FieldProperty(name = "forceSelection", value = "{Boolean}true"),
			@FieldProperty(name = "triggerAction", value = "all"),
			@FieldProperty(name = "selectOnFocus", value = "{Boolean}true")
		},
		listeners = @Listener(name = "select", value = Constants.PATH_SELECT_LISTENER))
	private final String optionalTabPath1;

	@DialogField(fieldLabel = "&nbsp;", tab = 3, required = true, xtype = "searchfield",
		additionalProperties = {
			@FieldProperty(name = "url", value = PathUtils.OZCOM_ROOT_PATH + ".search.json"),
			@FieldProperty(name = "forceSelection", value = "{Boolean}true"),
			@FieldProperty(name = "triggerAction", value = "all"),
			@FieldProperty(name = "selectOnFocus", value = "{Boolean}true")
		},
		listeners = @Listener(name = "select", value = Constants.PATH_SELECT_LISTENER))
	private final String optionalTabPath2;

	@DialogField(fieldLabel = "&nbsp;", tab = 3, required = true, xtype = "searchfield",
		additionalProperties = {
			@FieldProperty(name = "url", value = PathUtils.OZCOM_ROOT_PATH + ".search.json"),
			@FieldProperty(name = "forceSelection", value = "{Boolean}true"),
			@FieldProperty(name = "triggerAction", value = "all"),
			@FieldProperty(name = "selectOnFocus", value = "{Boolean}true")
		},
		listeners = @Listener(name = "select", value = Constants.PATH_SELECT_LISTENER))
	private final String optionalTabPath3;

	@DialogField(fieldLabel = "&nbsp;", tab = 3, required = true, xtype = "searchfield",
		additionalProperties = {
			@FieldProperty(name = "url", value = PathUtils.OZCOM_ROOT_PATH + ".search.json"),
			@FieldProperty(name = "forceSelection", value = "{Boolean}true"),
			@FieldProperty(name = "triggerAction", value = "all"),
			@FieldProperty(name = "selectOnFocus", value = "{Boolean}true")
		},
		listeners = @Listener(name = "select", value = Constants.PATH_SELECT_LISTENER))
	private final String optionalTabPath4;

	@DialogField(fieldLabel = "&nbsp;", tab = 3, required = true, xtype = "searchfield",
		additionalProperties = {
			@FieldProperty(name = "url", value = PathUtils.OZCOM_ROOT_PATH + ".search.json"),
			@FieldProperty(name = "forceSelection", value = "{Boolean}true"),
			@FieldProperty(name = "triggerAction", value = "all"),
			@FieldProperty(name = "selectOnFocus", value = "{Boolean}true")
		},
		listeners = @Listener(name = "select", value = Constants.PATH_SELECT_LISTENER))
	private final String optionalTabPath5;

	@DialogField(fieldLabel = "&nbsp;", tab = 3, required = true, xtype = "searchfield",
		additionalProperties = {
			@FieldProperty(name = "url", value = PathUtils.OZCOM_ROOT_PATH + ".search.json"),
			@FieldProperty(name = "forceSelection", value = "{Boolean}true"),
			@FieldProperty(name = "triggerAction", value = "all"),
			@FieldProperty(name = "selectOnFocus", value = "{Boolean}true")
		},
		listeners = @Listener(name = "select", value = Constants.PATH_SELECT_LISTENER))
	private final String optionalTabPath6;

	@DialogField(fieldLabel = "&nbsp;", tab = 3, required = true, xtype = "searchfield",
		additionalProperties = {
			@FieldProperty(name = "url", value = PathUtils.OZCOM_ROOT_PATH + ".search.json"),
			@FieldProperty(name = "forceSelection", value = "{Boolean}true"),
			@FieldProperty(name = "triggerAction", value = "all"),
			@FieldProperty(name = "selectOnFocus", value = "{Boolean}true")
		},
		listeners = @Listener(name = "select", value = Constants.PATH_SELECT_LISTENER))
	private final String optionalTabPath7;

	@DialogField(fieldLabel = "&nbsp;", tab = 3, required = true, xtype = "searchfield",
		additionalProperties = {
			@FieldProperty(name = "url", value = PathUtils.OZCOM_ROOT_PATH + ".search.json"),
			@FieldProperty(name = "forceSelection", value = "{Boolean}true"),
			@FieldProperty(name = "triggerAction", value = "all"),
			@FieldProperty(name = "selectOnFocus", value = "{Boolean}true")
		},
		listeners = @Listener(name = "select", value = Constants.PATH_SELECT_LISTENER))
	private final String optionalTabPath8;

	@DialogField(fieldLabel = "&nbsp;", tab = 3, required = true, xtype = "searchfield",
		additionalProperties = {
			@FieldProperty(name = "url", value = PathUtils.OZCOM_ROOT_PATH + ".search.json"),
			@FieldProperty(name = "forceSelection", value = "{Boolean}true"),
			@FieldProperty(name = "triggerAction", value = "all"),
			@FieldProperty(name = "selectOnFocus", value = "{Boolean}true")
		},
		listeners = @Listener(name = "select", value = Constants.PATH_SELECT_LISTENER))
	private final String optionalTabPath9;



	private final List<Tab> tabs = new ArrayList<Tab>();

	public WhatYouCanSee(final SlingHttpServletRequest request) throws ContentSearchException {

		final SlingBindings bindings = (SlingBindings) request.getAttribute(SlingBindings.class.getName());
		final SlingScriptHelper slingScriptHelper = bindings.getSling();
		final ContentSearchService contentSearchService = slingScriptHelper.getService(ContentSearchService.class);

		final Resource resource = request.getResource();
		final ValueMap properties = resource.adaptTo(ValueMap.class);
		final ResourceResolver resourceResolver = resource.getResourceResolver();
		final TagManager tagManager = resourceResolver.adaptTo(TagManager.class);

		tagId = properties.get("tagId", String.class);
		tag = tagId == null ? null : tagManager.resolve(tagId);

		// When no tag is selected, attempt to find a city or state tag, in that order
		if(tag == null) {
			final PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
			final Page page = pageManager.getContainingPage(resource);
			final Resource contentResource = page.getContentResource();
			final ValueMap pageProperties = contentResource.adaptTo(ValueMap.class);
			final String[] tags = pageProperties.get("cq:tags", new String[0]);
			tag = TagUtils.getCityTag(tagManager, tags);
			if (tag == null) {
				tag = TagUtils.getStateTag(tagManager, tags);
			}
		}

		title = properties.get(Constants.NAME_TITLE, "");
		text = properties.get(Constants.NAME_TEXT, "");
		showThingsToDo = properties.get(Constants.NAME_SHOW_THINGS_TO_DO, false);
		thingsToDoTabSize = properties.get(Constants.NAME_THINGS_TO_DO_TAB_SIZE, Constants.TAB_SIZE_10);
		showEvents = properties.get(Constants.NAME_SHOW_EVENTS, false);
		eventsTabSize = properties.get(Constants.NAME_EVENTS_TAB_SIZE, Constants.TAB_SIZE_10);
		showOptionalTab = properties.get(Constants.NAME_SHOW_OPTIONAL_TAB, false);
		optionalTabTitle = properties.get(Constants.NAME_TAB_3_TITLE, Constants.BLANK);
		optionalTabSize = properties.get(Constants.NAME_OPTIONAL_TAB_SIZE, Constants.TAB_SIZE_5);

		if (!showThingsToDo && !showEvents && !showOptionalTab) {
			showThingsToDo = true;
			showEvents = true;
		}

		optionalTabPath0 = properties.get(Constants.NAME_OPTIONAL_TAB_PATH_0, String.class);
		final Resource optionalTabResource0 = resourceResolver.getResource(optionalTabPath0);
		optionalTabPath1 = properties.get(Constants.NAME_OPTIONAL_TAB_PATH_1, String.class);
		final Resource optionalTabResource1 = resourceResolver.getResource(optionalTabPath1);
		optionalTabPath2 = properties.get(Constants.NAME_OPTIONAL_TAB_PATH_2, String.class);
		final Resource optionalTabResource2 = resourceResolver.getResource(optionalTabPath2);
		optionalTabPath3 = properties.get(Constants.NAME_OPTIONAL_TAB_PATH_3, String.class);
		final Resource optionalTabResource3 = resourceResolver.getResource(optionalTabPath3);
		optionalTabPath4 = properties.get(Constants.NAME_OPTIONAL_TAB_PATH_4, String.class);
		final Resource optionalTabResource4 = resourceResolver.getResource(optionalTabPath4);
		optionalTabPath5 = properties.get(Constants.NAME_OPTIONAL_TAB_PATH_5, String.class);
		final Resource optionalTabResource5 = resourceResolver.getResource(optionalTabPath5);
		optionalTabPath6 = properties.get(Constants.NAME_OPTIONAL_TAB_PATH_6, String.class);
		final Resource optionalTabResource6 = resourceResolver.getResource(optionalTabPath6);
		optionalTabPath7 = properties.get(Constants.NAME_OPTIONAL_TAB_PATH_7, String.class);
		final Resource optionalTabResource7 = resourceResolver.getResource(optionalTabPath7);
		optionalTabPath8 = properties.get(Constants.NAME_OPTIONAL_TAB_PATH_8, String.class);
		final Resource optionalTabResource8 = resourceResolver.getResource(optionalTabPath8);
		optionalTabPath9 = properties.get(Constants.NAME_OPTIONAL_TAB_PATH_9, String.class);
		final Resource optionalTabResource9 = resourceResolver.getResource(optionalTabPath9);

		final ContentSearchParametersBuilder baseBuilder = new ContentSearchParametersBuilder();
		baseBuilder.setPage(1);
		baseBuilder.setLanguagePath(PathUtils.getLanguageResource(resource).getPath());
		if(tag != null) {
			baseBuilder.setTags(Arrays.asList(tag.getTagID()));
		}

		if (showThingsToDo) {

			baseBuilder.setContentType(ContentType.ARTICLE);
			baseBuilder.setCount(Constants.TAB_SIZE_5.equals(thingsToDoTabSize) ? 5 : 10);
			final ContentSearchResult content = contentSearchService.search(baseBuilder.build());

			final Tab thingsToDo =
				new Tab(Constants.TTD_TAB_TITLE, "ttd", Constants.TTD_TAB_VIEW_MORE, content.getContent(),
					Constants.TTD_IMAGE_PATH, Constants.TTD_OUTLINE_IMAGE_PATH);
			tabs.add(thingsToDo);
		}

		if (showEvents) {

			baseBuilder.setContentType(ContentType.EVENT);
			baseBuilder.setCount(Constants.TAB_SIZE_5.equals(eventsTabSize) ? 5 : 10);
			final ContentSearchResult content = contentSearchService.search(baseBuilder.build());

			final Tab events =
				new Tab(Constants.EVENTS_TAB_TITLE, "events", Constants.EVENTS_TAB_VIEW_MORE, content.getContent(),
					Constants.EVENTS_IMAGE_PATH, Constants.EVENTS_OUTLINE_IMAGE_PATH);
			tabs.add(events);
		}

		if (showOptionalTab) {
			final List<Content> content = new ArrayList<Content>();
			content.add(Content.fromResource(optionalTabResource0));
			content.add(Content.fromResource(optionalTabResource1));
			content.add(Content.fromResource(optionalTabResource2));
			content.add(Content.fromResource(optionalTabResource3));
			content.add(Content.fromResource(optionalTabResource4));
			if (Constants.TAB_SIZE_10.equals(optionalTabSize)) {
				content.add(Content.fromResource(optionalTabResource5));
				content.add(Content.fromResource(optionalTabResource6));
				content.add(Content.fromResource(optionalTabResource7));
				content.add(Content.fromResource(optionalTabResource8));
				content.add(Content.fromResource(optionalTabResource9));
			}
			final Tab optionalTab = new Tab(optionalTabTitle, "optional", null, content,
				Constants.OPTIONAL_IMAGE_PATH, Constants.OPTIONAL_OUTLINE_IMAGE_PATH);
			tabs.add(optionalTab);
		}

	}

	public String getTag() {
		return "";
	}

	public String getTitle() {
		return title;
	}

	public String getText() {
		return text;
	}

	public List<Tab> getTabs() {
		return tabs;
	}

	public boolean isShowTabs() {
		return tabs.size() > 1;
	}

	public static class Tab {

		private final String displayName;
		private final String id;
		private final String viewMoreText;
		private final String selectedImagePath;
		private final String unselectedImagePath;
		private final List<ContentRow> contentRows = new ArrayList<ContentRow>();

		public Tab(final String displayName, final String id, final String viewMoreText, final List<Content> content,
			String selectedImagePath, String unselectedImagePath) {
			this.displayName = displayName;
			this.id = id;
			this.viewMoreText = viewMoreText;
			this.selectedImagePath = selectedImagePath;
			this.unselectedImagePath = unselectedImagePath;
			while (!content.isEmpty()) {
				contentRows.add(ContentRow.removeFromContent(content));
			}
		}

		public final String getDisplayName() {
			return displayName;
		}

		public final String getId() {
			return id;
		}

		public final List<ContentRow> getContentRows() {
			return contentRows;
		}

		public final String getViewMoreText() {
			return viewMoreText;
		}

		public String getSelectedImagePath() {
			return selectedImagePath;
		}

		public String getUnselectedImagePath() {
			return unselectedImagePath;
		}
	}

	public static class ContentRow {

		private static final int REMAINDER_MAX = ROW_SIZE - 1;

		private final Content hero;
		private final List<Content> remainder;

		public ContentRow(final Content hero, final List<Content> remainder) {
			this.hero = hero;
			this.remainder = remainder;
		}

		public final Content getSingle() {
			return hero;
		}

		public final List<Content> getRemainder() {
			return remainder;
		}

		/**
		 * Creates a content row with a non-null hero and up to 4 remainder contents by pulling from
		 * the provided content list.  Used content objects will be removed.  If the provided list is
		 * empty, an exception will be thrown.
		 *
		 * @param content
		 * @return
		 */
		public static ContentRow removeFromContent(final List<Content> content) {
			if (content.isEmpty()) {
				throw new IllegalStateException();
			}
			final Content hero = content.remove(0);
			final int remainderSize = content.size() > REMAINDER_MAX ? REMAINDER_MAX : content.size();
			final List<Content> remainder = content.subList(0, remainderSize);
			final List<Content> remainderCopy = new ArrayList<Content>(remainder);
			remainder.clear();
			return new ContentRow(hero, remainderCopy);
		}

	}

}
