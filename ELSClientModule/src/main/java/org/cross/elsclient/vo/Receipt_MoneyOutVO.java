/**
 * 付款单VO类
 * @author raychen
 * @date 2015/10/22
 */
package org.cross.elsclient.vo;

import org.cross.elscommon.util.ReceiptType;

public class Receipt_MoneyOutVO extends ReceiptVO{
	
	/**
	 * 付款金额
	 */
	public double money;
	
	/**
	 * 付款人name+ID
	 */
	public String perNameID;

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

	public Receipt_MoneyOutVO(String number, ReceiptType type, String time,
			double money, String perNameID, String receiveID,
			String clause, String comments) {
		super(number, type, time);
		this.money = money;
		this.perNameID = perNameID;
		this.receiveID = receiveID;
		this.clause = clause;
		this.comments = comments;
	}

	
}
