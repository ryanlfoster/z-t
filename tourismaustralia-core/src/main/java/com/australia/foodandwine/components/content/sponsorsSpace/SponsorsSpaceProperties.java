package com.australia.foodandwine.components.content.sponsorsSpace;

import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.FieldProperty;
import com.citytechinc.cq.component.annotations.widgets.PathField;
/**
 *
 */
public class SponsorsSpaceProperties {

	@DialogField(fieldLabel = "Sponsor's Big Title", name = "bigTitle",required = true)
	private String bigTitle;
	@DialogField(fieldLabel = "Sponsor's Image/Video Image",required = true, name = "imagePath")
	@PathField(rootPath="/content/dam")
	private String imagePath;
	@DialogField(fieldLabel = "Image Caption", name = "imageTitle")
	private String imageTitle;
	@DialogField(fieldLabel = "Link Text", name = "linkText")
	private String linkText;
	@DialogField(fieldLabel = "Link Text Path", name = "linkTextPath")
	@PathField
	private String linkTextPath;

	public String getBigTitle() {
		return bigTitle;
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
