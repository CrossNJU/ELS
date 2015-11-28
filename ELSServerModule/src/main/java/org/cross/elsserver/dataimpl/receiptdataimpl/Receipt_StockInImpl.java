package org.cross.elsserver.dataimpl.receiptdataimpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.cross.elscommon.po.ReceiptPO;
import org.cross.elscommon.po.Receipt_StockInPO;
import org.cross.elscommon.util.MySQL;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StringToType;
import org.cross.elsserver.dataimpl.tools.ReceiptTool;

public class Receipt_StockInImpl implements ReceiptTool{
	
	private MySQL mysql;
	
	public Receipt_StockInImpl(){
		this.mysql = new MySQL();
	}

	@Override
	public ResultMessage insert(ReceiptPO pos) {
		Receipt_StockInPO po = (Receipt_StockInPO)pos;
		String sql = "insert ignore into `receiptStockIn`(`number`, `time`,`goodsNum`) values ('"
				+ po.getNumber()+"','"+po.getTime()+"','"+po.getGoodsNumber()+"')";
		if(!mysql.execute(sql)) return ResultMessage.FAILED;
		return ResultMessage.SUCCESS;
	}

	@Override
	public ReceiptPO getFromDB(String number) {
		Receipt_StockInPO realPo = null;
		String sql = "select * from `receiptStockIn` where `number`='"+number+"'";
		ResultSet rs = mysql.query(sql);
		try {
			if (rs.next()) {
				realPo = new Receipt_StockInPO(rs.getString("number"), rs.getString("time"), null,
						rs.getString("goodsNum"));
				realPo.setApproveState(StringToType.toApproveType(rs.getString("approveState")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return realPo;
	}

}
