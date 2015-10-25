/**
 * 库存操作PO类
 * @author danni
 * @date 2015/10/25
 */
package org.cross.elsclient.po;

import java.io.Serializable;

import org.cross.elsclient.util.StockOperationType;
import org.cross.elsclient.util.StockType;
import org.cross.elsclient.vo.StockOperationVO;

public class StockOperationPO implements Serializable{
	
	/**
	 * 序列化UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 时间
	 */
	private String time;
	
	/**
	 * 类型
	 */
	private StockOperationType type;
	
	/**
	 * 快件
	 */
	private GoodsPO good;
	
	/**
	 * 金额
	 */
	private double money;
	
	/**
	 * 存放位置
	 */
	private StockType place;

	/**
	 * 构造方法
	 * @param time
	 * @param type
	 * @param good
	 * @param money
	 * @param place
	 */
	public StockOperationPO(String time, StockOperationType type, GoodsPO good, double money, StockType place) {
		super();
		this.time = time;
		this.type = type;
		this.good = good;
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
	

	public GoodsPO getGood() {
		return good;
	}
	

	public void setGood(GoodsPO good) {
		this.good = good;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public StockOperationVO toVO(){
		StockOperationVO vo = new StockOperationVO(this.time, this.type, this.good.toVO(), this.money, this.place);
		return vo;
	}
}
