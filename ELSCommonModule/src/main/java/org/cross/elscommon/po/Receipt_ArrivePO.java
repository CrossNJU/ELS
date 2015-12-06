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
	private String startPlace;

	private String startTime;

	/**
	 * 转运单编号
	 */
	private String transNum;

	/**
	 * 到达机构
	 */
	private String arriPlace;

	public Receipt_ArrivePO(String number, ReceiptType type, String time, String orgNum, String perNum,
			String startPlace, String startTime, String transNum, String arriPlace) {
		super(number, type, time, orgNum, perNum);
		this.startPlace = startPlace;
		this.startTime = startTime;
		this.transNum = transNum;
		this.arriPlace = arriPlace;
	}

	public String getStartPlace() {
		return startPlace;
	}

	public void setStartPlace(String startPlace) {
		this.startPlace = startPlace;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getTransNum() {
		return transNum;
	}

	public void setTransNum(String transNum) {
		this.transNum = transNum;
	}

	public String getArriPlace() {
		return arriPlace;
	}

	public void setArriPlace(String arriPlace) {
		this.arriPlace = arriPlace;
	}

}
