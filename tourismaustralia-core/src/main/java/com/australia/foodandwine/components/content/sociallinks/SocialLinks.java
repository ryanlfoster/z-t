package com.australia.foodandwine.components.content.sociallinks;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.FieldProperty;
import com.citytechinc.cq.component.annotations.Listener;
import com.citytechinc.cq.component.annotations.Tab;
import com.citytechinc.cq.component.annotations.widgets.DialogFieldSet;
import com.citytechinc.cq.component.annotations.widgets.RichTextEditor;
import com.citytechinc.cq.component.annotations.widgets.rte.Format;
import com.citytechinc.cq.component.annotations.widgets.rte.Justify;
import com.citytechinc.cq.component.annotations.widgets.rte.Lists;
import com.citytechinc.cq.component.annotations.widgets.rte.Style;
import com.citytechinc.cq.component.annotations.widgets.rte.Styles;

/**
 * This class sets the values obtained in the dialog , adds it to the list.
 * 
 */
@Component(disableTargeting = true, group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", value = "Social Links", tabs = {
	@Tab(title = "Title"), @Tab(title = "Link 1"), @Tab(title = "Link 2"), @Tab(title = "Link 3") }, listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class SocialLinks {

	@DialogField(fieldLabel = "Title", additionalProperties = @FieldProperty(name = "maxLength", value = "30"))
	@RichTextEditor(lists = @Lists(indent = false, ordered = false, outdent = false, unordered = false), justify = @Justify(justifycenter = false, justifyleft = false, justifyright = false), styles = @Styles(styles = @Style(cssName = "form-thank-you-small-print", text = "Small print")), format = @Format(bold = true, underline = true, italic = false))
	private final String title;

	@DialogField(tab = 2)
	@DialogFieldSet(border = false, collapsible = false, namePrefix = "socialLink1/")
	private final SocialLinksProperties socialLink1;

	@DialogField(tab = 3)
	@DialogFieldSet(border = false, collapsible = false, namePrefix = "socialLink2/")
	private final SocialLinksProperties socialLink2;

	@DialogField(tab = 4)
	@DialogFieldSet(border = false, collapsible = false, namePrefix = "socialLink3/")
	private final SocialLinksProperties socialLink3;

	/**
	 * constants
	 */
	private static final String TITLE = "title";
	private static final String SOCIAL_LINKS_LOGO = "socialLinksLogoPath";
	private static final String LINK_HOVER_LOGO = "linkLogoHoverPath";
	private static final String SOCIAL_LINKS_ALT_TAG = "socialLinksAltTag";
	private static final String SOCIAL_LINKS_TITLE = "socialLinksTitle";
	private static final String SOCIAL_LINKS = "socialLinks";

	/**
	 * 
	 * @param request
	 */
	public SocialLinks(SlingHttpServletRequest request) {
		Resource resource = request.getResource();
		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		title = properties.get(TITLE, StringUtils.EMPTY);
		socialLink1 = buildSocialLinksProperties(resource.getChild("socialLink1"));
		socialLink2 = buildSocialLinksProperties(resource.getChild("socialLink2"));
		socialLink3 = buildSocialLinksProperties(resource.getChild("socialLink3"));
	}

	private SocialLinksProperties buildSocialLinksProperties(Resource resource) {

		if (resource != null) {
			ValueMap linkProps = resource.adaptTo(ValueMap.class);
			String socialLinksLogoPath = linkProps.get(SOCIAL_LINKS_LOGO, StringUtils.EMPTY);
			String linkLogoHoverPath = linkProps.get(LINK_HOVER_LOGO, StringUtils.EMPTY);
			String socialLinksAltTag = linkProps.get(SOCIAL_LINKS_ALT_TAG, StringUtils.EMPTY);
			String socialLinksTitle = linkProps.get(SOCIAL_LINKS_TITLE, StringUtils.EMPTY);
			String socialLinks = linkProps.get(SOCIAL_LINKS, StringUtils.EMPTY);

			SocialLinksProperties socialLinksProperties = new SocialLinksProperties(socialLinksLogoPath,
				linkLogoHoverPath, socialLinksAltTag, socialLinksTitle, socialLinks);
			return socialLinksProperties;
		}
		return null;
	}

	public String getTitle() {
		return title;
	}

	public SocialLinksProperties getSocialLink1() {
		return socialLink1;
	}

	public SocialLinksProperties getSocialLink2() {
		return socialLink2;
	}

	public SocialLinksProperties getSocialLink3() {
		return socialLink3;
	}

}
