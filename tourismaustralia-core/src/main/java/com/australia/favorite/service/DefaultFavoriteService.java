package com.australia.favorite.service;

import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.australia.favorite.domain.UserFavorites;
import com.australia.favorite.repository.FavoriteRepository;

public class DefaultFavoriteService implements FavoriteService {

	private FavoriteRepository favoriteRepository;

	public DefaultFavoriteService(FavoriteRepository favoriteRepository) {
		this.favoriteRepository = favoriteRepository;
	}

	@Override
	@Transactional(readOnly = true)
	public UserFavorites getByUserId(String userId) {
		return favoriteRepository.getUserFavoritesByUserId(userId);
	}

	@Override
	@Transactional
	public void save(UserFavorites userFavorites) {
		if (userFavorites.getShareId() == null) {
			userFavorites.setShareId(UUID.randomUUID().toString());
		}
		favoriteRepository.save(userFavorites);
	}

	@Override
	@Transactional
	public void delete(UserFavorites userFavorites) {
		favoriteRepository.delete(userFavorites);
	}

}
