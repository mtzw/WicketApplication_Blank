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

package my.blank.project.web.page;

import my.blank.project.entity.Emp;
import my.blank.project.service.EmpService;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PageableListView;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.seasar.framework.container.annotation.tiger.Binding;

/**
 * EmpList
 */
public class EmpList extends WebPage {

	private static final long serialVersionUID = 1L;

	@Binding
	protected EmpService empService;

	public EmpList(final PageParameters parameters) {
		PageableListView<Emp> listView;
		add(listView = new PageableListView<Emp>("empList",
				empService.selectAll(), 5) {
			private static final long serialVersionUID = -7590937969459283595L;

			@Override
			protected void populateItem(ListItem<Emp> item) {
				Emp emp = item.getModelObject();
				item.add(new Label("emp_id", emp.getId()));
				item.add(new Label("emp_no", emp.getEmpNo()));
				item.add(new Label("emp_name", emp.getEmpName()));
			}
		});
		add(new PagingNavigator("navigator", listView));
	}

}
