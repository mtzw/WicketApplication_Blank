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

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;

import junit.framework.TestCase;

import org.seasar.doma.jdbc.SqlFile;
import org.seasar.doma.jdbc.dialect.Dialect;

/**
 * SQLTest
 */
public class SqlTest extends TestCase {

    /**  */
    protected SqlFileRepositoryProxy repository;

    /**  */
    protected Dialect dialect;

    /**  */
    protected Driver driver;

    /**  */
    protected String url;

    /**  */
    protected String user;

    /**  */
    protected String password;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        repository = new SqlFileRepositoryProxy();
        dialect = new org.seasar.doma.jdbc.dialect.H2Dialect();
        @SuppressWarnings("unchecked")
        Class<Driver> driverClass = (Class<Driver>) Class
                .forName("org.h2.Driver");
        driver = driverClass.newInstance();
        DriverManager.registerDriver(driver);
        url = "jdbc:h2:file:demo";
        user = "sa";
        password = "";
    }

    @Override
    protected void tearDown() throws Exception {
        DriverManager.deregisterDriver(driver);
        super.tearDown();
    }

    /**
     *
     * @param sqlFile
     * @throws Exception
     */
    protected void execute(SqlFile sqlFile) throws Exception {
        Connection connection = getConnection();
        try {
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            try {
                statement.execute(sqlFile.getSql());
            } finally {
                statement.close();
            }
        } finally {
            try {
                connection.rollback();
            } finally {
                connection.close();
            }
        }
    }

    /**
     *
     * @return @throws Exception
     */
    protected Connection getConnection() throws Exception {
        return DriverManager.getConnection(url, user, password);
    }

    /**
     *
     * @throws Exception
     */
    public void test0() throws Exception {
        SqlFile sqlFile = repository
                .getSqlFile(
                        "META-INF/my/blank/project/dao/DeptDao/selectById.sql",
                        dialect);
        execute(sqlFile);
    }

    /**
     *
     * @throws Exception
     */
    public void test1() throws Exception {
        SqlFile sqlFile = repository
                .getSqlFile(
                        "META-INF/my/blank/project/dao/DeptDao/selectByIdAndVersion.sql",
                        dialect);
        execute(sqlFile);
    }

    /**
     *
     * @throws Exception
     */
    public void test2() throws Exception {
        SqlFile sqlFile = repository.getSqlFile(
                "META-INF/my/blank/project/dao/EmpDao/selectAll.sql", dialect);
        execute(sqlFile);
    }

    /**
     *
     * @throws Exception
     */
    public void test3() throws Exception {
        SqlFile sqlFile = repository.getSqlFile(
                "META-INF/my/blank/project/dao/EmpDao/selectById.sql", dialect);
        execute(sqlFile);
    }

    /**
     *
     * @throws Exception
     */
    public void test4() throws Exception {
        SqlFile sqlFile = repository
                .getSqlFile(
                        "META-INF/my/blank/project/dao/EmpDao/selectByIdAndVersion.sql",
                        dialect);
        execute(sqlFile);
    }

}
