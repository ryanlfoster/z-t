package com.australia.foodandwine.experience.service;

import com.australia.foodandwine.experience.domain.ExperienceSearchParameters;
import com.australia.foodandwine.experience.domain.ExperienceSearchResult;

public interface ExperienceService {
	public ExperienceSearchResult search(ExperienceSearchParameters parameters);
}
