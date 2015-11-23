/**
 * 大仓库中区的PO
 * @author danni
 * @date 2015/10/22
 */
package org.cross.elscommon.po;

import java.io.Serializable;
import java.util.ArrayList;

import org.cross.elscommon.util.StockType;

public class StockAreaPO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 仓库小间编号
	 */
	private String number;

	/**
	 * 特定仓库类型
	 */
	private StockType stockType;

	/**
	 * 特定仓库总容量
	 */
	private int totalCapacity;

	/**
	 * 特定仓库已用容量
	 */
	private int usedCapacity;

	/**
	 * 特定仓库中存放的快递
	 */
	private ArrayList<GoodsPO> goodslist;

	public StockAreaPO(String number, StockType stockType, int totalCapacity) {
		super();
		this.number = number;
		this.stockType = stockType;
		this.totalCapacity = totalCapacity;

		this.usedCapacity = 0;
		this.goodslist = new ArrayList<GoodsPO>();
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public StockType getStockType() {
		return stockType;
	}

	public void setStockType(StockType stockType) {
		this.stockType = stockType;
	}

	public int getTotalCapacity() {
		return totalCapacity;
	}

	public void setTotalCapacity(int totalCapacity) {
		this.totalCapacity = totalCapacity;
	}

	public int getUsedCapacity() {
		return usedCapacity;
	}

	public void setUsedCapacity(int usedCapacity) {
		this.usedCapacity = usedCapacity;
	}

	public ArrayList<GoodsPO> getGoodslist() {
		return goodslist;
	}

	public void setGoodslist(ArrayList<GoodsPO> goodslist) {
		this.goodslist = goodslist;
	}

}
