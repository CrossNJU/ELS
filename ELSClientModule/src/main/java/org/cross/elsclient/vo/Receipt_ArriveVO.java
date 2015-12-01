/**
 * 到达单VO
 * @author raychen
 * @date 2015/10/21
 */
package org.cross.elsclient.vo;

import java.util.ArrayList;

import org.cross.elscommon.util.City;
import org.cross.elscommon.util.OrganizationType;
import org.cross.elscommon.util.ReceiptType;

public class Receipt_ArriveVO extends ReceiptVO {

	/**
	 * 出发地
	 */
	public City startPlace;

	/**
	 * 转运单编号
	 */
	public String transNum;

	/**
	 * 货物信息
	 */
	public ArrayList<String> orders;

	/**
	 * 到达的机构
	 */
	public OrganizationType arriveOrg;

	public Receipt_ArriveVO(String number, ReceiptType type, String time, City startPlace, String transNum,
			ArrayList<String> orders, OrganizationType arriveOrg) {
		super(number, type, time);
		this.startPlace = startPlace;
		this.transNum = transNum;
		this.orders = orders;
		this.arriveOrg = arriveOrg;
	}
	
	public void print(){
		super.print();
		System.out.println("到达单：出发地："+startPlace.toString()+" ,转运单编号："+transNum+" ,到达的机构："+arriveOrg.toString());
		System.out.println("array: 货物信息：");
		if (orders == null)	 {
			System.out.println("null");
		}else {
			for (int i = 0; i < orders.size(); i++) {
				System.out.println(orders.get(i));
			}
		}
		System.out.println("-------转运单打印结束");
	}

}
