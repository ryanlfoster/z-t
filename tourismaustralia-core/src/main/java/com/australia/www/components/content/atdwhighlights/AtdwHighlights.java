package com.australia.www.components.content.atdwhighlights;

import com.australia.atdw.domain.ATDWCategory;
import com.australia.atdw.domain.ATDWProduct;
import com.australia.atdw.domain.ATDWProductSearchParameters;
import com.australia.atdw.domain.ATDWProductSearchParametersBuilder;
import com.australia.atdw.service.ATDWProductService;
import com.australia.utils.PathUtils;
import com.citytechinc.cq.component.annotations.*;
import com.citytechinc.cq.component.annotations.widgets.Selection;
import com.day.cq.tagging.Tag;
import com.day.cq.tagging.TagManager;
import com.day.cq.wcm.api.PageManager;
import com.day.cq.wcm.foundation.forms.MergedValueMap;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.scripting.SlingBindings;
import org.apache.sling.api.scripting.SlingScriptHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing-bean for the ATDW Highlights ("make your trip happen") component.
 *
 * Created by gsnyder on 4/1/14.
 */
@Component(value="ATDW Highlights", tabs={@Tab(title=Constants.TAB_GENERAL), @Tab(title=Constants.TAB_CATEGORIES)},
        listeners = @Listener(name="afteredit", value="REFRESH_PAGE"))
public class AtdwHighlights {

    private static Tag selectPageTagForSearch(TagManager tagManager, Resource resource) {
        Tag[] tags = tagManager.getTags(resource);
        Tag firstStateTag = null;
        for(Tag tag: tags) {
            String tagId = tag.getTagID();
            if(tagId.matches(Constants.CITY_TAG_REGEX)) {
                return tag;
            } else if(firstStateTag == null && tagId.matches(Constants.STATE_TAG_REGEX)) {
                firstStateTag = tag;
            }
        }
        return firstStateTag; // No city tag found -- return the first state tag (which may itself be null)
    }

    private final ATDWProductService productService;

    @DialogField(fieldLabel="Component Title", name="./"+Constants.NAME_TITLE, tab = 1)
    private final String title;

    @DialogField(fieldLabel="Component Text", name="./"+Constants.NAME_TEXT, tab = 1)
    private final String text;

    @DialogField(fieldLabel="Component Type", name="./"+Constants.NAME_TYPE, defaultValue = Constants.TYPE_CITY, tab = 1)
    @Selection(type=Selection.SELECT, options={
            @Option(value=Constants.TYPE_TAG, text=Constants.TYPE_TAG),
            @Option(value=Constants.TYPE_CITY, text=Constants.TYPE_CITY),
            @Option(value=Constants.TYPE_STATE, text=Constants.TYPE_STATE),
            @Option(value=Constants.TYPE_TERM, text=Constants.TYPE_TERM)})
    private final String type;

    @DialogField(fieldLabel="Component Type Argument", name="./"+Constants.NAME_TYPE_ARGUMENT, tab = 1)
    private final String typeArgument;

    @DialogField(fieldLabel="Accommodation", name="./"+Constants.NAME_SHOW_ACCOMMODATIONS,
            fieldDescription="When checked, 'Accommodation' will be displayed", defaultValue="true", tab = 2)
    @Selection(type=Selection.CHECKBOX, options=@Option(value="true"))
    private final boolean showAccommodation;

    @DialogField(fieldLabel="Attractions", name="./"+Constants.NAME_SHOW_ATTRACTIONS,
            fieldDescription="When checked, 'Attractions' will be displayed", defaultValue="true", tab = 2)
    @Selection(type=Selection.CHECKBOX, options=@Option(value="true"))
    private final boolean showAttraction;

    @DialogField(fieldLabel="Restaurants", name="./"+Constants.NAME_SHOW_RESTAURANTS,
            fieldDescription="When checked, 'Restaurants' will be displayed", defaultValue="true", tab = 2)
    @Selection(type=Selection.CHECKBOX, options=@Option(value="true"))
    private final boolean showRestaurants;

    @DialogField(fieldLabel="Tours", name="./"+Constants.NAME_SHOW_TOURS,
            fieldDescription="When checked, 'Tours' will be displayed", defaultValue="true", tab = 2)
    @Selection(type=Selection.CHECKBOX, options=@Option(value="true"))
    private final boolean showTours;

    @DialogField(fieldLabel="Hire", name="./"+Constants.NAME_SHOW_HIRE,
            fieldDescription="When checked, 'Hire' will be displayed", defaultValue="true", tab = 2)
    @Selection(type=Selection.CHECKBOX, options=@Option(value="true"))
    private final boolean showHire;

    @DialogField(fieldLabel="Events", name="./"+Constants.NAME_SHOW_EVENTS,
            fieldDescription="When checked, 'Events' will be displayed", defaultValue="true", tab = 2)
    @Selection(type=Selection.CHECKBOX, options=@Option(value="true"))
    private final boolean showEvents;

