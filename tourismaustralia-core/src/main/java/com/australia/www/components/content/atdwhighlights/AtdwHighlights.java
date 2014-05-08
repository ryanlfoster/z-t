package com.australia.www.components.content.atdwhighlights;

import java.util.ArrayList;
import java.util.List;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.scripting.SlingBindings;
import org.apache.sling.api.scripting.SlingScriptHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.australia.atdw.domain.ATDWCategory;
import com.australia.atdw.domain.ATDWProduct;
import com.australia.atdw.domain.ATDWProductSearchParameters;
import com.australia.atdw.domain.ATDWProductSearchParametersBuilder;
import com.australia.atdw.service.ATDWProductService;
import com.australia.utils.PathUtils;
import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.FieldProperty;
import com.citytechinc.cq.component.annotations.Listener;
import com.citytechinc.cq.component.annotations.Option;
import com.citytechinc.cq.component.annotations.Tab;
import com.citytechinc.cq.component.annotations.widgets.Selection;
import com.day.cq.tagging.Tag;
import com.day.cq.tagging.TagManager;
import com.day.cq.wcm.api.PageManager;
import com.day.cq.wcm.foundation.forms.MergedValueMap;

/**
 * Backing-bean for the ATDW Highlights ("make your trip happen") component.
 * 
 * Created by gsnyder on 4/1/14.
 */
