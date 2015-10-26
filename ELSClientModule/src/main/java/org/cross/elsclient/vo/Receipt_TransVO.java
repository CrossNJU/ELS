/**
 * 转运单VO类（包括装车单、中转单、营业厅派件单）
 * @author raychen
 * @date 2015/10/22
 */
package org.cross.elsclient.vo;

import java.util.ArrayList;

import org.cross.elscommon.util.City;
import org.cross.elscommon.util.ReceiptType;

public class Receipt_TransVO extends ReceiptVO{
	
	/**
	 * 装运日期
	 */
	public String time;
	
	/**
	 * 中转中心/营业厅汽运编号
	 */
	public String localNumber;
	
	/**
	 * 车次/航班号
	 */
	public String vehicleNumber;
	
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
	
	/**
	 * 所有装运单号
	 */
	public ArrayList<String> orders;

	/**
	 * 运费
	 */
	public double cost;
	
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
	public Receipt_TransVO(String time, String localNumber, 
			String vehicleNumber, City startCity, 
			City arriveCity, PersonnelVO observer, 
			PersonnelVO driver, 
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
}
