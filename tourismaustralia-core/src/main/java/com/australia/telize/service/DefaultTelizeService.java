package com.australia.telize.service;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;

import com.australia.telize.domain.GeoLocation;
import com.australia.telize.repository.TelizeRepository;

@Component(label = "Default Telize Service", description = "Default Telize Service", immediate = true)
@Service
public class DefaultTelizeService implements TelizeService {

	@Reference
	private TelizeRepository telizeRepo;

	@Override
	public GeoLocation getLocation() {
		return telizeRepo.getGeoLocation();
	}

}
