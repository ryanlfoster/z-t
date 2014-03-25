package com.australia.foodandwine.components.content.sponsorsSpace;

import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.FieldProperty;
import com.citytechinc.cq.component.annotations.widgets.PathField;

/**
 *
 */
public class SponsorsSpaceProperties {

	@DialogField(fieldLabel = "Sponsor's Big Title", name = "bigTitle", required = true, fieldDescription = " The Maximum characters for this field is 300", additionalProperties = @FieldProperty(name = "maxLength", value = "300"))
	private String bigTitle;
	@DialogField(fieldLabel = "Sponsor's Image/Video Image", required = true, name = "imagePath")
	@PathField(rootPath = "/content/dam")
	private String imagePath;
	@DialogField(fieldLabel = "Image Caption", name = "imageTitle", fieldDescription = " The Maximum characters for this field is 200", additionalProperties = @FieldProperty(name = "maxLength", value = "200"))
	private String imageTitle;
	@DialogField(fieldLabel = "Link Text", name = "linkText", fieldDescription = " The Maximum characters for this field is 50", additionalProperties = @FieldProperty(name = "maxLength", value = "50"))
	private String linkText;
	@DialogField(fieldLabel = "Link Text Path", name = "linkTextPath", fieldDescription = "For external links please use prefix http:// or https:// (eg. http://www.google.com)")
	@PathField
	private String linkTextPath;

	private String externalLink;

	public String getBigTitle() {
		return bigTitle;
	}

	public String getExternalLink() {
		return externalLink;
	}

	public void setExternalLink(String externalLink) {
		this.externalLink = externalLink;
	}

	public void setBigTitle(String bigTitle) {
		this.bigTitle = bigTitle;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getImageTitle() {
		return imageTitle;
	}

	public void setImageTitle(String imageTitle) {
		this.imageTitle = imageTitle;
	}

	public String getLinkText() {
		return linkText;
	}

	public void setLinkText(String linkText) {
		this.linkText = linkText;
	}

	public String getLinkTextPath() {
		return linkTextPath;
	}

	public void setLinkTextPath(String linkTextPath) {
		this.linkTextPath = linkTextPath;
	}

}
