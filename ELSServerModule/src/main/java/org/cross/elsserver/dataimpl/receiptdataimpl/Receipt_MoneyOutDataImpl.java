package org.cross.elsserver.dataimpl.receiptdataimpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.cross.elscommon.po.PersonnelPO;
import org.cross.elscommon.po.ReceiptPO;
import org.cross.elscommon.po.Receipt_MoneyOutPO;
import org.cross.elscommon.util.MySQL;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StringToType;
import org.cross.elsserver.dataimpl.tools.ReceiptTool;

public class Receipt_MoneyOutDataImpl implements ReceiptTool{
	
	private MySQL mysql;
	
	public Receipt_MoneyOutDataImpl(){
		this.mysql = new MySQL();
	}

	@Override
	public ResultMessage insert(ReceiptPO po) {
		Receipt_MoneyOutPO realpo = (Receipt_MoneyOutPO)po;
		String sql = "insert ignore into `receiptMoneyOut`(`number`, `time`, `money`, `personnelNum`, `accountNum`, `clause`, `comments`) values ('"
				+ realpo.getNumber()+"','"+realpo.getTime()+"',"+realpo.getMoney()+",'"+realpo.getPersonnel().getId()+"','"
				+realpo.getReceiveID()+"','"+realpo.getClause()+"','"+realpo.getComments()+"')";
		if(!mysql.execute(sql)) return ResultMessage.FAILED;
		else return ResultMessage.SUCCESS;
	}

	@Override
	public ReceiptPO getFromDB(String number) {
		Receipt_MoneyOutPO po = null;
		String sql = "select * from `receiptMoneyOut` where `number`='"+number+"'";
		ResultSet rs = mysql.query(sql);
		try {
			if (rs.next()) {
				po = new Receipt_MoneyOutPO(rs.getString("number"), rs.getString("time"),
						rs.getDouble("money"), new PersonnelPO(rs.getString("personnelNum"), null, null, null, null),
						rs.getString("accountNum"), rs.getString("clause"), rs.getString("comments"));
				po.setApproveState(StringToType.toApproveType(rs.getString("approveState")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;
	}

}
