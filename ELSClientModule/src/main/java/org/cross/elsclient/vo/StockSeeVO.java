/**
 * 仓库查看的vo
 */
package org.cross.elsclient.vo;

import java.util.ArrayList;

public class StockSeeVO {
	/**
	 * 入库数
	 */
	public int goodsIn;
	
	/**
	 * 出库数
	 */
	public int goodsOut;
	
	/**
	 * 入库金额
	 */
	public double moneyIn;
	
	/**
	 * 出库金额
	 */
	public double moneyOut;
	
	/**
	 * 库存数量合计
	 */
	public int totalInStock;
	
	/**
	 * 快件
	 */
	public ArrayList<GoodsVO> goods;
	
}
