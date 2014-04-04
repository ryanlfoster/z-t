package com.australia.utils;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.resource.Resource;

public final class PathUtils {

	private PathUtils() {
	}

	public static final String OZCOM_ROOT_PATH = "/content/australia";
	public static final String FOOD_AND_WINE_ROOT_PATH = "/content/food-and-wine";

	public static final String FOOD_AND_WINE_404 = "/content/food-and-wine/404.html";
	public static final String OZCOM_404 = "/content/australia/%s/404.html";

	public static final String ATDW_DATA_PATH = OZCOM_ROOT_PATH + "/atdw";

	public static final String USER_GENERATED_PATH = "/content/usergenerated/";

	public static final String FOOD_AND_WINE_EXPERIENCES = FOOD_AND_WINE_ROOT_PATH + "/experiences";

	public static final String FOOD_AND_WINE_USER_GENERATED = "/content/usergenerated/food-and-wine";

    
    /**
     * Will get the language resource for the resource passed in. For example,
     * if resource at /content/en/mypage is passed in, then the resource at /content/en will be returned.
     * Currently operated on assumption that language exists as direct child of OZCOM_ROOT_PATH.
     * @param resource the resource who's containing language resource we want to find.
     * @return The resource representing the parent resource representing the language resource, 
     * or null if one could not be found.
     */
    public static final Resource getLanguageResource(final Resource resource) {
        Resource currentResource =resource;
        Resource parent;
        while ((parent=currentResource.getParent())!=null) {
            if (StringUtils.equals(parent.getPath() , OZCOM_ROOT_PATH)) {
                return currentResource;
            } else {
                currentResource = parent;
            }
        }
        return null;
    }

    public static  String getAllAtdwProductsForCategoryPath(Resource locale, String category){
        return locale.getPath() + "/products.html?cat=" + category;
    }
}
