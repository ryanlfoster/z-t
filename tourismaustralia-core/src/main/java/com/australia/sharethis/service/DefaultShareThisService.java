package com.australia.sharethis.service;

import java.util.Map;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Modified;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.commons.osgi.PropertiesUtil;

@Component(label = "Default ShareThis Service", description = "Default ShareThis Service", immediate = true)
@Service
public class DefaultShareThisService implements ShareThisService {
	public static final String DEFAULT_SHARETHIS_ACCOUNT_ID = "publisher";

	@Property(label = "ShareThis Account ID", description = "The account identifier for ShareThis")
	private static final String SHARETHIS_ACCOUNT_ID = "shareThisAccountId";
	private String accountId;

	@Activate
	@Modified
	protected void activate(final Map<String, Object> properties) throws Exception {
		accountId = PropertiesUtil.toString(properties.get(SHARETHIS_ACCOUNT_ID), DEFAULT_SHARETHIS_ACCOUNT_ID);
	}

	@Override
	public String getAccountId() {
		return accountId;
	}

}
