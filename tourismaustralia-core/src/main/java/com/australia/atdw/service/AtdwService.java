package com.australia.atdw.service;

import com.australia.atdw.domain.products.AtdwProductsResponse;

public interface AtdwService {
	public AtdwProductsResponse getProducts(int count, int page);
}
