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

package my.blank.project.dao;

import my.blank.project.entity.Dept;

import org.seasar.doma.jdbc.Config;

/**
 */
@SuppressWarnings("unused")
public class DeptDaoDelegate {

    private final Config config;

    private final DeptDao dao;

    /**
     * @param config the config
     * @param dao the Dao
     */
    public DeptDaoDelegate(Config config, DeptDao dao) {
        if (config == null) {
            throw new NullPointerException("config");
        }
        if (dao == null) {
            throw new NullPointerException("dao");
        }
        this.config = config;
        this.dao = dao;
    }

    /**
     * @param entity
     * @return affected rows
     */
    public int insertOrUpdate(Dept entity) {
        return -1;
    }

    /**
     * @param entity
     * @return affected rows
     */
    public int insert(Dept entity) {
        return -1;
    }

    /**
     * @param entity
     * @return affected rows
     */
    public int update(Dept entity) {
        return -1;
    }

    /**
     * @param entity
     * @return affected rows
     */
    public int delete(Dept entity) {
        return -1;
    }
}