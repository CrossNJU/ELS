package org.cross.elsclient.vo;

import org.cross.elsclient.util.Type_receipt;

public class Receipt_OrderVO extends ReceiptVO{
	//寄件人/收件人，
	
	/**
	 * 快件信息
	 */
	public GoodsVO goods;
	
	/**
	 * 
	 */
	public double cost;
	public String receiveTime;
	public String expectTime;
	
	public String number;
	
	public Receipt_OrderVO(GoodsVO goods,
			double cost, String receiveTime, 
			String expectTime, String number){
		this.goods = goods;
		this.expectTime = expectTime;
		this.cost = cost;
		this.receiveTime = receiveTime;
		
		this.number = number;
		super.number = number;
		super.type = Type_receipt.ORDER;
	}
	
	public Receipt_OrderVO(String number){
		this.number = number;
		super.number = number;
		super.type = Type_receipt.ORDER;
	}
	
}
