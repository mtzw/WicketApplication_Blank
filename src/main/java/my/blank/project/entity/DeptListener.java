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

package my.blank.project.entity;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

/**
 * 
 */
public class DeptListener implements EntityListener<Dept> {

    @Override
    public void preInsert(Dept entity, PreInsertContext<Dept> context) {
    }

    @Override
    public void preUpdate(Dept entity, PreUpdateContext<Dept> context) {
    }

    @Override
    public void preDelete(Dept entity, PreDeleteContext<Dept> context) {
    }

    @Override
    public void postInsert(Dept entity, PostInsertContext<Dept> context) {
    }

    @Override
    public void postUpdate(Dept entity, PostUpdateContext<Dept> context) {
    }

    @Override
    public void postDelete(Dept entity, PostDeleteContext<Dept> context) {
    }
}