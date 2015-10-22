/**
 * 付款单VO类
 * @author raychen
 * @date 2015/10/22
 */
package org.cross.elsclient.vo;

import org.cross.elsclient.po.PersonnelPO;
import org.cross.elsclient.util.Type_receipt;

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
	public PersonnelPO receivePerson;
	
	/**
	 * 付款账号
	 */
	public String ID;
	
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
	public Receipt_MoneyOutVO(String number, String time, double money, PersonnelPO receivePerson,
			String iD, String clause, String comments) {
		super(number, Type_receipt.MONEYOUT);
		this.time = time;
		this.money = money;
		this.receivePerson = receivePerson;
		ID = iD;
		this.clause = clause;
		this.comments = comments;
		this.number = number;
	}
	
}
