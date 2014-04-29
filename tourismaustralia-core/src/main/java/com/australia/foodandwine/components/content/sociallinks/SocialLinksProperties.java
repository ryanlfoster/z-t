package com.australia.foodandwine.components.content.sociallinks;

import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.FieldProperty;
import com.citytechinc.cq.component.annotations.widgets.PathField;

public class SocialLinksProperties {

	@DialogField(fieldLabel = "Link Image")
	@PathField(rootPath = "/content/dam")
	private final String socialLinksLogoPath;

	@DialogField(fieldLabel = "Link Hover Image")
	@PathField(rootPath = "/content/dam")
	private final String linkLogoHoverPath;

	@DialogField(fieldLabel = "Link Title", additionalProperties = @FieldProperty(name = "maxLength", value = "30"))
	private final String socialLinksTitle;

	@DialogField(fieldLabel = "Link Path", fieldDescription = "Please use prefix http:// or https:// (eg. http://www.google.com)")
	private final String socialLinks;

	public SocialLinksProperties(String socialLinksLogoPath, String linkLogoHoverPath, String socialLinksAltTag,
		String socialLinksTitle, String socialLinks) {
		this.socialLinks = socialLinks;
		this.socialLinksLogoPath = socialLinksLogoPath;
		this.linkLogoHoverPath = linkLogoHoverPath;
		this.socialLinksTitle = socialLinksTitle;
	}

	public String getSocialLinksLogoPath() {
		return socialLinksLogoPath;
	}

	public String getLinkLogoHoverPath() {
		return linkLogoHoverPath;
	}

	public String getSocialLinksTitle() {
		return socialLinksTitle;
	}

	public String getSocialLinks() {
		return socialLinks;
	}

}
