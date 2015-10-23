/**
 * 转运单PO
 * @author raychen
 * @date 2015/10/23
 */
package org.cross.elsclient.po;

import java.io.Serializable;
import java.util.ArrayList;

import org.cross.elsclient.util.City;
import org.cross.elsclient.util.ReceiptType;

public class Receipt_TransPO extends ReceiptPO implements Serializable{

	/**
	 * 序列化UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 装运日期
	 */
	private String time;
	
	/**
	 * 中转中心/营业厅汽运编号
	 */
	private String localNumber;
	
	/**
	 * 车次/航班号
	 */
	private String vehicleNumber;
	
	/**
	 * 出发地
	 */
	private City startCity;
	
	/**
	 * 到达地
	 */
	private City arriveCity;
	
	/**
	 * 监装员
	 */
	private PersonnelPO observer;
	
	/**
	 * 押运员（司机）
	 */
	private PersonnelPO driver;
	
	/**
	 * 所有装运单号
	 */
	private ArrayList<String> orders;

	/**
	 * 运费
	 */
	private double cost;
	
	/**
	 * 转运单编号
	 */
	public String number;
	
	/**
	 * 构造方法
	 * @param time
	 * @param localNumber
	 * @param vehicleNumber
	 * @param startCity
	 * @param arriveCity
	 * @param observer
	 * @param driver
	 * @param orders
	 * @param number
	 */
	public Receipt_TransPO(String time, String localNumber, 
			String vehicleNumber, City startCity, 
			City arriveCity, PersonnelPO observer, 
			PersonnelPO driver, 
			String number){
		super(number, ReceiptType.TRANS, time);
		this.time = time;
		this.localNumber = localNumber;
		this.vehicleNumber = vehicleNumber;
		this.startCity = startCity;
		this.arriveCity = arriveCity;
		this.observer = observer;
		this.driver = driver;
		
		this.number = number;
		this.orders = new ArrayList<String>();
		this.cost = 0;
	}

	public String getTime() {
		return time;
	}
	

	public void setTime(String time) {
		this.time = time;
	}
	

	public String getLocalNumber() {
		return localNumber;
	}
	

	public void setLocalNumber(String localNumber) {
		this.localNumber = localNumber;
	}
	

	public String getVehicleNumber() {
		return vehicleNumber;
	}
	

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	

	public City getStartCity() {
		return startCity;
	}
	

	public void setStartCity(City startCity) {
		this.startCity = startCity;
	}
	

	public City getArriveCity() {
		return arriveCity;
	}
	

	public void setArriveCity(City arriveCity) {
		this.arriveCity = arriveCity;
	}
	

	public PersonnelPO getObserver() {
		return observer;
	}
	

	public void setObserver(PersonnelPO observer) {
		this.observer = observer;
	}
	

	public PersonnelPO getDriver() {
		return driver;
	}
	

	public void setDriver(PersonnelPO driver) {
		this.driver = driver;
	}
	

	public ArrayList<String> getOrders() {
		return orders;
	}
	

	public void setOrders(ArrayList<String> orders) {
		this.orders = orders;
	}
	

	public double getCost() {
		return cost;
	}
	

	public void setCost(double cost) {
		this.cost = cost;
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
