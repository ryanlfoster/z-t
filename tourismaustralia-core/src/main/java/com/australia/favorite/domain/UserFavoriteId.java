package com.australia.favorite.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.google.common.base.Objects;

@Embeddable
public class UserFavoriteId implements Serializable {
	private static final long serialVersionUID = 3096378262112761701L;

	@Column(nullable = false)
	private String userId;

	@Column(nullable = false)
	private String page;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final UserFavoriteId other = (UserFavoriteId) obj;

		return Objects.equal(this.userId, other.userId) && Objects.equal(this.page, other.page);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.userId, this.page);
	}
}
