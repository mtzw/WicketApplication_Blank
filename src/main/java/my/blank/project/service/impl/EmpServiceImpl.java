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

package my.blank.project.service.impl;

import java.util.List;

import my.blank.project.dao.EmpDao;
import my.blank.project.entity.Emp;
import my.blank.project.service.EmpService;

import org.seasar.framework.container.annotation.tiger.Binding;

public class EmpServiceImpl implements EmpService {
	@Binding
	protected EmpDao empDao;

	public List<Emp> selectAll() {
		return empDao.selectAll();
	}

}
