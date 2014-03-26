package com.australia.foodandwine.components.content.header;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.australia.foodandwine.components.content.sponsorsSpace.SponsorsSpace;
import com.australia.utils.PathUtils;
import com.australia.widgets.multicomposite.MultiCompositeField;
import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Listener;
import com.citytechinc.cq.component.annotations.widgets.PathField;



@Component(group = ".hidden", basePath = "jcr_root/apps/foodandwine/components",actions = { "text:Header", "-", "Edit" },disableTargeting = true, value = "Header", 
listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class Header {
	@DialogField(fieldLabel = "Logo Image Path" ,name="./imagePath",required=true)
	@PathField(rootPath = "/content/dam")
	private  String imagePath;

	@DialogField(fieldLabel = "Logo Link Path",name="./logoLinkPath")
	@PathField
	private  String linkPath;

	@DialogField(fieldLabel="Header Text and Links")
	@MultiCompositeField
	private  List<HeaderBean> headerDataList;
	
	private static  Logger LOG = LoggerFactory.getLogger(SponsorsSpace.class);
	/**
	 * Constants
	 */
	private static final String HEADERDATALIST="headerDataList";
	private static final String IMAGEPATH="imagePath";
	private static final String LOGOLINKPATH="logoLinkPath";
	private static final String HEADERLINKPATH="headerLinkPath";
	private static final String HEADERLINKTEXT="headerLinkText"; 
	private static final String HTML_EXTENSION = ".html";
	/**
	 * 
	 * @param request
	 */
	
	public Header(SlingHttpServletRequest request) {
		
		
		String headerPath = PathUtils.FOOD_AND_WINE_ROOT_PATH + "/jcr:content/header";
		Resource headerResource = request.getResourceResolver().getResource(headerPath);
		if (headerResource != null) {
		ValueMap properties = headerResource.adaptTo(ValueMap.class);
		imagePath = properties.get(IMAGEPATH,StringUtils.EMPTY);
		linkPath = properties.get(LOGOLINKPATH, StringUtils.EMPTY)+HTML_EXTENSION;
		headerDataList = new ArrayList<HeaderBean>();
		
		LOG.info(" imagepath on heade "+imagePath);
		//linksLeft = new ArrayList<TextLink>();
		headerData(headerDataList, headerResource, HEADERDATALIST);
		
		}
		
	}
	private void headerData(List<HeaderBean> headerDataList, Resource headerResource, String headrString) {
		if (headerResource.getChild(headrString) != null) {
			Iterable<Resource> resources = headerResource.getChild(headrString).getChildren();
			for (Resource r : resources) {
				ValueMap linkProps = r.adaptTo(ValueMap.class);
				String pagePath = linkProps.get(HEADERLINKPATH, StringUtils.EMPTY);
				String linkText = linkProps.get(HEADERLINKTEXT, StringUtils.EMPTY);
				HeaderBean headerBean = new HeaderBean();
				headerBean.setPagePath(pagePath);
				headerBean.setLinkText(linkText);
				headerDataList.add(headerBean);
			}
		}
		
	}
	/**
	 * 
	 * @return
	 */
	public String getImagePath() {
		return imagePath;
	}

	public String getLinkPath() {
		return linkPath;
	}
	public List<HeaderBean> getHeaderDataList() {
		return headerDataList;
	}

}
