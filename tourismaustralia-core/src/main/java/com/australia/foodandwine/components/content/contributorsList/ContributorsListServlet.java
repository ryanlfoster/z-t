package com.australia.foodandwine.components.content.contributorsList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.query.InvalidQueryException;
import javax.jcr.query.Query;
import javax.jcr.query.QueryManager;
import javax.jcr.query.QueryResult;
import javax.servlet.ServletException;

import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.australia.utils.PathUtils;
import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.Listener;
import com.day.cq.commons.jcr.JcrConstants;
import com.day.cq.wcm.api.Page;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component(disableTargeting = true, group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", name = "contributorsList", value = "Contributers List", listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
@SlingServlet(resourceTypes = "foodandwine/components/content/contributorsList", selectors = "contributors", extensions = "json", methods = "POST")
public class ContributorsListServlet extends SlingAllMethodsServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4085955964503690676L;
	private static final JsonFactory FACTORY = new JsonFactory();
	private static final ObjectMapper MAPPER = new ObjectMapper();
	private List<ContributorsListProperties> articlesList;
	private Map<String, List<ContributorsListProperties>> artileMap = new LinkedHashMap<String, List<ContributorsListProperties>>();
	private static final Logger LOG = LoggerFactory.getLogger(ContributorsListServlet.class);
	private int size, pageCount;

	@Override
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException,
		IOException {
		String searchParmeter = request.getParameter("searchParameter");
		String offsetValue = request.getParameter("offsetValue");
		String limitValue = request.getParameter("limitValue");
		int offset = Integer.parseInt(offsetValue);
		int limit = Integer.parseInt(limitValue);
		Session session = request.getResourceResolver().adaptTo(Session.class);
		try {
			if (!(searchParmeter.equals(""))) {
				String QUERY_STRING = "SELECT * FROM [cq:PageContent] AS s WHERE ISDESCENDANTNODE(["
					+ PathUtils.FOOD_AND_WINE_EXPERIENCES
					+ "])  and s.[cq:template] like '/apps/foodandwine/templates/articlepage' and s.[jcr:title] like '"
					+ searchParmeter + "%' ";
				size = getArticleSize(session, QUERY_STRING);
				if (size > 20) {
					pageCount = size / 20;
				} else {
					pageCount = 1;
				}
				contributersListQueryManager(session, QUERY_STRING, offset, limit);
			} else {
				String QUERY_STRING = "SELECT * FROM [cq:PageContent] AS s WHERE ISDESCENDANTNODE(["
					+ PathUtils.FOOD_AND_WINE_EXPERIENCES
					+ "])  and s.[cq:template] like '/apps/foodandwine/templates/articlepage' ";
				size = getArticleSize(session, QUERY_STRING);
				if (size > 20) {
					pageCount = size / 20;
				} else {
					pageCount = 1;
				}
				contributersListQueryManager(session, QUERY_STRING, offset, limit);
			}
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			JsonGenerator generator = FACTORY.createGenerator(response.getWriter());
			MAPPER.writeValue(generator, artileMap);
			artileMap.clear();
		} catch (RepositoryException e) {
			e.printStackTrace();
		}
	}

	private void contributersListQueryManager(Session session, String QUERY_STRING, int offset, int limit) {
		try {
			QueryManager queryManager = session.getWorkspace().getQueryManager();
			Query query = queryManager.createQuery(QUERY_STRING, Query.JCR_SQL2);
			query.setOffset(offset);
			query.setLimit(limit);
			QueryResult result = query.execute();
			NodeIterator nodeIterator = result.getNodes();
			while (nodeIterator.hasNext() && null != nodeIterator) {
				ContributorsListProperties contributorsListProperties = new ContributorsListProperties();
				contributorsListProperties.setArtileCount(size);
				contributorsListProperties.setPageCount(pageCount);
				Node nextNode = nodeIterator.nextNode();
				String alphabet = nextNode.getParent().getParent().getNode(JcrConstants.JCR_CONTENT)
					.getProperty(JcrConstants.JCR_TITLE).getValue().getString();
				String businessName = nextNode.getProperty(JcrConstants.JCR_TITLE).getValue().getString();
				contributorsListProperties.setBusinessName(businessName);
				if (nextNode.hasNode("map")) {
					Node node = nextNode.getNode("map");
					String state = node.getProperty("state").getValue().getString();
					String businessWebsite = node.getProperty("website").getValue().getString();
					contributorsListProperties.setBusinessWebsite(businessWebsite);
					contributorsListProperties.setState(state);
				}
				char charAt = businessName.charAt(0);
				String charecter = Character.toString(charAt);
				if (alphabet.equalsIgnoreCase(charecter)) {
					addToMap(alphabet, contributorsListProperties);
				}
			}

		} catch (RepositoryException e) {
			LOG.error("Error using query manager", e);
		}
	}

	private void addToMap(String key, ContributorsListProperties contributorsListProperties) {

		if (artileMap.containsKey(key)) {
			artileMap.get(key).add(contributorsListProperties);
		} else {
			articlesList = new ArrayList<ContributorsListProperties>();
			articlesList.add(contributorsListProperties);
			artileMap.put(key, articlesList);
		}
	}

	private int getArticleSize(Session session, String QUERY_STRING) throws InvalidQueryException, RepositoryException {
		QueryManager queryManager = session.getWorkspace().getQueryManager();
		Query query = queryManager.createQuery(QUERY_STRING, Query.JCR_SQL2);
		QueryResult result = query.execute();
		NodeIterator nodeIterator = result.getNodes();
		int size = (int) nodeIterator.getSize();
		return size;

	}
}
