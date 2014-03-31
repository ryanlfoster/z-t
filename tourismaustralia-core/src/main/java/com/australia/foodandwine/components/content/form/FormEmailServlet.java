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
import org.apache.sling.api.resource.ModifiableValueMap;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.australia.utils.PathUtils;
import com.day.cq.mailer.MailService;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

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

	@Override
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException,
		IOException {
		ResourceResolver resourceResolver = null;
		try {
			resourceResolver = resourceResovlerFactory.getAdministrativeResourceResolver(null);
			PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
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
			String phoneNumber = request.getParameter("phone-number");

			Page userGeneratedPage = pageManager.create(PathUtils.FOOD_AND_WINE_USER_GENERATED, null, null,
				"experience-" + UUID.randomUUID().toString(), true);

			Resource userGeneratedPageContentResource = userGeneratedPage.getContentResource();
			ModifiableValueMap contentProperties = userGeneratedPageContentResource.adaptTo(ModifiableValueMap.class);

			contentProperties.put("businessName", businessName);
			contentProperties.put("location", location);
			contentProperties.put("selectTerritory", selectTerritory);
			contentProperties.put("mail", mail);
			contentProperties.put("businessWebsite", businessWebsite);
			contentProperties.put("businessDescription", businessDescription);
			contentProperties.put("photoDescription", photoDescription);
			contentProperties.put("primaryCategory", primaryCategory);
			contentProperties.put("secondaryCategory", secondaryCategory);
			contentProperties.put("cq:distribute", true);
			contentProperties.put("phoneNumber", phoneNumber);

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
			properties.put("Phone Number", phoneNumber);

			imageUpload(request, userGeneratedPageContentResource, resourceResolver.adaptTo(Session.class));
			resourceResolver.commit();

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

			response.sendRedirect(resourceResolver.map(form.getRedirectUrl()));
		} catch (Exception e) {
			LOG.error(e.getMessage());
		} finally {
			if (resourceResolver != null && resourceResolver.isLive()) {
				resourceResolver.close();
			}
		}
	}

	private void imageUpload(SlingHttpServletRequest request, Resource contentResource, Session session)
		throws IOException {

		Map<String, RequestParameter[]> params = request.getRequestParameterMap();
		for (Map.Entry<String, RequestParameter[]> pairs : params.entrySet()) {
			String key = pairs.getKey();
			RequestParameter[] pArr = pairs.getValue();
			RequestParameter param = pArr[0];
			Node formArticleNode = contentResource.adaptTo(Node.class);
			if ((key.equalsIgnoreCase("upload-photo"))) {
				try {
					InputStream stream = param.getInputStream();
					String contentType = getServletContext().getMimeType(param.getFileName());
					ValueFactory valueFactory = session.getValueFactory();
					Binary contentValue = valueFactory.createBinary(stream);
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
