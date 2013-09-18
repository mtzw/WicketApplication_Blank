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

import static org.easymock.EasyMock.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import my.blank.project.entity.Emp;
import my.blank.project.service.EmpService;

import org.apache.wicket.markup.html.list.PageableListView;
import org.apache.wicket.markup.html.navigation.paging.IPageableItems;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Test;
import org.seasar.framework.unit.S2TigerTestCase;
import org.seasar.framework.unit.annotation.EasyMock;
import org.seasar.wicket.ComponentInjectionListener;

public class EmpListTest extends S2TigerTestCase {

	@EasyMock(register = true)
	protected EmpService empService;

	/**
	 * WicketTester
	 */
	protected WicketTester tester;

	/**
	 * Configure WicketTester instance.
	 */
	@Override
	protected void setUp() throws Exception {
		tester = new WicketTester(EmpList.class);
		tester.getApplication().getComponentInstantiationListeners()
				.add(new ComponentInjectionListener());
		tester.getApplication().getMarkupSettings()
				.setDefaultMarkupEncoding("utf-8");
	}

	@Test
	public void testRenderEmpListPage() {
		List<Emp> empList = new ArrayList<>();
		Emp emp = new Emp();
		emp.setId(110L);
		emp.setEmpNo(97768);
		emp.setEmpName("Test Engineer");
		empList.add(emp);

		expect(empService.selectAll()).andReturn(empList).anyTimes();

		replay(empService);

		// start and render the test page
		tester.startPage(EmpList.class);

		// assert rendered page class
		tester.assertRenderedPage(EmpList.class);

		// assert rendered components
		tester.assertContains("EmpList");
		tester.assertContains("EmpId");
		tester.assertContains("EmpNo");
		tester.assertContains("EmpName");

		tester.assertComponent("empList", PageableListView.class);
		IPageableItems renderedEmpList = (IPageableItems) tester
				.getComponentFromLastRenderedPage("empList");
		assertThat(renderedEmpList.getItemCount(), is(1L));
		tester.assertContains("110");
		tester.assertContains("97768");
		tester.assertContains("Test Engineer");

		tester.assertComponent("navigator", PagingNavigator.class);

		verify(empService);
	}

}
