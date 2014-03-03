package com.australia.atdw.repository;

import java.io.InputStream;

import com.australia.atdw.domain.products.AtdwProductsResponse;

public interface AtdwRepository {
	public AtdwProductsResponse getProducts(int count, int page);

	public InputStream getProductXml(String productId);
}
