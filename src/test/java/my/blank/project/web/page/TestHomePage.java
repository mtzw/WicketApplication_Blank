package my.blank.project.web.page;

import junit.framework.TestCase;

import org.apache.wicket.util.tester.WicketTester;

/**
 * Simple test using the WicketTester
 */
public class TestHomePage extends TestCase {
	private WicketTester tester;

	public void setUp() {
		tester = new WicketTester();
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
