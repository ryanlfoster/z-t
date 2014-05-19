package com.australia.cqimport.vo;

/**
 * Created by vpushpanayagam on 23/04/14.
 */
public class TagVO {

	private String name;
	private String value;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		TagVO tagVO = (TagVO) o;

		// if (!name.equals(tagVO.name)) return false;
		if (!value.equals(tagVO.value))
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = name.hashCode();
		result = 31 * result + value.hashCode();
		return result;
	}

}
