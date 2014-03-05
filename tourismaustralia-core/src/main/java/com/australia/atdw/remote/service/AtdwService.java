package com.australia.atdw.remote.service;

import java.io.InputStream;

import com.australia.atdw.remote.domain.AtdwProductsResponse;

public interface AtdwService {
	public AtdwProductsResponse getProducts(int count, int page);

	public InputStream getProductXml(String productId);
}
