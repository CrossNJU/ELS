/**
 * 库存操作VO类
 * @author danni
 * @date 2015/10/25
 */
package org.cross.elsclient.vo;

import org.cross.elsclient.util.StockOperationType;
import org.cross.elsclient.util.StockType;

public class StockOperationVO {
	/**
	 * 时间
	 */
	public String time;
	
	/**
	 * 类型
	 */
	public StockOperationType type;
	
	/**
	 * 快件
	 */
	public GoodsVO good;
	
	/**
	 * 金额
	 */
	public double money;
	
	/**
	 * 存放位置
	 */
	public StockType place;

	public StockOperationVO(String time, StockOperationType type, GoodsVO good, double money, StockType place) {
		super();
		this.time = time;
		this.type = type;
		this.good = good;
		this.money = money;
		this.place = place;
	}
	
}
