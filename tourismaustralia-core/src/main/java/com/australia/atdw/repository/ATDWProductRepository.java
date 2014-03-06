package com.australia.atdw.repository;

import java.util.List;

import com.australia.atdw.domain.ATDWProduct;
import com.australia.atdw.domain.ATDWProductSearchParameters;

public interface ATDWProductRepository {
	public List<ATDWProduct> search(ATDWProductSearchParameters parameters);
}
