package com.australia.atdw.cron;

import com.australia.atdw.jms.AtdwQueueService;
import com.australia.atdw.remote.domain.products.AtdwProductsResponse;
import com.australia.atdw.remote.domain.products.Product;
import com.australia.atdw.remote.service.AtdwService;
import com.australia.atdw.service.ATDWProductService;
import com.google.common.base.Stopwatch;
import org.apache.felix.scr.annotations.*;
import org.osgi.framework.BundleContext;
import org.quartz.CronExpression;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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

    @Reference
    private ATDWProductService adtwProductService;

    private String schedulerExpression;

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

    private void removeStaleProducts(){
        if(schedulerExpression != null) {
            try {
                CronExpression expression = new CronExpression(schedulerExpression);
                Date now = new Date();
                Date thisExecution = expression.getTimeBefore(now);
                Date previousExecution = expression.getTimeBefore(thisExecution);
                Date twicePreviousExecution = expression.getTimeBefore(previousExecution);
                adtwProductService.deleteOldProducts(twicePreviousExecution);
            } catch (ParseException e) {
                LOG.error("Removal of stale products failed: Unable to parse Cron expression", e);
            }
        } else {
            LOG.error("Removal of stale products failed: Scheduler expression not found");
        }
    }

    @Modified
    void modified(Map<String, Object> values)
    {
        Object expressionObject = values.get("scheduler.expression");
        schedulerExpression = (expressionObject instanceof String) ? (String) expressionObject : schedulerExpression;
    }

    @Activate
    void activate(BundleContext context, Map<String, Object> values)
    {
        Object expressionObject = values.get("scheduler.expression");
        schedulerExpression = (expressionObject instanceof String) ? (String) expressionObject : schedulerExpression;
    }

}
