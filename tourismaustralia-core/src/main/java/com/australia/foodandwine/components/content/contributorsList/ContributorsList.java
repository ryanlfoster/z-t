package com.australia.foodandwine.components.content.contributorsList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;

import org.apache.sling.api.SlingHttpServletRequest;

import com.australia.utils.LinkUtils;
import com.australia.utils.PathUtils;
import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.Listener;
import com.day.cq.commons.jcr.JcrConstants;
import com.day.cq.wcm.api.Page;

@Component(disableTargeting = true, group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", name = "contributorsList", value = "Contributers List", listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class ContributorsList {
	private List<ContributorsListProperties> articlesList;
	private Map<String, List<ContributorsListProperties>> artileMap = new LinkedHashMap<String, List<ContributorsListProperties>>();

	public ContributorsList(SlingHttpServletRequest request) {
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
				Node node2;
				try {
					node2 = node.getNode(JcrConstants.JCR_CONTENT).getNode("map");
					if (node2.hasProperty("state")) {
						String state = node2.getProperty("state").getValue().getString();
						contributorsListProperties.setState(state);
					}
					if (node2.hasProperty("website")) {
						String website = node2.getProperty("website").getValue().getString();
						contributorsListProperties.setBusinessWebsite(website);
					}
					char charAt = businessName.charAt(0);
					String charecter = Character.toString(charAt);
					
					
					if(alphanet.equalsIgnoreCase(charecter)){
					articlesList.add(contributorsListProperties);
					}
				} catch (PathNotFoundException e) {
					e.printStackTrace();
				} catch (RepositoryException e) {
					e.printStackTrace();
				}
			}
			if(!(articlesList.isEmpty())){
			artileMap.put(alphanet, articlesList);
			}
		}
	}

	public Map<String, List<ContributorsListProperties>> getArtileMap() {
		return artileMap;
	}

}
