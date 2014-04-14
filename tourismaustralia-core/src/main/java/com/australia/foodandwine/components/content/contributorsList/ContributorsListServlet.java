package com.australia.foodandwine.components.content.contributorsList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.query.Query;
import javax.jcr.query.QueryManager;
import javax.jcr.query.QueryResult;
import javax.jcr.query.Row;
import javax.jcr.query.RowIterator;
import javax.servlet.ServletException;

import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.australia.utils.PathUtils;
import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.Listener;
import com.day.cq.commons.jcr.JcrConstants;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.day.cq.wcm.foundation.Image;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;

@SlingServlet(resourceTypes = "foodandwine/components/content/contributorsList",selectors="contributors",extensions="json", methods = "POST")

public class ContributorsListServlet extends SlingAllMethodsServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4085955964503690676L;
	private static final JsonFactory FACTORY = new JsonFactory();
	private static final ObjectMapper MAPPER = new ObjectMapper();
	private final List<ContributorsListProperties> articlesList = new ArrayList<ContributorsListProperties>();
	private static final Logger LOG = LoggerFactory.getLogger(ContributorsListServlet.class);
	private static final String QUERY_STRING = "SELECT * FROM [cq:PageContent] AS s WHERE ISDESCENDANTNODE(["
		+ PathUtils.FOOD_AND_WINE_EXPERIENCES
		+ "])  and s.[cq:template] like '/apps/foodandwine/templates/articlepage'";

	@Override
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException,
		IOException {
		String searchParmeter = request.getParameter("searchParmeter");
		PageManager pageManager = request.getResourceResolver().adaptTo(PageManager.class);
		Session session = request.getResourceResolver().adaptTo(Session.class);

		try {
			QueryManager queryManager = session.getWorkspace().getQueryManager();

			Query query = queryManager.createQuery(String.format(QUERY_STRING), Query.JCR_SQL2);
			QueryResult result = query.execute();
			NodeIterator nodeIterator = result.getNodes();

			while (nodeIterator.hasNext() && null != nodeIterator) {
				ContributorsListProperties contributorsListProperties = new ContributorsListProperties();
				Node nextNode = nodeIterator.nextNode();
				String businessName = nextNode.getProperty(JcrConstants.JCR_TITLE).getValue().getString();
				contributorsListProperties.setBusinessName(businessName);
				if (nextNode.hasNode("map")) {
					Node node = nextNode.getNode("map");
					String state = node.getProperty("state").getValue().getString();
					String businessWebsite = node.getProperty("website").getValue().getString();
					contributorsListProperties.setBusinessWebsite(businessWebsite);
					contributorsListProperties.setState(state);
				}
				articlesList.add(contributorsListProperties);

			}
		} catch (RepositoryException e) {
			LOG.error("Error using query manager", e);
		}

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		JsonGenerator generator = FACTORY.createGenerator(response.getWriter());
		MAPPER.writeValue(generator, articlesList);
		articlesList.clear();
	}

}
