package org.cross.elsserver.dataimpl.receiptdataimpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.cross.elscommon.po.ReceiptPO;
import org.cross.elscommon.po.Receipt_StockOutPO;
import org.cross.elscommon.util.MySQL;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StringToType;
import org.cross.elsserver.dataimpl.tools.ReceiptTool;

public class Receipt_StockOutDataImpl implements ReceiptTool {

	private MySQL mysql;

	public Receipt_StockOutDataImpl() {
		this.mysql = new MySQL();
	}

	@Override
	public ResultMessage insert(ReceiptPO po) {
		Receipt_StockOutPO realpo = (Receipt_StockOutPO) po;
		String sql = "insert ignore into `receiptStockOut`(`number`, `time`, `goodsNum`, `transNum`, `transType`, `targetCity`) values ('"
				+ realpo.getNumber() + "','" + realpo.getTime() + "','" + realpo.getGoodsNumber() + "','"
				+ realpo.getTransNumber() + "','" + realpo.getVehicle().toString() + "','" + realpo.getCity().toString()
				+ "')";
		if(!mysql.execute(sql)) return ResultMessage.FAILED;
		else return ResultMessage.SUCCESS;
	}

	@Override
	public ReceiptPO getFromDB(String number) {
		Receipt_StockOutPO po = null;
		String sql = "select from `receiptStockOut` where `number`='"+number+"'";
		ResultSet rs = mysql.query(sql);
		try {
			if (rs.next()) {
				po = new Receipt_StockOutPO(rs.getString("goodsNum"), rs.getString("time"), StringToType.toCity(rs.getString("targetCity")),
						StringToType.toVehicleType(rs.getString("transType")), rs.getString("transNum"), rs.getString("number"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;
	}

}
