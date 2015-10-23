/**
 * 收款单PO
 * @author raychen
 * @date 2015/10/23
 */
package org.cross.elsclient.po;

import java.io.Serializable;
import java.util.ArrayList;

import org.cross.elsclient.util.ReceiptType;

public class Receipt_MoneyInPO extends ReceiptPO implements Serializable{

	/**
	 * 序列化UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 收款日期
	 */
	private String time;
	
	/**
	 * 收款金额
	 */
	private double money;
	
	/**
	 * 收款快递员
	 */
	private PersonnelPO person;
	
	/**
	 * 所有订单条形码号
	 */
	private ArrayList<String> orderNumbers;
	
	/**
	 * 收款单编号
	 */
	private String number;
	
	/**
	 * 构造方法
	 * @param time
	 * @param money
	 * @param person
	 * @param number
	 */
	public Receipt_MoneyInPO(String time, double money, PersonnelPO person, String number){
		super(number, ReceiptType.MONEYIN, time);
		this.time = time;
		this.money = money;
		this.person = person;
		
		this.number = number;
		this.orderNumbers = new ArrayList<String>();
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
	

	public PersonnelPO getPerson() {
		return person;
	}
	

	public void setPerson(PersonnelPO person) {
		this.person = person;
	}
	

	public ArrayList<String> getOrderNumbers() {
		return orderNumbers;
	}
	

	public void setOrderNumbers(ArrayList<String> orderNumbers) {
		this.orderNumbers = orderNumbers;
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
