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
	 * 出发地(机构name)
	 */
	public String startOrgName;

	/**
	 * 出发地(机构ID)
	 */
	public String startOrgID;

	/**
	 * 转运单编号
	 */
	public String transNum;
	/**
	 * 出发时间
	 */
	public String startTime;

	/**
	 * 货物信息
	 */
	public ArrayList<GoodsVO> goods;

	/**
	 * 到达的机构name
	 */
	public String arriveOrgName;

	/**
	 * 到达的机构ID
	 */
	public String arriveOrgID;

	public Receipt_ArriveVO(String number, ReceiptType type, String time,
			String startOrgName, String startOrgID, String transNum,
			String startTime, ArrayList<GoodsVO> goods, String arriveOrgName,
			String arriveOrgID) {
		super(number, type, time);
		this.startOrgName = startOrgName;
		this.startOrgID = startOrgID;
		this.transNum = transNum;
		this.startTime = startTime;
		this.goods = goods;
		this.arriveOrgName = arriveOrgName;
		this.arriveOrgID = arriveOrgID;
	}

}
