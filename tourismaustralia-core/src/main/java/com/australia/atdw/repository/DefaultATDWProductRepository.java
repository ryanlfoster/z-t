package com.australia.atdw.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.apache.commons.lang3.StringUtils;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.jcr.resource.JcrResourceConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.australia.atdw.domain.ATDWProduct;
import com.australia.atdw.domain.ATDWProductSearchParameters;
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
import com.google.common.base.Stopwatch;

@Component(label = "ATDW Product Repository", description = "ATDW Product Repository", immediate = true)
@Service
public class DefaultATDWProductRepository implements ATDWProductRepository {
	private static final Logger LOG = LoggerFactory.getLogger(DefaultATDWProductRepository.class);
	private static final String JCR_PREFIX = "@" + NameConstants.NN_CONTENT + "/";

	@Reference
	private ResourceResolverFactory resourceResolverFactory;

	@Reference
	private QueryBuilder builder;

	@Override
	public List<ATDWProduct> search(ATDWProductSearchParameters parameters) {
		ResourceResolver resourceResolver = null;
		List<ATDWProduct> atdwProducts = new ArrayList<ATDWProduct>();
		try {
			resourceResolver = resourceResolverFactory.getAdministrativeResourceResolver(null);
			int propertyCount = 1;
			PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
			Session session = resourceResolver.adaptTo(Session.class);
			Map<String, String> queryMap = new TreeMap<String, String>();
			queryMap.put(QueryUtils.TYPE, NameConstants.NT_PAGE);
			QueryUtils.addProperty(queryMap, propertyCount, JCR_PREFIX
				+ JcrResourceConstants.SLING_RESOURCE_TYPE_PROPERTY, "tourismaustralia/components/page/atdw");
			propertyCount++;
			String path = PathUtils.ATDW_DATA_PATH;
			if (parameters.getCategory() != null) {
				path = path + "/" + parameters.getCategory().getCategory();
			}
			queryMap.put(propertyCount + QueryUtils.SEPERATOR + QueryUtils.PATH, path);
			propertyCount++;
			if (StringUtils.isNotEmpty(parameters.getText())) {
				QueryUtils.addFullText(queryMap, propertyCount, parameters.getText());
				propertyCount++;
			}
			if (StringUtils.isNotEmpty(parameters.getCity())) {
				QueryUtils.addProperty(queryMap, propertyCount, JCR_PREFIX + "city", parameters.getCity());
				propertyCount++;
			}
			if (StringUtils.isNotEmpty(parameters.getState())) {
				QueryUtils.addProperty(queryMap, propertyCount, JCR_PREFIX + "state", parameters.getState());
				propertyCount++;
			}
			if (parameters.getTags() != null && parameters.getTags().size() > 0) {
				List<Tag> tags = new ArrayList<Tag>();
				TagManager tagManager = resourceResolver.adaptTo(TagManager.class);
				for (String s : parameters.getTags()) {
					Tag t = tagManager.resolve(s);
					if (t != null) {
						tags.add(t);
					}
				}
				QueryUtils.addQueryForTags(queryMap, tags, propertyCount);
				propertyCount++;
			}

			queryMap.put(QueryUtils.OFFSET, Long.toString((parameters.getPage() - 1) * parameters.getCount()));
			queryMap.put(QueryUtils.LIMIT, Long.toString(parameters.getCount()));
			Query query = builder.createQuery(PredicateGroup.create(queryMap), session);
			SearchResult result = query.getResult();
			for (Hit hit : result.getHits()) {
				try {
					if (hit.getPath() != null) {
						Page page = pageManager.getPage(hit.getPath());
						if (page != null
							&& page.getTemplate().getPath().equals("/apps/tourismaustralia/templates/atdw")) {
							atdwProducts.add(new ATDWProduct(page));
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
		return atdwProducts;
	}

	@Override
	public void deleteOldProducts(Date updatedBefore) {
		Stopwatch stopwatch = Stopwatch.createStarted();
		LOG.info("Starting removal of old ATDW records (since {})", updatedBefore);
		ResourceResolver resourceResolver = null;
		try {
			resourceResolver = resourceResolverFactory.getAdministrativeResourceResolver(null);
			Session session = resourceResolver.adaptTo(Session.class);
			Map<String, String> queryMap = new TreeMap<String, String>();
			queryMap.put(QueryUtils.TYPE, NameConstants.NT_PAGE);
			QueryUtils.addProperty(queryMap, 1, JCR_PREFIX + JcrResourceConstants.SLING_RESOURCE_TYPE_PROPERTY,
				"tourismaustralia/components/page/atdw");
			queryMap.put(QueryUtils.PATH, PathUtils.ATDW_DATA_PATH);
			queryMap.put("daterange.property", "@jcr:content/cq:lastModified");
			queryMap.put("daterange.upperBound", Long.toString(updatedBefore.getTime()));
			Query query = builder.createQuery(PredicateGroup.create(queryMap), session);
			for (Map.Entry<String, String> e : queryMap.entrySet()) {
				LOG.debug("{}={}", e.getKey(), e.getValue());
			}
			query.setHitsPerPage(0);
			SearchResult result = query.getResult();
			LOG.info("Search returned {} stale ADTW records in {}. Removing stale records.", result.getTotalMatches(),
				result.getExecutionTime());
			for (Hit hit : result.getHits()) {
				try {
					Node node = hit.getNode();
					LOG.info("Removing {}", node.getPath());
					node.remove();
				} catch (RepositoryException e) {
					LOG.error("Removal of stale product node failed", e);
				}
			}
			session.save();
		} catch (LoginException e) {
			LOG.error("JCR login failed", e);
		} catch (Exception e) {
			LOG.error("JCR session save failed", e);
		} finally {
			if (resourceResolver != null && resourceResolver.isLive()) {
				resourceResolver.close();
			}
		}
		LOG.info("ATDW record cleanup completed in {} milliseconds", stopwatch.stop().elapsed(TimeUnit.MILLISECONDS));
	}
}
