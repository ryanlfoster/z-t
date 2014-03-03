package com.australia.atdw.jms.service;

import java.util.Map;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Modified;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.commons.osgi.PropertiesUtil;

@Component(label = "Default ATDW Product Message Consumer Configuration Service", description = "Default ATDW Product Message Consumer Configuration Service", immediate = true, metatype = true)
@Service
public class DefaultAtdwProductMessageConsumerConfigurationService implements
	AtdwProductMessageConsumerConfigurationService {

	private static final int DEFAULT_MESSAGE_CONSUMER_COUNT = 20;
	@Property(label = "Message Consumers", description = "The count of message consumers for atdw products queue", intValue = DEFAULT_MESSAGE_CONSUMER_COUNT)
	private static final String MESSAGE_CONSUMER_COUNT = "messageConsumersCount";
	private int messageConsumersCount;

	@Override
	public int getMessageConsumersCount() {
		return messageConsumersCount;
	}

	@Activate
	@Modified
	protected void activate(final Map<String, Object> properties) throws Exception {
		messageConsumersCount = PropertiesUtil.toInteger(properties.get(MESSAGE_CONSUMER_COUNT),
			DEFAULT_MESSAGE_CONSUMER_COUNT);
	}
}