    @DialogField(fieldLabel="Transport", name="./"+Constants.NAME_SHOW_TRANSPORT,
            fieldDescription="When checked, 'Transport' will be displayed", defaultValue="true", tab = 2)
    @Selection(type=Selection.CHECKBOX, options=@Option(value="true"))
    private final boolean showTransport;

    /** Builder to be further configured with category information in order to populate each category tab */
    private final ATDWProductSearchParametersBuilder baseBuilder;

    /** The path segment corresponding to locale.  Will be passed to product service to obtain results in correct language */
    private final Resource localeResource;

    private ValueMap properties;

    private Tag selectedTag;

    public AtdwHighlights(SlingHttpServletRequest request) {

        SlingBindings bindings = (SlingBindings) request.getAttribute(SlingBindings.class.getName());
        SlingScriptHelper slingScriptHelper = bindings.getSling();
        productService = slingScriptHelper.getService(ATDWProductService.class);

        Resource resource = request.getResource();
        properties = resource.adaptTo(ValueMap.class);

        // properties will be null when creating a new node in author, use a blank map for initial display
        properties = properties == null ? new MergedValueMap(new ArrayList<Resource>()) : properties;

        title = properties.get(Constants.NAME_TITLE, "");
        text = properties.get(Constants.NAME_TEXT, "");
        type = properties.get(Constants.NAME_TYPE, "");
        typeArgument = properties.get(Constants.NAME_TYPE_ARGUMENT, "");

        localeResource = PathUtils.getLanguageResource(resource);

        showAccommodation = properties.get(Constants.NAME_SHOW_ACCOMMODATIONS, false);
        showAttraction = properties.get(Constants.NAME_SHOW_ATTRACTIONS, false);
        showRestaurants = properties.get(Constants.NAME_SHOW_RESTAURANTS, false);
        showTours = properties.get(Constants.NAME_SHOW_TOURS, false);
        showHire = properties.get(Constants.NAME_SHOW_HIRE, false);
        showEvents = properties.get(Constants.NAME_SHOW_EVENTS, false);
        showTransport = properties.get(Constants.NAME_SHOW_TRANSPORT, false);

        PageManager pageManager = resource.getResourceResolver().adaptTo(PageManager.class);
        Resource pageResource = pageManager.getContainingPage(resource).getContentResource();
        baseBuilder = getBaseBuilder(type, typeArgument, pageResource);
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

    public String getSelectedTagId() {
        return selectedTag == null ? "NONE" : selectedTag.getTagID();
    }

    public List<Category> getActiveCategories() {
        List<Category> activeCategories = new ArrayList<Category>();
        for(ATDWCategory category: Constants.CATEGORY_ORDERING) {
            String showCategoryName = Constants.getShowPropertyName(category);
            if(properties.get(showCategoryName, false)) {
                activeCategories.add(new Category(category));
            }
        }
        return activeCategories;
    }

    private ATDWProductSearchParametersBuilder getBaseBuilder(String type, String typeArgument, Resource resource) {
        // Initialize the base search parameters builder to be used for category searches
        ATDWProductSearchParametersBuilder baseBuilder = new ATDWProductSearchParametersBuilder();
        if(Constants.TYPE_TAG.equals(type)) {
            TagManager tagManager = resource.getResourceResolver().adaptTo(TagManager.class);
            Tag selectedTag = selectPageTagForSearch(tagManager, resource);
            this.selectedTag = selectedTag;  // Save the selected tag to display to author
            if(selectedTag != null) {
                // remove segments beyond 'ta:places/{state}/{city}"
                while(selectedTag.getTagID().split("/").length > 3) {
                    selectedTag = selectedTag.getParent();
                }
                // get the city title if present and switch pointer to the state tag parent
                if(selectedTag.getTagID().split("/").length == 3) {
                    baseBuilder.setCity(selectedTag.getTitle());
                    selectedTag = selectedTag.getParent();
                }
                // get the state title if present
                if(selectedTag.getTagID().split("/").length == 2) {
                    baseBuilder.setState(selectedTag.getTitle());
                }
            }
        } else if(Constants.TYPE_STATE.equals(type)) {
            baseBuilder.setState(typeArgument);
        } else if(Constants.TYPE_CITY.equals(type)) {
            baseBuilder.setCity(typeArgument);
        } else if(Constants.TYPE_TERM.equals(type)) {
            baseBuilder.setText(typeArgument);
        }
        return baseBuilder;
    }

    public class Category {

        private final ATDWCategory category;
        private final List<ATDWProduct> products;

        public Category(ATDWCategory category) {
            this.category = category;

            ATDWProductSearchParameters params = baseBuilder.setCategory(category).build();
            List<ATDWProduct> out = productService.search(params);
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
            return PathUtils.getAllAtdwProductsForCategoryPath(localeResource, category.toString());
        }

        public List<ATDWProduct> getProducts() {
            return products;
        }

    }

}
