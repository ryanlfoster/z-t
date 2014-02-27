package com.australia.favorite.repository;

import org.hibernate.SessionFactory;

import com.australia.favorite.domain.UserFavorites;

public class DefaultFavoriteRepository implements FavoriteRepository {
	private SessionFactory sessionFactory;

	public DefaultFavoriteRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public UserFavorites getUserFavoritesByUserId(String userId) {
		final String query = "From UserFavorites where userId=:userId";
		return (UserFavorites) sessionFactory.getCurrentSession().createQuery(query).setString("userId", userId)
			.uniqueResult();
	}

	@Override
	public void save(UserFavorites userFavorites) {
		sessionFactory.getCurrentSession().saveOrUpdate(userFavorites);
	}

	@Override
	public void delete(UserFavorites userFavorites) {
		sessionFactory.getCurrentSession().delete(userFavorites);
	}

}
