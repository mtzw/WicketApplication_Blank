package my.blank.project.web.page;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * Homepage
 */
public class HomePage extends WebPage {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("serial")
	public HomePage(final PageParameters parameters) {
		add(new Label("message", "Congratulations!"));
		add(new Link<Void>("link") {
			@Override
			public void onClick() {
				setResponsePage(EmpList.class);
			}
		});
	}

}
