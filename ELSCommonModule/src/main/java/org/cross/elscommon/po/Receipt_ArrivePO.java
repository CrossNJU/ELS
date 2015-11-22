/**
 * 到达单PO
 * @author raychen
 * @date 2015/20/23
 */
package org.cross.elscommon.po;

import java.util.ArrayList;

import org.cross.elscommon.util.City;
import org.cross.elscommon.util.OrganizationType;
import org.cross.elscommon.util.ReceiptType;

public class Receipt_ArrivePO extends ReceiptPO {

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

	public Receipt_ArrivePO(String number, ReceiptType type, String time, City startPlace, String transNum,
			ArrayList<String> orders, OrganizationType arriveOrg) {
		super(number, type, time);
		this.startPlace = startPlace;
		this.transNum = transNum;
		this.orders = orders;
		this.arriveOrg = arriveOrg;
	}

	public City getStartPlace() {
		return startPlace;
	}

	public void setStartPlace(City startPlace) {
		this.startPlace = startPlace;
	}

	public String getTransNum() {
		return transNum;
	}

	public void setTransNum(String transNum) {
		this.transNum = transNum;
	}

	public ArrayList<String> getGoodslist() {
		return orders;
	}

	public void setGoodslist(ArrayList<String> orders) {
		this.orders = orders;
	}

	public OrganizationType getArriveOrg() {
		return arriveOrg;
	}

	public void setArriveOrg(OrganizationType arriveOrg) {
		this.arriveOrg = arriveOrg;
	}

}
