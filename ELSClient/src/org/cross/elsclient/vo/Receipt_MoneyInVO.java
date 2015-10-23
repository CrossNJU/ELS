/**
 * 营业厅收款单VO类
 * @author raychen
 * @date 2015/10/22
 */
package org.cross.elsclient.vo;

import java.util.ArrayList;

import org.cross.elsclient.util.ReceiptType;

public class Receipt_MoneyInVO extends ReceiptVO{
	
	/**
	 * 收款日期
	 */
	public String time;
	
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
	 * 收款单编号
	 */
	public String number;
	
	/**
	 * 构造方法
	 * @param time
	 * @param money
	 * @param person
	 * @param number
	 */
	public Receipt_MoneyInVO(String time, double money, PersonnelVO person, String number){
		super(number, ReceiptType.MONEYIN, time);
		this.time = time;
		this.money = money;
		this.person = person;
		
		this.number = number;
		this.orderNumbers = new ArrayList<String>();
	}

}
