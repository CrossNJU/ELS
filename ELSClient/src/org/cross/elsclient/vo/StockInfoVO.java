/**
 * 库存查看VO类
 * @author danni
 * @date 2015/10/19
 */
package org.cross.elsclient.vo;

public class StockInfoVO {
	/**
	 * 起始时间
	 */
	public String startTime;
	/**
	 *终止时间 
	 */
	public String endTime;
	/**
	 * 出库数量
	 */
	public int numOut;
	
	/**
	 * 入库数量
	 */
	public int numIn;
	
	/**
	 * 出库金额
	 */
	public int moneyOut;
	
	/**
	 * 入库金额
	 */
	public int moneyIn;
	
	/**
	 * 库存数量
	 */
	public int numInStock;
	
	/**
	 * 存储位置
	 */
	public String locate;

}
