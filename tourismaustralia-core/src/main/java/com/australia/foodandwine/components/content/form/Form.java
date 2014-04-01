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
import com.citytechinc.cq.component.annotations.widgets.MultiField;
import com.citytechinc.cq.component.annotations.widgets.PathField;
import com.citytechinc.cq.component.annotations.widgets.TextArea;

@Component(disableTargeting = true, group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", value = "Form", listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class Form {

	@DialogField(fieldLabel = "Email Subject", name = "./emailSubject", required = true)
	private final String emailSubject;

	@DialogField(fieldLabel = "Email Body", name = "./emailBody", required = true)
	@TextArea
	private final String emailBody;

	@DialogField(fieldLabel = "Zen Desk Email Address")
	private final String zenDeskEmail;

	@DialogField(fieldLabel = "Email Id's")
	@MultiField
	private final List<String> emailIdsList;

	@DialogField(fieldLabel = "Thank You Page Redirect", required = true)
	@PathField
	private final String redirectUrl;

	@DialogField(fieldLabel = "Privacy Policy Link", required = true)
	@PathField(rootPath = "/content")
	private final String privacyPolicyLink;

	@DialogField(fieldLabel = "Terms and Condition Link", required = true)
	@PathField(rootPath = "/content")
	private final String termsLink;

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
		privacyPolicyLink = properties.get("privacyPolicyLink", StringUtils.EMPTY);
		termsLink = properties.get("termsLink", StringUtils.EMPTY);
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

}
