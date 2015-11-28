package org.cross.elsserver.dataimpl.receiptdataimpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.cross.elscommon.po.ReceiptPO;
import org.cross.elscommon.po.Receipt_OrderPO;
import org.cross.elscommon.util.MySQL;
import org.cross.elscommon.util.People;
import org.cross.elscommon.util.ReceiptType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StringToType;
import org.cross.elsserver.dataimpl.tools.ReceiptTool;

public class Receipt_OrderDataImpl implements ReceiptTool{

	private MySQL mysql;

	public Receipt_OrderDataImpl() {
		this.mysql = new MySQL();
	}

	public ResultMessage insert(ReceiptPO pop) {
		Receipt_OrderPO po = (Receipt_OrderPO)pop;
		String sql = "insert ignore into `receiptOrder`(`number`, `time`, `type`, `cost`, `goodsNum` , `expectTime`, `targetCity`, `startCity`, `pushPeople`, `receivePeople`,`isApproved`) values ('"
				+ po.getNumber() + "','" + po.getTime() + "','" + po.getType().toString() + "'," + po.getCost() + ",'"
				+ po.getGoodsNum() + "','" + po.getExpectTime() + "','" + po.getTargetPlace().toString() + "','"
				+ po.getStartPlace().toString() + "','" + po.getPushPeople().name + "','" + po.getReceivePeople().name
				+ "',false)";
		if (!mysql.execute(sql)) {
			return ResultMessage.FAILED;
		} else
			return ResultMessage.SUCCESS;
	}
	
	public ReceiptPO getFromDB(String number) {
		Receipt_OrderPO po = null;
		String sql = "select * from `receiptOrder` where `number`='"+number+"'";
		ResultSet rs = mysql.query(sql);
		try {
			if (rs.next()) {
				po = new Receipt_OrderPO(rs.getString("number"), ReceiptType.ORDER,
						rs.getString("time"), rs.getString("goodsNum"), rs.getDouble("cost"),
						rs.getString("expectTime"), StringToType.toCity(rs.getString("targetCity")),
						StringToType.toCity(rs.getString("startCity")),
						new People(rs.getString("pushPeople"), null, null),
						new People(rs.getString("receivePeople"), null, null));
				po.setApproveState(StringToType.toApproveType(rs.getString("approveState")));
				po.setReceiveTime(rs.getString("receiveTime"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;
	}

}
