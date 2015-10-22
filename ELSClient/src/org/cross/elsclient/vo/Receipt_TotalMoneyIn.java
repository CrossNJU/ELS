/**
 * 总收款单VO类
 * @author raychen
 * @date 2015/10/22
 */
package org.cross.elsclient.vo;

import java.util.ArrayList;

import org.cross.elsclient.po.PersonnelPO;
import org.cross.elsclient.util.Type_receipt;

public class Receipt_TotalMoneyIn extends ReceiptVO{
	
	/**
	 * 收款日期
	 */
	public String time;
	
	/**
	 * 收款人
	 */
	public PersonnelPO person;
	
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
	public String place;
	
	/**
	 * 收款单编号
	 */
	public String number;

	/**
	 * 构造函数
	 * @param time
	 * @param person
	 * @param place
	 * @param number
	 */
	public Receipt_TotalMoneyIn(String time, PersonnelPO person,
			String place, String number) {
		super(number, Type_receipt.TOTALMONEYIN);
		this.time = time;
		this.person = person;
		this.place = place;
		this.number = number;
		
		this.receipt_Moneyins = new ArrayList<Receipt_MoneyInVO>();
		this.sum = 0;
	}
}
