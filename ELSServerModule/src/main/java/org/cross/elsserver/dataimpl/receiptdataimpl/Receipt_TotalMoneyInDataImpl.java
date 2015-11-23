package org.cross.elsserver.dataimpl.receiptdataimpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.cross.elscommon.po.PersonnelPO;
import org.cross.elscommon.po.ReceiptPO;
import org.cross.elscommon.po.Receipt_TotalMoneyInPO;
import org.cross.elscommon.util.MySQL;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StringToType;
import org.cross.elsserver.dataimpl.tools.ReceiptTool;

public class Receipt_TotalMoneyInDataImpl implements ReceiptTool {
	private MySQL mysql;

	public Receipt_TotalMoneyInDataImpl() {
		this.mysql = new MySQL();
	}

	@Override
	public ResultMessage insert(ReceiptPO po) {
		Receipt_TotalMoneyInPO realpo = (Receipt_TotalMoneyInPO) po;
		String sql = "insert ignore into `receiptTotalMoneyIn`(`number`, `time`, `personnelNum`, `money`, `place`) values ('"
				+ realpo.getNumber() + "','" + realpo.getTime() + "','" + realpo.getPerson().getId() + "',"
				+ realpo.getSum() + ",'" + realpo.getCity().toString() + "')";
		if(!mysql.execute(sql)) return ResultMessage.FAILED;
		return ResultMessage.SUCCESS;
	}

	@Override
	public ReceiptPO getFromDB(String number) {
		Receipt_TotalMoneyInPO po = null;
		String sql = "select * from `receiptTotalMoneyIn` where `number`='"+number+"'";
		ResultSet rs = mysql.query(sql);
		try {
			if (rs.next()) {
				po = new Receipt_TotalMoneyInPO(rs.getString("time"), new PersonnelPO(rs.getString("personnelNum"), null, null, null, null),
						StringToType.toCity(rs.getString("place")), rs.getString("number"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;
	}

}
