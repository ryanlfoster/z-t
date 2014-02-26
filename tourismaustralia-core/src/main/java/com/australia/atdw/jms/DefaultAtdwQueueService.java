package com.australia.atdw.jms;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import com.australia.atdw.domain.products.Product;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DefaultAtdwQueueService implements AtdwQueueService {
	@Autowired
	private AtdwGateway gateway;

	@Override
	public void addToQueue(Product product) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(product);
		gateway.send(jsonString);
	}

}