@Component(value = "ATDW Highlights", tabs = { @Tab(title = Constants.TAB_GENERAL),
	@Tab(title = Constants.TAB_CATEGORIES) }, listeners = { @Listener(name = "afteredit", value = "REFRESH_PAGE"),
	@Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class AtdwHighlights {
	private static final Logger LOG = LoggerFactory.getLogger(AtdwHighlights.class);

	private static Tag selectPageTagForSearch(TagManager tagManager, Resource resource) {
		Tag[] tags = tagManager.getTags(resource);
		Tag firstStateTag = null;
		for (Tag tag : tags) {
			String tagId = tag.getTagID();
			if (tagId.matches(Constants.CITY_TAG_REGEX)) {
				return tag;
			} else if (firstStateTag == null && tagId.matches(Constants.STATE_TAG_REGEX)) {
				firstStateTag = tag;
			}
		}
		return firstStateTag; // No city tag found -- return the first state tag
								// (which may itself be null)
	}

	private final ATDWProductService productService;

	@DialogField(fieldLabel = "Component Title", tab = 1)
	private final String title;

	@DialogField(fieldLabel = "Component Text", tab = 1, xtype = "textarea", additionalProperties = { @FieldProperty(name = "grow", value = "true") })
	private final String text;

	@DialogField(fieldLabel = "Product Population  Strategy", tab = 1, xtype = "highlightstrategy", fieldDescription = "Choose to populate by City, State, Search Term, or Tag.  If tag is selected, the containing"
		+ " page should have a \"ta:places\" tag associated with it.", defaultValue = "Tag|")
	private final String strategy;
	private final String type;
	private final String typeArgument;

	@DialogField(fieldLabel = "Accommodation", fieldDescription = "When checked, 'Accommodation' will be displayed", defaultValue = "true", tab = 2)
	@Selection(type = Selection.CHECKBOX, options = @Option(value = "true"))
	private final boolean showAccommodations;

	@DialogField(fieldLabel = "Attractions", fieldDescription = "When checked, 'Attractions' will be displayed", defaultValue = "true", tab = 2)
	@Selection(type = Selection.CHECKBOX, options = @Option(value = "true"))
	private final boolean showAttractions;

	@DialogField(fieldLabel = "Restaurants", fieldDescription = "When checked, 'Restaurants' will be displayed", defaultValue = "true", tab = 2)
	@Selection(type = Selection.CHECKBOX, options = @Option(value = "true"))
	private final boolean showRestaurants;

	@DialogField(fieldLabel = "Tours", fieldDescription = "When checked, 'Tours' will be displayed", defaultValue = "true", tab = 2)
	@Selection(type = Selection.CHECKBOX, options = @Option(value = "true"))
	private final boolean showTours;

	@DialogField(fieldLabel = "Hire", fieldDescription = "When checked, 'Hire' will be displayed", defaultValue = "true", tab = 2)
	@Selection(type = Selection.CHECKBOX, options = @Option(value = "true"))
	private final boolean showHire;

	@DialogField(fieldLabel = "Events", fieldDescription = "When checked, 'Events' will be displayed", defaultValue = "true", tab = 2)
	@Selection(type = Selection.CHECKBOX, options = @Option(value = "true"))
	private final boolean showEvents;

	@DialogField(fieldLabel = "Transport", fieldDescription = "When checked, 'Transport' will be displayed", defaultValue = "true", tab = 2)
	@Selection(type = Selection.CHECKBOX, options = @Option(value = "true"))
	private final boolean showTransport;

	/**
	 * Builder to be further configured with category information in order to
	 * populate each category tab
	 */
	private final ATDWProductSearchParametersBuilder baseBuilder;

	/**
	 * The path segment corresponding to locale. Will be passed to product
	 * service to obtain results in correct language
	 */
	private final Resource localeResource;

	private ValueMap properties;

	private Tag selectedTag;
	private String city;
	private String state;
	private String term;

	public AtdwHighlights(SlingHttpServletRequest request) {
		LOG.info("inside AtdwHighlights constructor line 116 ");
		SlingBindings bindings = (SlingBindings) request.getAttribute(SlingBindings.class.getName());
		SlingScriptHelper slingScriptHelper = bindings.getSling();
		productService = slingScriptHelper.getService(ATDWProductService.class);

		Resource resource = request.getResource();
		properties = resource.adaptTo(ValueMap.class);

		// properties will be null when creating a new node in author, use a
		// blank map for initial display
		properties = properties == null ? new MergedValueMap(new ArrayList<Resource>()) : properties;

		title = properties.get(Constants.NAME_TITLE, "");
		text = properties.get(Constants.NAME_TEXT, "");
		strategy = properties.get(Constants.NAME_STRATEGY, "Tag|");
		String[] strategyComponents = strategy.split("\\|");
		type = strategyComponents.length > 0 ? strategyComponents[0] : "Tag";
		typeArgument = strategyComponents.length > 1 ? strategyComponents[1] : "";

		localeResource = PathUtils.getLanguageResource(resource);

		showAccommodations = properties.get(Constants.NAME_SHOW_ACCOMMODATIONS, false);
		showAttractions = properties.get(Constants.NAME_SHOW_ATTRACTIONS, false);
		showRestaurants = properties.get(Constants.NAME_SHOW_RESTAURANTS, false);
		showTours = properties.get(Constants.NAME_SHOW_TOURS, false);
		showHire = properties.get(Constants.NAME_SHOW_HIRE, false);
		showEvents = properties.get(Constants.NAME_SHOW_EVENTS, false);
		showTransport = properties.get(Constants.NAME_SHOW_TRANSPORT, false);

		PageManager pageManager = resource.getResourceResolver().adaptTo(PageManager.class);
		Resource pageResource = pageManager.getContainingPage(resource).getContentResource();
		LOG.info("inside AtdwHighlights constructor line 147 ");
		baseBuilder = getBaseBuilder(type, typeArgument, pageResource);
		LOG.info("inside AtdwHighlights constructor line 149 ");
	}

	public String getTitle() {
		return title;
	}

	public String getText() {
		return text;
	}

	public boolean isTagBased() {
		return Constants.TYPE_TAG.equals(type);
	}

	public String getType() {
		return type;
	}

	public String getTypeArgument() {
		return typeArgument;
	}

	public String getSelectedTagId() {
		return selectedTag == null ? "NONE (Add a ta:places tag to the page to allow for proper population of products)"
			: selectedTag.getTagID();
	}

	public List<Category> getActiveCategories() {
		boolean overrideHidden = false;
		// If all categories are hidden, turn them all on. Fixes an issue when
		// the component is first added to a page.
		if (!showAccommodations && !showAttractions && !showRestaurants && !showTours && !showHire && !showEvents
			&& !showTransport) {
			overrideHidden = true;
		}
		List<Category> activeCategories = new ArrayList<Category>();
		for (ATDWCategory category : Constants.CATEGORY_ORDERING) {
			String showCategoryName = Constants.getShowPropertyName(category);
			if (properties.get(showCategoryName, false) || overrideHidden) {
				activeCategories.add(new Category(category));
			}
		}
		return activeCategories;
	}

	private ATDWProductSearchParametersBuilder getBaseBuilder(String type, String typeArgument, Resource resource) {
		// Initialize the base search parameters builder to be used for category
		// searches
		ATDWProductSearchParametersBuilder baseBuilder = new ATDWProductSearchParametersBuilder();
		baseBuilder.setCount(9);
		if (Constants.TYPE_TAG.equals(type)) {
			TagManager tagManager = resource.getResourceResolver().adaptTo(TagManager.class);
			Tag selectedTag = selectPageTagForSearch(tagManager, resource);
			this.selectedTag = selectedTag; // Save the selected tag to display
											// to author
			if (selectedTag != null) {
				// remove segments beyond 'ta:places/{state}/{city}"
				while (selectedTag.getTagID().split("/").length > 3) {
					selectedTag = selectedTag.getParent();
				}
				// get the city title if present and switch pointer to the state
				// tag parent
				if (selectedTag.getTagID().split("/").length == 3) {
					city = selectedTag.getTitle();
					baseBuilder.setCity(city);
					selectedTag = selectedTag.getParent();
				}
				// get the state title if present
				if (selectedTag.getTagID().split("/").length == 2) {
					state = selectedTag.getTitle();
					baseBuilder.setState(state);
				}
			}
		} else if (Constants.TYPE_STATE.equals(type)) {
			baseBuilder.setState(typeArgument);
			state = typeArgument;
		} else if (Constants.TYPE_CITY.equals(type)) {
			baseBuilder.setCity(typeArgument);
			city = typeArgument;
		} else if (Constants.TYPE_TERM.equals(type)) {
			baseBuilder.setText(typeArgument);
			term = typeArgument;
		}
		return baseBuilder;
	}

	public class Category {

		private final ATDWCategory category;
		private final List<ATDWProduct> products;

		public Category(ATDWCategory category) {
			this.category = category;

			ATDWProductSearchParameters params = baseBuilder.setCategory(category).build();
			LOG.info("inside AtdwHighlights Category line 245 ");

			List<ATDWProduct> out = productService.search(params).getResults();
			LOG.info("inside AtdwHighlights Category line 248 ");

			products = out == null ? new ArrayList<ATDWProduct>() : out;
		}

		public String getId() {
			return category.name();
		}

		public String getDisplay() {
			return Constants.getDisplayString(category);
		}

		public String getStandardIconPath() {
			return Constants.getStandardIconPath(category);
		}

		public String getActiveIconPath() {
			return Constants.getActiveIconPath(category);
		}

		public String getAllProductsPath() {
			return PathUtils.getAtdwSearchPath(localeResource, category.toString(), state, null, city, term, 1);
		}

		public List<ATDWProduct> getProducts() {
			return products;
		}

	}

}
