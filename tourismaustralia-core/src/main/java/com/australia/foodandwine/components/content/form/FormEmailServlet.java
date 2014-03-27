package com.australia.foodandwine.components.content.form;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jcr.Binary;
import javax.jcr.Node;
import javax.jcr.Session;
import javax.jcr.ValueFactory;
import javax.servlet.ServletException;

import org.apache.commons.lang.text.StrLookup;
import org.apache.commons.mail.HtmlEmail;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.request.RequestParameter;
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
	private Session session;
	private String key;
	private RequestParameter param;
	
	private String contentType;
	private Binary contentValue;

	@Override
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException,
		IOException {
		boolean emailCheck = false;
		try {
			Form form = new Form(request);
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
			String photoDescription = request.getParameter("photoDescription");
			String categoryRestaurants = request.getParameter("category-restaurants");
			String categoryWine = request.getParameter("category-wine");
			String categoryProduce = request.getParameter("category-produce");
			String categoryEvents = request.getParameter("category-events");
			String categoryPeople = request.getParameter("category-people");
			String categorExperiences = request.getParameter("category-experiences");
			String categorySeafood = request.getParameter("category-seafood");

			Node node = request.getResourceResolver().resolve("/content/usergenerated/").adaptTo(Node.class);
			session = request.getResourceResolver().adaptTo(Session.class);
			Node formArticleNode = node.addNode("formNode" + new Date().getTime());
			formArticleNode.setPrimaryType("nt:unstructured");
			formArticleNode.setProperty("businessName", businessName);
			formArticleNode.setProperty("location", location);
			formArticleNode.setProperty("selectTerritory", selectTerritory);
			formArticleNode.setProperty("mail", mail);
			formArticleNode.setProperty("businessWebsite", businessWebsite);
			formArticleNode.setProperty("businessDescription", businessDescription);
			formArticleNode.setProperty("photoDescription", photoDescription);

			if (null != categoryRestaurants || !"".equals(categoryRestaurants)) {
				formArticleNode.setProperty("categoryRestaurants", categoryRestaurants);
			}
			if (null != categoryRestaurants || !"".equals(categoryRestaurants)) {
				formArticleNode.setProperty("categoryWine", categoryWine);
			}
			if (null != categoryProduce || !"".equals(categoryProduce)) {
				formArticleNode.setProperty("categoryProduce", categoryProduce);
			}
			if (null != categoryEvents || !"".equals(categoryEvents)) {
				formArticleNode.setProperty("categoryEvents", categoryEvents);
			}
			if (null != categoryPeople || !"".equals(categoryPeople)) {
				formArticleNode.setProperty("categoryPeople", categoryPeople);
			}
			if (null != categorExperiences || !"".equals(categorExperiences)) {
				formArticleNode.setProperty("categorExperiences", categorExperiences);
			}
			if (null != categorySeafood || !"".equals(categorySeafood)) {
				formArticleNode.setProperty("categorySeafood", categorySeafood);
			}

			imageUpload(request, formArticleNode);
			session.save();

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

			sendEmail(request, emailCheck, properties,form);
			response.sendRedirect(form.getRedirectUrl());
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
	}

	private void imageUpload(SlingHttpServletRequest request, Node formArticleNode) throws IOException {
		
		Map<String, RequestParameter[]> params = request.getRequestParameterMap();
		for (Map.Entry<String, RequestParameter[]> pairs : params.entrySet()) {
			key = pairs.getKey();
			RequestParameter[] pArr = pairs.getValue();
			param = pArr[0];

			if ((key.equalsIgnoreCase("upload-photo"))) {
				try {
					InputStream stream = param.getInputStream();
					contentType = param.getContentType();
					ValueFactory valueFactory = session.getValueFactory();
					contentValue = valueFactory.createBinary(stream);
					Node fileNode = formArticleNode.addNode("file", "nt:file");
					fileNode.addMixin("mix:referenceable");
					Node resourceNode = fileNode.addNode("jcr:content", "nt:resource");
					resourceNode.setProperty("jcr:mimeType", contentType);
					resourceNode.setProperty("jcr:data", contentValue);
				} catch (Exception e) {
					LOG.error(e.getMessage());

				}
			}
		}
	}

	private void sendEmail(SlingHttpServletRequest request, boolean emailCheck, Map<String, String> properties,Form form) {
		
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
	}
}
