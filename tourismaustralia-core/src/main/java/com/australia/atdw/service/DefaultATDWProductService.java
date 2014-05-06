package com.australia.atdw.service;

import com.australia.atdw.domain.ATDWProductSearchParameters;
import com.australia.atdw.domain.ATDWSearchResult;
import com.australia.atdw.repository.ATDWProductRepository;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;

import java.util.Date;

@Component(label = "ATDW Product Service", description = "ATDW Product Service", immediate = true)
@Service
public class DefaultATDWProductService implements ATDWProductService {
	@Reference
	private ATDWProductRepository atdwRepo;

	@Override
	public ATDWSearchResult search(ATDWProductSearchParameters parameters) {
		return atdwRepo.search(parameters);
	}

	@Override
	public void deleteOldProducts(Date updatedBefore) {
		atdwRepo.deleteOldProducts(updatedBefore);
	}

}
