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
