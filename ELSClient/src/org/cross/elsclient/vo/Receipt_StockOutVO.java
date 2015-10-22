/**
 * 出库单VO类
 * @author raychen
 * @date 2015/10/22
 */
package org.cross.elsclient.vo;

import org.cross.elsclient.util.Type_receipt;
import org.cross.elsclient.util.Type_vehicle;

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
	public String place;
	
	/**
	 * 装运形式
	 */
	public Type_vehicle vehicle;
	
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
	 * @param place
	 * @param vehicle
	 * @param transNumber
	 * @param number
	 */
	public Receipt_StockOutVO(String goodsNumber, String time, 
			String place, Type_vehicle vehicle, String transNumber,
			String number){
		this.goodsNumber = goodsNumber;
		this.time = time;
		this.place = place;
		this.vehicle = vehicle;
		this.transNumber = transNumber;
		
		this.number = number;
		super.number = number;
		super.type = Type_receipt.STOCKOUT;
	}
}
