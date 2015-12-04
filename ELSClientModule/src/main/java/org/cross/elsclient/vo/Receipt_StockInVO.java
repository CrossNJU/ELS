/**
 * 入库单VO类
 * @author raychen
 * @date 2015/10/22
 */
package org.cross.elsclient.vo;

import org.cross.elscommon.util.ReceiptType;

public class Receipt_StockInVO extends ReceiptVO {
	/**
	 * 快递编号
	 */
	public String goodsNumber;

	/**
	 * 入库日期
	 */
	public String time;

	/**
	 * 目的地(营业厅name+id)
	 */
	public String businessHallNameID;

	/**
	 * 入库单编号
	 */
	public String number;

	/**
	 * 仓库区号
	 */
	public String stockAreaNum;

	public Receipt_StockInVO(String number, ReceiptType type, String time,
			String goodsNumber, String time2, String businessHallNameID,
			String number2, String stockAreaNum) {
		super(number, type, time);
		this.goodsNumber = goodsNumber;
		time = time2;
		this.businessHallNameID = businessHallNameID;
		number = number2;
		this.stockAreaNum = stockAreaNum;
	}

}
