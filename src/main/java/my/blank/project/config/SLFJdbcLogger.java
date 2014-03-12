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

import static my.blank.project.config.Loggers.*;
import static org.seasar.doma.message.Message.*;

import java.sql.SQLException;

import org.seasar.doma.jdbc.JdbcLogger;
import org.seasar.doma.jdbc.Sql;
import org.seasar.doma.jdbc.SqlExecutionSkipCause;

public class SLFJdbcLogger implements JdbcLogger {

	@Override
	public void logDaoMethodEntering(String callerClassName,
			String callerMethodName, Object... args) {
		JDBC_LOGGER.debug("ENTRY");
	}

	@Override
	public void logDaoMethodExiting(String callerClassName,
			String callerMethodName, Object result) {
		JDBC_LOGGER.debug(String.format("RETURN %s", result));
	}

	@Override
	public void logDaoMethodThrowing(String callerClassName,
			String callerMethodName, RuntimeException e) {
		JDBC_LOGGER.error(String.format("THROW %s", e.toString()), e);
	}

	@Override
	public void logSqlExecutionSkipping(String callerClassName,
			String callerMethodName, SqlExecutionSkipCause cause) {
		JDBC_LOGGER.debug(cause.name());
	}

	@Override
	public void logSql(String callerClassName, String callerMethodName,
			Sql<?> sql) {
		JDBC_LOGGER.debug(DOMA2076.getMessage(sql.getSqlFilePath(),
				sql.getFormattedSql()));
	}

	@Override
	public void logLocalTransactionBegun(String callerClassName,
			String callerMethodName, String transactionId) {
		JDBC_LOGGER.debug(DOMA2063.getMessage(transactionId));
	}

	@Override
	public void logLocalTransactionEnded(String callerClassName,
			String callerMethodName, String transactionId) {
		JDBC_LOGGER.debug(DOMA2064.getMessage(transactionId));
	}

	@Override
	public void logLocalTransactionSavepointCreated(String callerClassName,
			String callerMethodName, String transactionId, String savepointName) {
		JDBC_LOGGER.debug(DOMA2065.getMessage(transactionId, savepointName));
	}

	@Override
	public void logLocalTransactionSavepointReleased(String callerClassName,
			String callerMethodName, String transactionId, String savepointName) {
		JDBC_LOGGER.debug(DOMA2066.getMessage(transactionId, savepointName));
	}

	@Override
	public void logLocalTransactionCommitted(String callerClassName,
			String callerMethodName, String transactionId) {
		JDBC_LOGGER.debug(DOMA2067.getMessage(transactionId));
	}

	@Override
	public void logLocalTransactionRolledback(String callerClassName,
			String callerMethodName, String transactionId) {
		JDBC_LOGGER.debug(DOMA2068.getMessage(transactionId));
	}

	@Override
	public void logLocalTransactionSavepointRolledback(String callerClassName,
			String callerMethodName, String transactionId, String savepointName) {
		JDBC_LOGGER.debug(DOMA2069.getMessage(transactionId, savepointName));

	}

	@Override
	public void logLocalTransactionRollbackFailure(String callerClassName,
			String callerMethodName, String transactionId, SQLException e) {
		JDBC_LOGGER.error(DOMA2070.getMessage(transactionId));
	}

	@Override
	public void logAutoCommitEnablingFailure(String callerClassName,
			String callerMethodName, SQLException e) {
		JDBC_LOGGER.debug(DOMA2071.getMessage(), e);
	}

	@Override
	public void logTransactionIsolationSettingFailuer(String callerClassName,
			String callerMethodName, int transactionIsolationLevel,
			SQLException e) {
		JDBC_LOGGER.error(DOMA2072.getMessage(transactionIsolationLevel), e);
	}

	@Override
	public void logConnectionClosingFailure(String callerClassName,
			String callerMethodName, SQLException e) {
		JDBC_LOGGER.error(DOMA2073.getMessage(), e);
	}

	@Override
	public void logStatementClosingFailure(String callerClassName,
			String callerMethodName, SQLException e) {
		JDBC_LOGGER.error(DOMA2074.getMessage(), e);
	}

	@Override
	public void logResultSetClosingFailure(String callerClassName,
			String callerMethodName, SQLException e) {
		JDBC_LOGGER.error(DOMA2075.getMessage(), e);
	}

}
