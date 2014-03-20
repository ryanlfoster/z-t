package com.australia.foodandwine.components.content.form;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jcr.Node;
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

@SlingServlet(resourceTypes = "foodandwine/components/content/form", selectors = "formemail", extensions = "json", methods = "POST")
public class FormEmailServlet extends SlingAllMethodsServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2934133851990899177L;

	private static final Logger LOG = LoggerFactory.getLogger(FormEmailServlet.class);

	@Reference
	private MailService mailService;

	@Override
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException,
		IOException {
		boolean emailCheck = false;
		try {
			Map<String, String> properties = new HashMap<String, String>();
			String businessName = request.getParameter("businessName");
			String location = request.getParameter("location");
			String selectTerritory = request.getParameter("selectTerritory");
			String mail = request.getParameter("mail");
			String verifymail = request.getParameter("verifymail");
			if (verifymail.equals(mail)) {
				emailCheck = true;
			}
			String businessWebsite = request.getParameter("businessWebsite");
			String businessDescription = request.getParameter("businessDescription");
			// String photo = request.getParameter("verifymail");
			String photoDescription = request.getParameter("photoDescription");
			String categoryRestaurants = request.getParameter("category-restaurants");
			String categoryWine = request.getParameter("category-wine");
			String categoryProduce = request.getParameter("category-produce");
			String categoryEvents = request.getParameter("category-events");
			String categoryPeople = request.getParameter("category-people");
			String categorExperiences = request.getParameter("category-experiences");
			String categorySeafood = request.getParameter("category-seafood");

			properties.put("businessName", businessName);
			properties.put("location", location);
			properties.put("selectTerritory", selectTerritory);
			properties.put("mail", mail);
			properties.put("businessWebsite", businessWebsite);
			properties.put("businessDescription", businessDescription);
			properties.put("photoDescription", photoDescription);
			properties.put("categoryRestaurants", categoryRestaurants);
			properties.put("categoryWine", categoryWine);
			properties.put("categoryProduce", categoryProduce);
			properties.put("categoryEvents", categoryEvents);
			properties.put("categoryPeople", categoryPeople);
			properties.put("categorExperiences", categorExperiences);
			properties.put("categorySeafood", categorySeafood);

			Form form = new Form(request);
			List<String> emailIdsList = form.getEmailIdsList();
			String emailTemplatePath = form.getEmailTemplate();
			String emailSubject = form.getEmailSubject();

			for (String emailIds : emailIdsList) {
				if (emailCheck) {
					final MailTemplate mailTemplate = MailTemplate.create(emailTemplatePath
						+ "/jcr:content/renditions/original", request.getResourceResolver().adaptTo(Session.class));
					try {
						final HtmlEmail email = mailTemplate.getEmail(StrLookup.mapLookup(properties), HtmlEmail.class);
						email.setSubject(emailSubject);
						email.addTo(emailIds);
						mailService.send(email);
					} catch (Exception e) {
						LOG.error("Error sending an email", e);
					}
				}
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
	}
}
