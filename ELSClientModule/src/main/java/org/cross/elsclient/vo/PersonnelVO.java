/**
 * 人员VO
 * @author Polaris Chen
 * @date 2015/10/19
 */
package org.cross.elsclient.vo;

import java.util.ArrayList;

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
	 * 人员所属机构名称 + 编号
	 */
	public String orgNameID;

	/**
	 * 人员工资
	 */
	public double payment;

	/**
	 * 人员工资提成
	 */
	public double extraMoney;

	public PersonnelVO(String number, String name, String sex, String id,
			String phone, PositionType position, String birthday,
			String orgNameID, double payment, double extraMoney) {
		super();
		this.number = number;
		this.name = name;
		this.sex = sex;
		this.id = id;
		this.phone = phone;
		this.position = position;
		this.birthday = birthday;
		this.orgNameID = orgNameID;
		this.payment = payment;
		this.extraMoney = extraMoney;
	}

}
