package com.australia.content.service;

import com.australia.content.model.Content;

import java.util.List;

/**
 * Created by gsnyder on 4/16/14.
 */
public interface ContentFinderService {

	List<Content> findContent(String path, String tagId, String templateType, int limit) throws ContentFinderException;

}
