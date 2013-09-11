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
