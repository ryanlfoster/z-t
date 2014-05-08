package com.australia.content.service;

import com.australia.content.domain.Content;
import com.australia.content.domain.ContentSearchParameters;
import com.australia.content.domain.ContentSearchResult;
import com.australia.content.domain.ContentType;
import com.australia.utils.QueryUtils;
import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.Hit;
import com.day.cq.search.result.SearchResult;
import com.day.cq.tagging.Tag;
import com.day.cq.tagging.TagManager;
import org.apache.commons.lang3.StringUtils;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.jcr.api.SlingRepository;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component(label = "Content Search Service", immediate = true, metatype = true)
@Service(value = ContentSearchService.class)
public class DefaultContentSearchService implements ContentSearchService {

	@Reference
	private SlingRepository repository;

	@Reference
	private QueryBuilder queryBuilder;

	@Reference
	private ResourceResolverFactory resourceResolverFactory;

	@Override
	public final ContentSearchResult search(ContentSearchParameters parameters)
		throws ContentSearchException {

		final List<Content> out = new ArrayList<Content>();
		long totalResultCount = 0;
		Session session = null;
		try {

			final String defaultWorkspace = repository.getDefaultWorkspace();
			session = repository.loginAdministrative(defaultWorkspace);
			ResourceResolver resourceResolver = resourceResolverFactory.getAdministrativeResourceResolver(null);

			final Map<String, String> predicateMap = new HashMap<String, String>();
			predicateMap.put("type", "cq:Page");

			if (parameters.getLanguagePath() != null) {
				predicateMap.put(QueryUtils.PATH, parameters.getLanguagePath());
			}

			int propertyCount = 1;

			if (StringUtils.isNotEmpty(parameters.getText())) {
				QueryUtils.addFullText(predicateMap, propertyCount, parameters.getText());
				propertyCount++;
			}

			if (parameters.getTags() != null && parameters.getTags().size() > 0) {
				TagManager tagManager = resourceResolver.adaptTo(TagManager.class);
				List<Tag> tags = new ArrayList<Tag>();
				for (String s : parameters.getTags()) {
					Tag t = tagManager.resolve(s);
					if (t != null) {
						tags.add(t);
					}
				}
				QueryUtils.addQueryForTags(predicateMap, tags, propertyCount++);
			}

			if (parameters.getContentType() != null) {
				predicateMap.put("property", "jcr:content/@cq:template");
				predicateMap.put("property.value", parameters.getContentType().getTemplate());
			} else {
				QueryUtils.addProperty(predicateMap, propertyCount++, "jcr:content/@cq:template",
					ContentType.allTemplates());
			}

			// Either removeFromSearch property doesn't exist, or it exists but is not equal to true
			String groupPrefix = propertyCount + "_group.";
			String groupProp1Prefix = groupPrefix + "1_property";
			String groupProp2Prefix = groupPrefix + "2_property";
			String removeFromSearchPropName = "jcr:content/removeFromSearch";
			predicateMap.put(groupPrefix + "p.or", "true");
			predicateMap.put(groupProp1Prefix, removeFromSearchPropName);
			predicateMap.put(groupProp1Prefix + ".operation", "unequals");
			predicateMap.put(groupProp1Prefix + ".value", "true");
			predicateMap.put(groupProp2Prefix, removeFromSearchPropName);
			predicateMap.put(groupProp2Prefix + ".operation", "exists");
			predicateMap.put(groupProp2Prefix + ".value", "false");

			predicateMap.put(QueryUtils.OFFSET, Long.toString((parameters.getPage() - 1) * parameters.getCount()));
			predicateMap.put(QueryUtils.LIMIT, Long.toString(parameters.getCount()));

			final PredicateGroup predicates = PredicateGroup.create(predicateMap);

			final Query query = queryBuilder.createQuery(predicates, session);
			final SearchResult searchResult = query.getResult();
			totalResultCount = searchResult.getTotalMatches();
			final List<Hit> hits = searchResult.getHits();
			for (final Hit hit: hits) {
				out.add(Content.fromResource(hit.getResource()));
			}

		} catch (RepositoryException e) {

			throw new ContentSearchException("Failed to find requested content", e);

		} catch (LoginException e) {

			throw new ContentSearchException("Failed to find requested content", e);

		} finally {

			if (session != null && session.isLive()) {
				session.logout();
			}

		}

		return new ContentSearchResult(totalResultCount, out);
	}
}
