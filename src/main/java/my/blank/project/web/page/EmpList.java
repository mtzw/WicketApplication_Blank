package my.blank.project.web.page;

import my.blank.project.entity.Emp;
import my.blank.project.service.EmpService;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
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
		add(new ListView<Emp>("empList", empService.selectAll()) {
			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<Emp> item) {
				Emp emp = item.getModelObject();
				item.add(new Label("emp_id", emp.getId()));
				item.add(new Label("emp_no", emp.getEmpNo()));
				item.add(new Label("emp_name", emp.getEmpName()));
			}
		});
	}

}
