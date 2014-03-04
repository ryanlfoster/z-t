package com.australia.atdw.jms;

import com.australia.atdw.domain.products.Product;

public interface AtdwGateway {
	void send(Product product);
}
