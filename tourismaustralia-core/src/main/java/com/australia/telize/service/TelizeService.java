package com.australia.telize.service;

import com.australia.telize.domain.GeoLocation;

public interface TelizeService {

	GeoLocation getLocation();
	GeoLocation getLocation(String xForwardedIP);

}
