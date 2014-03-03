package com.australia.atdw.service;

import java.io.InputStream;

import com.australia.atdw.domain.products.AtdwProductsResponse;

public interface AtdwService {
	public AtdwProductsResponse getProducts(int count, int page);

	public InputStream getProductXml(String productId);
}
