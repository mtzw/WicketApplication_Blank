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
@Entity(listener = DeptListener.class)
@Table(name = "DEPT")
public class Dept implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -3407478611280476876L;

	/**  */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    Long id;

    /**  */
    @Column(name = "DEPT_NO")
    Integer deptNo;

    /**  */
    @Column(name = "DEPT_NAME")
    String deptName;

    /**  */
    @Column(name = "LOC")
    String loc;

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
     * Returns the deptNo.
     * 
     * @return the deptNo
     */
    public Integer getDeptNo() {
        return deptNo;
    }

    /** 
     * Sets the deptNo.
     * 
     * @param deptNo the deptNo
     */
    public void setDeptNo(Integer deptNo) {
        this.deptNo = deptNo;
    }

    /** 
     * Returns the deptName.
     * 
     * @return the deptName
     */
    public String getDeptName() {
        return deptName;
    }

    /** 
     * Sets the deptName.
     * 
     * @param deptName the deptName
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    /** 
     * Returns the loc.
     * 
     * @return the loc
     */
    public String getLoc() {
        return loc;
    }

    /** 
     * Sets the loc.
     * 
     * @param loc the loc
     */
    public void setLoc(String loc) {
        this.loc = loc;
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