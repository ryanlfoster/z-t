package com.australia.foodandwine.components.content.header;

import java.util.ArrayList;
import java.util.List;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;

import com.australia.widgets.multicomposite.MultiCompositeField;
import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Listener;
import com.citytechinc.cq.component.annotations.Tab;
import com.citytechinc.cq.component.annotations.widgets.PathField;

@Component(group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", value = "Header", listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class Header {
	@DialogField(fieldLabel = "Image path" ,name="./imagePath")
	@PathField
	private final String imagePath;

	@DialogField(fieldLabel = "Link path",name="./linkPath")
	@PathField
	private final String linkPath;

	@DialogField
	@MultiCompositeField
	private final List<HeaderBean> headerDataList;

	private static final String HEADERDATALIST="headerDataList";
	private static final String IMAGEPATH="imagePath";
	private static final String LOGOLINKPATH="logoLinkPath";
	public Header(SlingHttpServletRequest request) {
		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		imagePath = properties.get("imagePath", "");
		linkPath = properties.get("linkPath", "");

		headerDataList = new ArrayList<HeaderBean>();
		try {
			Iterable<Resource> resources = request.getResource().getChild("headerDataList").getChildren();
			for (Resource r : resources) {
				ValueMap linkProps = r.adaptTo(ValueMap.class);
				String pagePath = linkProps.get("pagePath", "");
				String linkText = linkProps.get("linkText", "");
				HeaderBean headerBean = new HeaderBean();
				headerBean.setPagePath(pagePath);
				headerBean.setLinkText(linkText);
				headerDataList.add(headerBean);
			}
		} catch (NullPointerException e) {

		}

	}

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
