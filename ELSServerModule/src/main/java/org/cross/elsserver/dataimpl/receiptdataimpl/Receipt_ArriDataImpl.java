package org.cross.elsserver.dataimpl.receiptdataimpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.cross.elscommon.po.ReceiptPO;
import org.cross.elscommon.po.Receipt_ArrivePO;
import org.cross.elscommon.util.MySQL;
import org.cross.elscommon.util.ReceiptType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StringToType;
import org.cross.elsserver.dataimpl.tools.ReceiptTool;

public class Receipt_ArriDataImpl implements ReceiptTool {

	private MySQL mysql;
	
	public Receipt_ArriDataImpl(){
		this.mysql = new MySQL();
	}
	
	@Override
	public ResultMessage insert(ReceiptPO po) {
		Receipt_ArrivePO arrivePO = (Receipt_ArrivePO) po;
		String sql = "insert ignore into `receiptArrive`(`time`, `number`, `startCity`, `arriveOrg`, `transNum`) values ('"
				+ arrivePO.getTime() + "','" + arrivePO.getNumber() + "','" + arrivePO.getStartPlace().toString()
				+ "','" + arrivePO.getArriveOrg().toString() + "','" + arrivePO.getTransNum() + "')";
		if(!mysql.execute(sql)) return ResultMessage.FAILED;
		return ResultMessage.SUCCESS;
	}

	@Override
	public ReceiptPO getFromDB(String number) {
		String sql = "select * from `receiptArrive` where `number`='"+number+"'";
		Receipt_ArrivePO po = null;
		ResultSet rs = mysql.query(sql);
		try {
			if (rs.next()) {
				po = new Receipt_ArrivePO(rs.getString("number"), ReceiptType.ARRIVE, rs.getString("time"), 
						StringToType.toCity(rs.getString("startCity")), rs.getString("transNum"), 
						null, StringToType.toOrg(rs.getString("arriveOrg")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;
	}

}
