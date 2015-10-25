/**
 * 大仓库中区的VO
 * @author danni
 * @date 2015/10/22
 */
package org.cross.elsclient.vo;

import java.util.ArrayList;

import org.cross.elsclient.util.StockType;

public class StockAreaVO {
	
	/**
	 * 特定仓库类型
	 */
	public StockType stockType;
	
	/**
	 * 特定仓库总容量
	 */
	public int totalCapacity;
	
	/**
	 * 特定仓库已用容量
	 */
	public int usedCapacity;
	
	/**
	 * 特定仓库中存放的快递
	 */
	public ArrayList<GoodsVO> goodsList;

	/**
	 * 构造方法
	 * @param stockType
	 * @param totalCapacity
	 */
	public StockAreaVO(StockType stockType,int totalCapacity){
		this.stockType = stockType;
		this.totalCapacity = totalCapacity;
		
		usedCapacity = 0;
		goodsList = new ArrayList<GoodsVO>();
	}
}
