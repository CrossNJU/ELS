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
	public String goodsNum;

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
	 * 寄件人
	 */
	public People pushPeople;

	/**
	 * 收件人
	 */
	public People receivePeople;

	public Receipt_OrderVO(String number, ReceiptType type, String time, String goodsNum, double cost,
			String expectTime, City targetPlace, City startPlace, People pushPeople,
			People receivePeople) {
		super(number, type, time);
		this.goodsNum = goodsNum;
		this.cost = cost;
		this.expectTime = expectTime;
		this.targetPlace = targetPlace;
		this.startPlace = startPlace;
		this.pushPeople = pushPeople;
		this.receivePeople = receivePeople;
		
		this.receiveTime = null;
	}

}
