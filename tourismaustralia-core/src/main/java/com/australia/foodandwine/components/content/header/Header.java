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
import com.australia.widgets.multicomposite.MultiCompositeField;
import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Listener;
import com.citytechinc.cq.component.annotations.widgets.PathField;

@Component(group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", value = "Header", listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class Header {
	@DialogField(fieldLabel = "Logo Image Path" ,name="./imagePath")
	@PathField
	private final String imagePath;

	@DialogField(fieldLabel = "Logo Link Path",name="./logoLinkPath")
	@PathField
	private final String linkPath;

	@DialogField(fieldLabel="Header Text and Links")
	@MultiCompositeField
	private final List<HeaderBean> headerDataList;
	
	@DialogField(fieldLabel="Search Icon Path")
	@PathField
	private final String searchIconPath;
	private static final Logger LOG = LoggerFactory.getLogger(SponsorsSpace.class);
	/**
	 * Constants
	 */
	private static final String HEADERDATALIST="headerDataList";
	private static final String IMAGEPATH="imagePath";
	private static final String SEARCHICONPATH="searchIconPath";
	private static final String LOGOLINKPATH="logoLinkPath";
	private static final String HEADERLINKPATH="headerLinkPath";
	private static final String HEADERLINKTEXT="headerLinkText"; 
	private static final String HTML_EXTENSION = ".html";
	private static final String EXCEPTION="Exception in Header.java";
	/**
	 * 
	 * @param request
	 */
	public Header(SlingHttpServletRequest request) {
		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		imagePath = properties.get(IMAGEPATH,StringUtils.EMPTY);
		linkPath = properties.get(LOGOLINKPATH, StringUtils.EMPTY)+HTML_EXTENSION;

		headerDataList = new ArrayList<HeaderBean>();
		try {
			Iterable<Resource> resources = request.getResource().getChild(HEADERDATALIST).getChildren();
			for (Resource r : resources) {
				ValueMap linkProps = r.adaptTo(ValueMap.class);
				String pagePath = linkProps.get(HEADERLINKPATH, StringUtils.EMPTY);
				String linkText = linkProps.get(HEADERLINKTEXT, StringUtils.EMPTY);
				HeaderBean headerBean = new HeaderBean();
				headerBean.setPagePath(pagePath);
				headerBean.setLinkText(linkText);
				headerDataList.add(headerBean);
			}
		} catch (NullPointerException e) {
			LOG.error(EXCEPTION+e.getMessage());

		}
		searchIconPath=properties.get(SEARCHICONPATH,StringUtils.EMPTY);

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
	public String getSearchIconPath(){
		return searchIconPath;
	}

}
