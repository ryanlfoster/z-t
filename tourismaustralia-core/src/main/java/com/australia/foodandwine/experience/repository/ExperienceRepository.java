package com.australia.foodandwine.experience.repository;

import com.australia.foodandwine.experience.domain.ExperienceSearchParameters;
import com.australia.foodandwine.experience.domain.ExperienceSearchResult;

public interface ExperienceRepository {
	public ExperienceSearchResult search(ExperienceSearchParameters parameters);
}
