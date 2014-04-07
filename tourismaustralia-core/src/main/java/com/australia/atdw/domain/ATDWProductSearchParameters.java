package com.australia.atdw.domain;

import com.australia.search.domain.AbstractSearchParameters;
import com.google.common.base.Objects;

public class ATDWProductSearchParameters extends AbstractSearchParameters {
	private ATDWCategory category;

	public ATDWCategory getCategory() {
		return category;
	}

	public void setCategory(ATDWCategory category) {
		this.category = category;
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
			&& Objects.equal(category, other.category);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.getCount(), this.getText(), this.getPage(), this.getTags(), category);
	}
}
