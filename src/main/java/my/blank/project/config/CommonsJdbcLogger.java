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

import java.sql.SQLException;

import org.seasar.doma.jdbc.JdbcLogger;
import org.seasar.doma.jdbc.Sql;
import org.seasar.doma.jdbc.SqlExecutionSkipCause;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonsJdbcLogger implements JdbcLogger {

	@Override
	public void logConnectionClosingFailure(String callerClassName,
			String callerMethodName, SQLException e) {
	}

	@Override
	public void logStatementClosingFailure(String callerClassName,
			String callerMethodName, SQLException e) {
	}

	@Override
	public void logResultSetClosingFailure(String callerClassName,
			String callerMethodName, SQLException e) {
	}

	@Override
	public void logAutoCommitEnablingFailure(String callerClassName,
			String callerMethodName, SQLException e) {
	}

	@Override
	public void logTransactionIsolationSettingFailuer(String callerClassName,
			String callerMethodName, int transactionIsolationLevel,
			SQLException e) {
	}

	@Override
	public void logDaoMethodEntering(String callerClassName,
			String callerMethodName, Object... parameters) {
		Logger logger = LoggerFactory.getLogger(callerClassName);
		logger.info("START " + callerClassName + "#" + callerMethodName);
	}

	@Override
	public void logDaoMethodExiting(String callerClassName,
			String callerMethodName, Object result) {
		Logger logger = LoggerFactory.getLogger(callerClassName);
		logger.info("END   " + callerClassName + "#" + callerMethodName);
	}

	@Override
	public void logDaoMethodThrowing(String callerClassName,
			String callerMethodName, RuntimeException e) {
		Logger logger = LoggerFactory.getLogger(callerClassName);
		logger.info("END   " + callerClassName + "#" + callerMethodName
				+ " RuntimeException: " + e);
	}

	@Override
	public void logSqlExecutionSkipping(String callerClassName,
			String callerMethodName, SqlExecutionSkipCause cause) {
		Logger logger = LoggerFactory.getLogger(callerClassName);
		logger.info("SKIPPED(" + cause.name() + ") " + callerClassName + "#"
				+ callerMethodName);
	}

	@Override
	public void logSql(String callerClassName, String callerMethodName,
			Sql<?> sql) {
		Logger logger = LoggerFactory.getLogger(callerClassName);
		String message = String.format("SQL log. sqlFilePath=[%s],%n%s",
				sql.getSqlFilePath(), sql.getFormattedSql());
		logger.info(message);
	}

	@Override
	public void logLocalTransactionBegun(String callerClassName,
			String callerMethodName, String transactionId) {
	}

	@Override
	public void logLocalTransactionCommitted(String callerClassName,
			String callerMethodName, String transactionId) {
	}

	@Override
	public void logLocalTransactionRolledback(String callerClassName,
			String callerMethodName, String transactionId) {
	}

	@Override
	public void logLocalTransactionSavepointCreated(String callerClassName,
			String callerMethodName, String transactionId, String savepointName) {
	}

	@Override
	public void logLocalTransactionSavepointReleased(String callerClassName,
			String callerMethodName, String transactionId, String savepointName) {
	}

	@Override
	public void logLocalTransactionSavepointRolledback(String callerClassName,
			String callerMethodName, String transactionId, String savepointName) {
	}

	@Override
	public void logLocalTransactionRollbackFailure(String callerClassName,
			String callerMethodName, String transactionId, SQLException e) {
	}

	@Override
	public void logLocalTransactionEnded(String callerClassName,
			String callerMethodName, String transactionId) {
	}

}
