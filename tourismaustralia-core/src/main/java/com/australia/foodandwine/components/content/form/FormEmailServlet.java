package com.australia.foodandwine.components.content.form;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.jcr.Binary;
import javax.jcr.Node;
import javax.jcr.Session;
import javax.jcr.ValueFactory;
import javax.servlet.ServletException;

import org.apache.commons.mail.HtmlEmail;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.request.RequestParameter;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.dam.api.Asset;
import com.day.cq.dam.api.AssetManager;
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
			Map<String, String> properties = new LinkedHashMap<String, String>();
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
			String videoUrl = request.getParameter("videoUrl");

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

			properties.put("Business Name ", businessName);
			properties.put("Location ", location);
			properties.put("Territory ", selectTerritory);
			properties.put("Email ", mail);
			properties.put("Business Website ", businessWebsite);
			properties.put("Business Description ", businessDescription);
			properties.put("Photo Description ", photoDescription);

			if (categoryRestaurants != null) {
				formArticleNode.setProperty("categoryRestaurants", categoryRestaurants);
				properties.put("Category Restaurants", categoryRestaurants);
			}
			if (categoryWine != null) {
				formArticleNode.setProperty("categoryWine", categoryWine);
				properties.put("Category Wine ", categoryWine);
			}
			if (categoryProduce != null) {
				formArticleNode.setProperty("categoryProduce", categoryProduce);
				properties.put("Category Produce ", categoryProduce);
			}
			if (categoryEvents != null) {
				formArticleNode.setProperty("categoryEvents", categoryEvents);
				properties.put("Category Events ", categoryEvents);
			}
			if (categoryPeople != null) {
				formArticleNode.setProperty("categoryPeople", categoryPeople);
				properties.put("Category People ", categoryPeople);
			}
			if (categorExperiences != null) {
				formArticleNode.setProperty("categorExperiences", categorExperiences);
				properties.put("Categor Experiences ", categorExperiences);
			}
			if (categorySeafood != null) {
				formArticleNode.setProperty("categorySeafood", categorySeafood);
				properties.put("Category Seafood ", categorySeafood);
			}
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
			sendEmail(request, emailCheck, mapBuilder, form);
			response.sendRedirect(form.getRedirectUrl());
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
	}

	private void imageUpload(SlingHttpServletRequest request, Node formArticleNode, Session session) throws IOException {

		Map<String, RequestParameter[]> params = request.getRequestParameterMap();
		String imageNodePath=null;
		try{
		imageNodePath = formArticleNode.addNode("image","sling:OrderedFolder").getPath();
		}catch(Exception e){
			
			
		}
		for (Map.Entry<String, RequestParameter[]> pairs : params.entrySet()) {
			key = pairs.getKey();
			RequestParameter[] pArr = pairs.getValue();
			param = pArr[0];

			if ((key.equalsIgnoreCase("upload-photo"))) {
				try {
					InputStream stream = param.getInputStream();
					LOG.info("Stream  form servlet "+stream);
					//contentType=param.getFileName().toString();
					LOG.info("Contet type of form servlet "+contentType);
//					if (param.getFileName().endsWith(".jpeg")) {
//						contentType = "image/jpeg";
//					}
//					if (param.getFileName().endsWith(".png")) {
//						contentType = "image/png";
//					}
//					if (param.getFileName().endsWith(".jpg")) {
//						contentType = "image/jpg";
//					}

//					ValueFactory valueFactory = session.getValueFactory();
//					contentValue = valueFactory.createBinary(stream);
//					Node fileNode = formArticleNode.addNode("file", "nt:file");
//					fileNode.addMixin("mix:referenceable");
//					Node resourceNode = fileNode.addNode("jcr:content", "nt:resource");
//					resourceNode.setProperty("jcr:mimeType", "image/png");
//					resourceNode.setProperty("jcr:data", contentValue);
//					resourceNode.setProperty("cq:distribute", true);
					
					AssetManager assetManager = request.getResourceResolver().adaptTo(AssetManager.class);
					Asset asset = assetManager.createAsset(imageNodePath+"/imageFile", stream, "image/png", true);
					
					String path = asset.getOriginal().getPath();
					LOG.info("path : : " + path);
				} catch (Exception e) {
					LOG.error(e.getMessage());
				}
			}
		}
	}

	private void sendEmail(SlingHttpServletRequest request, boolean emailCheck, StringBuilder mapBuilder, Form form) {

		List<String> emailIdsList = form.getEmailIdsList();
		String emailSubject = form.getEmailSubject();
		for (String emailIds : emailIdsList) {
			if (emailCheck) {
				try {
					final HtmlEmail email = new HtmlEmail();
					email.setSubject(emailSubject);
					email.setContent(mapBuilder.toString(), "text/html; charset=utf-8");
					email.addTo(emailIds);
					mailService.send(email);
				} catch (Exception e) {
					LOG.error("Error sending an email", e);
				}
			}
		}
	}
}
