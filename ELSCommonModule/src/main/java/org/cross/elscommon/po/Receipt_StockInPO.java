/**
 * 入库单PO
 * @author raychen
 * @date 2015/10/23
 */
package org.cross.elscommon.po;

import java.io.Serializable;

import org.cross.elscommon.util.ReceiptType;

public class Receipt_StockInPO extends ReceiptPO implements Serializable{
	/**
	 * 序列化UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 快递编号
	 */
	private String goodsNumber;
	
	/**
	 * 入库日期
	 */
	private String time;
	
	/**
	 * 放到仓库的位置
	 */
	private StockAreaPO place;
	
	/**
	 * 入库单编号
	 */
	private String number;
	
	/**
	 * 构造方法
	 * @param goodsNumber
	 * @param time
	 * @param stock
	 * @param number
	 */
	public Receipt_StockInPO(String goodsNumber, String time, 
			StockAreaPO stock, String number){
		super(number, ReceiptType.STOCKIN, time);
		this.goodsNumber = goodsNumber;
		this.time = time;
		this.place = stock;
		
		this.number = number;
	}

	public String getGoodsNumber() {
		return goodsNumber;
	}
	

	public void setGoodsNumber(String goodsNumber) {
		this.goodsNumber = goodsNumber;
	}
	

	public String getTime() {
		return time;
	}
	

	public void setTime(String time) {
		this.time = time;
	}
	

	public StockAreaPO getPlace() {
		return place;
	}
	

	public void setPlace(StockAreaPO place) {
		this.place = place;
	}
	

	public String getNumber() {
		return number;
	}
	

	public void setNumber(String number) {
		this.number = number;
	}
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
