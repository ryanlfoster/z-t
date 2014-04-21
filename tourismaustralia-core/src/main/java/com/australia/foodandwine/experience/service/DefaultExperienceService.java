package com.australia.foodandwine.experience.service;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;

import com.australia.foodandwine.experience.domain.ExperienceSearchParameters;
import com.australia.foodandwine.experience.domain.ExperienceSearchResult;
import com.australia.foodandwine.experience.repository.ExperienceRepository;

@Component(label = "Food and Wine Experience Service", description = "Food and Wine Experience Service", immediate = true)
@Service
public class DefaultExperienceService implements ExperienceService {

	@Reference
	private ExperienceRepository experienceRepository;

	@Override
	public ExperienceSearchResult search(ExperienceSearchParameters parameters) {
		return experienceRepository.search(parameters);
	}

}
