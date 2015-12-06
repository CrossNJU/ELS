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
	 * 目的地(营业厅name)
	 */
	public String targetOrgName;

	/**
	 * 目的地(营业厅ID)
	 */
	public String targetOrgID;
	/**
	 * 仓库区号
	 */
	public String stockAreaNum;

	public Receipt_StockInVO(String number, ReceiptType type, String time,
			String goodsNumber, String targetOrgName, String targetOrgID,
			String stockAreaNum) {
		super(number, type, time);
		this.goodsNumber = goodsNumber;
		this.targetOrgName = targetOrgName;
		this.targetOrgID = targetOrgID;
		this.stockAreaNum = stockAreaNum;
	}

}
