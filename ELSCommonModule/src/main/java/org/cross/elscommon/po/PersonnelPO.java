/**
 * 人员PO
 * @author Polaris Chen
 * @date 2015/10/19
 */
package org.cross.elscommon.po;

import java.io.Serializable;
import java.util.ArrayList;

import org.cross.elscommon.util.OrganizationType;
import org.cross.elscommon.util.PositionType;

public class PersonnelPO implements Serializable {

	/**
	 * 序列化UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 人员工号
	 */
	private String id;
	/**
	 * 人员姓名
	 */
	private String name;
	/**
	 * 人员职位
	 */
	private PositionType position;
	/**
	 * 人员所属机构type
	 */
	private OrganizationType organization;
	/**
	 * 人员所属机构ID
	 */
	private String organizationID;
	/**
	 * 人员工资
	 */
	private double payment;
	/**
	 * 已处理单据
	 */
	private ArrayList<ReceiptPO> dealedReceipts;
	
	public ArrayList<ReceiptPO> getDealedReceipts() {
		return dealedReceipts;
	}

	public void setDealedReceipts(ArrayList<ReceiptPO> dealedReceipts) {
		this.dealedReceipts = dealedReceipts;
	}

	public double getPayment() {
		return payment;
	}

	public void setPayment(double payment) {
		this.payment = payment;
	}
	
	/**
	 * 构造方法
	 * 
	 * @param id
	 * @param name
	 * @param position
	 */
	public PersonnelPO(String id, String name, PositionType position,OrganizationType organization,String organizationID) {
		this.id = id;
		this.name = name;
		this.position = position;
		this.organization = organization;
		this.organizationID = organizationID;
		
		this.payment = 0;
		this.dealedReceipts = new ArrayList<ReceiptPO>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PositionType getPosition() {
		return position;
	}

	public void setPosition(PositionType position) {
		this.position = position;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public OrganizationType getOrganization() {
		return organization;
	}

	public void setOrganization(OrganizationType organization) {
		this.organization = organization;
	}

	public String getOrganizationID() {
		return organizationID;
	}

	public void setOrganizationID(String organizationID) {
		this.organizationID = organizationID;
	}

}
