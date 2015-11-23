package org.cross.elsserver.dataimpl.receiptdataimpl;

import org.cross.elscommon.po.ReceiptPO;
import org.cross.elscommon.po.Receipt_StockOutPO;
import org.cross.elscommon.util.MySQL;
import org.cross.elscommon.util.ResultMessage;
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
		
	}

	@Override
	public ReceiptPO getFromDB(String number) {
		// TODO Auto-generated method stub
		return null;
	}

}
