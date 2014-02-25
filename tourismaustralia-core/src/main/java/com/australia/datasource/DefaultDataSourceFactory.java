package com.australia.datasource;

import javax.sql.DataSource;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.commons.datasource.poolservice.DataSourcePool;

@Component(label = "TA DataSource Factory", description = "Responsible for handing OSGi configured data sources to dependent services.")
@Service
public final class DefaultDataSourceFactory implements DataSourceFactory {

	private static final Logger LOG = LoggerFactory.getLogger(DefaultDataSourceFactory.class);
	private static final String MYSQL_DRIVER_CLASSPATH = "com.mysql.jdbc.Driver";
	private static final String DATASOURCE_NAME = "ta";

	@Reference
	private DataSourcePool dataSourcePool;

	public DataSource getDataSourceFromPool() {
		DataSource dataSource = null;
		try {
			Class.forName(MYSQL_DRIVER_CLASSPATH);
			dataSource = (DataSource) dataSourcePool.getDataSource(DATASOURCE_NAME);
		} catch (final Exception exception) {
			LOG.error("An exception occured attempting to retrieve the datasoruce: '{}'. See Exception: {}",
				DATASOURCE_NAME, ExceptionUtils.getFullStackTrace(exception));
		}
		return dataSource;
	}
}
