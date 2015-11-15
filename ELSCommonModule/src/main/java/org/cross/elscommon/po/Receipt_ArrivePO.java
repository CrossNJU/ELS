/**
 * 到达单PO
 * @author raychen
 * @date 2015/20/23
 */
package org.cross.elscommon.po;

import java.io.Serializable;
import java.util.ArrayList;

import org.cross.elscommon.util.City;
import org.cross.elscommon.util.ReceiptType;

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
	private ArrayList<GoodsPO> goods;
	
	/**
	 * 转运单编号
	 */
	private String transNumber;
	
	/**
	 * 构造方法
	 * @param time
	 * @param city
	 * @param number
	 */
	public Receipt_ArrivePO(String time, City city, String number, String transNumber){
		super(number, ReceiptType.ARRIVE, time);
		this.time = time;
		this.city = city;
		this.number = number;
		this.transNumber = transNumber;
		
		this.goods = new ArrayList<GoodsPO>();
	}

	public ArrayList<GoodsPO> getGoods() {
		return goods;
	}
	
	public void setGoods(GoodsPO good) {
		this.goods.add(good);
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

	public String getTransNumber() {
		return transNumber;
	}
	

	public void setTransNumber(String transNumber) {
		this.transNumber = transNumber;
	}
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
