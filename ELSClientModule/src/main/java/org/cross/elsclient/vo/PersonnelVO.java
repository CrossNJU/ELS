/**
 * 人员VO
 * @author Polaris Chen
 * @date 2015/10/19
 */
package org.cross.elsclient.vo;


import org.cross.elscommon.po.SalaryPO;
import org.cross.elscommon.util.ConstantVal;
import org.cross.elscommon.util.PositionType;
import org.cross.elscommon.util.SalaryType;

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
			String id, String phone, String birthday) {
		super();
		this.number = number;
		this.name = name;
		this.sex = sex;
		this.id = id;
		this.phone = phone;
		this.position = position;
		this.birthday = birthday;
		this.orgNum = orgNum;
		
		SalaryType type;
		double once = 0;
		double num = 0;
		
		switch (position) {
		case DRIVER:
			type = SalaryType.ADDONCE;
			once = ConstantVal.constant.getOnce();
			break;
		case COURIER:
			type = SalaryType.ADDNUM;
			num = ConstantVal.constant.getNum();
			break;
		default:
			type = SalaryType.BYMONTHONLY;
		}
		
		this.salary = new SalaryPO(type, ConstantVal.constant.getBaseMoney(position), once, num, number);
	}

}
