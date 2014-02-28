package com.australia.favorite.domain;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.apache.commons.lang.StringUtils;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "user_favorites")
public class UserFavorites {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String userId;

	@Column(unique = true)
	private String shareId;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "userId")
	@OrderColumn(name = "sort")
	private List<Favorite> favorites = new LinkedList<Favorite>();

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getShareId() {
		return shareId;
	}

	public void setShareId(String shareId) {
		this.shareId = shareId;
	}

	public List<Favorite> getFavorites() {
		return favorites;
	}

	public void setFavorites(List<Favorite> favorites) {
		this.favorites = favorites;
	}

	public void addFavorite(Favorite favorite) {
		favorites.add(favorite);
		favorite.setUserId(userId);
	}

	public boolean findFavorite(Favorite favorite) {
		for (Favorite fav : favorites) {
			if (fav.getPage().equalsIgnoreCase(favorite.getPage())) {
				return true;
			}
		}
		return false;
	}

	public void moveFavorite(int from, int to) {
		Favorite favorite = favorites.get(from);
		favorites.remove(from);
		favorites.add(to, favorite);
	}

	public void removeFavorite(Favorite favorite) {
		Iterator<Favorite> iter = favorites.iterator();
		while (iter.hasNext()) {
			Favorite fav = (Favorite) iter.next();
			if (StringUtils.equalsIgnoreCase(fav.getPage(), favorite.getPage())) {
				iter.remove();
				break;
			}
		}
	}
}
