/**
 * 订单PO类
 * @author raychen
 * @date 2015/10/21
 */
package org.cross.elsclient.po;

import org.cross.elsclient.util.Type_receipt;

public class Receipt_OrderPO extends ReceiptPO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GoodsPO goods;
	private double cost;
	private String receiveTime;
	private String expectTime;
	
	private String number;
	
	public Receipt_OrderPO(GoodsPO goods,
			double cost, String receiveTime, 
			String expectTime, String number){
		this.goods = goods;
		this.expectTime = expectTime;
		this.cost = cost;
		this.receiveTime = receiveTime;
		
		this.number = number;
		super.setNumber(number);;
		super.setType(Type_receipt.ORDER);
	}
	
	public Receipt_OrderPO(String number){
		this.number = number;
		super.setNumber(number);
		super.setType(Type_receipt.ORDER);
	}
	
	public void setNumber(String number){
		this.number = number;
	}
	
	public String getNumber(){
		return this.number;
	}
	
	public void setGoods(GoodsPO goods){
		this.goods = goods;
	}
	
	public GoodsPO getGoods(){
		return this.goods;
	}
	
	public void cost(double cost){
		this.cost = cost;
	}
	
	public double getCost(){
		return this.cost;
	}
	
	public void setReceiveTime(String time){
		this.receiveTime = time;
	}
	
	public String getReceiveTime(){
		return this.receiveTime;
	}
	
	public void setExpectTime(String time){
		this.expectTime = time;
	}
	
	public String getExpectTime(){
		return this.expectTime;
	}
}
