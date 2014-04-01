package com.australia.foodandwine.components.content.sponsorsSpace;

import org.apache.commons.lang3.StringUtils;

import com.australia.utils.LinkUtils;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.FieldProperty;
import com.citytechinc.cq.component.annotations.widgets.PathField;

/**
 *
 */
public class SponsorsSpaceProperties {

	@DialogField(fieldLabel = "Big Title", name = "bigTitle", required = true, additionalProperties = @FieldProperty(name = "maxLength", value = "300"))
	private final String bigTitle;
	@DialogField(fieldLabel = "Image/Video", required = true, name = "imagePath")
	@PathField(rootPath = "/content/dam")
	private final String imagePath;
	@DialogField(fieldLabel = "Image Caption", name = "imageTitle", additionalProperties = @FieldProperty(name = "maxLength", value = "200"))
	private final String imageTitle;
	@DialogField(fieldLabel = "Image Alt Tag", required = true)
	private final String imageAltTag;
	@DialogField(fieldLabel = "Link Text", name = "linkText", additionalProperties = @FieldProperty(name = "maxLength", value = "50"))
	private final String linkText;
	@DialogField(fieldLabel = "Link Text Path", required = true, name = "linkTextPath", fieldDescription = "For external links please use prefix http:// or https:// (eg. http://www.google.com)")
	@PathField
	private final String linkTextPath;
	private boolean external;

	public SponsorsSpaceProperties(String bigTitle, String imagePath, String imageTitle, String linkText,
		String linkTextPath, String imageAltTag) {
		this.bigTitle = bigTitle;
		this.imagePath = imagePath;
		this.imageTitle = imageTitle;
		this.imageAltTag = imageAltTag;
		this.linkText = linkText;
		this.linkTextPath = linkTextPath;
		if (StringUtils.isNotEmpty(linkTextPath)) {
			external = LinkUtils.isExternal(linkTextPath);
		}
	}

	public String getBigTitle() {
		return bigTitle;
	}

	public String getImagePath() {
		return imagePath;
	}

	public String getImageTitle() {
		return imageTitle;
	}

	public String getLinkText() {
		return linkText;
	}

	public String getLinkTextPath() {
		return linkTextPath;
	}

	public String getImageAltTag() {
		return imageAltTag;
	}

	public boolean isExternal() {
		return external;
	}

}
