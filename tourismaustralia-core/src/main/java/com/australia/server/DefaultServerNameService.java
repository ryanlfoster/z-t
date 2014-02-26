package com.australia.server;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Modified;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.commons.osgi.PropertiesUtil;

@Component(label = "Server Name Service", description = "External Location for Server", immediate = true, metatype = true)
@Service
public class DefaultServerNameService implements ServerNameService {
	@Property(label = "Author Server Name", description = "The external location of the author server")
	protected static final String AUTHOR_SERVER_NAME = "authorServerName";
	private String authorServerName;

	@Property(label = "Food And Wine Server Name", description = "The external location of the food and wine publish server")
	protected static final String FOOD_AND_WINE_SERVER_NAME = "foodAndWineServerName";
	private String foodAndWineServerName;

	@Property(label = "Australia.com Server Name", description = "The external location of the australia.com publish server")
	protected static final String AUSTRALIA_SERVER_NAME = "australiaComServerName";
	private String australiaComServerName;

	@Override
	public String getAuthorServerName() {
		return authorServerName;
	}

	@Override
	public String getAustraliaComServerName() {
		return australiaComServerName;
	}

	@Override
	public String getFoodAndWineServerName() {
		return foodAndWineServerName;
	}

	@Activate
	@Modified
	protected void activate(final Map<String, Object> properties) throws Exception {
		authorServerName = PropertiesUtil.toString(properties.get(AUTHOR_SERVER_NAME), StringUtils.EMPTY);
		foodAndWineServerName = PropertiesUtil.toString(properties.get(FOOD_AND_WINE_SERVER_NAME), StringUtils.EMPTY);
		australiaComServerName = PropertiesUtil.toString(properties.get(AUSTRALIA_SERVER_NAME), StringUtils.EMPTY);
	}
}
