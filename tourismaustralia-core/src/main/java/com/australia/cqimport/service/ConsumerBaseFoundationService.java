package com.australia.cqimport.service;

import com.australia.cqimport.domain.ConsumerBaseFoundationType;

public interface ConsumerBaseFoundationService {
	public ConsumerBaseFoundationType getByPath(String path);
}
