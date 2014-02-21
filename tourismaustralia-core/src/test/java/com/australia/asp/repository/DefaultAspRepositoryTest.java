package com.australia.asp.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import java.util.HashMap;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.australia.asp.domain.Specialist;

public class DefaultAspRepositoryTest {
	private static DefaultAspRepository asp;

	@BeforeClass
	public static void setup() throws Exception {
		asp = new DefaultAspRepository();
		asp.activate(new HashMap<String, Object>());
	}

	@Test
	public void getSpecialists() {
		List<Specialist> specialists = asp.getSpecialists();
		assertNotNull(specialists);
		assertNotSame(0, specialists.size());
	}

	@Test
	public void getSpecialistsByCountry() {
		List<Specialist> specialists = asp.getSpecialistsByCountry("United States Of America");
		assertNotNull(specialists);
		assertNotSame(0, specialists.size());
	}

	@Test
	public void getSpecialistsByCountryAndState() {
		List<Specialist> specialists = asp.getSpecialistsByCountryAndState("United States Of America", "Texas");
		assertNotNull(specialists);
		assertNotSame(0, specialists.size());
	}

	@Test
	public void getSpecialistsByCountryAndStateAndCity() {
		List<Specialist> specialists = asp.getSpecialistsByCountryAndStateAndCity("United States Of America", "Texas",
			"San Antonio");
		assertNotNull(specialists);
		assertNotSame(0, specialists.size());
	}
}
