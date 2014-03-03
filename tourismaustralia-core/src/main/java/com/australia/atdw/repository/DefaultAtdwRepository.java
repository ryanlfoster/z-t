package com.australia.atdw.repository;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Modified;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.sling.commons.osgi.PropertiesUtil;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.australia.atdw.domain.products.AtdwProductsResponse;

@Component(label = "Default ATDW Repository", description = "Default ATDW Repository", immediate = true, metatype = true)
@Service
public class DefaultAtdwRepository implements AtdwRepository {
	private static final String PRODUCTS_PATH = "/productsearchservice.svc/products";
	private static final String PRODUCT_PATH = "/productsearchservice.svc/product";
	private static final String DEFAULT_ATDW_LOCATION = "http://atlas.atdw.com.au/";

	@Property(label = "ATWD Atlast Service Location", description = "The external location of the ATWD Atlast Service", value = DEFAULT_ATDW_LOCATION)
	private static final String ATDW_LOCATION = "atdwLocation";
	private String atdwLocation;

	private static final String DEFAULT_ATDW_KEY = "123456789101112";
	@Property(label = "ATWD Atlast Service Key", description = "The key for the ATWD Atlast Service", value = DEFAULT_ATDW_KEY)
	private static final String ATDW_KEY = "atdwKey";
	private String atdwKey;

	private RestTemplate rest;

	@Override
	public AtdwProductsResponse getProducts(int count, int page) {
		Map<String, Object> parameters = getBaseParameters();
		parameters.put("size", count);
		parameters.put("pge", page);
		return getAtdwData(PRODUCTS_PATH, parameters, AtdwProductsResponse.class);
	}

	@Override
	public InputStream getProductXml(String productId) {
		Map<String, Object> parameters = getBaseParameters();
		parameters.put("productId", productId);
		return getAtdwData(PRODUCT_PATH, parameters, InputStream.class);
	}

	private <T> T getAtdwData(String path, Map<String, Object> parameters, Class<T> clazz) {
		StringBuilder sb = new StringBuilder();
		sb.append(atdwLocation).append(path).append("?");
		for (String key : parameters.keySet()) {
			sb.append(key).append("={").append(key).append("}&");
		}
		return rest.getForObject(sb.toString(), clazz, parameters);
	}

	private Map<String, Object> getBaseParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("key", atdwKey);
		parameters.put("out", "XML");
		return parameters;
	}

	@Activate
	@Modified
	protected void activate(final Map<String, Object> properties) throws Exception {
		atdwLocation = PropertiesUtil.toString(properties.get(ATDW_LOCATION), DEFAULT_ATDW_LOCATION);
		atdwKey = PropertiesUtil.toString(properties.get(ATDW_KEY), DEFAULT_ATDW_KEY);
		ThreadSafeClientConnManager cm = new ThreadSafeClientConnManager();
		cm.setMaxTotal(50);
		cm.setDefaultMaxPerRoute(50);
		rest = new RestTemplate(new HttpComponentsClientHttpRequestFactory(new DefaultHttpClient(cm, null)));
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		messageConverters.add(new AtdwInputStreamMessageConverter());
		messageConverters.addAll(rest.getMessageConverters());
		rest.setMessageConverters(messageConverters);
	}
}
