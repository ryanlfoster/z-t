package com.australia.foodandwine.searchresults.repository;

import com.australia.foodandwine.searchresults.domain.FAWSearchParameters;
import com.australia.foodandwine.searchresults.domain.FAWSearchResult;

public interface FAWSearchRepository {
	public FAWSearchResult search(FAWSearchParameters parameters);
}
