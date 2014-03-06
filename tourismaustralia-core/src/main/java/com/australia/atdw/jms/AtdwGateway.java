package com.australia.atdw.jms;

import com.australia.atdw.remote.domain.products.Product;

public interface AtdwGateway {
	void send(Product product);
}
