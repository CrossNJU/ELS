/**
 * 入库单VO类
 * @author raychen
 * @date 2015/10/22
 */
package org.cross.elsclient.vo;

import org.cross.elsclient.po.StockPO;
import org.cross.elsclient.util.Type_receipt;

public class Receipt_StockInVO extends ReceiptVO{
	/**
	 * 快递编号
	 */
	public String goodsNumber;
	
	/**
	 * 入库日期
	 */
	public String time;
	
	/**
	 * 放到仓库的位置....
	 */
	public StockPO place;
	
	/**
	 * 入库单编号
	 */
	public String number;
	
	/**
	 * 构造方法
	 * @param goodsNumber
	 * @param time
	 * @param stock
	 * @param number
	 */
	public Receipt_StockInVO(String goodsNumber, String time, 
			StockPO stock, String number){
		this.goodsNumber = goodsNumber;
		this.time = time;
		this.place = stock;
		
		this.number = number;
		super.number = number;
		super.type = Type_receipt.STOCKIN;
	}
}
