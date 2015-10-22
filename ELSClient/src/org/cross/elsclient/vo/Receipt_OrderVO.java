package org.cross.elsclient.vo;

import org.cross.elsclient.po.PeoplePO;
import org.cross.elsclient.util.Type_receipt;

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
	public String targetPlace;
	
	/**
	 * 出发地
	 */
	public String startPlace;
	
	/**
	 * 订单编号
	 */
	public String number;
	
	/**
	 * 寄件人
	 */
	public PeoplePO pushPeople;
	
	/**
	 * 收件人
	 */
	public PeoplePO receivePeople;
	
	/**
	 * 构造方法
	 * @param goods
	 * @param cost
	 * @param receiveTime
	 * @param expectTime
	 * @param number
	 */
	public Receipt_OrderVO(GoodsVO goods,
			double cost, String receiveTime, 
			String expectTime, String number){
		this.goods = goods;
		this.expectTime = expectTime;
		this.cost = cost;
		this.receiveTime = receiveTime;
		
		this.number = number;
		super.number = number;
		super.type = Type_receipt.ORDER;
	}
	
	public Receipt_OrderVO(String number){
		this.number = number;
		super.number = number;
		super.type = Type_receipt.ORDER;
	}
	
}
