/**
 * 转运单VO类（包括装车单、中转单、营业厅派件单）
 * @author raychen
 * @date 2015/10/22
 */
package org.cross.elsclient.vo;

import java.util.ArrayList;

import org.cross.elsclient.util.Type_receipt;

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
	public String startPlace;
	
	/**
	 * 到达地
	 */
	public String arrivePlace;
	
	/**
	 * 监装员
	 */
	public String observer;
	
	/**
	 * 押运员（司机）
	 */
	public String driver;
	
	/**
	 * 所有装运单号
	 */
	public ArrayList<Receipt_OrderVO> orders;

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
	 * @param startPlace
	 * @param arrivePlace
	 * @param observer
	 * @param driver
	 * @param orders
	 * @param cost
	 * @param number
	 */
	public Receipt_TransVO(String time, String localNumber, 
			String vehicleNumber, String startPlace, 
			String arrivePlace, String observer, 
			String driver, 
			double cost, String number){
		this.time = time;
		this.localNumber = localNumber;
		this.vehicleNumber = vehicleNumber;
		this.startPlace = startPlace;
		this.arrivePlace = arrivePlace;
		this.observer = observer;
		this.driver = driver;
		this.cost = cost;
		
		this.number = number;
		super.number = number;
		super.type = Type_receipt.TRANS;
		this.orders = new ArrayList<Receipt_OrderVO>();
	}
}
