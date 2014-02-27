package com.australia.datasource;

import javax.sql.DataSource;

public interface DataSourceFactory {
	DataSource getDataSourceFromPool();
}
