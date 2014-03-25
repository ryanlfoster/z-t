package com.australia.foodandwine.components.content.articleImage;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;

import com.australia.foodandwine.components.constants.CQJCRConstants;
import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.FieldProperty;
import com.citytechinc.cq.component.annotations.Listener;
import com.citytechinc.cq.component.annotations.widgets.PathField;
import com.citytechinc.cq.component.annotations.widgets.TextField;

@Component(group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", value = "Article Image with Caption", listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class ArticleImage {

	@DialogField(fieldLabel = "Article Image", required = true, name = "./imagePath")
	@PathField(rootPath = "/content/dam")
	private final String imagePath;

	@DialogField(fieldLabel = "Image Caption Bold", name = "./captionBold", fieldDescription = " The Maximum characters for this field is 200", additionalProperties = @FieldProperty(name = "maxLength", value = "200"))
	private final String captionBold;

	@DialogField(fieldLabel = "Image Caption", name = "./imageCaption", fieldDescription = " The Maximum characters for this field is 300", additionalProperties = @FieldProperty(name = "maxLength", value = "300"))
	private final String imageCaption;

	@DialogField(fieldLabel = "Link Image To a Page", name = "./articleImageLinkPage", fieldDescription = "For external links please use prefix http:// or https:// (eg. http://www.google.com)" , required = true)
	@PathField
	private String articleImageLinkPage;

	private String externalLink = null;

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
		articleImageLinkPage = properties.get(ARTICLE_IMAGE_LINK_PAGE, StringUtils.EMPTY);
		if ((articleImageLinkPage.contains("http://")) || (articleImageLinkPage.contains("https://"))) {
			externalLink = articleImageLinkPage + "";
		} else {
			articleImageLinkPage = articleImageLinkPage + CQJCRConstants.HTML_EXTENSION;
		}

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

	public String getExternalLink() {
		return externalLink;
	}

}
