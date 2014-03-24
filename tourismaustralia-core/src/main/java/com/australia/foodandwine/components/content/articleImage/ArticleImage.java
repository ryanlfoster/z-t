package com.australia.foodandwine.components.content.articleImage;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Listener;
import com.citytechinc.cq.component.annotations.widgets.PathField;

@Component(group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", value = "Article Image with Caption", listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class ArticleImage {

	@DialogField(fieldLabel = "Articl Image", required = true, name = "./imagePath")
	@PathField(rootPath = "/content/dam")
	private final String imagePath;

	@DialogField(fieldLabel = "Image Caption Bold", name = "./captionBold")
	private final String captionBold;

	@DialogField(fieldLabel = "Image Caption", name = "./imageCaption")
	private final String imageCaption;

	@DialogField(fieldLabel = "Link Image To a Page", name = "./articleImageLinkPage")
	@PathField
	private final String articleImageLinkPage;

	/**
	 * Constants
	 */
	private final static String IMAGE_PATH = "imagePath";
	private final static String CAPTION_BOLD = "captionBold";
	private final static String IMAGE_CAPTION = "imageCaption";
	private final static String ARTICLE_IMAGE_LINK_PAGE = "articleImageLinkPage";

	public ArticleImage(SlingHttpServletRequest request) {
		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		imagePath = properties.get(IMAGE_PATH, StringUtils.EMPTY);
		captionBold = properties.get(CAPTION_BOLD, StringUtils.EMPTY);
		imageCaption = properties.get(IMAGE_CAPTION, StringUtils.EMPTY);
		articleImageLinkPage = properties.get(ARTICLE_IMAGE_LINK_PAGE, StringUtils.EMPTY) + ".html";
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

}
