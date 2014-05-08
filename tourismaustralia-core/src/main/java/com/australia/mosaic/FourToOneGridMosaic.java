package com.australia.mosaic;

import java.util.List;

/**
 * Represents a grid mosaic with one large single item balanced by a grid of 4 smaller items
 * @param <T>
 */
public class FourToOneGridMosaic<T> {

	private T singleItem;

	private List<T> gridFourItems;

	public FourToOneGridMosaic() {

	}

	public FourToOneGridMosaic(T singleItem, List<T> gridFourItems) {
		this.singleItem = singleItem;
		this.gridFourItems = gridFourItems;
	}

	public T getSingleItem() {
		return singleItem;
	}

	public void setSingleItem(T singleItem) {
		this.singleItem = singleItem;
	}

	public List<T> getGridFourItems() {
		return gridFourItems;
	}

	public void setGridFourItems(List<T> gridFourItems) {
		this.gridFourItems = gridFourItems;
	}
}
