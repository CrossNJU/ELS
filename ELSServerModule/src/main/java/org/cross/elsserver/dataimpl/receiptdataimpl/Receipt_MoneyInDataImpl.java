package org.cross.elsserver.dataimpl.receiptdataimpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.cross.elscommon.po.PersonnelPO;
import org.cross.elscommon.po.ReceiptPO;
import org.cross.elscommon.po.Receipt_MoneyInPO;
import org.cross.elscommon.util.MySQL;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elsserver.dataimpl.tools.ReceiptTool;

public class Receipt_MoneyInDataImpl implements ReceiptTool {

	private MySQL mysql;

	public Receipt_MoneyInDataImpl() {
		this.mysql = new MySQL();
	}

	@Override
	public ResultMessage insert(ReceiptPO po) {
		Receipt_MoneyInPO realpo = (Receipt_MoneyInPO) po;
		String sql = "insert ignore into `receiptMoneyIn`(`number`, `time`, `personnelNum`, `money`) values ('"
				+ realpo.getNumber() + "','" + realpo.getTime() + "','" + realpo.getPerson().getId() + "','"
				+ realpo.getMoney() + "')";
		if (!mysql.execute(sql))
			return ResultMessage.FAILED;
		return ResultMessage.SUCCESS;
	}

	@Override
	public ReceiptPO getFromDB(String number) {
		Receipt_MoneyInPO po = null;
		String sql = "select from `receiptMoneyIn` where `number`='" + number + "'";
		ResultSet rs = mysql.query(sql);
		try {
			if (rs.next()) {
				po = new Receipt_MoneyInPO(rs.getString("time"), rs.getDouble("money"),
						new PersonnelPO(rs.getString("personnelNum"), null, null, null, null), rs.getString("number"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;
	}

}
