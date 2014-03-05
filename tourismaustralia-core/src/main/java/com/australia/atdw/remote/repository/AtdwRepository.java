package com.australia.atdw.remote.repository;

import java.io.InputStream;

import com.australia.atdw.remote.domain.AtdwProductsResponse;

public interface AtdwRepository {
	public AtdwProductsResponse getProducts(int count, int page);

	public InputStream getProductXml(String productId);
}
