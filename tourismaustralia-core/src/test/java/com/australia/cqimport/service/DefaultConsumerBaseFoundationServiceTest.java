package com.australia.cqimport.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.australia.cqimport.domain.ConsumerBaseFoundationType;

public class DefaultConsumerBaseFoundationServiceTest {
	private DefaultConsumerBaseFoundationService service;

	@Before
	public void setup() {
		this.service = new DefaultConsumerBaseFoundationService();
	}

	@Test
	public void loadVictoria() {
		ConsumerBaseFoundationType cbf = service.getByPath("en/explore/states/vic");
		assertNotNull(cbf);
		assertEquals(cbf.getHdlTitle(), "Victoria");
	}
}
