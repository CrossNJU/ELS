/**
 * 总收款单VO类
 * @author raychen
 * @date 2015/10/22
 */
package org.cross.elsclient.vo;

import java.util.ArrayList;

import org.cross.elscommon.util.City;
import org.cross.elscommon.util.ReceiptType;

public class Receipt_TotalMoneyInVO extends ReceiptVO {

	/**
	 * 收款日期
	 */
	public String time;

	/**
	 * 收款人name+id
	 */
	public String perNameID;

	/**
	 * 总收款金额
	 */
	public double sum;

	/**
	 * 收款单
	 */
	public ArrayList<Receipt_MoneyInVO> receipt_Moneyins;

	/**
	 * 收款营业厅编号
	 */
	public String businessHallNum;

	/**
	 * 总收款单编号
	 */
	public String number;

	public Receipt_TotalMoneyInVO(String number, ReceiptType type, String time,
			String time2, String perNameID, double sum,
			ArrayList<Receipt_MoneyInVO> receipt_Moneyins,
			String businessHallNum, String number2) {
		super(number, type, time);
		time = time2;
		this.perNameID = perNameID;
		this.sum = sum;
		this.receipt_Moneyins = receipt_Moneyins;
		this.businessHallNum = businessHallNum;
		number = number2;
	}

}
