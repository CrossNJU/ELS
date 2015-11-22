package org.cross.elsserver.dataimpl.receiptdataimpl;

import org.cross.elscommon.po.Receipt_OrderPO;
import org.cross.elscommon.util.MySQL;
import org.cross.elscommon.util.ResultMessage;

public class Receipt_OrderDataImpl {

	private MySQL mysql;

	public Receipt_OrderDataImpl() {
		this.mysql = new MySQL();
	}

	public ResultMessage insert(Receipt_OrderPO po) {
		String sql = "insert ignore into `receiptOrder`(`number`, `time`, `type`, `cost`, `goodsNum` , `expectTime`, `targetCity`, `startCity`, `pushPeople`, `receivePeople`) values ('"
				+ po.getNumber() + "','" + po.getTime() + "','" + po.getType().toString() + "'," + po.getCost() + ",'"
				+ po.getGoodsNum() + "','" + po.getExpectTime() + "','" + po.getTargetPlace().toString() + "','"
				+ po.getStartPlace().toString() + "','" + po.getPushPeople().name + "','" + po.getReceivePeople().name
				+ "')";
		if (!mysql.execute(sql)) {
			return ResultMessage.FAILED;
		}else return ResultMessage.SUCCESS;
	}

//	public ResultMessage addToMoneyIn(String moneyInNum, String number) {
//
//	}
}
