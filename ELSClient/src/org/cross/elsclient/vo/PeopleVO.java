/**
 * 寄/收件人VO类
 * @author raychen
 * @date 2015/10/23
 */
package org.cross.elsclient.vo;

import java.util.ArrayList;

import org.cross.elsclient.po.GoodsPO;

public class PeopleVO {

	/**
	 * 寄出/将收的货物
	 */
	public ArrayList<GoodsPO> goods;
	
	/**
	 * 寄/收件人姓名
	 */
	public String name;
	
	/**
	 * 寄/收件人地址
	 */
	public String address;
	
	/**
	 * 寄/收件人电话
	 */
	public String phone;
		
	/**
	 * 构造方法
	 * @param name
	 * @param address
	 * @param phone
	 */
	public PeopleVO(String name, String address, String phone){
		this.name = name;
		this.address = address;
		this.phone = phone;
	}
	
}
