/**
 * 转运单VO类（包括装车单、中转单、营业厅派件单）
 * @author raychen
 * @date 2015/10/22
 */
package org.cross.elsclient.vo;

import java.util.ArrayList;

import org.cross.elscommon.util.City;
import org.cross.elscommon.util.OrganizationType;
import org.cross.elscommon.util.ReceiptType;

public class Receipt_TransVO extends ReceiptVO{

	/**
	 * 所有装运单号
	 */
	public ArrayList<String> orders;

	/**
	 * 运费
	 */
	public double cost;

	/**
	 * 转运单所属机构
	 */
	public OrganizationType org;

	/**
	 * 中转中心/营业厅汽运编号
	 */
	public String localNum;

	/**
	 * 车次/航班号(车辆代号)
	 */
	public String vehicleNum;

	/**
	 * 出发地
	 */
	public City startCity;

	/**
	 * 到达地
	 */
	public City arriveCity;

	/**
	 * 监装员
	 */
	public PersonnelVO observer;

	/**
	 * 押运员（司机）
	 */
	public PersonnelVO driver;

	public Receipt_TransVO(String number, ReceiptType type, String time, ArrayList<String> orders, double cost,
			OrganizationType org, String localNum, String vehicleNum, City startCity, City arriveCity,
			PersonnelVO observer, PersonnelVO driver) {
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

}
