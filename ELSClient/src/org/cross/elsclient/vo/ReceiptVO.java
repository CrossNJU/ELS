/**
 * 单据VO类
 * @author raychen
 * @date 2015/10/21
 */
package org.cross.elsclient.vo;

import org.cross.elsclient.util.Type_receipt;

public class ReceiptVO {
	
	/**
	 * 单据编号
	 */
	public String number;
	
	/**
	 * 单据类型
	 */
	public Type_receipt type;
	
	/**
	 * 构造方法
	 * @param number
	 * @param type
	 */
	public ReceiptVO(String number, Type_receipt type){
		this.number = number;
		this.type = type;
	}
	
	/**
	 * 构造方法
	 */
	public ReceiptVO(){
		
	}
}
