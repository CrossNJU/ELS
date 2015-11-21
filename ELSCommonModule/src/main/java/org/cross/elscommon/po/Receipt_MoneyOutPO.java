/**
 * 付款单PO
 * @author raychen
 * @date 2015/10/23
 */
package org.cross.elscommon.po;

import java.io.Serializable;

import org.cross.elscommon.util.ReceiptType;

public class Receipt_MoneyOutPO extends ReceiptPO implements Serializable{

	/**
	 * 序列化UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 付款日期
	 */
	private String time;
	
	/**
	 * 付款金额
	 */
	private double money;
	
	/**
	 * 付款人
	 */
	private PersonnelPO receivePerson;
	
	/**
	 * 付款账号
	 */
	private String ID;
	
	/**
	 * 条目
	 */
	private String clause;
	
	/**
	 * 备注
	 */
	private String comments;
	
	/**
	 * 付款单编号
	 */
	private String number;

	/**
	 * 构造方法
	 * @param number
	 * @param time
	 * @param money
	 * @param receivePerson
	 * @param iD
	 * @param clause
	 * @param comments
	 */
	public Receipt_MoneyOutPO(String number, String time, double money, PersonnelPO receivePerson,
			String iD, String clause, String comments) {
		super(number, ReceiptType.MONEYOUT, time);
		this.time = time;
		this.money = money;
		this.receivePerson = receivePerson;
		ID = iD;
		this.clause = clause;
		this.comments = comments;
		this.number = number;
	}

	public String getTime() {
		return time;
	}
	

	public void setTime(String time) {
		this.time = time;
	}
	

	public double getMoney() {
		return money;
	}
	

	public void setMoney(double money) {
		this.money = money;
	}
	

	public PersonnelPO getReceivePerson() {
		return receivePerson;
	}
	

	public void setReceivePerson(PersonnelPO receivePerson) {
		this.receivePerson = receivePerson;
	}
	

	public String getID() {
		return ID;
	}
	

	public void setID(String iD) {
		ID = iD;
	}
	

	public String getClause() {
		return clause;
	}
	

	public void setClause(String clause) {
		this.clause = clause;
	}
	

	public String getComments() {
		return comments;
	}
	

	public void setComments(String comments) {
		this.comments = comments;
	}
	

	public String getNumber() {
		return number;
	}
	

	public void setNumber(String number) {
		this.number = number;
	}
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}