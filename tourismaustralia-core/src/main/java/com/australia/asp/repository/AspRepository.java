package com.australia.asp.repository;

import java.util.List;

import com.australia.asp.domain.Specialist;

public interface AspRepository {
	public List<Specialist> getSpecialists();

	public List<Specialist> getSpecialistsByCountry(String country);

	public List<Specialist> getSpecialistsByCountryAndState(String country, String state);

	public List<Specialist> getSpecialistsByCountryAndStateAndCity(String country, String state, String city);
}
