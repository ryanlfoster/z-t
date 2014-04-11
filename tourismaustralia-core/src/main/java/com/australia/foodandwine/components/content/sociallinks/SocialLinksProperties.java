package com.australia.foodandwine.components.content.sociallinks;

import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.FieldProperty;
import com.citytechinc.cq.component.annotations.widgets.PathField;

public class SocialLinksProperties {

	@DialogField(fieldLabel = "Social Links Logo", required = true)
	@PathField(rootPath = "/content/dam")
	private final String socialLinksLogoPath;

	@DialogField(fieldLabel = "Social Link Logo Alt Tag Text", additionalProperties = @FieldProperty(name = "maxLength", value = "30"))
	private final String socialLinksAltTag;

	@DialogField(fieldLabel = "Social Links Title", required = true, additionalProperties = @FieldProperty(name = "maxLength", value = "30"))
	private final String socialLinksTitle;

	@DialogField(fieldLabel = "Social Links Path", required = true, fieldDescription = "Please use prefix http:// or https:// (eg. http://www.google.com)")
	private final String socialLinks;

	public SocialLinksProperties(String socialLinksLogoPath, String socialLinksAltTag, String socialLinksTitle,
		String socialLinks) {
		this.socialLinks = socialLinks;
		this.socialLinksAltTag = socialLinksAltTag;
		this.socialLinksLogoPath = socialLinksLogoPath;
		this.socialLinksTitle = socialLinksTitle;
	}

	public String getSocialLinksAltTag() {
		return socialLinksAltTag;
	}

	public String getSocialLinksLogoPath() {
		return socialLinksLogoPath;
	}

	public String getSocialLinksTitle() {
		return socialLinksTitle;
	}

	public String getSocialLinks() {
		return socialLinks;
	}

}
