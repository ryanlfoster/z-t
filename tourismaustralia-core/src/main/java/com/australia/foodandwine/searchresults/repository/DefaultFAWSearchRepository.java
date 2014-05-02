package com.australia.foodandwine.searchresults.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.apache.commons.lang3.StringUtils;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.jcr.resource.JcrResourceConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.australia.atdw.repository.DefaultATDWProductRepository;
import com.australia.foodandwine.searchresults.domain.FAWSearch;
import com.australia.foodandwine.searchresults.domain.FAWSearchParameters;
import com.australia.foodandwine.searchresults.domain.FAWSearchResult;
import com.australia.utils.PathUtils;
import com.australia.utils.QueryUtils;
import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.Hit;
import com.day.cq.search.result.SearchResult;
import com.day.cq.tagging.Tag;
import com.day.cq.tagging.TagManager;
import com.day.cq.wcm.api.NameConstants;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

@Component(label = "Food and Wine Search Repository", description = "Food and Wine Search Repository", immediate = true)
@Service
public class DefaultFAWSearchRepository implements FAWSearchRepository {

	private static final Logger LOG = LoggerFactory.getLogger(DefaultATDWProductRepository.class);
	private static final String JCR_PREFIX = "@" + NameConstants.NN_CONTENT + "/";

	@Reference
	private ResourceResolverFactory resourceResolverFactory;

	@Reference
	private QueryBuilder builder;

	@Override
	public FAWSearchResult search(FAWSearchParameters parameters) {
		ResourceResolver resourceResolver = null;
		SearchResult result = null;
		List<FAWSearch> fawSearchesList = new ArrayList<FAWSearch>();
		try {
			resourceResolver = resourceResolverFactory.getAdministrativeResourceResolver(null);
			TagManager tagManager = resourceResolver.adaptTo(TagManager.class);
			int propertyCount = 1;
			PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
			Session session = resourceResolver.adaptTo(Session.class);
			Map<String, String> queryMap = new TreeMap<String, String>();
			queryMap.put(QueryUtils.TYPE, NameConstants.NT_PAGE);

			queryMap.put("1_property", JCR_PREFIX + JcrResourceConstants.SLING_RESOURCE_TYPE_PROPERTY);
			queryMap.put("1_property.1_value", "foodandwine/components/page/articlepage");
			queryMap.put("1_property.2_value", "foodandwine/components/page/instagrampage");
			queryMap.put("1_property.3_value", "foodandwine/components/page/facebookpage");
			queryMap.put("1_property.4_value", "foodandwine/components/page/twitterpage");
			propertyCount++;

			String path = PathUtils.FOOD_AND_WINE_ROOT_PATH;
			queryMap.put(propertyCount + QueryUtils.SEPERATOR + QueryUtils.PATH, path);
			propertyCount++;
			if (StringUtils.isNotEmpty(parameters.getText())) {
				QueryUtils.addFullText(queryMap, propertyCount, parameters.getText());
				propertyCount++;
			}
			if (parameters.getTags() != null && parameters.getTags().size() > 0) {
				List<Tag> tags = new ArrayList<Tag>();
				for (String s : parameters.getTags()) {
					Tag t = tagManager.resolve(s);
					if (t != null) {
						tags.add(t);
					}
				}
				QueryUtils.addQueryForTags(queryMap, tags, propertyCount);
				propertyCount++;
			}

			if (StringUtils.isNotEmpty(parameters.getPlace())) {
				QueryUtils.addProperty(queryMap, propertyCount, JCR_PREFIX + "cq:tags", parameters.getPlace() + "%");
				QueryUtils.setPropertyAsLike(queryMap, propertyCount);
				propertyCount++;
			}

			queryMap.put(QueryUtils.ORDER_BY, JCR_PREFIX + "jcr:title");
			queryMap.put(QueryUtils.ORDER_BY_SORT, QueryUtils.ASC);

			queryMap.put(QueryUtils.OFFSET, Long.toString((parameters.getPage() - 1) * parameters.getCount()));
			queryMap.put(QueryUtils.LIMIT, Long.toString(parameters.getPage() * parameters.getCount()));
			Query query = builder.createQuery(PredicateGroup.create(queryMap), session);
			result = query.getResult();
			long totalMatches = result.getTotalMatches();
			for (Hit hit : result.getHits()) {
				try {
					if (hit.getPath() != null) {
						Page page = pageManager.getPage(hit.getPath());
						if (page != null) {
							fawSearchesList.add(new FAWSearch(totalMatches, page, tagManager));
						}
					}
				} catch (RepositoryException e) {
					LOG.error("Error creating story", e);
				}
			}
			return new FAWSearchResult(fawSearchesList, totalMatches, parameters.getPage());

		} catch (Exception e) {
			LOG.error("Error searching for ATDW Products", e);
		} finally {
			if (resourceResolver != null && resourceResolver.isLive()) {
				resourceResolver.close();
			}
		}
		return null;
	}

}
