package org.cross.elsserver.dataimpl.receiptdataimpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.cross.elscommon.po.PersonnelPO;
import org.cross.elscommon.po.ReceiptPO;
import org.cross.elscommon.po.Receipt_TransPO;
import org.cross.elscommon.util.MySQL;
import org.cross.elscommon.util.ReceiptType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StringToType;
import org.cross.elsserver.dataimpl.tools.ReceiptTool;

public class Receipt_TransDataImpl implements ReceiptTool {

	private MySQL mysql;

	public Receipt_TransDataImpl() {
		this.mysql = new MySQL();
	}

	@Override
	public ResultMessage insert(ReceiptPO po) {
		Receipt_TransPO pos = (Receipt_TransPO) po;
		String sql = "insert ignore into `receiptTrans`(`number`, `time`, `loNum`, `veNum`, `startCity`, `endCity`, `observer`, `driver`, `cost`, `transOrg`) values ('"
				+ pos.getNumber() + "','" + pos.getTime() + "','" + pos.getLocalNum() + "','" + pos.getVehicleNum()
				+ "','" + pos.getStartCity().toString() + "','" + pos.getArriveCity().toString() + "','"
				+ pos.getObserver().getId() + "','" + pos.getDriver().getId() + "'," + pos.getCost() + ",'"
				+ pos.getOrg().toString() + "')";
		if (!mysql.execute(sql))
			return ResultMessage.FAILED;
		return ResultMessage.SUCCESS;
	}

	@Override
	public ReceiptPO getFromDB(String number) {
		Receipt_TransPO po = null;
		String sql = "select * from `receiptTrans` where `number`='"+number+"'";
		ResultSet rs = mysql.query(sql);
		try {
			if (rs.next()) {
				po = new Receipt_TransPO(rs.getString("number"), 
						ReceiptType.TRANS, rs.getString("time"), null, rs.getDouble("cost"), 
						StringToType.toOrg(rs.getString("transOrg")), rs.getString("loNum"), 
						rs.getString("veNum"), StringToType.toCity(rs.getString("startCity")), 
						StringToType.toCity(rs.getString("endCity")), new PersonnelPO(rs.getString("observer"), null, null, null, null), 
						new PersonnelPO(rs.getString("driver"), null, null, null, null));
				po.setApproveState(StringToType.toApproveType(rs.getString("approveState")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;
	}

}
