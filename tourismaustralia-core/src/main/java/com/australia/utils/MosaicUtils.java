package com.australia.utils;

import com.australia.mosaic.FourToOneGridMosaic;

import java.util.ArrayList;
import java.util.List;

public final class MosaicUtils {

	public static <T> List<FourToOneGridMosaic<T>> convertToMosaic(List<T> items) {
		final List<FourToOneGridMosaic<T>> out = new ArrayList<FourToOneGridMosaic<T>>();

		final int size = items.size();
		int index = 0;
		while(size > index + 1) {
			final T singleItem = items.get(index);
			index++;
			final int mosaicSize = Math.min(4, size - index);
			final List<T> fourGridItems = new ArrayList<T>(items.subList(index, index + mosaicSize));
			index += mosaicSize;
			out.add(new FourToOneGridMosaic<T>(singleItem, fourGridItems));
		}

		return out;
	}



	private MosaicUtils() { }
}
