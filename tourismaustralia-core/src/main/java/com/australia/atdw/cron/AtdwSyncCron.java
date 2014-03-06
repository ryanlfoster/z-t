package com.australia.atdw.cron;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.australia.atdw.jms.AtdwQueueService;
import com.australia.atdw.remote.domain.products.AtdwProductsResponse;
import com.australia.atdw.remote.domain.products.Product;
import com.australia.atdw.remote.service.AtdwService;
import com.google.common.base.Stopwatch;

@Component(label = "Atdw Sync Cron Service", metatype = true)
@Service
@Properties({ @Property(name = "scheduler.expression", value = "0 5 0 ? * SUN *"),
	@Property(name = "scheduler.concurrent", propertyPrivate = true, boolValue = false) })
public class AtdwSyncCron implements Runnable {
	private static final Logger LOG = LoggerFactory.getLogger(AtdwSyncCron.class);
	private static final int COUNT = 1000;
	@Reference
	private AtdwQueueService atdwQueueService;

	@Reference
	private AtdwService atdwService;

	@Override
	public void run() {
		LOG.debug("Starting Sync from ATDW");
		Stopwatch stopwatch = Stopwatch.createStarted();
		try {
			loadProductsFromAtdw(1);
		} catch (IOException e) {
			LOG.error("Error syncing products from ATDW", e);
		}
		LOG.debug("Starting Sync from ATDW Complete in {}s", stopwatch.stop().elapsed(TimeUnit.SECONDS));
	}

	private void loadProductsFromAtdw(int page) throws IOException {
		LOG.debug("Loading page {} from ATDW", page);
		AtdwProductsResponse response = atdwService.getProducts(COUNT, page);
		if (response != null && response.getProducts() != null && response.getProducts().getProducts() != null) {
			for (Product product : response.getProducts().getProducts()) {
				atdwQueueService.addToQueue(product);
			}
			if (page * COUNT < response.getNumberOfResults()) {
				loadProductsFromAtdw(page + 1);
			}
		}
	}

}
