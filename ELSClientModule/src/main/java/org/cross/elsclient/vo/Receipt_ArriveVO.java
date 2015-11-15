/**
 * 到达单VO
 * @author raychen
 * @date 2015/10/21
 */
package org.cross.elsclient.vo;

import java.util.ArrayList;

import org.cross.elscommon.util.City;
import org.cross.elscommon.util.ReceiptType;

public class Receipt_ArriveVO extends ReceiptVO{
	
	/**
	 * 到达日期
	 */
	public String time;
	
	/**
	 * 出发地
	 */
	public City city;
	
	/**
	 * 到达单编号
	 */
	public String number;
	
	/**
	 * 转运单编号
	 */
	public String transNumber;
	
	/**
	 * 货物信息
	 */
	public ArrayList<GoodsVO> goods;
	
	/**
	 * 构造方法
	 * @param time
	 * @param city
	 * @param number
	 * @param transNumber 
	 */
	public Receipt_ArriveVO(String time, City city, String number, String transNumber){
		super(number, ReceiptType.ARRIVE, time);
		this.time = time;
		this.city = city;
		this.number = number;
		this.transNumber = transNumber;
		
		this.goods = new ArrayList<GoodsVO>();
	}
}
