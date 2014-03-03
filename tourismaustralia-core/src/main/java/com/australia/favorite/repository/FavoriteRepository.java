package com.australia.favorite.repository;

import com.australia.favorite.domain.UserFavorites;

public interface FavoriteRepository {
	public UserFavorites getUserFavoritesByUserId(String userId);

	public UserFavorites getUserFavoritesByShareId(String shareId);

	public void save(UserFavorites userFavorites);

	public void delete(UserFavorites userFavorites);
}
