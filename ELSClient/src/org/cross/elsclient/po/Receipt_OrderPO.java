/**
 * 订单PO类
 * @author raychen
 * @date 2015/10/21
 */
package org.cross.elsclient.po;

import java.io.Serializable;

import org.cross.elsclient.util.City;
import org.cross.elsclient.util.ReceiptType;
import org.cross.elsclient.vo.Receipt_OrderVO;

public class Receipt_OrderPO extends ReceiptPO implements Serializable{

	/**
	 * 序列化UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 快件信息
	 */
	private GoodsPO goods;
	
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
	 * 订单编号
	 */
	private String number;
	
	/**
	 * 寄件人
	 */
	private PeoplePO pushPeople;
	
	/**
	 * 收件人
	 */
	private PeoplePO receivePeople;
	
	/**
	 * 订单创建时间
	 */
	private String time;
	
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
	public Receipt_OrderPO(GoodsPO goods,
			String receiveTime, 
			String expectTime, String number,
			City targetPlace, City startPlace,
			PeoplePO pushPeople, PeoplePO receivePeople,
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
	public Receipt_OrderPO(String number, String time){
		super(number, ReceiptType.ORDER, time);
		this.number = number;
		this.time = time;
	}

	public GoodsPO getGoods() {
		return goods;
	}
	

	public void setGoods(GoodsPO goods) {
		this.goods = goods;
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
	

	public String getNumber() {
		return number;
	}
	

	public void setNumber(String number) {
		this.number = number;
	}
	

	public PeoplePO getPushPeople() {
		return pushPeople;
	}
	

	public void setPushPeople(PeoplePO pushPeople) {
		this.pushPeople = pushPeople;
	}
	

	public PeoplePO getReceivePeople() {
		return receivePeople;
	}
	

	public void setReceivePeople(PeoplePO receivePeople) {
		this.receivePeople = receivePeople;
	}
	

	public String getTime() {
		return time;
	}
	

	public void setTime(String time) {
		this.time = time;
	}
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Receipt_OrderVO toVOsimple(){
		Receipt_OrderVO vo = new Receipt_OrderVO(this.number, this.expectTime);
		return vo;
	}
}
