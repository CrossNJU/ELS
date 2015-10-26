/**
 * 大仓库中区的PO
 * @author danni
 * @date 2015/10/22
 */
package org.cross.elsclient.po;

import java.io.Serializable;
import java.util.ArrayList;

import org.cross.elsclient.util.StockType;

public class StockAreaPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	private ArrayList<GoodsPO> goodsList;

	/**
	 * 构造方法
	 * @param stockType
	 * @param totalCapacity
	 */
	public StockAreaPO(StockType stockType,int totalCapacity){
		this.stockType = stockType;
		this.totalCapacity = totalCapacity;
		
		usedCapacity = 0;
		goodsList = new ArrayList<GoodsPO>();
	}
	
	public StockType getStockType(){
		return stockType;
	}
	public void setStockType(StockType stockType){
		this.stockType = stockType;
	}
	
	public int getTotalCapacity(){
		return totalCapacity;
	}
	public void setTotalCapacity(int totalCapacity){
		this.totalCapacity = totalCapacity;
	}
	
	public int getUsedCapacity(){
		return usedCapacity;
	}
	public void setUsedCapacity(int usedCapacity){
		this.usedCapacity = usedCapacity;
	}
	
	public ArrayList<GoodsPO> getGoodsList(){
		return goodsList;
	}
	public void setGoodList(ArrayList<GoodsPO> po){
		this.goodsList = po;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
