package my.blank.project.service;

import java.util.List;

import my.blank.project.dao.EmpDao;
import my.blank.project.entity.Emp;

import org.seasar.framework.container.annotation.tiger.Binding;

public class EmpService {

	@Binding
	protected EmpDao empDao;

	public List<Emp> selectAll() {
		return empDao.selectAll();
	}

}
