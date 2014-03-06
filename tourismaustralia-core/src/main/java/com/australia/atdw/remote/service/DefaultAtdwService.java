package com.australia.atdw.remote.service;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;

import com.australia.atdw.remote.domain.product.AtdwDataResultsType;
import com.australia.atdw.remote.domain.products.AtdwProductsResponse;
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
	public AtdwDataResultsType getProduct(String productId) {
		return atdwRepo.getProduct(productId);
	}

}
