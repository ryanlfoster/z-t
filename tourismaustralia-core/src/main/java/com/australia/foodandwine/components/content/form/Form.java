package com.australia.foodandwine.components.content.form;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;

import com.australia.foodandwine.components.constants.CQJCRConstants;
import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Listener;
import com.citytechinc.cq.component.annotations.widgets.MultiField;
import com.citytechinc.cq.component.annotations.widgets.PathField;

/**
 *
 */

@Component(group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", value = "Form", listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class Form {

	@DialogField(fieldLabel = "Email Template", name = "./emailTemplate", required = true)
	@PathField
	private final String emailTemplate;

	@DialogField(fieldLabel = "Email Subject", name = "./emailSubject", required = true)
	private String emailSubject;

	@DialogField(fieldLabel = "Email Id's")
	@MultiField
	private final List<String> emailIdsList;

	@DialogField(fieldLabel = "Thank You Page Redirect", name = "./redirectUrl", required = true)
	@PathField
	private String redirectUrl;

	/**
	 * Constants
	 */
	private final static String EMAIL_TEMPLATE = "emailTemplate";
	private final static String EMAIL_SUBJECT = "emailSubject";
	private final static String EMAIL_IDS_LIST = "emailIdsList";
	private final static String THAMK_YOU_PAGE_REDIRECT_URL = "redirectUrl";

	public Form(SlingHttpServletRequest request) {
		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		emailTemplate = properties.get(EMAIL_TEMPLATE, StringUtils.EMPTY);
		emailSubject = properties.get(EMAIL_SUBJECT, StringUtils.EMPTY);
		this.emailIdsList = Arrays.asList(properties.get(EMAIL_IDS_LIST, new String[0]));
		redirectUrl = properties.get(THAMK_YOU_PAGE_REDIRECT_URL, StringUtils.EMPTY) + CQJCRConstants.HTML_EXTENSION;

	}

	/**
	 * 
	 * @return
	 */
	public String getEmailTemplate() {
		return emailTemplate;
	}

	/**
	 * 
	 * @return
	 */
	public String getRedirectUrl() {
		return redirectUrl;
	}

	/**
	 * 
	 * @return
	 */
	public List<String> getEmailIdsList() {
		return emailIdsList;
	}

	/**
	 * 
	 * @return
	 */
	public String getEmailSubject() {
		return emailSubject;
	}

}
