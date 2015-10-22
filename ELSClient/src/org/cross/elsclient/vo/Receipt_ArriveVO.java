/**
 * 到达单VO
 * @author raychen
 * @date 2015/10/21
 */
package org.cross.elsclient.vo;

public class Receipt_ArriveVO extends ReceiptVO{
	
	/**
	 * 到达日期
	 */
	public String time;
	
	/**
	 * 出发地
	 */
	public String place;
	
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
	 * @param place
	 * @param number
	 * @param good
	 */
	public Receipt_ArriveVO(String time, String place, String number,
			GoodsVO good){
		this.time = time;
		this.place = place;
		this.number = super.number;
		this.good = good;
	}
}
