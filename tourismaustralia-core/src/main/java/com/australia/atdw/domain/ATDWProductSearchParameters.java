package com.australia.atdw.domain;

import com.australia.search.domain.AbstractSearchParameters;
import com.google.common.base.Objects;

public class ATDWProductSearchParameters extends AbstractSearchParameters {
	private ATDWCategory category;
	private String city;
	private String region;
	private String state;

	public ATDWCategory getCategory() {
		return category;
	}

	public void setCategory(ATDWCategory category) {
		this.category = category;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		ATDWProductSearchParameters other = (ATDWProductSearchParameters) obj;
		return Objects.equal(this.getCount(), other.getCount()) && Objects.equal(this.getPage(), other.getPage())
			&& Objects.equal(this.getText(), other.getText()) && Objects.equal(this.getTags(), other.getTags())
			&& Objects.equal(category, other.category) && Objects.equal(city, other.city)
			&& Objects.equal(region, other.region) && Objects.equal(state, other.state);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.getCount(), this.getText(), this.getPage(), this.getTags(), category, city,
			region, state);
	}
}
