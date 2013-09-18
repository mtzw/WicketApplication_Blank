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

package my.blank.project.entity;

import java.io.Serializable;

import java.math.BigDecimal;
import java.sql.Date;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.Table;
import org.seasar.doma.Version;

/**
 * 
 */
@Entity(listener = EmpListener.class)
@Table(name = "EMP")
public class Emp implements Serializable {

    /**  */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    Long id;

    /**  */
    @Column(name = "EMP_NO")
    Integer empNo;

    /**  */
    @Column(name = "EMP_NAME")
    String empName;

    /**  */
    @Column(name = "MGR_ID")
    Integer mgrId;

    /**  */
    @Column(name = "HIREDATE")
    Date hiredate;

    /**  */
    @Column(name = "SAL")
    BigDecimal sal;

    /**  */
    @Column(name = "DEPT_ID")
    Integer deptId;

    /**  */
    @Version
    @Column(name = "VERSION_NO")
    Integer versionNo;

    /** 
     * Returns the id.
     * 
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /** 
     * Sets the id.
     * 
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /** 
     * Returns the empNo.
     * 
     * @return the empNo
     */
    public Integer getEmpNo() {
        return empNo;
    }

    /** 
     * Sets the empNo.
     * 
     * @param empNo the empNo
     */
    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }

    /** 
     * Returns the empName.
     * 
     * @return the empName
     */
    public String getEmpName() {
        return empName;
    }

    /** 
     * Sets the empName.
     * 
     * @param empName the empName
     */
    public void setEmpName(String empName) {
        this.empName = empName;
    }

    /** 
     * Returns the mgrId.
     * 
     * @return the mgrId
     */
    public Integer getMgrId() {
        return mgrId;
    }

    /** 
     * Sets the mgrId.
     * 
     * @param mgrId the mgrId
     */
    public void setMgrId(Integer mgrId) {
        this.mgrId = mgrId;
    }

    /** 
     * Returns the hiredate.
     * 
     * @return the hiredate
     */
    public Date getHiredate() {
        return hiredate;
    }

    /** 
     * Sets the hiredate.
     * 
     * @param hiredate the hiredate
     */
    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    /** 
     * Returns the sal.
     * 
     * @return the sal
     */
    public BigDecimal getSal() {
        return sal;
    }

    /** 
     * Sets the sal.
     * 
     * @param sal the sal
     */
    public void setSal(BigDecimal sal) {
        this.sal = sal;
    }

    /** 
     * Returns the deptId.
     * 
     * @return the deptId
     */
    public Integer getDeptId() {
        return deptId;
    }

    /** 
     * Sets the deptId.
     * 
     * @param deptId the deptId
     */
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    /** 
     * Returns the versionNo.
     * 
     * @return the versionNo
     */
    public Integer getVersionNo() {
        return versionNo;
    }

    /** 
     * Sets the versionNo.
     * 
     * @param versionNo the versionNo
     */
    public void setVersionNo(Integer versionNo) {
        this.versionNo = versionNo;
    }
}