/**
 * 大仓库中区的PO
 * @author danni
 * @date 2015/10/22
 */
package org.cross.elsclient.po;

import java.util.ArrayList;

public class StockAreaPO {
	/**
	 * 特定仓库类型
	 */
	private String stockType;
	
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
	private static ArrayList<GoodsPO> goodsList;

	/**
	 * 构造方法
	 * @param stockType
	 * @param totalCapacity
	 */
	public StockAreaPO(String stockType,int totalCapacity){
		this.stockType = stockType;
		this.totalCapacity = totalCapacity;
		
		usedCapacity = 0;
		goodsList = new ArrayList<GoodsPO>();
	}
	
	public String getStockType(){
		return stockType;
	}
	public void setStockType(String stockType){
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
	
}
