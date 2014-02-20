package com.australia.asp.service;

import java.util.List;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;

import com.australia.asp.domain.Specialist;
import com.australia.asp.repository.AspRepository;

@Component(label = "Default ASP Service", description = "Default ASP Service", immediate = true)
@Service
public class DefaultAspService implements AspService {
	@Reference
	private AspRepository asp;

	@Override
	public List<Specialist> getSpecialists() {
		return asp.getSpecialists();
	}

	@Override
	public List<Specialist> getSpecialistsByCountry(String country) {
		return asp.getSpecialistsByCountry(country);
	}

	@Override
	public List<Specialist> getSpecialistsByCountryAndState(String country, String state) {
		return asp.getSpecialistsByCountryAndState(country, state);
	}

	@Override
	public List<Specialist> getSpecialistsByCountryAndStateAndCity(String country, String state, String city) {
		return asp.getSpecialistsByCountryAndStateAndCity(country, state, city);
	}
}
