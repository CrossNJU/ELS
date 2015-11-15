/**
 * 订单VO类
 * @author raychen
 * @date 2015/10/22
 */
package org.cross.elsclient.vo;

import org.cross.elscommon.util.City;
import org.cross.elscommon.util.People;
import org.cross.elscommon.util.ReceiptType;

public class Receipt_OrderVO extends ReceiptVO{
	
	/**
	 * 快件信息
	 */
	public GoodsVO goods;
	
	/**
	 * 费用
	 */
	public double cost;
	
	/**
	 * 收件时间
	 */
	public String receiveTime;
	
	/**
	 * 预计到达时间
	 */
	public String expectTime;
	
	/**
	 * 目的地
	 */
	public City targetPlace;
	
	/**
	 * 出发地
	 */
	public City startPlace;
	
	/**
	 * 订单编号
	 */
	public String number;
	
	/**
	 * 寄件人
	 */
	public People pushPeople;
	
	/**
	 * 收件人
	 */
	public People receivePeople;
	
	/**
	 * 订单创建时间
	 */
	public String time;
	
	/**
	 * 构造方法
	 * @param goods
	 * @param receiveTime
	 * @param expectTime
	 * @param number
	 * @param targetPlace
	 * @param startPlace
	 * @param pushPeople
	 * @param receivePeople
	 * @param time
	 */
	public Receipt_OrderVO(GoodsVO goods,
			String receiveTime, 
			String expectTime, String number,
			City targetPlace, City startPlace,
			People pushPeople, People receivePeople,
			String time){
		super(number, ReceiptType.ORDER, time);
		this.goods = goods;
		this.expectTime = expectTime;
		this.receiveTime = receiveTime;
		this.targetPlace = targetPlace;
		this.startPlace = startPlace;
		this.pushPeople = pushPeople;
		this.receivePeople = receivePeople;
		this.time = time;
		
		this.number = number;
		this.cost = 0;
	}
	
	/**
	 * 缺省构造方法
	 * @param number
	 * @param time
	 */
	public Receipt_OrderVO(String number, String time){
		super(number, ReceiptType.ORDER, time);
		this.number = number;
		this.time = time;
	}
	
}
