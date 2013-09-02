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
