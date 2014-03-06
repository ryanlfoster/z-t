package com.australia.atdw.remote.service;

import com.australia.atdw.remote.domain.product.AtdwDataResultsType;
import com.australia.atdw.remote.domain.products.AtdwProductsResponse;

public interface AtdwService {
	public AtdwProductsResponse getProducts(int count, int page);

	public AtdwDataResultsType getProduct(String productId);
}
