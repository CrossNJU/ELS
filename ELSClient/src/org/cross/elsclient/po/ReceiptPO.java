/**
 * 单据PO
 * @author raychen
 * @date 2015/10/21
 */
package org.cross.elsclient.po;

import java.io.Serializable;

import org.cross.elsclient.util.ReceiptType;

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
	 * 单据类型
	 */
	private ReceiptType type;
	
	/**
	 * 单据生成时间
	 */
	private String time;
	
	/**
	 * 构造方法
	 * @param number
	 * @param type
	 * @param time
	 */
	public ReceiptPO(String number, ReceiptType type, String time){
		this.number = number;
		this.type = type;
		this.time = time;
	}
	
	/**
	 * 默认构造方法
	 */
	public ReceiptPO(){
		
	}

	public String getNumber() {
		return number;
	}
	

	public void setNumber(String number) {
		this.number = number;
	}
	

	public ReceiptType getType() {
		return type;
	}
	

	public void setType(ReceiptType type) {
		this.type = type;
	}
	

	public String getTime() {
		return time;
	}
	

	public void setTime(String time) {
		this.time = time;
	}
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
