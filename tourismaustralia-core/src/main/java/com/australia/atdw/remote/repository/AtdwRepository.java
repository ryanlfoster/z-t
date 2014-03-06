package com.australia.atdw.remote.repository;

import com.australia.atdw.remote.domain.product.AtdwDataResultsType;
import com.australia.atdw.remote.domain.products.AtdwProductsResponse;

public interface AtdwRepository {
	public AtdwProductsResponse getProducts(int count, int page);

	public AtdwDataResultsType getProduct(String productId);
}
