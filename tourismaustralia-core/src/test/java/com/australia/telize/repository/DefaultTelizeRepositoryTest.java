package com.australia.telize.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import com.australia.telize.domain.GeoLocation;

public class DefaultTelizeRepositoryTest {

	private TelizeRepository tlze;

	@Before
	public void setUp() throws Exception {
		DefaultTelizeRepository tlze = new DefaultTelizeRepository();
		tlze.activate(new HashMap<String, Object>());
		this.tlze = tlze;
	}

	@Test
	public void testGetGeoLocation() {
		GeoLocation geoloc = tlze.getGeoLocation();
		assertNotNull(geoloc);
		assertEquals(geoloc.getCountry(), "AU");
	}

}
