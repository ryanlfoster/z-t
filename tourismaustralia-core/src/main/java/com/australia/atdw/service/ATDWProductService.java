package com.australia.atdw.service;

import com.australia.atdw.domain.ATDWProductSearchParameters;
import com.australia.atdw.domain.ATDWSearchResult;

import java.util.Date;

public interface ATDWProductService {
	public ATDWSearchResult search(ATDWProductSearchParameters parameters);

	public void deleteOldProducts(Date updatedBefore);
}
