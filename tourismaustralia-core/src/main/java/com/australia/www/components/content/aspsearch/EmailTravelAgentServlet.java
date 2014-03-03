package com.australia.www.components.content.aspsearch;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.jcr.Session;
import javax.servlet.ServletException;

import org.apache.commons.lang.text.StrLookup;
import org.apache.commons.mail.HtmlEmail;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.commons.mail.MailTemplate;
import com.day.cq.mailer.MailService;

@SlingServlet(resourceTypes = "tourismaustralia/components/content/aspSearch", selectors = "agentemail", extensions = "json", methods = "POST")
public class EmailTravelAgentServlet extends SlingAllMethodsServlet {
	private static final long serialVersionUID = -5723334337800295209L;
	private static final Logger LOG = LoggerFactory.getLogger(EmailTravelAgentServlet.class);

	@Reference
	private MailService mailService;

	@Override
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException,
		IOException {
		Map<String, String> properties = new HashMap<String, String>();
		String agentEmail = request.getParameter("agentEmail");
		String agentName = request.getParameter("agentName");
		String userName = request.getParameter("userName");
		String userEmail = request.getParameter("userEmail");
		String message = request.getParameter("message");

		properties.put("agentName", agentName);
		properties.put("userName", userName);
		properties.put("userEmail", userEmail);
		properties.put("message", message);

		final MailTemplate mailTemplate = MailTemplate.create(
			"/content/dam/australia/emails/travelAgent/en.txt/jcr:content/renditions/original", request
				.getResourceResolver().adaptTo(Session.class));
		try {
			final HtmlEmail email = mailTemplate.getEmail(StrLookup.mapLookup(properties), HtmlEmail.class);
			email.setSubject("Aus.com Email to Agent");
			email.addTo(agentEmail);
			mailService.send(email);
		} catch (Exception e) {
			LOG.error("The was an error sending the email to the agent", e);
		}
	}
}
