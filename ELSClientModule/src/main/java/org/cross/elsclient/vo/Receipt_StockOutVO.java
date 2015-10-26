/**
 * 出库单VO类
 * @author raychen
 * @date 2015/10/22
 */
package org.cross.elsclient.vo;

import org.cross.elscommon.util.City;
import org.cross.elscommon.util.ReceiptType;
import org.cross.elscommon.util.VehicleType;

public class Receipt_StockOutVO extends ReceiptVO{
	/**
	 * 快递编号
	 */
	public String goodsNumber;
	
	/**
	 * 出库日期
	 */
	public String time;
	
	/**
	 * 目的地
	 */
	public City city;
	
	/**
	 * 装运形式
	 */
	public VehicleType vehicle;
	
	/**
	 * 转运单编号
	 */
	public String transNumber;
	
	/**
	 * 出库单编号
	 */
	public String number;
	
	/**
	 * 构造方法
	 * @param goodsNumber
	 * @param time
	 * @param city
	 * @param vehicle
	 * @param transNumber
	 * @param number
	 */
	public Receipt_StockOutVO(String goodsNumber, String time, 
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
}
