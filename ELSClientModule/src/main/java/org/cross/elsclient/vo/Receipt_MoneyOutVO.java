/**
 * 付款单VO类
 * @author raychen
 * @date 2015/10/22
 */
package org.cross.elsclient.vo;

import org.cross.elscommon.util.ReceiptType;

public class Receipt_MoneyOutVO extends ReceiptVO{

	/**
	 * 付款日期
	 */
	public String time;
	
	/**
	 * 付款金额
	 */
	public double money;
	
	/**
	 * 付款人
	 */
	public PersonnelVO personnel;

	/**
	 * 付款账号
	 */
	public String receiveID;
	
	/**
	 * 条目
	 */
	public String clause;
	
	/**
	 * 备注
	 */
	public String comments;
	
	/**
	 * 付款单编号
	 */
	public String number;

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
	public Receipt_MoneyOutVO(String number, String time, double money, PersonnelVO receivePerson,
			String iD, String clause, String comments) {
		super(number, ReceiptType.MONEYOUT, time);
		this.time = time;
		this.money = money;
		this.personnel = receivePerson;
		this.receiveID = iD;
		this.clause = clause;
		this.comments = comments;
		this.number = number;
	}
	
}
