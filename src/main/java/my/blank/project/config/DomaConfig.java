/*
 * Copyright 2004-2013 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package my.blank.project.config;

import javax.sql.DataSource;

import org.seasar.doma.jdbc.ClassHelper;
import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.DefaultClassHelper;
import org.seasar.doma.jdbc.ExceptionSqlLogType;
import org.seasar.doma.jdbc.JdbcLogger;
import org.seasar.doma.jdbc.RequiresNewController;
import org.seasar.doma.jdbc.SqlFileRepository;
import org.seasar.doma.jdbc.dialect.Dialect;
import org.seasar.doma.jdbc.dialect.H2Dialect;
import org.seasar.extension.datasource.DataSourceFactory;
import org.seasar.extension.datasource.impl.SelectableDataSourceProxy;
import org.seasar.framework.container.S2Container;
import org.seasar.framework.container.factory.SingletonS2ContainerFactory;

public class DomaConfig implements Config {

	private static final SqlFileRepository sqlfileRepository = new SqlFileRepositoryProxy();

	private static final JdbcLogger jdbcLogger = new SLFJdbcLogger();

	private static final RequiresNewController requiresNewController = new S2RequiresNewController();

	private static final Dialect dialect = new H2Dialect();

	private static final ClassHelper classHelper = new DefaultClassHelper();

	@Override
	public String getDataSourceName() {
		S2Container container = SingletonS2ContainerFactory.getContainer();
		if (container.hasComponentDef(DataSourceFactory.class)) {
			DataSourceFactory dataSourceFactory = (DataSourceFactory) container
					.getComponent(DataSourceFactory.class);
			if (getDataSourceInternal() instanceof SelectableDataSourceProxy) {
				return dataSourceFactory.getSelectableDataSourceName();
			}
		}
		return getClass().getName();
	}

	@Override
	public DataSource getDataSource() {
		return getDataSourceInternal();
	}

	protected DataSource getDataSourceInternal() {
		S2Container container = SingletonS2ContainerFactory.getContainer();
		return (DataSource) container.getComponent(DataSource.class);
	}

	@Override
	public Dialect getDialect() {
		return dialect;
	}

	@Override
	public RequiresNewController getRequiresNewController() {
		return requiresNewController;
	}

	@Override
	public JdbcLogger getJdbcLogger() {
		return jdbcLogger;
	}

	@Override
	public SqlFileRepository getSqlFileRepository() {
		return sqlfileRepository;
	}

	@Override
	public ClassHelper getClassHelper() {
		return classHelper;
	}

	@Override
	public ExceptionSqlLogType getExceptionSqlLogType() {
		return ExceptionSqlLogType.FORMATTED_SQL;
	}

	@Override
	public int getBatchSize() {
		return 10;
	}

	@Override
	public int getFetchSize() {
		return 0;
	}

	@Override
	public int getMaxRows() {
		return 0;
	}

	@Override
	public int getQueryTimeout() {
		return 0;
	}
}
