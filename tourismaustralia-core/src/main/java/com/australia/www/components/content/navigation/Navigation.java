package com.australia.www.components.content.navigation;

import com.australia.utils.LinkUtils;
import com.australia.utils.PathUtils;
import com.australia.widgets.multicomposite.MultiCompositeField;
import com.australia.www.link.MosaicLink;
import com.australia.www.link.MosaicThemeLink;
import com.australia.www.link.TextLinkWithState;
import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Listener;
import com.citytechinc.cq.component.annotations.Tab;
import com.citytechinc.cq.component.annotations.widgets.PathField;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.resource.Resource;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wma on 28/04/2014.
 */
@Component(value = "Navigation", dialogWidth = 600, disableTargeting = true, group = ".hidden", tabs = { @Tab(title = "Arrival Bar"), @Tab(title = "Navigation Bar"), @Tab(title = "Megamenu 1"), @Tab(title = "Megamenu 2"), @Tab(title = "Megamenu 3") }, listeners = {
        @Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
        @Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class Navigation {

    @DialogField(fieldLabel = "Find Out More Link", fieldDescription = "For external links please use prefix http:// or https:// (eg. http://www.google.com)", required = false, tab = 1)
    @PathField(rootPath = "/content")
    private String findOutMoreLink;

    @DialogField(fieldLabel = "Arrival Bar Link 1 Text", required = false, tab = 1)
    private String arrivalBarLink1Text;

    @DialogField(fieldLabel = "Arrival Bar Link 1 Mobile Text", required = false, tab = 1)
    private String arrivalBarLink1MobileText;

    @DialogField(fieldLabel = "Arrival Bar Link 1", fieldDescription = "For external links please use prefix http:// or https:// (eg. http://www.google.com)", required = false, tab = 1)
    @PathField(rootPath = "/content")
    private String arrivalBarLink1;

    @DialogField(fieldLabel = "Arrival Bar Link 2 Text", required = false, tab = 1)
    private String arrivalBarLink2Text;

    @DialogField(fieldLabel = "Arrival Bar Link 2 Mobile Text", required = false, tab = 1)
    private String arrivalBarLink2MobileText;

    @DialogField(fieldLabel = "Arrival Bar Link 2", fieldDescription = "For external links please use prefix http:// or https:// (eg. http://www.google.com)", required = false, tab = 1)
    @PathField(rootPath = "/content")
    private String arrivalBarLink2;

    @DialogField(fieldLabel = "Search Page Path", fieldDescription = "Location of search page", required = true, tab = 2)
    @PathField(rootPath = "/content")
    private String searchPagePath;

    @DialogField(fieldLabel = "Search Placeholder Text", fieldDescription = "Placeholder text for search", required = true, tab = 2)
    private String searchPlaceholderText;

    @DialogField(fieldLabel = "Map Link", fieldDescription = "For external links please use prefix http:// or https:// (eg. http://www.google.com)", required = false, tab = 2)
    @PathField(rootPath = "/content")
    private String mapLink;

    @DialogField(fieldLabel = "My Trip Link", fieldDescription = "For external links please use prefix http:// or https:// (eg. http://www.google.com)", required = false, tab = 2)
    @PathField(rootPath = "/content")
    private String myTripLink;

    @DialogField(fieldLabel = "Megamenu 1 Title", fieldDescription = "Required to activate panel, if there's no title, the panel will not be hidden", required = false, tab = 2)
    private String megamenu1Title;

    @DialogField(fieldLabel = "Megamenu 2 Title", fieldDescription = "Required to activate panel, if there's no title, the panel will not be hidden", required = false, tab = 2)
    private String megamenu2Title;

    @DialogField(fieldLabel = "Megamenu 3 Title", fieldDescription = "Required to activate panel, if there's no title, the panel will not be hidden", required = false, tab = 2)
    private String megamenu3Title;

    @DialogField(fieldLabel = "LHS Category Title", required = false, tab = 3)
    private String megamenu1LhsCategoryTitle;

    @DialogField(fieldLabel = "LHS Mosaic Links", tab = 3)
    @MultiCompositeField
    private List<MosaicThemeLink> megamenu1LhsMosaicThemeLinks;

    @DialogField(fieldLabel = "RHS Category Title", required = false, tab = 3)
    private String megamenu1RhsCategoryTitle;

    @DialogField(fieldLabel = "RHS Mosaic Links",  fieldDescription = "For each row of LHS tiles, a row of RHS tiles will be displayed", tab = 3)
    @MultiCompositeField
    private List<MosaicLink> megamenu1RhsMosaicLinks;

    @DialogField(fieldLabel = "LHS Category Title 1", required = false, tab = 4)
    private String megamenu2LhsCategoryTitle1;

    @DialogField(fieldLabel = "LHS Category Title 1 Links",  tab = 4)
    @MultiCompositeField
    private List<TextLinkWithState> megamenu2LhsCategoryTitle1Links;

    @DialogField(fieldLabel = "LHS Category Title 2", required = false, tab = 4)
    private String megamenu2LhsCategoryTitle2;

    @DialogField(fieldLabel = "LHS Category Title 2 Links",  tab = 4)
    @MultiCompositeField
    private List<TextLinkWithState> megamenu2LhsCategoryTitle2Links;

    @DialogField(fieldLabel = "LHS Category Title 3", required = false, tab = 4)
    private String megamenu2LhsCategoryTitle3;

    @DialogField(fieldLabel = "LHS Category Title 3 Links",  tab = 4)
    @MultiCompositeField
    private List<TextLinkWithState> megamenu2LhsCategoryTitle3Links;

    @DialogField(fieldLabel = "LHS Category Title", required = false, tab = 5)
    private String megamenu3LhsCategoryTitle;

    @DialogField(fieldLabel = "LHS Mosaic Links", tab = 5)
    @MultiCompositeField
    private List<MosaicLink> megamenu3LhsMosaicLinks;

    @DialogField(fieldLabel = "RHS Category Title", required = false, tab = 5)
    private String megamenu3RhsCategoryTitle;

    @DialogField(fieldLabel = "RHS Mosaic Links",  fieldDescription = "For each row of LHS tiles, a row of RHS tiles will be displayed", tab = 5)
    @MultiCompositeField
    private List<MosaicLink> megamenu3RhsMosaicLinks;

    private String homepagePath;

    private boolean findOutMoreLinkIsExternal;
    private boolean arrivalBarLink1IsExternal;
    private boolean arrivalBarLink2IsExternal;
    private boolean mapLinkIsExternal;
    private boolean myTripLinkIsExternal;

    public Navigation(SlingHttpServletRequest request) {
        Page currentPage = request.getResourceResolver().adaptTo(PageManager.class).getContainingPage(request.getResource());
        String navigationPath = currentPage.getAbsoluteParent(2).getPath() + "/jcr:content/navigation";
        Resource navigationResource = request.getResourceResolver().getResource(navigationPath);

        if (navigationResource != null) {
            ValueMap properties = navigationResource.adaptTo(ValueMap.class);
            findOutMoreLink = LinkUtils.getHrefFromPath(properties.get("findOutMoreLink", StringUtils.EMPTY));
            findOutMoreLinkIsExternal = LinkUtils.isExternal(properties.get("findOutMoreLink", StringUtils.EMPTY));
            arrivalBarLink1Text = properties.get("arrivalBarLink1Text", StringUtils.EMPTY);
            arrivalBarLink1MobileText = properties.get("arrivalBarLink1MobileText", StringUtils.EMPTY);
            arrivalBarLink1 = LinkUtils.getHrefFromPath(properties.get("arrivalBarLink1", StringUtils.EMPTY));
            arrivalBarLink1IsExternal = LinkUtils.isExternal(properties.get("arrivalBarLink1", StringUtils.EMPTY));
            arrivalBarLink2Text = properties.get("arrivalBarLink2Text", StringUtils.EMPTY);
            arrivalBarLink2MobileText = properties.get("arrivalBarLink2MobileText", StringUtils.EMPTY);
            arrivalBarLink2 = LinkUtils.getHrefFromPath(properties.get("arrivalBarLink2", StringUtils.EMPTY));
            arrivalBarLink2IsExternal = LinkUtils.isExternal(properties.get("arrivalBarLink2", StringUtils.EMPTY));
            searchPagePath = LinkUtils.getHrefFromPath(properties.get("searchPagePath", StringUtils.EMPTY));
            searchPlaceholderText = properties.get("searchPlaceholderText", StringUtils.EMPTY);
            mapLink = LinkUtils.getHrefFromPath(properties.get("mapLink", StringUtils.EMPTY));
            mapLinkIsExternal = LinkUtils.isExternal(properties.get("mapLink", StringUtils.EMPTY));
            myTripLink = LinkUtils.getHrefFromPath(properties.get("myTripLink", StringUtils.EMPTY));
            myTripLinkIsExternal = LinkUtils.isExternal(properties.get("myTripLink", StringUtils.EMPTY));
            megamenu1Title = properties.get("megamenu1Title", StringUtils.EMPTY);
            megamenu2Title = properties.get("megamenu2Title", StringUtils.EMPTY);
            megamenu3Title = properties.get("megamenu3Title", StringUtils.EMPTY);
            megamenu1LhsCategoryTitle = properties.get("megamenu1LhsCategoryTitle", StringUtils.EMPTY);
            megamenu1RhsCategoryTitle = properties.get("megamenu1RhsCategoryTitle", StringUtils.EMPTY);

            megamenu1LhsMosaicThemeLinks = new ArrayList<MosaicThemeLink>();
            buildMosaicThemeLinks(megamenu1LhsMosaicThemeLinks, navigationResource, "megamenu1LhsMosaicThemeLinks");

            megamenu1RhsMosaicLinks = new ArrayList<MosaicLink>();
            buildMosaicLinks(megamenu1RhsMosaicLinks, navigationResource, "megamenu1RhsMosaicLinks");

            megamenu2LhsCategoryTitle1 = properties.get("megamenu2LhsCategoryTitle1", StringUtils.EMPTY);
            megamenu2LhsCategoryTitle2 = properties.get("megamenu2LhsCategoryTitle2", StringUtils.EMPTY);
            megamenu2LhsCategoryTitle3 = properties.get("megamenu2LhsCategoryTitle3", StringUtils.EMPTY);

            megamenu2LhsCategoryTitle1Links = new ArrayList<TextLinkWithState>();
            buildTextLinkWithState(megamenu2LhsCategoryTitle1Links, navigationResource, "megamenu2LhsCategoryTitle1Links");

            megamenu2LhsCategoryTitle2Links = new ArrayList<TextLinkWithState>();
            buildTextLinkWithState(megamenu2LhsCategoryTitle2Links, navigationResource, "megamenu2LhsCategoryTitle2Links");

            megamenu2LhsCategoryTitle3Links = new ArrayList<TextLinkWithState>();
            buildTextLinkWithState(megamenu2LhsCategoryTitle3Links, navigationResource, "megamenu2LhsCategoryTitle3Links");

            megamenu3LhsCategoryTitle = properties.get("megamenu3LhsCategoryTitle", StringUtils.EMPTY);
            megamenu3RhsCategoryTitle = properties.get("megamenu3RhsCategoryTitle", StringUtils.EMPTY);

            megamenu3LhsMosaicLinks = new ArrayList<MosaicLink>();
            buildMosaicLinks(megamenu3LhsMosaicLinks, navigationResource, "megamenu3LhsMosaicLinks");

            megamenu3RhsMosaicLinks = new ArrayList<MosaicLink>();
            buildMosaicLinks(megamenu3RhsMosaicLinks, navigationResource, "megamenu3RhsMosaicLinks");

            homepagePath = LinkUtils.getHrefFromPath(currentPage.getAbsoluteParent(2).getPath());

        }
    }

    public void buildMosaicThemeLinks(List links, Resource navigationResource, String linksColumn){
        if(navigationResource.getChild(linksColumn) != null){
            Iterable<Resource> resources = navigationResource.getChild(linksColumn).getChildren();
            for (Resource r : resources) {
                ValueMap linkProps = r.adaptTo(ValueMap.class);
                String pagePath = LinkUtils.getHrefFromPath(linkProps.get("pagePath", StringUtils.EMPTY));
                String linkText = linkProps.get("linkText", StringUtils.EMPTY);
                String image = linkProps.get("image", StringUtils.EMPTY);
                String iconImage = linkProps.get("iconImage", StringUtils.EMPTY);
                String theme = linkProps.get("theme", StringUtils.EMPTY);
                MosaicThemeLink link = new MosaicThemeLink();
                link.setPagePath(pagePath);
                link.setLinkText(linkText);
                link.setImage(image);
                link.setIconImage(iconImage);
                link.setTheme(theme);
                links.add(link);
            }
        }
    }

    public void buildMosaicLinks(List links, Resource navigationResource, String linksColumn){
        if(navigationResource.getChild(linksColumn) != null){
            Iterable<Resource> resources = navigationResource.getChild(linksColumn).getChildren();
            for (Resource r : resources) {
                ValueMap linkProps = r.adaptTo(ValueMap.class);
                String pagePath = LinkUtils.getHrefFromPath(linkProps.get("pagePath", StringUtils.EMPTY));
                boolean isExternal = LinkUtils.isExternal(linkProps.get("pagePath", StringUtils.EMPTY));
                String linkText = linkProps.get("linkText", StringUtils.EMPTY);
                String image = linkProps.get("image", StringUtils.EMPTY);
                String iconImage = linkProps.get("iconImage", StringUtils.EMPTY);
                MosaicLink link = new MosaicLink();
                link.setPagePath(pagePath);
                link.setIsExternal(isExternal);
                link.setLinkText(linkText);
                link.setImage(image);
                link.setIconImage(iconImage);
                links.add(link);
            }
        }
    }

    public void buildTextLinkWithState(List links, Resource navigationResource, String linksColumn){
        if(navigationResource.getChild(linksColumn) != null){
            Iterable<Resource> resources = navigationResource.getChild(linksColumn).getChildren();
            for (Resource r : resources) {
                ValueMap linkProps = r.adaptTo(ValueMap.class);
                String pagePath = LinkUtils.getHrefFromPath(linkProps.get("pagePath", StringUtils.EMPTY));
                boolean isExternal = LinkUtils.isExternal(linkProps.get("pagePath", StringUtils.EMPTY));
                String linkText = linkProps.get("linkText", StringUtils.EMPTY);
                String state = linkProps.get("state", StringUtils.EMPTY);
                TextLinkWithState link = new TextLinkWithState();
                link.setPagePath(pagePath);
                link.setIsExternal(isExternal);
                link.setLinkText(linkText);
                link.setState(state);
                links.add(link);
            }
        }
    }

    public String getFindOutMoreLink() {
        return findOutMoreLink;
    }

    public boolean getFindOutMoreLinkIsExternal() {
        return findOutMoreLinkIsExternal;
    }

    public String getArrivalBarLink1Text() {
        return arrivalBarLink1Text;
    }

    public String getArrivalBarLink1MobileText() {
        return arrivalBarLink1MobileText;
    }

    public String getArrivalBarLink1() {
        return arrivalBarLink1;
    }

    public boolean getArrivalBarLink1IsExternal() {
        return arrivalBarLink1IsExternal;
    }

    public String getArrivalBarLink2Text() {
        return arrivalBarLink2Text;
    }

    public String getArrivalBarLink2MobileText() {
        return arrivalBarLink2MobileText;
    }

    public String getArrivalBarLink2() {
        return arrivalBarLink2;
    }

    public boolean getArrivalBarLink2IsExternal() {
        return arrivalBarLink2IsExternal;
    }

    public String getSearchPagePath() { return searchPagePath; }

    public String getSearchPlaceholderText() { return searchPlaceholderText; }

    public String getMapLink() {
        return mapLink;
    }

    public boolean getMapLinkIsExternal() {
        return mapLinkIsExternal;
    }

    public String getMyTripLink() {
        return myTripLink;
    }

    public boolean getMyTripLinkIsExternal() {
        return myTripLinkIsExternal;
    }

    public String getMegamenu1Title() {
        return megamenu1Title;
    }

    public String getMegamenu2Title() {
        return megamenu2Title;
    }

    public String getMegamenu3Title() {
        return megamenu3Title;
    }

    public String getMegamenu1LhsCategoryTitle() {
        return megamenu1LhsCategoryTitle;
    }

    public List<MosaicThemeLink> getMegamenu1LhsMosaicThemeLinks() {
        return megamenu1LhsMosaicThemeLinks;
    }

    public String getMegamenu1RhsCategoryTitle() {
        return megamenu1RhsCategoryTitle;
    }

    public List<MosaicLink> getMegamenu1RhsMosaicLinks() {
        return megamenu1RhsMosaicLinks;
    }

    public String getMegamenu2LhsCategoryTitle1() { return megamenu2LhsCategoryTitle1; }

    public List<TextLinkWithState> getMegamenu2LhsCategoryTitle1Links() { return megamenu2LhsCategoryTitle1Links; }

    public String getMegamenu2LhsCategoryTitle2() { return megamenu2LhsCategoryTitle2; }

    public List<TextLinkWithState> getMegamenu2LhsCategoryTitle2Links() { return megamenu2LhsCategoryTitle3Links; }

    public String getMegamenu2LhsCategoryTitle3() { return megamenu2LhsCategoryTitle3; }

    public List<TextLinkWithState> getMegamenu2LhsCategoryTitle3Links() { return megamenu2LhsCategoryTitle3Links; }

    public String getMegamenu3LhsCategoryTitle() {
        return megamenu3LhsCategoryTitle;
    }

    public List<MosaicLink> getMegamenu3LhsMosaicLinks() {
        return megamenu3LhsMosaicLinks;
    }

    public String getMegamenu3RhsCategoryTitle() {
        return megamenu3RhsCategoryTitle;
    }

    public List<MosaicLink> getMegamenu3RhsMosaicLinks() {
        return megamenu3RhsMosaicLinks;
    }

    public String getHomepagePath() { return homepagePath; }

}
