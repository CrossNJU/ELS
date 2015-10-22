/**
 * 订单VO类
 * @author raychen
 * @date 2015/10/22
 */
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
	 * @param receiveTime
	 * @param expectTime
	 * @param number
	 * @param targetPlace
	 * @param startPlace
	 * @param pushPeople
	 * @param receivePeople
	 */
	public Receipt_OrderVO(GoodsVO goods,
			String receiveTime, 
			String expectTime, String number,
			String targetPlace, String startPlace,
			PeoplePO pushPeople, PeoplePO receivePeople){
		this.goods = goods;
		this.expectTime = expectTime;
		this.receiveTime = receiveTime;
		this.targetPlace = targetPlace;
		this.startPlace = startPlace;
		this.pushPeople = pushPeople;
		this.receivePeople = receivePeople;
		
		this.number = number;
		super.number = number;
		super.type = Type_receipt.ORDER;
		this.cost = 0;
	}
	
	public Receipt_OrderVO(String number){
		this.number = number;
		super.number = number;
		super.type = Type_receipt.ORDER;
	}
	
}
