/**
 * 单据PO
 * @author raychen
 * @date 2015/10/21
 */
package org.cross.elsclient.po;

import java.io.Serializable;

import org.cross.elsclient.util.Type_receipt;

public class ReceiptPO implements Serializable{
	
	
	/**
	 * 序列化UID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 单据编号
	 */
	private String number;
	
	/**
	 * 单据类型，包括到达单、收款单、付款单、订单、入库单、出库单、装车转运单
	 */
	private Type_receipt type;
	
	/**
	 * 构造方法
	 * @param number
	 * @param type
	 */
	public ReceiptPO(String number, Type_receipt type){
		this.number = number;
		this.type = type;
	}
	
	/**
	 * 默认构造方法
	 */
	public ReceiptPO(){
		
	}
	
	public void setNumber(String number){
		this.number = number;
	}
	
	public String getNumber(){
		return this.number;
	}
	
	public void setType(Type_receipt type){
		this.type = type;
	}
	
	public Type_receipt getType(){
		return this.type;
	}
}
