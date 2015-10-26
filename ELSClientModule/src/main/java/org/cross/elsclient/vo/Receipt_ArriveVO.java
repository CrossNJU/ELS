/**
 * 到达单VO
 * @author raychen
 * @date 2015/10/21
 */
package org.cross.elsclient.vo;

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
	 * 货物信息
	 */
	public GoodsVO good;
	
	/**
	 * 构造方法
	 * @param time
	 * @param city
	 * @param number
	 * @param good
	 */
	public Receipt_ArriveVO(String time, City city, String number,
			GoodsVO good){
		super(number, ReceiptType.ARRIVE, time);
		this.time = time;
		this.city = city;
		this.number = number;
		this.good = good;
	}
}
