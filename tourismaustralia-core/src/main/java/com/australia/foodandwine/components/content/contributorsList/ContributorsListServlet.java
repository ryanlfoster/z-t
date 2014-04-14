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

	@Override
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException,
		IOException {
		String searchParmeter = request.getParameter("searchParameter");

		artileMap.clear();
		Session session = request.getResourceResolver().adaptTo(Session.class);
		if (!(searchParmeter.equals(""))) {
			String QUERY_STRING = "SELECT * FROM [cq:PageContent] AS s WHERE ISDESCENDANTNODE(["
				+ PathUtils.FOOD_AND_WINE_EXPERIENCES
				+ "])  and s.[cq:template] like '/apps/foodandwine/templates/articlepage' and s.[jcr:title] like '"
				+ searchParmeter + "%' ";
			contributersListQueryManager(session, QUERY_STRING);
		} else {
			// String QUERY_STRING =
			// "SELECT * FROM [cq:PageContent] AS s WHERE ISDESCENDANTNODE(["
			// + PathUtils.FOOD_AND_WINE_EXPERIENCES
			// +
			// "])  and s.[cq:template] like '/apps/foodandwine/templates/articlepage' ";
			// contributersListQueryManager(session, QUERY_STRING);
			onLoadContributorsList(request);
		}
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		JsonGenerator generator = FACTORY.createGenerator(response.getWriter());
		MAPPER.writeValue(generator, artileMap);

	}

	private void contributersListQueryManager(Session session, String QUERY_STRING) {
		try {
			QueryManager queryManager = session.getWorkspace().getQueryManager();
			Query query = queryManager.createQuery(QUERY_STRING, Query.JCR_SQL2);
			QueryResult result = query.execute();
			NodeIterator nodeIterator = result.getNodes();
			articlesList = new ArrayList<ContributorsListProperties>();
			while (nodeIterator.hasNext() && null != nodeIterator) {
				ContributorsListProperties contributorsListProperties = new ContributorsListProperties();
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
					articlesList.add(contributorsListProperties);
					artileMap.put(alphabet, articlesList);
				}

			}
		} catch (RepositoryException e) {
			LOG.error("Error using query manager", e);
		}

	}

	private void onLoadContributorsList(SlingHttpServletRequest request) {

		Page page = request.getResourceResolver().resolve(PathUtils.FOOD_AND_WINE_EXPERIENCES).adaptTo(Page.class);
		Iterator<Page> listChildren = page.listChildren();
		while (listChildren.hasNext()) {
			Page next = listChildren.next();
			String alphanet = next.getTitle();
			Iterator<Page> articlePages = next.listChildren();
			articlesList = new ArrayList<ContributorsListProperties>();
			while (articlePages.hasNext()) {
				ContributorsListProperties contributorsListProperties = new ContributorsListProperties();
				Page articlePage = articlePages.next();
				String businessName = articlePage.getTitle();
				contributorsListProperties.setBusinessName(businessName);
				Node node = request.getResourceResolver().resolve(articlePage.getPath()).adaptTo(Node.class);
				Node mapNode, jcrNode;
				try {
					jcrNode = node.getNode(JcrConstants.JCR_CONTENT);
					if (jcrNode.hasProperty("primaryCategory")) {
						String primaryCategory = jcrNode.getProperty("primaryCategory").getValue().getString();
						contributorsListProperties.setPrimaryCategory(primaryCategory);
					}
					mapNode = jcrNode.getNode("map");
					if (mapNode.hasProperty("state")) {
						String state = mapNode.getProperty("state").getValue().getString();
						contributorsListProperties.setState(state);
					}
					if (mapNode.hasProperty("website")) {
						String website = mapNode.getProperty("website").getValue().getString();
						contributorsListProperties.setBusinessWebsite(website);
					}
					char charAt = businessName.charAt(0);
					String charecter = Character.toString(charAt);
					if (alphanet.equalsIgnoreCase(charecter)) {
						articlesList.add(contributorsListProperties);
					}

				} catch (PathNotFoundException e) {
					e.printStackTrace();
				} catch (RepositoryException e) {
					e.printStackTrace();
				}
			}
			if (!(articlesList.isEmpty())) {
				artileMap.put(alphanet, articlesList);
			}
		}
	}
}
