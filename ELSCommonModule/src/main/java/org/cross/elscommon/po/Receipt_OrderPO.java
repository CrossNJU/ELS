/**
 * 订单PO类
 * @author raychen
 * @date 2015/10/21
 */
package org.cross.elscommon.po;

import org.cross.elscommon.util.City;
import org.cross.elscommon.util.People;
import org.cross.elscommon.util.ReceiptType;

public class Receipt_OrderPO extends ReceiptPO {

	/**
	 * 快件信息
	 */
	private String goodsNum;

	/**
	 * 费用
	 */
	private double cost;

	/**
	 * 收件时间
	 */
	private String receiveTime;

	/**
	 * 预计到达时间
	 */
	private String expectTime;

	/**
	 * 目的地
	 */
	private City targetPlace;

	/**
	 * 出发地
	 */
	private City startPlace;

	/**
	 * 寄件人
	 */
	private People pushPeople;

	/**
	 * 收件人
	 */
	private People receivePeople;

	public Receipt_OrderPO(String number, ReceiptType type, String time, String goodsNum, double cost,
			String expectTime, City targetPlace, City startPlace, People pushPeople, People receivePeople) {
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

	public String getGoodsNum() {
		return goodsNum;
	}

	public void setGoodsNum(String goodsNum) {
		this.goodsNum = goodsNum;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getReceiveTime() {
		return receiveTime;
	}

	public void setReceiveTime(String receiveTime) {
		this.receiveTime = receiveTime;
	}

	public String getExpectTime() {
		return expectTime;
	}

	public void setExpectTime(String expectTime) {
		this.expectTime = expectTime;
	}

	public City getTargetPlace() {
		return targetPlace;
	}

	public void setTargetPlace(City targetPlace) {
		this.targetPlace = targetPlace;
	}

	public City getStartPlace() {
		return startPlace;
	}

	public void setStartPlace(City startPlace) {
		this.startPlace = startPlace;
	}

	public People getPushPeople() {
		return pushPeople;
	}

	public void setPushPeople(People pushPeople) {
		this.pushPeople = pushPeople;
	}

	public People getReceivePeople() {
		return receivePeople;
	}

	public void setReceivePeople(People receivePeople) {
		this.receivePeople = receivePeople;
	}

}
