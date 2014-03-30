package com.australia.foodandwine.components.content.form;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.jcr.Binary;
import javax.jcr.Node;
import javax.jcr.Session;
import javax.jcr.ValueFactory;
import javax.servlet.ServletException;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.HtmlEmail;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.request.RequestParameter;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

	@Reference
	private ResourceResolverFactory resourceResovlerFactory;

	private Session session;
	private String key;
	private RequestParameter param;

	private String contentType;
	private Binary contentValue;

	@Override
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException,
		IOException {
		ResourceResolver resourceResolver = null;
		try {
			resourceResolver = resourceResovlerFactory.getAdministrativeResourceResolver(null);
			Form form = new Form(request);
			Map<String, String> properties = new LinkedHashMap<String, String>();
			String businessName = request.getParameter("businessName");
			String location = request.getParameter("location");
			String selectTerritory = request.getParameter("selectTerritory");
			String mail = request.getParameter("mail");

			String businessWebsite = request.getParameter("businessWebsite");
			String businessDescription = request.getParameter("businessDescription");
			String photoDescription = request.getParameter("photoDescription");
			String primaryCategory = request.getParameter("category-primary");
			String secondaryCategory = request.getParameter("category-secondary");
			String videoUrl = request.getParameter("videoUrl");

			Node node = resourceResolver.resolve("/content/usergenerated/").adaptTo(Node.class);
			session = resourceResolver.adaptTo(Session.class);
			Node formArticleNode = node.addNode("experienceFormNode" + UUID.randomUUID().toString());
			formArticleNode.setPrimaryType("nt:unstructured");
			formArticleNode.setProperty("cq:distribute", true);
			formArticleNode.setProperty("businessName", businessName);
			formArticleNode.setProperty("location", location);
			formArticleNode.setProperty("selectTerritory", selectTerritory);
			formArticleNode.setProperty("mail", mail);
			formArticleNode.setProperty("businessWebsite", businessWebsite);
			formArticleNode.setProperty("businessDescription", businessDescription);
			formArticleNode.setProperty("photoDescription", photoDescription);
			formArticleNode.setProperty("primaryCategory", primaryCategory);
			formArticleNode.setProperty("secondaryCategory", secondaryCategory);

			properties.put("Business Name ", businessName);
			properties.put("Location ", location);
			properties.put("Territory ", selectTerritory);
			properties.put("Email ", mail);
			properties.put("Business Website ", businessWebsite);
			properties.put("Business Description ", businessDescription);
			properties.put("Photo Description ", photoDescription);
			properties.put("Primary Category", primaryCategory);
			properties.put("Secondary Category", secondaryCategory);
			properties.put("Video Url", videoUrl);

			imageUpload(request, formArticleNode, session);
			session.save();

			StringBuilder mapBuilder = new StringBuilder();
			mapBuilder.append(form.getEmailBody());
			mapBuilder.append("<html><body>");
			mapBuilder.append("<br>=============Form Data =============<br>");
			for (Map.Entry<String, String> entry : properties.entrySet()) {
				mapBuilder.append("<b>" + entry.getKey() + "</b> : " + entry.getValue() + "<br>");
			}
			mapBuilder.append("</body></html>");
			LOG.info("mapBuilder : " + mapBuilder.toString());

			sendEmail(request, mapBuilder, form);
			// Zendesk
			sendZendeskEmail(request, mapBuilder, form, mail);

			response.sendRedirect(form.getRedirectUrl());
		} catch (Exception e) {
			LOG.error(e.getMessage());
		} finally {
			if (resourceResolver != null && resourceResolver.isLive()) {
				resourceResolver.close();
			}
		}
	}

	private void imageUpload(SlingHttpServletRequest request, Node formArticleNode, Session session) throws IOException {

		Map<String, RequestParameter[]> params = request.getRequestParameterMap();
		for (Map.Entry<String, RequestParameter[]> pairs : params.entrySet()) {
			key = pairs.getKey();
			RequestParameter[] pArr = pairs.getValue();
			param = pArr[0];

			if ((key.equalsIgnoreCase("upload-photo"))) {
				try {
					InputStream stream = param.getInputStream();
					contentType = getServletContext().getMimeType(param.getFileName());
					ValueFactory valueFactory = session.getValueFactory();
					contentValue = valueFactory.createBinary(stream);
					Node fileNode = formArticleNode.addNode("file", "nt:file");
					fileNode.addMixin("mix:referenceable");
					Node resourceNode = fileNode.addNode("jcr:content", "nt:resource");
					resourceNode.setProperty("jcr:mimeType", contentType);
					resourceNode.setProperty("jcr:data", contentValue);
					resourceNode.setProperty("cq:distribute", true);

				} catch (Exception e) {
					LOG.error(e.getMessage());
				}
			}
		}
	}

	private void sendEmail(SlingHttpServletRequest request, StringBuilder mapBuilder, Form form) {

		List<String> emailIdsList = form.getEmailIdsList();
		String emailSubject = form.getEmailSubject();
		for (String emailIds : emailIdsList) {
			Email email = new HtmlEmail();
			try {
				email.setSubject(emailSubject);
				email.setContent(mapBuilder.toString(), "text/html; charset=utf-8");
				email.addTo(emailIds);
				mailService.send(email);
			} catch (Exception e) {
				LOG.error("Error sending an email", e);
			}

		}
	}

	private void sendZendeskEmail(SlingHttpServletRequest request, StringBuilder mapBuilder, Form form,
		String emailAddress) {
		Email email = new HtmlEmail();
		String emailSubject = form.getEmailSubject();
		String zenDesk = form.getZenDeskEmail();
		StringBuilder zenDeskEmail = new StringBuilder();
		zenDeskEmail.append("#requester ").append(emailAddress).append("<br/>").append(mapBuilder.toString());
		try {
			email.setSubject(emailSubject);
			email.setContent(zenDeskEmail.toString(), "text/html; charset=utf-8");
			email.addTo(zenDesk);
			mailService.send(email);
		} catch (Exception e) {
			LOG.error("Error sending an email", e);
		}

	}
}
