package com.australia.atdw.repository;

import com.australia.atdw.domain.ATDWProductSearchParameters;
import com.australia.atdw.domain.ATDWSearchResult;

import java.util.Date;

public interface ATDWProductRepository {
	public ATDWSearchResult search(ATDWProductSearchParameters parameters);

	public void deleteOldProducts(Date updatedBefore);
}
