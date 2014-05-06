package com.australia.atdw.repository;

import com.australia.atdw.domain.ATDWProductSearchParameters;
import com.australia.atdw.domain.ATDWSearchResult;

import java.util.Date;
import java.util.Map;
import java.util.Set;

public interface ATDWProductRepository {
	public ATDWSearchResult search(ATDWProductSearchParameters parameters);

	public void deleteOldProducts(Date updatedBefore);

	/**
	 * Gets a data structure containing all locations currently mapped to ATDW data.  The outer map keys are state
	 * names.  These each map to an inner mapping, the keys of which are the regions within that state.  The value
	 * associated with each region mapping is a set of cities within the region.  Locations for which no region is
	 * specified will map to a region key of "".
	 *
	 * @return the location data structure described above
	 */
	public Map<String, Map<String, Set<String>>> getLocationMap();
}
