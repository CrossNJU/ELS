/**
 * 总收款单VO类
 * @author raychen
 * @date 2015/10/22
 */
package org.cross.elsclient.vo;

import java.util.ArrayList;

import org.cross.elsclient.util.City;
import org.cross.elsclient.util.ReceiptType;

public class Receipt_TotalMoneyInVO extends ReceiptVO{
	
	/**
	 * 收款日期
	 */
	public String time;
	
	/**
	 * 收款人
	 */
	public PersonnelVO person;
	
	/**
	 * 总收款金额
	 */
	public double sum;
	
	/**
	 * 收款单
	 */
	public ArrayList<Receipt_MoneyInVO> receipt_Moneyins;
	
	/**
	 * 收款地点
	 */
	public City city;
	
	/**
	 * 收款单编号
	 */
	public String number;

	/**
	 * 构造函数
	 * @param time
	 * @param person
	 * @param city
	 * @param number
	 */
	public Receipt_TotalMoneyInVO(String time, PersonnelVO person,
			City city, String number) {
		super(number, ReceiptType.TOTALMONEYIN, time);
		this.time = time;
		this.person = person;
		this.city = city;
		this.number = number;
		
		this.receipt_Moneyins = new ArrayList<Receipt_MoneyInVO>();
		this.sum = 0;
	}
}
