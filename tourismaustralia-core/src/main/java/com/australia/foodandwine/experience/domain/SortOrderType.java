package com.australia.foodandwine.experience.domain;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import com.australia.utils.QueryUtils;

public enum SortOrderType {
	ASC(QueryUtils.ASC),
	DESC(QueryUtils.DESC);

	private String sort;
	private static final Map<String, SortOrderType> lookup = new HashMap<String, SortOrderType>();

	static {
		for (SortOrderType s : EnumSet.allOf(SortOrderType.class)) {
			lookup.put(s.getSort(), s);
		}
	}

	private SortOrderType(String sort) {
		this.sort = sort;
	}

	public String getSort() {
		return sort;
	}

	public static SortOrderType get(String sort) {
		return lookup.get(sort);
	}

	@Override
	public String toString() {
		return sort;
	}
}
