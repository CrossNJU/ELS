/**
 * 单据VO类
 * @author raychen
 * @date 2015/10/21
 */
package org.cross.elsclient.vo;

import org.cross.elsclient.util.ReceiptType;

public class ReceiptVO {
	
	/**
	 * 单据编号
	 */
	public String number;
	
	/**
	 * 单据类型
	 */
	public ReceiptType type;
	
	/**
	 * 单据生成时间
	 */
	public String time;
	
	/**
	 * 构造方法
	 * @param number
	 * @param type
	 * @param time
	 */
	public ReceiptVO(String number, ReceiptType type, String time){
		this.number = number;
		this.type = type;
		this.time = time;
	}
	
	/**
	 * 默认构造方法
	 */
	public ReceiptVO(){
		
	}
}
