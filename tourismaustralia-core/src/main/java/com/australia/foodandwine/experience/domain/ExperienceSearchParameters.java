package com.australia.foodandwine.experience.domain;

import com.australia.search.domain.AbstractSearchParameters;
import com.google.common.base.Objects;

public class ExperienceSearchParameters extends AbstractSearchParameters {
	private SortOrderType sort;

	public SortOrderType getSort() {
		return sort;
	}

	public void setSort(SortOrderType sort) {
		this.sort = sort;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		ExperienceSearchParameters other = (ExperienceSearchParameters) obj;
		return Objects.equal(this.getCount(), other.getCount()) && Objects.equal(this.getPage(), other.getPage())
			&& Objects.equal(this.getText(), other.getText()) && Objects.equal(this.getTags(), other.getTags())
			&& Objects.equal(sort, other.sort);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.getCount(), this.getText(), this.getPage(), this.getTags(), sort);
	}
}
