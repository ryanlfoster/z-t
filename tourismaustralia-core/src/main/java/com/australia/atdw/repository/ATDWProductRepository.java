package com.australia.atdw.repository;

import com.australia.atdw.domain.ATDWProduct;
import com.australia.atdw.domain.ATDWProductSearchParameters;

import java.util.Date;
import java.util.List;

public interface ATDWProductRepository {
	public List<ATDWProduct> search(ATDWProductSearchParameters parameters);

    public void deleteOldProducts(Date updatedBefore);
}
