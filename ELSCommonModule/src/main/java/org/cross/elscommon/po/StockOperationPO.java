/**
 * 库存操作PO类
 * @author danni
 * @date 2015/10/25
 */
package org.cross.elscommon.po;

import org.cross.elscommon.util.StockOperationType;
import org.cross.elscommon.util.StockType;

public class StockOperationPO{

	/**
	 * 时间
	 */
	private String time;
	
	/**
	 * 类型（出入库）
	 */
	private StockOperationType type;
	
	/**
	 * 快件编号
	 */
	private String goodNum;
	
	/**
	 * 金额
	 */
	private double money;
	
	/**
	 * 存放小间类型
	 */
	private StockType place;

	public StockOperationPO(String time, StockOperationType type, String goodNum, double money, StockType place) {
		super();
		this.time = time;
		this.type = type;
		this.goodNum = goodNum;
		this.money = money;
		this.place = place;
	}

	public String getTime() {
		return time;
	}
	

	public void setTime(String time) {
		this.time = time;
	}
	

	public StockOperationType getType() {
		return type;
	}
	

	public void setType(StockOperationType type) {
		this.type = type;
	}
	

	public String getGoodNum() {
		return goodNum;
	}
	

	public void setGoodNum(String goodNum) {
		this.goodNum = goodNum;
	}
	

	public double getMoney() {
		return money;
	}
	

	public void setMoney(double money) {
		this.money = money;
	}
	

	public StockType getPlace() {
		return place;
	}
	

	public void setPlace(StockType place) {
		this.place = place;
	}
	
	
}
