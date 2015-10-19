/**
 * 库存的VO
 * @author danni
 * @date 2015/10/19
 */
package org.cross.elsclient.vo;

import java.util.ArrayList;

public class StockVO {
	/**
	 * 仓库类型
	 */
	public String stockType;
	
	/**
	 * 仓库已用容量
	 */
	public static double stockCapacityUsed;
	
	/**
	 * 仓库中存放的快递
	 */
	public static ArrayList<GoodsVO> goodsList;
	
	/**
	 * 构造方法
	 * @param stockType
	 */
	
	public StockVO(String type){
		this.stockType = type;
		this.stockCapacityUsed = 0;
		this.goodsList = new ArrayList<GoodsVO>();
	}
}
