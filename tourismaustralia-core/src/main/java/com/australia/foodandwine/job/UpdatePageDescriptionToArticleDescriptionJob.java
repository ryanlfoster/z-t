package com.australia.foodandwine.job;

import java.io.IOException;
import java.io.PrintWriter;

import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.Session;
import javax.jcr.query.Query;
import javax.jcr.query.QueryManager;
import javax.jcr.query.QueryResult;
import javax.servlet.ServletException;

import org.apache.commons.lang.StringUtils;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.settings.SlingSettingsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.australia.utils.PathUtils;
import com.day.cq.commons.jcr.JcrConstants;

@SlingServlet(paths = "/bin/updatepagedescription/run", extensions = ".html", methods = "GET")
public class UpdatePageDescriptionToArticleDescriptionJob extends SlingAllMethodsServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4262321069161089308L;
	private static final Logger LOG = LoggerFactory.getLogger(UpdatePageDescriptionToArticleDescriptionJob.class);
	private static final String QUERY_STRING = "SELECT * FROM [cq:PageContent] AS s WHERE ISDESCENDANTNODE(["
		+ PathUtils.FOOD_AND_WINE_EXPERIENCES
		+ "])  AND [cq:template] like '%/apps/foodandwine/templates/articlepage%'";

	@Reference
	private SlingSettingsService slingSettings;

	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException,
		IOException {
		PrintWriter out = response.getWriter();
		try {
			Session session = request.getResourceResolver().adaptTo(Session.class);
			QueryManager queryManager = session.getWorkspace().getQueryManager();
			Query query = queryManager.createQuery(QUERY_STRING, Query.JCR_SQL2);
			QueryResult result = query.execute();
			NodeIterator nodeIterator = result.getNodes();

			while (nodeIterator != null && nodeIterator.hasNext()) {
				Node nextNode = nodeIterator.nextNode();
				if (nextNode.hasProperty(JcrConstants.JCR_DESCRIPTION)) {
					String jcrDescription = nextNode.getProperty(JcrConstants.JCR_DESCRIPTION).getValue().getString();
					if (!nextNode.hasProperty("articleDescription") && !jcrDescription.equals(StringUtils.EMPTY)) {
						nextNode.setProperty("articleDescription", jcrDescription);
					}
				}
			}
			session.save();
			out.print("Page Description value has been updated to Article Description");
		} catch (Exception e) {
			LOG.error("Error updating pageDescription", e);
			out.print("Some Error Occured while trying to update page description");
		}
	}

}
