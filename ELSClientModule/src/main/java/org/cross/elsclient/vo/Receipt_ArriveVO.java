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
	 * 出发地(机构name+id)
	 */
	public String startOrgNameID;

	/**
	 * 转运单编号
	 */
	public String transNum;
	/**
	 * 出发时间
	 */
	public String startTime;
	/**
	 * 到达时间
	 */
	public String time;
	/**
	 * 货物信息
	 */
	public ArrayList<GoodsVO> goods;

	/**
	 * 到达的机构name+id
	 */
	public String arriveOrgNameID;

	public Receipt_ArriveVO(String number, ReceiptType type, String time,
			String startOrgNameID, String transNum, String startTime,
			String time2, ArrayList<GoodsVO> goods, String arriveOrgNameID) {
		super(number, type, time);
		this.startOrgNameID = startOrgNameID;
		this.transNum = transNum;
		this.startTime = startTime;
		time = time2;
		this.goods = goods;
		this.arriveOrgNameID = arriveOrgNameID;
	}

}
