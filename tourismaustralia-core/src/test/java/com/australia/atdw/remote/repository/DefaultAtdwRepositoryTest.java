package com.australia.atdw.remote.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import com.australia.atdw.remote.domain.AtdwProductsResponse;
import com.australia.atdw.remote.repository.AtdwRepository;
import com.australia.atdw.remote.repository.DefaultAtdwRepository;

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

	@Test
	public void getProductXml() throws IOException {
		InputStream xml = atdw.getProductXml("9198512");
		assertNotNull(xml);
		assertTrue(xml.available() > 0);
	}
}
