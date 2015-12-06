/**
 * 人员VO
 * @author Polaris Chen
 * @date 2015/10/19
 */
package org.cross.elsclient.vo;

import java.util.ArrayList;

import org.cross.elscommon.po.SalaryPO;
import org.cross.elscommon.util.City;
import org.cross.elscommon.util.OrganizationType;
import org.cross.elscommon.util.PositionType;
import org.omg.CORBA.PUBLIC_MEMBER;

public class PersonnelVO {

	/**
	 * 人员工号
	 */
	public String number;
	/**
	 * 人员姓名
	 */
	public String name;
	/**
	 * 人员性别
	 */
	public String sex;
	/**
	 * 人员身份证号
	 */
	public String id;
	/**
	 * 人员手机
	 */
	public String phone;
	/**
	 * 人员职位
	 */
	public PositionType position;
	/**
	 * 人员出生日期
	 */
	public String birthday;
	/**
	 * 人员所属机构编号
	 */
	public String orgNum;
	/**
	 * 薪资策略
	 */
	public SalaryPO salary;

	public PersonnelVO(String number, String name, PositionType position, String orgNum, String sex,
			String id, String phone, String birthday, SalaryPO salary) {
		super();
		this.number = number;
		this.name = name;
		this.sex = sex;
		this.id = id;
		this.phone = phone;
		this.position = position;
		this.birthday = birthday;
		this.orgNum = orgNum;
		this.salary = salary;
	}

}
