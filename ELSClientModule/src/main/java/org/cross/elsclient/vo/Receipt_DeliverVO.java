package org.cross.elsclient.vo;

import org.cross.elscommon.util.ReceiptType;

public class Receipt_DeliverVO extends ReceiptVO{
	
	public String orderNum;

	public String name;

	public String posterNum;

	public Receipt_DeliverVO(String number, ReceiptType type, String time,
			String orderNum, String name, String posterNum) {
		super(number, type, time);
		this.orderNum = orderNum;
		this.name = name;
		this.posterNum = posterNum;
	}
	
	
}
