/**
 * 到达单PO
 * @author raychen
 * @date 2015/20/23
 */
package org.cross.elsclient.po;

import java.io.Serializable;

import org.cross.elsclient.util.City;
import org.cross.elsclient.util.ReceiptType;

public class Receipt_ArrivePO extends ReceiptPO implements Serializable{

	/**
	 * 序列化UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 到达日期
	 */
	private String time;
	
	/**
	 * 出发地
	 */
	private City city;
	
	/**
	 * 到达单编号
	 */
	private String number;
	
	/**
	 * 货物信息
	 */
	private GoodsPO good;
	
	/**
	 * 构造方法
	 * @param time
	 * @param city
	 * @param number
	 * @param good
	 */
	public Receipt_ArrivePO(String time, City city, String number,
			GoodsPO good){
		super(number, ReceiptType.ARRIVE, time);
		this.time = time;
		this.city = city;
		this.number = number;
		this.good = good;
	}

	public String getTime() {
		return time;
	}
	

	public void setTime(String time) {
		this.time = time;
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
	

	public GoodsPO getGood() {
		return good;
	}
	

	public void setGood(GoodsPO good) {
		this.good = good;
	}
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
