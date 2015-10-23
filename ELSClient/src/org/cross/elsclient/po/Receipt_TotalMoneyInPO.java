/**
 * 总收款单PO
 * @author raychen
 * @date 2015/10/23
 */
package org.cross.elsclient.po;

import java.io.Serializable;
import java.util.ArrayList;

import org.cross.elsclient.util.City;
import org.cross.elsclient.util.ReceiptType;

public class Receipt_TotalMoneyInPO extends ReceiptPO implements Serializable{

	/**
	 * 序列化UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 收款日期
	 */
	private String time;
	
	/**
	 * 收款人
	 */
	private PersonnelPO person;
	
	/**
	 * 总收款金额
	 */
	private double sum;
	
	/**
	 * 收款单
	 */
	private ArrayList<Receipt_MoneyInPO> receipt_Moneyins;
	
	/**
	 * 收款地点
	 */
	private City city;
	
	/**
	 * 收款单编号
	 */
	private String number;

	/**
	 * 构造函数
	 * @param time
	 * @param person
	 * @param city
	 * @param number
	 */
	public Receipt_TotalMoneyInPO(String time, PersonnelPO person,
			City city, String number) {
		super(number, ReceiptType.TOTALMONEYIN, time);
		this.time = time;
		this.person = person;
		this.city = city;
		this.number = number;
		
		this.receipt_Moneyins = new ArrayList<Receipt_MoneyInPO>();
		this.sum = 0;
	}

	public String getTime() {
		return time;
	}
	

	public void setTime(String time) {
		this.time = time;
	}
	

	public PersonnelPO getPerson() {
		return person;
	}
	

	public void setPerson(PersonnelPO person) {
		this.person = person;
	}
	

	public double getSum() {
		return sum;
	}
	

	public void setSum(double sum) {
		this.sum = sum;
	}
	

	public ArrayList<Receipt_MoneyInPO> getReceipt_Moneyins() {
		return receipt_Moneyins;
	}
	

	public void setReceipt_Moneyins(ArrayList<Receipt_MoneyInPO> receipt_Moneyins) {
		this.receipt_Moneyins = receipt_Moneyins;
	}
	

	public City getCity() {
		return city;
	}
	

	public void setCity(City city) {
		this.city = city;
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
