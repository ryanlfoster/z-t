package com.australia.atdw.jms;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import com.australia.atdw.remote.domain.products.Product;

public class DefaultAtdwQueueService implements AtdwQueueService {
	@Autowired
	private AtdwGateway gateway;

	@Override
	public void addToQueue(Product product) throws IOException {
		gateway.send(product);
	}

}
