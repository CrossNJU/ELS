package org.cross.elsserver.dataimpl.receiptdataimpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.cross.elscommon.po.ReceiptPO;
import org.cross.elscommon.po.Receipt_DeliverPO;
import org.cross.elscommon.util.MySQL;
import org.cross.elscommon.util.ReceiptType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StringToType;
import org.cross.elsserver.dataimpl.tools.ReceiptTool;

public class Receipt_DelDataImpl implements ReceiptTool {

	private MySQL mysql;

	public Receipt_DelDataImpl() {
		this.mysql = new MySQL();
	}

	@Override
	public ResultMessage insert(ReceiptPO po) {
		Receipt_DeliverPO delpo = (Receipt_DeliverPO) po;
		String sql = "insert ignore into `receiptDeliver`(`number`, `orderNum`, `name`, `posterNum`, `time`) values ('"
				+ delpo.getNumber() + "','" + delpo.getOrderNum() + "','" + delpo.getName() + "','"
				+ delpo.getPosterNum() + "','" + delpo.getTime() + "')";
		if (!mysql.execute(sql))
			return ResultMessage.FAILED;
		return ResultMessage.SUCCESS;
	}

	@Override
	public ReceiptPO getFromDB(String number) {
		String sql = "select * from `receiptDeliver` where `number`='" + number + "'";
		Receipt_DeliverPO po = null;
		ResultSet rs = mysql.query(sql);
		try {
			if (rs.next()) {
				po = new Receipt_DeliverPO(number, ReceiptType.DELIVER, rs.getString("time"), null, null,
						rs.getString("orderNum"), rs.getString("name"), rs.getString("posterNum"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sql = "select * from `receipt` where `number`='" + number + "'";
		rs = mysql.query(sql);
		try {
			if (rs.next()) {
				po.setApproveState(StringToType.toApproveType(rs.getString("approveState")));
				po.setOrgNum(rs.getString("orgNum"));
				po.setPerNum(rs.getString("perNum"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;
	}

}
