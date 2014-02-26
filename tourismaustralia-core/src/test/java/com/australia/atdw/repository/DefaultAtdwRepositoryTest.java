package com.australia.atdw.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import com.australia.atdw.domain.products.AtdwProductsResponse;

public class DefaultAtdwRepositoryTest {
	private AtdwRepository atdw;

	@Before
	public void setup() throws Exception {
		DefaultAtdwRepository atdw = new DefaultAtdwRepository();
		atdw.activate(new HashMap<String, Object>());
		this.atdw = atdw;
	}

	@Test
	public void getProducts() {
		AtdwProductsResponse response = atdw.getProducts(100, 1);
		assertNotNull(response);
		assertNotNull(response.getProducts());
		assertNotNull(response.getProducts().getProducts());
		assertEquals(100, response.getProducts().getProducts().size());
	}
}
