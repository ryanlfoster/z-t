package com.australia.foodandwine.components.content.otherExperiences;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.australia.utils.LinkUtils;
import com.australia.utils.TagUtils;
import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Listener;
import com.citytechinc.cq.component.annotations.widgets.PathField;
import com.day.cq.commons.jcr.JcrConstants;
import com.day.cq.tagging.Tag;
import com.day.cq.tagging.TagManager;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.day.cq.wcm.foundation.Image;

@Component(disableTargeting = true, actions = { "text:Other Experiences", "-", "edit" }, group = ".hidden", basePath = "jcr_root/apps/foodandwine/components", value = "Other Experiences", listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class OtherExperiences {
	@DialogField(fieldLabel = "Other Experiences Path1", required = true, name = "./otherExperiencesPagePath1")
	@PathField
	private String otherExperiencesPagePath1;

	@DialogField(fieldLabel = "Other Experiences Path2", required = true, name = "./otherExperiencesPagePath2")
	@PathField
	private String otherExperiencesPagePath2;

	@DialogField(fieldLabel = "Other Experiences Path3", required = true, name = "./otherExperiencesPagePath3")
	@PathField
	private String otherExperiencesPagePath3;

	@DialogField(fieldLabel = "Other Experiences Path4", required = true, name = "./otherExperiencesPagePath4")
	@PathField
	private String otherExperiencesPagePath4;

	private static final Logger LOG = LoggerFactory.getLogger(OtherExperiences.class);

	private final List<OtherExperiencesArticleListProperties> articlesList = new ArrayList<OtherExperiencesArticleListProperties>();
	private List<String> experienceList;
	private String stateTitle;

	public OtherExperiences(SlingHttpServletRequest request) {
		ValueMap linkProps = request.getResource().adaptTo(ValueMap.class);
		experienceList = new ArrayList<String>();

		try {

			String otherExperiencesPagePath1 = linkProps.get("otherExperiencesPagePath1", String.class);
			String otherExperiencesPagePath2 = linkProps.get("otherExperiencesPagePath2", String.class);
			String otherExperiencesPagePath3 = linkProps.get("otherExperiencesPagePath3", String.class);
			String otherExperiencesPagePath4 = linkProps.get("otherExperiencesPagePath4", String.class);
			if (otherExperiencesPagePath1 != null && otherExperiencesPagePath2 != null
				&& otherExperiencesPagePath3 != null && otherExperiencesPagePath4 != null) {
				experienceList.add(otherExperiencesPagePath1);
				experienceList.add(otherExperiencesPagePath2);
				experienceList.add(otherExperiencesPagePath3);
				experienceList.add(otherExperiencesPagePath4);

				for (String experiencePath : experienceList) {
					if (experiencePath.contains(".html")) {
						experiencePath = experiencePath.replace(".html", StringUtils.EMPTY);
					}
					PageManager pageManager = request.getResourceResolver().adaptTo(PageManager.class);
					Page currentPage = pageManager.getContainingPage(request.getResource());
					String[] pageTags = currentPage.getProperties().get("cq:tags", new String[0]);
					TagManager tagManager = request.getResourceResolver().adaptTo(TagManager.class);
					Tag stateTag = TagUtils.getStateTag(tagManager, pageTags);
					if (stateTag != null) {
						stateTitle = stateTag.getTitle();
					}
					Page articlePage = pageManager.getPage(experiencePath);
					ValueMap pageProperties = articlePage.getProperties();
					String title = articlePage.getTitle();
					String image = null;
					Resource jcrResource = articlePage.adaptTo(Resource.class).getChild(JcrConstants.JCR_CONTENT);
					Image pageImage = new Image(jcrResource, "image");
					if (pageImage != null && pageImage.hasContent()) {
						image = pageImage.getPath() + ".img.jpg";
					}
					String[] tags = pageProperties.get("cq:tags", new String[0]);
					List<String> tagTitles = new ArrayList<String>();
					for (Tag tag : TagUtils.getFoodAndWineCategoryTags(tagManager, tags)) {
						tagTitles.add(tag.getTitle());
					}
					String city = null;
					Tag cityTag = TagUtils.getCityTag(tagManager, tags);
					if (cityTag != null) {
						city = cityTag.getTitle();
					}
					String state = StringUtils.EMPTY;
					if (stateTag != null) {
						state = stateTag.getTitle();
					}
					String icon = pageProperties.get("categoryLogoPath", String.class);
					articlesList.add(new OtherExperiencesArticleListProperties(title, LinkUtils
						.getHrefFromPath(articlePage.getPath()), image, city, state, tagTitles.toArray(new String[0]),
						icon));
				}
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}

	}

	public List<OtherExperiencesArticleListProperties> getArticlesList() {
		return articlesList;
	}

	public String getStateTitle() {
		return stateTitle;
	}

}
