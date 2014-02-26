package com.australia.www.components.page.contactus;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jcr.Session;
import javax.servlet.ServletException;

import org.apache.commons.lang.text.StrLookup;
import org.apache.commons.mail.HtmlEmail;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.widgets.MultiField;
import com.day.cq.commons.mail.MailTemplate;
import com.day.cq.mailer.MailService;

/**
 * Created by cchin on 24/02/14.
 */
@SlingServlet(resourceTypes = "tourismaustralia/components/content/contactUs",
	selectors = "contactemail", extensions = "json", methods = "POST")
@Component(name = "contactUs", value = "Contact Us Form")
public class ContactUsServlet extends SlingAllMethodsServlet {
	private static final Logger LOG = LoggerFactory.getLogger(ContactUsServlet.class);

	@Reference
	private MailService mailService;

	@DialogField(fieldLabel = "Recipient Emails")
	@MultiField
	private List<String> recipientEmails;


	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
		throws ServletException, IOException {
		Map<String, String> properties = new HashMap<String, String>();
		String userName = request.getParameter("userName");
		String userEmail = request.getParameter("userEmail");
		String message = request.getParameter("message");
		String[] defaultRecipient = { request.getParameter("defaultRecipient") };

		properties.put("userName", userName);
		properties.put("userEmail", userEmail);
		properties.put("message", message);

		ValueMap props = request.getResource().adaptTo(ValueMap.class);
		this.recipientEmails = Arrays.asList(props.get("recipientEmails", defaultRecipient));

		final MailTemplate mailTemplate = MailTemplate.create(
			"/content/dam/australia/emails/contactUs/en.txt",
			request.getResourceResolver().adaptTo(Session.class));

		try {
			final HtmlEmail email = mailTemplate.getEmail(StrLookup.mapLookup(properties), HtmlEmail.class);
			for (String rem : this.recipientEmails) {
				email.addTo(rem);
			}
			mailService.send(email);
		} catch (Exception e) {
			LOG.error("There was an error sending the email to TA Staff", e);
		}
	}

	public List<String> getRecipientEmails() {
		return recipientEmails;
	}

}
