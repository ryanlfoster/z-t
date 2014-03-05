package com.australia.atdw.remote.service;

import java.io.InputStream;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;

import com.australia.atdw.remote.domain.AtdwProductsResponse;
import com.australia.atdw.remote.repository.AtdwRepository;

@Component(label = "Default ATDW Service", description = "Default ATDW Service", immediate = true)
@Service
public class DefaultAtdwService implements AtdwService {

	@Reference
	private AtdwRepository atdwRepo;

	@Override
	public AtdwProductsResponse getProducts(int count, int page) {
		return atdwRepo.getProducts(count, page);
	}

	@Override
	public InputStream getProductXml(String productId) {
		return atdwRepo.getProductXml(productId);
	}

}
