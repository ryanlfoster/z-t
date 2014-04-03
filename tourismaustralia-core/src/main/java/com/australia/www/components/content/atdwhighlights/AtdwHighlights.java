package com.australia.www.components.content.atdwhighlights;

import com.australia.atdw.domain.ATDWCategory;
import com.australia.atdw.domain.ATDWProduct;
import com.australia.atdw.domain.ATDWProductSearchParameters;
import com.australia.atdw.domain.ATDWProductSearchParametersBuilder;
import com.australia.atdw.service.ATDWProductService;
import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Option;
import com.citytechinc.cq.component.annotations.Tab;
import com.citytechinc.cq.component.annotations.widgets.Selection;
import com.day.cq.tagging.Tag;
import com.day.cq.tagging.TagManager;
import com.day.cq.wcm.foundation.forms.MergedValueMap;
import org.apache.felix.scr.annotations.Reference;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.scripting.SlingBindings;
import org.apache.sling.api.scripting.SlingScriptHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gsnyder on 4/1/14.
 */
@Component(value="ATDW Highlights", tabs={@Tab(title=Constants.TAB_GENERAL), @Tab(title=Constants.TAB_CATEGORIES)})
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
        return firstStateTag; // No city tag found -- return the first state tag (which may be null)
    }

    @Reference
    private ATDWProductService productService;

    private final String path;

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

    private final ATDWProductSearchParametersBuilder baseBuilder;

    private ValueMap properties;

    public AtdwHighlights(SlingHttpServletRequest request) {

        if(productService == null) {
            SlingBindings bindings = (SlingBindings) request.getAttribute(SlingBindings.class.getName());
            SlingScriptHelper slingScriptHelper = bindings.getSling();
            productService = slingScriptHelper.getService(ATDWProductService.class);
        }

        path = request.getResource().getPath();

        properties = request.getResource().adaptTo(ValueMap.class);

        // properties will be null when creating a new node in author, use a blank map for initial display
        properties = properties == null ? new MergedValueMap(new ArrayList<Resource>()) : properties;

        title = properties.get(Constants.NAME_TITLE, "");
        text = properties.get(Constants.NAME_TEXT, "");
        type = properties.get(Constants.NAME_TYPE, "");
        typeArgument = properties.get(Constants.NAME_TYPE_ARGUMENT, "");

        showAccommodation = properties.get(Constants.NAME_SHOW_ACCOMMODATIONS, false);
        showAttraction = properties.get(Constants.NAME_SHOW_ATTRACTIONS, false);
        showRestaurants = properties.get(Constants.NAME_SHOW_RESTAURANTS, false);
        showTours = properties.get(Constants.NAME_SHOW_TOURS, false);
        showHire = properties.get(Constants.NAME_SHOW_HIRE, false);
        showEvents = properties.get(Constants.NAME_SHOW_EVENTS, false);
        showTransport = properties.get(Constants.NAME_SHOW_TRANSPORT, false);

        // Initialize the base search parameters builder to be used for category searches
        baseBuilder = new ATDWProductSearchParametersBuilder();
        if(Constants.TYPE_TAG.equals(type)) {
            Resource resource = request.getResource();
            TagManager tagManager = resource.getResourceResolver().adaptTo(TagManager.class);
            Tag selectedTag = selectPageTagForSearch(tagManager, resource);
            if(selectedTag != null) {
                baseBuilder.setTags(Arrays.asList(selectedTag.getTagID()));
            }
        } else if(Constants.TYPE_STATE.equals(type)) {
            baseBuilder.setTags(Arrays.asList(Constants.PLACE_TAG_PREFIX + typeArgument));
        } else if(Constants.TYPE_CITY.equals(type)) {
            baseBuilder.setText(typeArgument);
        } else if(Constants.TYPE_TERM.equals(type)) {
            baseBuilder.setText(typeArgument);
        }
    }

    public String getPath() {
        return path;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String getType() {
        return type;
    }

    public String getTypeArgument() {
        return typeArgument;
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

    private List<ATDWProduct> getProducts(ATDWCategory category) {
        ATDWProductSearchParameters params = baseBuilder.setCategory(category).build();
        return productService.search(params);
    }

    public class Category {

        private final ATDWCategory category;

        public Category(ATDWCategory category) {
            this.category = category;
        }

        public String getId() {
            return category.name();
        }

        public String getDisplay() {
            return category.toString();
        }

        public String getStandardIconPath() {
            return Constants.getStandardIconPath(category);
        }

        public String getActiveIconPath() {
            return Constants.getActiveIconPath(category);
        }

        public List<ATDWProduct> getProducts() {
            ATDWProductSearchParameters params = baseBuilder.setCategory(category).build();
            return productService.search(params);
        }

    }

}
