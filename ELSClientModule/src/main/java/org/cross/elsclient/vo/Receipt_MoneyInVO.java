/**
 * 营业厅收款单VO类
 * @author raychen
 * @date 2015/10/22
 */
package org.cross.elsclient.vo;

import java.util.ArrayList;

import org.cross.elscommon.util.ReceiptType;

public class Receipt_MoneyInVO extends ReceiptVO {

	/**
	 * 收款金额
	 */
	public double money;

	/**
	 * 收款快递员
	 */
	public PersonnelVO person;

	/**
	 * 所有订单条形码号
	 */
	public ArrayList<String> orderNumbers;

	/**
	 * 收款营业厅+编号
	 */
	public String businessHallNameID;

	public Receipt_MoneyInVO(String time,
			double money, PersonnelVO person,String number,
			ArrayList<String> orderNumbers,
			String businessHallNameID) {
		super(number, ReceiptType.MONEYIN, time);
		this.money = money;
		this.person = person;
		this.orderNumbers = orderNumbers;
		this.businessHallNameID = businessHallNameID;
	}

}
