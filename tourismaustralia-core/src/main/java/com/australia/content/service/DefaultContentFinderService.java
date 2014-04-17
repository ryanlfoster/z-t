package com.australia.content.service;

import com.australia.content.model.Content;
import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.Hit;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.jcr.api.SlingRepository;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component(label = "Content Finder Service", immediate = true, metatype = true)
@Service(value = ContentFinderService.class)
public class DefaultContentFinderService implements ContentFinderService {

	private static final String DEFAULT_PATH = "/content";

	@Reference
	private SlingRepository repository;

	@Reference
	private QueryBuilder queryBuilder;

	@Override public final List<Content> findContent(final String path, final String tagId, final String templateType,
		int limit)
		throws ContentFinderException {

		final List<Content> out = new ArrayList<Content>();

		Session session = null;
		try {

			final String defaultWorkspace = repository.getDefaultWorkspace();
			session = repository.loginAdministrative(defaultWorkspace);

			final Map<String, String> predicateMap = new HashMap<String, String>();
			predicateMap.put("type", "cq:Page");

			if (tagId != null) {
				predicateMap.put("tagid", tagId);
				predicateMap.put("tagid.property", "jcr:content/cq:tags");
			}

			if (templateType != null) {
				predicateMap.put("property", "jcr:content/cq:template");
				predicateMap.put("property.value", templateType);
			}

			predicateMap.put("path", path != null ? path : DEFAULT_PATH);

			final PredicateGroup predicates = PredicateGroup.create(predicateMap);

			final Query query = queryBuilder.createQuery(predicates, session);
			query.setHitsPerPage(limit >= 0 ? limit : 0);

			final List<Hit> hits = query.getResult().getHits();
			for (final Hit hit: hits) {
				out.add(Content.fromResource(hit.getResource()));
			}

			session.save();

		} catch (RepositoryException e) {

			throw new ContentFinderException("Failed to find requested content", e);

		} finally {

			if (session != null && session.isLive()) {
				session.logout();
			}

		}

		return out;
	}
}
