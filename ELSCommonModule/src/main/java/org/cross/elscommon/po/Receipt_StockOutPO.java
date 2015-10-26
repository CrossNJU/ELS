/**
 * 出库单PO
 * @author raychen
 * @date 2015/10/23
 */
package org.cross.elscommon.po;

import java.io.Serializable;

import org.cross.elscommon.util.City;
import org.cross.elscommon.util.ReceiptType;
import org.cross.elscommon.util.VehicleType;

public class Receipt_StockOutPO extends ReceiptPO implements Serializable{
	
	/**
	 * 序列化UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 快递编号
	 */
	private String goodsNumber;
	
	/**
	 * 出库日期
	 */
	private String time;
	
	/**
	 * 目的地
	 */
	private City city;
	
	/**
	 * 装运形式
	 */
	private VehicleType vehicle;
	
	/**
	 * 转运单编号
	 */
	private String transNumber;
	
	/**
	 * 出库单编号
	 */
	private String number;
	
	/**
	 * 构造方法
	 * @param goodsNumber
	 * @param time
	 * @param city
	 * @param vehicle
	 * @param transNumber
	 * @param number
	 */
	public Receipt_StockOutPO(String goodsNumber, String time, 
			City city, VehicleType vehicle, String transNumber,
			String number){
		super(number, ReceiptType.STOCKOUT, time);
		this.goodsNumber = goodsNumber;
		this.time = time;
		this.city = city;
		this.vehicle = vehicle;
		this.transNumber = transNumber;
		
		this.number = number;
	}

	public String getGoodsNumber() {
		return goodsNumber;
	}
	

	public void setGoodsNumber(String goodsNumber) {
		this.goodsNumber = goodsNumber;
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
	

	public VehicleType getVehicle() {
		return vehicle;
	}
	

	public void setVehicle(VehicleType vehicle) {
		this.vehicle = vehicle;
	}
	

	public String getTransNumber() {
		return transNumber;
	}
	

	public void setTransNumber(String transNumber) {
		this.transNumber = transNumber;
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
