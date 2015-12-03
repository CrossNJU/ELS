/**
 * 收款单PO
 * @author raychen
 * @date 2015/10/23
 */
package org.cross.elscommon.po;

import java.io.Serializable;
import java.util.ArrayList;

import org.cross.elscommon.util.ReceiptType;

public class Receipt_MoneyInPO extends ReceiptPO implements Serializable {

	/**
	 * 收款金额
	 */
	private double money;

	public Receipt_MoneyInPO(String number, ReceiptType type, String time,
			String orgNum, String perNum, double money) {
		super(number, type, time, orgNum, perNum);
		this.money = money;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

}
