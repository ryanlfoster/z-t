package com.australia.atdw.repository;

import com.australia.atdw.domain.products.AtdwProductsResponse;

public interface AtdwRepository {
	public AtdwProductsResponse getProducts(int count, int page);
}
