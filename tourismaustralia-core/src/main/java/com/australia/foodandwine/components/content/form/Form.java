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

/**
 *
 */

@Component(group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", value = "Form", listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class Form {

	@DialogField(fieldLabel = "Email Subject", name = "./emailSubject", required = true)
	private String emailSubject;

	@DialogField(fieldLabel = "Email Body", name = "./emailBody", required = true)
	@TextArea
	private String emailBody;

	@DialogField(fieldLabel = "Email Id's")
	@MultiField
	private final List<String> emailIdsList;

	@DialogField(fieldLabel = "Zendesk Id", name = "./zendeskId", required = true, fieldDescription="Zendesk email id (eg. support@zendesk.com)")
	private String zendeskId;

	@DialogField(fieldLabel = "Zendesk Tags", name = "./zendeskTags", required = true, fieldDescription="Add ZenDesk tags here to create Zendesk Tickets (Eg. #status open)")
	@TextArea
	private String zendeskTags;

	@DialogField(fieldLabel = "Thank You Page Redirect", name = "./redirectUrl", required = true)
	@PathField
	private String redirectUrl;

	/**
	 * Constants
	 */
	private final static String EMAIL_SUBJECT = "emailSubject";
	private final static String EMAIL_BODY = "emailBody";
	private final static String EMAIL_IDS_LIST = "emailIdsList";
	private final static String THAMK_YOU_PAGE_REDIRECT_URL = "redirectUrl";
	private final static String ZENDESK_ID = "zendeskId";
	private final static String ZENDESK_TAGS = "zendeskTags";

	public Form(SlingHttpServletRequest request) {
		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		emailSubject = properties.get(EMAIL_SUBJECT, StringUtils.EMPTY);
		emailBody = properties.get(EMAIL_BODY, StringUtils.EMPTY);
		zendeskId = properties.get(ZENDESK_ID, StringUtils.EMPTY);
		zendeskTags = properties.get(ZENDESK_TAGS, StringUtils.EMPTY);
		this.emailIdsList = Arrays.asList(properties.get(EMAIL_IDS_LIST, new String[0]));
		redirectUrl = LinkUtils.getHrefFromPath(properties.get(THAMK_YOU_PAGE_REDIRECT_URL, StringUtils.EMPTY));

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

	/**
	 * 
	 * @return
	 */
	public String getEmailBody() {
		return emailBody;
	}

	/**
	 * 
	 * @return
	 */
	public String getZendeskId() {
		return zendeskId;
	}

	/**
	 * 
	 * @return
	 */
	public String getZendeskTags() {
		return zendeskTags;
	}

}
