/**
 * 出库单VO类
 * @author raychen
 * @date 2015/10/22
 */
package org.cross.elsclient.vo;

import java.util.ArrayList;

import org.cross.elscommon.util.City;
import org.cross.elscommon.util.ReceiptType;
import org.cross.elscommon.util.VehicleType;

public class Receipt_StockOutVO extends ReceiptVO {
	/**
	 * 快递编号
	 */
	public ArrayList<String> goodsNumber;

	/**
	 * 出库日期
	 */
	public String time;

	/**
	 * 目的地(营业厅name)
	 */
	public String targetOrgName;

	/**
	 * 目的地(营业厅ID)
	 */
	public String targetOrgID;

	/**
	 * 装运形式
	 */
	public String vehicle;

	/**
	 * 转运单编号
	 */
	public String transNumber;

	/**
	 * 出库单编号
	 */
	public String number;

	public Receipt_StockOutVO(String number, ReceiptType type, String time,
			ArrayList<String> goodsNumber, String time2, String targetOrgName,
			String targetOrgID, String vehicle, String transNumber,
			String number2) {
		super(number, type, time);
		this.goodsNumber = goodsNumber;
		time = time2;
		this.targetOrgName = targetOrgName;
		this.targetOrgID = targetOrgID;
		this.vehicle = vehicle;
		this.transNumber = transNumber;
		number = number2;
	}

}
