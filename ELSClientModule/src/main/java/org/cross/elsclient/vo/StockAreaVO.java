/**
 * 大仓库中区的VO
 * @author danni
 * @date 2015/10/22
 */
package org.cross.elsclient.vo;

import java.util.ArrayList;

import org.cross.elscommon.util.StockType;

public class StockAreaVO {
	
	/**
	 * 仓库小间编号
	 */
	public String number;
	
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

	public StockAreaVO(String number, StockType stockType, int totalCapacity) {
		super();
		this.number = number;
		this.stockType = stockType;
		this.totalCapacity = totalCapacity;
		
		this.usedCapacity = 0;
		this.goodsList = new ArrayList<GoodsVO>();
	}

}
