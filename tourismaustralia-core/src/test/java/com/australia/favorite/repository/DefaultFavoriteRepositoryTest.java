package com.australia.favorite.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.australia.favorite.domain.UserFavorites;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/datasource.xml" })
public class DefaultFavoriteRepositoryTest {
	private static final String USER_ID = "206563d4-34c3-4368-a586-31032416173f";
	@Autowired
	private FavoriteRepository favRepo;

	@Test
	@Transactional
	public void getByUserId() {
		UserFavorites userFavs = favRepo.getUserFavoritesByUserId(USER_ID);
		assertNotNull(userFavs);
		assertEquals(4, userFavs.getFavorites().size());
		assertEquals("/content/australia/page3", userFavs.getFavorites().get(1).getPage());
	}

	@Test
	@Transactional
	public void save() {
		UserFavorites userFav = new UserFavorites();
		favRepo.save(userFav);
		UserFavorites userFavFromRepo = favRepo.getUserFavoritesByUserId(userFav.getUserId());
		assertEquals(userFav, userFavFromRepo);
	}
}
