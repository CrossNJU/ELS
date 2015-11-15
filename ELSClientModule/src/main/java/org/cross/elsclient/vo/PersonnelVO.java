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
	public String id;
	/**
	 * 人员姓名
	 */
	public String name;
	/**
	 * 人员职位
	 */
	public PositionType position;
	/**
	 * 人员所属机构type
	 */
	public OrganizationType organization;
	/**
	 * 人员所属机构编号
	 */
	public String organizationID;
	/**
	 * 人员工资
	 */
	public double payment;
	/**
	 * 已处理单据
	 */
	public ArrayList<ReceiptVO> dealedReceipts;

	/**
	 * 构造方法
	 * 
	 * @param id
	 * @param name
	 * @param position
	 */
	public PersonnelVO(String id, String name, PositionType position,OrganizationType organization,String organizationID) {
		this.id = id;
		this.name = name;
		this.position = position;
		this.organization = organization;
		this.organizationID = organizationID;
		
		this.payment = 0;
		this.dealedReceipts = new ArrayList<ReceiptVO>();
	}
}
