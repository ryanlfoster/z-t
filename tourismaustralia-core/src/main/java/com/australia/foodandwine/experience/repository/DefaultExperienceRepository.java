package com.australia.foodandwine.experience.repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
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
import com.australia.foodandwine.experience.domain.Experience;
import com.australia.foodandwine.experience.domain.ExperienceSearchParameters;
import com.australia.foodandwine.experience.domain.ExperienceSearchResult;
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

@Component(label = "Food and Wine Experience Repository", description = "Food and Wine Experience Repository", immediate = true)
@Service
public class DefaultExperienceRepository implements ExperienceRepository {

	private static final Logger LOG = LoggerFactory.getLogger(DefaultATDWProductRepository.class);
	private static final String JCR_PREFIX = "@" + NameConstants.NN_CONTENT + "/";
	private static final String EXPERIENCE_RESOURCE_TYPE = "foodandwine/components/page/articlepage";
	private Map<String, List<Experience>> articleMap;
	private List<Experience> experiences;
	@Reference
	private ResourceResolverFactory resourceResolverFactory;
	private SearchResult result;
	@Reference
	private QueryBuilder builder;

	private void addToMap(String alphabet, Page page, TagManager tagManager) {
		Experience experience = new Experience(page, tagManager);

		if (articleMap.containsKey(alphabet)) {
			articleMap.get(alphabet).add(experience);

		} else {
			experiences = new ArrayList<Experience>();
			experiences.add(new Experience(page, tagManager));
			articleMap.put(alphabet, experiences);

		}

	}

	public ExperienceSearchResult search(ExperienceSearchParameters parameters) {
		ResourceResolver resourceResolver = null;
		articleMap = new LinkedHashMap<String, List<Experience>>();
		// experiences.clear();
		try {
			resourceResolver = resourceResolverFactory.getAdministrativeResourceResolver(null);
			TagManager tagManager = resourceResolver.adaptTo(TagManager.class);
			int propertyCount = 1;
			PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
			Session session = resourceResolver.adaptTo(Session.class);
			Map<String, String> queryMap = new TreeMap<String, String>();
			queryMap.put(QueryUtils.TYPE, NameConstants.NT_PAGE);
			QueryUtils.addProperty(queryMap, propertyCount, JCR_PREFIX
				+ JcrResourceConstants.SLING_RESOURCE_TYPE_PROPERTY, EXPERIENCE_RESOURCE_TYPE);
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
			queryMap.put(QueryUtils.ORDER_BY, JCR_PREFIX + "jcr:title");
			if (parameters.getSort() != null && QueryUtils.ASC.equals(parameters.getSort().getSort())) {
				queryMap.put(QueryUtils.ORDER_BY_SORT, QueryUtils.ASC);
			} else {
				queryMap.put(QueryUtils.ORDER_BY_SORT, QueryUtils.DESC);
			}
			queryMap.put(QueryUtils.OFFSET, Long.toString((parameters.getPage() - 1) * parameters.getCount()));
			queryMap.put(QueryUtils.LIMIT, Long.toString(parameters.getCount()));
			Query query = builder.createQuery(PredicateGroup.create(queryMap), session);
			result = query.getResult();
			for (Hit hit : result.getHits()) {
				try {
					if (hit.getPath() != null) {
						Page page = pageManager.getPage(hit.getPath());
						if (page != null
							&& page.getTemplate().getPath().equals("/apps/foodandwine/templates/articlepage")) {
							String alphabet = StringUtils.EMPTY;
							String articleTitle = StringUtils.EMPTY;
							try {
								articleTitle = page.getTitle();
							} catch (NullPointerException e) {
							}
							if (articleTitle.equals(StringUtils.EMPTY) || null != articleTitle) {
								articleTitle = page.getParent().getName();
							}
							try {
								alphabet = page.getParent().getTitle();
							} catch (NullPointerException e) {
								LOG.error("Error trying to get Parent Page Title", e);
							}
							if (alphabet.equals(StringUtils.EMPTY) || null != alphabet) {
								alphabet = page.getParent().getName();
							}
							char charAt = articleTitle.charAt(0);
							String charecter = Character.toString(charAt);
							if (alphabet.equalsIgnoreCase(charecter)) {
								addToMap(alphabet, page, tagManager);
							}
						}
					}
				} catch (RepositoryException e) {
					LOG.error("Error creating story", e);
				}
			}
		} catch (Exception e) {
			LOG.error("Error searching for ATDW Products", e);
		} finally {
			if (resourceResolver != null && resourceResolver.isLive()) {
				resourceResolver.close();
			}
		}
		return new ExperienceSearchResult(experiences, articleMap, result.getTotalMatches(), parameters.getPage());
	}
}
