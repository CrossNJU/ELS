/**
 * 寄/收件人PO类
 * @author raychen
 * @date 2015/10/22
 */
package org.cross.elsclient.po;

import java.io.Serializable;
import java.util.ArrayList;

public class PeoplePO implements Serializable{
	/**
	 * 序列化UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 寄出/将收的货物
	 */
	private ArrayList<GoodsPO> goods;
	
	/**
	 * 寄/收件人姓名
	 */
	private String name;
	
	/**
	 * 寄/收件人地址
	 */
	private String address;
	
	/**
	 * 寄/收件人电话
	 */
	private String phone;
		
	/**
	 * 构造方法
	 * @param name
	 * @param address
	 * @param phone
	 */
	public PeoplePO(String name, String address, String phone){
		this.name = name;
		this.address = address;
		this.phone = phone;
	}
	
	public void setGoods(GoodsPO good){
		this.goods.add(good);
	}
	
	public ArrayList<GoodsPO> getGoods(){
		return this.goods;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setAddress(String address){
		this.address = address;
	}
	
	public String getAddress(){
		return this.address;
	}
	
	public void setPhone(String phone){
		this.phone = phone;
	}
	
	public String getPhone(){
		return this.phone;
	}
}
