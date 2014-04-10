package com.australia.atdw.service;

import java.util.Date;
import java.util.List;

import com.australia.atdw.domain.ATDWProduct;
import com.australia.atdw.domain.ATDWProductSearchParameters;

public interface ATDWProductService {
	public List<ATDWProduct> search(ATDWProductSearchParameters parameters);

	public void deleteOldProducts(Date updatedBefore);
}
