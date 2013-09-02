package my.blank.project.service;

import static org.easymock.EasyMock.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seasar.framework.container.annotation.tiger.Binding;
import org.seasar.framework.unit.Seasar2;
import org.seasar.framework.unit.annotation.EasyMock;
import org.seasar.framework.unit.annotation.EasyMockType;

@RunWith(Seasar2.class)
public class EmpServiceTest {

	@Binding
	protected EmpService empService;

	@EasyMock(register = false, value = EasyMockType.NICE)
	private EmpService mockService;

	@Test
	public void testInject() {
		assertThat(empService, is(notNullValue()));
	}

	@Test
	@SuppressWarnings("unchecked")
	public void testSelectAll() {
		expect(mockService.selectAll()).andReturn(Collections.EMPTY_LIST)
				.anyTimes();

		replay(mockService);

		assertThat(mockService.selectAll(), is(Collections.EMPTY_LIST));

		verify(mockService);
	}

}
