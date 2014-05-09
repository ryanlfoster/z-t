package com.australia.foodandwine.components.content.form;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;

import com.australia.utils.LinkUtils;
import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Listener;
import com.citytechinc.cq.component.annotations.Tab;
import com.citytechinc.cq.component.annotations.widgets.MultiField;
import com.citytechinc.cq.component.annotations.widgets.PathField;
import com.citytechinc.cq.component.annotations.widgets.RichTextEditor;
import com.citytechinc.cq.component.annotations.widgets.TextArea;
import com.citytechinc.cq.component.annotations.widgets.rte.Format;
import com.citytechinc.cq.component.annotations.widgets.rte.Justify;
import com.citytechinc.cq.component.annotations.widgets.rte.Lists;
import com.citytechinc.cq.component.annotations.widgets.rte.Style;
import com.citytechinc.cq.component.annotations.widgets.rte.Styles;

@Component(disableTargeting = true, group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", value = "Form", tabs = {
	@Tab(title = "Email configuration"), @Tab(title = "Category Description") ,@Tab(title="Checkbox Description")}, listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class Form {

	@DialogField(fieldLabel = "Email Subject", name = "./emailSubject", required = true, tab = 1)
	private final String emailSubject;

	@DialogField(fieldLabel = "Email Body", name = "./emailBody", required = true, tab = 1)
	@TextArea
	private final String emailBody;

	@DialogField(fieldLabel = "Zen Desk Email Address", tab = 1)
	private final String zenDeskEmail;

	@DialogField(fieldLabel = "Email Id's", tab = 1)
	@MultiField
	private final List<String> emailIdsList;

	@DialogField(fieldLabel = "Thank You Page Redirect", required = true, tab = 1)
	@PathField
	private final String redirectUrl;

	@DialogField(fieldLabel = "Privacy Policy Link", required = true, tab = 1)
	@PathField(rootPath = "/content")
	private final String privacyPolicyLink;

	@DialogField(fieldLabel = "Terms and Condition Link", required = true, tab = 1)
	@PathField(rootPath = "/content")
	private final String termsLink;

	@DialogField(fieldLabel = "Restaurants Description", tab = 2)
	private final String restaurantDescription;

	@DialogField(fieldLabel = "WineStory Description", tab = 2)
	private final String wineStoryDescription;

	@DialogField(fieldLabel = "Produce Description", tab = 2)
	private final String produceDescription;

	@DialogField(fieldLabel = "Events Description", tab = 2)
	private final String eventsDescription;

	@DialogField(fieldLabel = "People Description", tab = 2)
	private final String peopleDescription;

	@DialogField(fieldLabel = "Experiences Description", tab = 2)
	private final String experiencesDescription;

	@DialogField(fieldLabel = "Seafood Description", tab = 2)
	private final String seafoodDescription;
	
	@DialogField(fieldLabel="Title", tab=3)
	private String checkboxTitle;
	
	@DialogField(fieldLabel="Description", tab=3)
	@RichTextEditor(lists = @Lists(indent = false, ordered = false, outdent = false, unordered = false), justify = @Justify(justifycenter = false, justifyleft = false, justifyright = false), styles = @Styles(styles = @Style(cssName = "checkbox-description", text = "checkbos description")), format = @Format(bold = true, underline = true, italic = false))
	private  String checkboxDescription;
	
	@DialogField(fieldLabel="Validation Message",tab=3)
	private String validationMessage;

	private final String formPath;

	private final static String EMAIL_SUBJECT = "emailSubject";
	private final static String EMAIL_BODY = "emailBody";
	private final static String EMAIL_IDS_LIST = "emailIdsList";
	private final static String THAMK_YOU_PAGE_REDIRECT_URL = "redirectUrl";

	public Form(SlingHttpServletRequest request) {
		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		emailSubject = properties.get(EMAIL_SUBJECT, StringUtils.EMPTY);
		emailBody = properties.get(EMAIL_BODY, StringUtils.EMPTY);
		zenDeskEmail = properties.get("zenDeskEmail", StringUtils.EMPTY);
		this.emailIdsList = Arrays.asList(properties.get(EMAIL_IDS_LIST, new String[0]));
		redirectUrl = LinkUtils.getHrefFromPath(properties.get(THAMK_YOU_PAGE_REDIRECT_URL, StringUtils.EMPTY));
		formPath = request.getResourceResolver().map(request.getResource().getPath() + ".formemail.json");
		privacyPolicyLink = LinkUtils.getHrefFromPath(properties.get("privacyPolicyLink", StringUtils.EMPTY));
		termsLink = LinkUtils.getHrefFromPath(properties.get("termsLink", StringUtils.EMPTY));

		restaurantDescription = properties.get("restaurantDescription", "Restautants");
		wineStoryDescription = properties.get("wineStoryDescription", "Winery");
		produceDescription = properties.get("produceDescription", "Produce");
		eventsDescription = properties.get("eventsDescription", "Festivals");
		peopleDescription = properties.get("peopleDescription", "People");
		experiencesDescription = properties.get("experiencesDescription", "Experiences");
		seafoodDescription = properties.get("seafoodDescription", "Seafood");
		
		checkboxTitle=properties.get("checkboxTitle",StringUtils.EMPTY);
		checkboxDescription=properties.get("checkboxDescription",StringUtils.EMPTY);
		checkboxDescription=checkboxDescription.replaceAll("<p>", "");
		checkboxDescription=checkboxDescription.replaceAll("</p>", "");
		validationMessage=properties.get("validationMessage",StringUtils.EMPTY);
	}

	public String getValidationMessage() {
		return validationMessage;
	}

	public String getCheckboxTitle() {
		return checkboxTitle;
	}

	public String getRestaurantDescription() {
		return restaurantDescription;
	}

	public String getWineStoryDescription() {
		return wineStoryDescription;
	}

	public String getProduceDescription() {
		return produceDescription;
	}

	public String getEventsDescription() {
		return eventsDescription;
	}

	public String getPeopleDescription() {
		return peopleDescription;
	}

	public String getExperiencesDescription() {
		return experiencesDescription;
	}

	public String getSeafoodDescription() {
		return seafoodDescription;
	}

	public String getRedirectUrl() {
		return redirectUrl;
	}

	public List<String> getEmailIdsList() {
		return emailIdsList;
	}

	public String getEmailSubject() {
		return emailSubject;
	}

	public String getEmailBody() {
		return emailBody;
	}

	public String getZenDeskEmail() {
		return zenDeskEmail;
	}

	public String getFormPath() {
		return formPath;
	}

	public String getPrivacyPolicyLink() {
		return privacyPolicyLink;
	}

	public String getTermsLink() {
		return termsLink;
	}
	
	public String getCheckboxDescription() {
		return checkboxDescription;
	}


}
