package com.australia.foodandwine.searchresults.service;

import com.australia.foodandwine.searchresults.domain.FAWSearchParameters;
import com.australia.foodandwine.searchresults.domain.FAWSearchResult;


public interface SearchReslutsService {
	public FAWSearchResult search(FAWSearchParameters parameters);
}
