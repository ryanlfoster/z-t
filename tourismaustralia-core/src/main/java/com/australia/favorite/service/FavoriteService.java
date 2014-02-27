package com.australia.favorite.service;

import com.australia.favorite.domain.UserFavorites;

public interface FavoriteService {
	public UserFavorites getByUserId(String userId);

	public void save(UserFavorites userFavorites);

	public void delete(UserFavorites userFavorites);
}
