/**
 * 转运单PO
 * @author raychen
 * @date 2015/10/23
 */
package org.cross.elscommon.po;

import java.util.ArrayList;

import org.cross.elscommon.util.City;
import org.cross.elscommon.util.OrganizationType;
import org.cross.elscommon.util.ReceiptType;

public class Receipt_TransPO extends ReceiptPO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 所有装运单号
	 */
	private ArrayList<String> orders;

	/**
	 * 运费
	 */
	private double cost;

	/**
	 * 转运单所属机构
	 */
	private OrganizationType org;

	/**
	 * 中转中心/营业厅汽运编号
	 */
	private String localNum;

	/**
	 * 车次/航班号(车辆代号)
	 */
	private String vehicleNum;

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

	public Receipt_TransPO(String number, ReceiptType type, String time, ArrayList<String> orders, double cost,
			OrganizationType org, String localNum, String vehicleNum, City startCity, City arriveCity,
			PersonnelPO observer, PersonnelPO driver) {
		super(number, type, time);
		this.orders = orders;
		this.cost = cost;
		this.org = org;
		this.localNum = localNum;
		this.vehicleNum = vehicleNum;
		this.startCity = startCity;
		this.arriveCity = arriveCity;
		this.observer = observer;
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

	public OrganizationType getOrg() {
		return org;
	}

	public void setOrg(OrganizationType org) {
		this.org = org;
	}

	public String getLocalNum() {
		return localNum;
	}

	public void setLocalNum(String localNum) {
		this.localNum = localNum;
	}

	public String getVehicleNum() {
		return vehicleNum;
	}

	public void setVehicleNum(String vehicleNum) {
		this.vehicleNum = vehicleNum;
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

}
