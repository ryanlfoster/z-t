package com.australia.asp.service;

import java.util.List;

import com.australia.asp.domain.Specialist;

public interface AspService {
	public List<Specialist> getSpecialists();

	public List<Specialist> getSpecialistsByCountry(String country);

	public List<Specialist> getSpecialistsByCountryAndState(String country, String state);

	public List<Specialist> getSpecialistsByCountryAndStateAndCity(String country, String state, String city);
}
