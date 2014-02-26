package com.australia.atdw.jms;

import java.io.IOException;

import com.australia.atdw.domain.products.Product;

public interface AtdwQueueService {
	public void addToQueue(Product product) throws IOException;
}
