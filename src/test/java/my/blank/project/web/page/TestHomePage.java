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
