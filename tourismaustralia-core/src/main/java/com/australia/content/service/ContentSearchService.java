package com.australia.content.service;

import com.australia.content.domain.ContentSearchParameters;
import com.australia.content.domain.ContentSearchResult;

/**
 * Created by gsnyder on 4/16/14.
 */
public interface ContentSearchService {

	ContentSearchResult search(ContentSearchParameters params) throws ContentSearchException;

}
