package com.australia.foodandwine.searchresults.service;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;

import com.australia.foodandwine.experience.domain.ExperienceSearchParameters;
import com.australia.foodandwine.experience.domain.ExperienceSearchResult;
import com.australia.foodandwine.experience.repository.ExperienceRepository;
import com.australia.foodandwine.searchresults.domain.FAWSearchParameters;
import com.australia.foodandwine.searchresults.domain.FAWSearchResult;
import com.australia.foodandwine.searchresults.repository.FAWSearchRepository;

@Component(label = "Food and Wine SearchResult Service", description = "Food and Wine SearchResult Service", immediate = true)
@Service
public class DefaultSearchResultsService implements SearchReslutsService {

	@Reference
	private FAWSearchRepository fawSearchRepository;

	@Override
	public FAWSearchResult search(FAWSearchParameters parameters) {
		return fawSearchRepository.search(parameters);
	}

}
