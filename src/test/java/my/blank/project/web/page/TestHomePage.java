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

import org.apache.wicket.util.tester.WicketTester;
import org.seasar.framework.unit.S2TigerTestCase;
import org.seasar.wicket.ComponentInjectionListener;

/**
 * Simple test using the WicketTester
 */
public class TestHomePage extends S2TigerTestCase {

	/**
	 * WicketTester
	 */
	protected WicketTester tester;

	/**
	 * Configure WicketTester instance.
	 */
	@Override
	protected void setUp() throws Exception {
		tester = new WicketTester();
		tester.getApplication().getComponentInstantiationListeners()
				.add(new ComponentInjectionListener());
		tester.getApplication().getMarkupSettings()
				.setDefaultMarkupEncoding("utf-8");
	}

	public void testRenderMyPage() {
		// start and render the test page
		tester.startPage(HomePage.class);

		// assert rendered page class
		tester.assertRenderedPage(HomePage.class);

		// assert rendered label component
		tester.assertLabel("message", "Congratulations!");
	}

}
