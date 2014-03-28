package com.australia.foodandwine.components.content.articleImage;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;

import com.australia.utils.LinkUtils;
import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Listener;
import com.citytechinc.cq.component.annotations.Tab;
import com.citytechinc.cq.component.annotations.widgets.Html5SmartImage;
import com.citytechinc.cq.component.annotations.widgets.PathField;
import com.day.cq.wcm.foundation.Image;

@Component(group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", value = "Article Image with Caption", tabs = {
	@Tab(title = "Image"), @Tab(title = "Properties") }, listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class ArticleImage {

	@DialogField(fieldLabel = "Image Path", tab = 1)
	@Html5SmartImage(allowUpload = false, name = "backgroundImage")
	private String imagePath;

	@DialogField(fieldLabel = "Image Caption Bold", name = "./captionBold", tab = 2)
	private final String captionBold;

	@DialogField(fieldLabel = "Image Caption", name = "./imageCaption", tab = 2)
	private final String imageCaption;

	@DialogField(fieldLabel = "Link Image To a Page", name = "./articleImageLinkPage", fieldDescription = "For external links please use prefix http:// or https:// (eg. http://www.google.com)", tab = 2)
	@PathField(rootPath = "/content")
	private final String articleImageLinkPage;
	private final boolean external;

	/**
	 * Constants
	 */
	private final static String CAPTION_BOLD = "captionBold";
	private final static String IMAGE_CAPTION = "imageCaption";
	private final static String ARTICLE_IMAGE_LINK_PAGE = "articleImageLinkPage";

	public ArticleImage(SlingHttpServletRequest request) {
		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		Image image = new Image(request.getResource(), "backgroundImage");
		if (image != null && image.hasContent()) {
			imagePath = image.getPath();
		}
		captionBold = properties.get(CAPTION_BOLD, StringUtils.EMPTY);
		imageCaption = properties.get(IMAGE_CAPTION, StringUtils.EMPTY);
		articleImageLinkPage = LinkUtils.getHrefFromPath(properties.get(ARTICLE_IMAGE_LINK_PAGE, StringUtils.EMPTY));
		external = LinkUtils.isExternal(articleImageLinkPage);
	}

	public String getArticleImageLinkPage() {
		return articleImageLinkPage;
	}

	public String getImagePath() {
		return imagePath;
	}

	public String getCaptionBold() {
		return captionBold;
	}

	public String getImageCaption() {
		return imageCaption;
	}

	public boolean isExternal() {
		return external;
	}

}
