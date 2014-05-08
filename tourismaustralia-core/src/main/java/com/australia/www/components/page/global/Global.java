package com.australia.www.components.page.global;

import com.adobe.granite.xss.XSSAPI;
import com.australia.pagecategories.PageCategory;
import com.australia.server.ServerNameService;
import com.australia.utils.ServerUtils;
import com.australia.www.components.page.sharethis.ShareThis;
import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.FieldProperty;
import com.citytechinc.cq.component.annotations.Option;
import com.citytechinc.cq.component.annotations.widgets.NumberField;
import com.citytechinc.cq.component.annotations.widgets.Selection;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.day.cq.wcm.api.designer.Design;
import com.day.cq.wcm.commons.WCMUtils;
import com.day.cq.wcm.foundation.Image;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.scripting.SlingBindings;
import org.apache.sling.api.scripting.SlingScriptHelper;
import org.apache.sling.settings.SlingSettingsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(value = "Global", path = "page", group = ".hidden", editConfig = false, fileName = "extra_dialog")
public class Global {
	private static final Logger LOG = LoggerFactory.getLogger(Global.class);
	private final int OZCOM_CONTENT_ROOT = 1;

	@DialogField(fieldLabel = "Hide from Search", fieldDescription = "Removes the page from the site search")
	@Selection(type = Selection.CHECKBOX, options = @Option(value = "true"))
	private final boolean removeFromSearch;

	@DialogField(fieldLabel = "Latitude", additionalProperties = { @FieldProperty(name = "minValue", value = "-90"),
		@FieldProperty(name = "maxValue", value = "90") })
	@NumberField(decimalPrecision = 4)
	private final Double latitude;

	@DialogField(fieldLabel = "Longitude", additionalProperties = { @FieldProperty(name = "minValue", value = "-180"),
		@FieldProperty(name = "maxValue", value = "180") })
	@NumberField(decimalPrecision = 4)
	private final Double longitude;

	@DialogField(fieldLabel = "Page Category", xtype = "categoryselect")
	private final String ausPageCategory;

	private final String title;
	private final String description;
	private final String keywords;
	private final String imagePath;
	private final String url;
	private final String favIcon;
	private final String lastModified;
	private final String socialNetworks;
	private final Boolean isHomePage;

	public Global(SlingHttpServletRequest request) {
		SlingScriptHelper sling = ((SlingBindings) request.getAttribute(SlingBindings.class.getName())).getSling();
		XSSAPI xssAPI = sling.getService(XSSAPI.class);
		SlingSettingsService slingSettings = sling.getService(SlingSettingsService.class);
		ServerNameService serverNameService = sling.getService(ServerNameService.class);

		Page currentPage = request.getResourceResolver().adaptTo(PageManager.class)
			.getContainingPage(request.getResource());

		ValueMap properties = currentPage.getProperties();
		removeFromSearch = properties.get("removeFromSearch", false);
		latitude = properties.get("latitude", Double.class);
		longitude = properties.get("longitude", Double.class);
		ausPageCategory = properties.get("ausPageCategory", String.class);

		title = currentPage.getTitle() == null ? xssAPI.encodeForHTML(currentPage.getName()) : xssAPI
			.encodeForHTML(currentPage.getTitle());
		description = xssAPI.encodeForHTMLAttr(properties.get("jcr:description", ""));
		keywords = xssAPI.encodeForHTMLAttr(WCMUtils.getKeywords(currentPage, false));
		lastModified = StringUtils.left(xssAPI.encodeForHTMLAttr(properties.get("cq:lastModified", "")), 10);
		socialNetworks = this.getSocialNetworks(request, currentPage.getAbsoluteParent(OZCOM_CONTENT_ROOT));
		isHomePage = currentPage.equals(currentPage.getAbsoluteParent(1));

		Resource imageResource = currentPage.getContentResource();
		Image image = new Image(imageResource, "image");
		String serverName = ServerUtils.getServerURL(slingSettings, serverNameService, request);

		if (image.hasContent()) {
			if (!StringUtils.isEmpty(image.getFileReference())) {
				imagePath = serverName + image.getFileReference();
			} else {
				imagePath = serverName + image.getPath() + ".adapt.full.high.jpg";
			}
		} else {
			imagePath = null;
		}

		url = serverName + currentPage.getPath() + ".html";
		String tempFavIcon = currentPage.adaptTo(Design.class).getPath() + "/favicon.ico";
		if (request.getResourceResolver().getResource(tempFavIcon) == null) {
			favIcon = null;
		} else {
			favIcon = tempFavIcon;
		}
	}

	private String getSocialNetworks(SlingHttpServletRequest request, Page parent) {
		String stPageURL = parent.getPath() + "/jcr:content/shareThis";
		Resource sharethisPage = request.getResourceResolver().getResource(stPageURL);
		ShareThis shareobj = new ShareThis(parent, sharethisPage);
		String json = "";
		try {
			ObjectMapper mapper = new ObjectMapper();
			json = mapper.writeValueAsString(shareobj);
		} catch (JsonProcessingException e) {
			LOG.error("There was an error generating the json for SocialNetworks", e);
		}
		return json;
	}

	public boolean getRemoveFromSearch() {
		return removeFromSearch;
	}

	public Double getLatitude() {
		return latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public PageCategory getPageCategory() {
		return PageCategory.fromDisplayString(ausPageCategory);
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getKeywords() {
		return keywords;
	}

	public String getImagePath() {
		return imagePath;
	}

	public String getUrl() {
		return url;
	}

	public String getFavIcon() {
		return favIcon;
	}

	public String getLastModified() {
		return lastModified;
	}

	public String getSocialNetworks() {
		return socialNetworks;
	}

	public Boolean getIsHomePage() {
		return isHomePage;
	}

}
