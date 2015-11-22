package org.cross.elsserver.dataimpl.receiptdataimpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.cross.elscommon.po.Receipt_OrderPO;
import org.cross.elscommon.util.MySQL;
import org.cross.elscommon.util.ResultMessage;

public class Receipt_OrderDataImpl {

	private MySQL mysql;

	public Receipt_OrderDataImpl() {
		this.mysql = new MySQL();
	}

	public ResultMessage insert(Receipt_OrderPO po) {
		String sql = "insert ignore into `receiptOrder`(`number`, `time`, `type`, `cost`, `goodsNum` , `expectTime`, `targetCity`, `startCity`, `pushPeople`, `receivePeople`,`isApproved`) values ('"
				+ po.getNumber() + "','" + po.getTime() + "','" + po.getType().toString() + "'," + po.getCost() + ",'"
				+ po.getGoodsNum() + "','" + po.getExpectTime() + "','" + po.getTargetPlace().toString() + "','"
				+ po.getStartPlace().toString() + "','" + po.getPushPeople().name + "','" + po.getReceivePeople().name
				+ "',false)";
		if (!mysql.execute(sql)) {
			return ResultMessage.FAILED;
		}else return ResultMessage.SUCCESS;
	}
	
	public Receipt_OrderPO transFromDB(ResultSet rs){
		Receipt_OrderPO po = null;
		try {
			if (rs.next()) {
				po = new Receipt_OrderPO(rs.getString("number"), , time, goodsNum, cost, expectTime, targetPlace, startPlace, pushPeople, receivePeople)
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;
	}

//	public ResultMessage addToMoneyIn(String moneyInNum, String number) {
//
//	}
}
