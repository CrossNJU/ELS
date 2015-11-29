package org.cross.elsclient.ui.stockkeeperui;

import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService_Stub;
import org.cross.elsclient.blservice.stockblservice.StockBLService;
import org.cross.elsclient.ui.businesshallclerkui.ReceiptManagePanel;
import org.cross.elsclient.ui.businesshallclerkui.arri.ArriAddPanel;
import org.cross.elsclient.ui.businesshallclerkui.trans.TransAddPanel;
import org.cross.elsclient.ui.component.ELSFunctionPanel;

public class StockFunctionPanel extends ELSFunctionPanel{
	public ReceiptBLService receiptbl;
	public StockBLService stockbl;
	
	public StockFunctionPanel() {
		super();
		receiptbl = new ReceiptBLService_Stub();
		init();
	}
	@Override
	public void init() {
		super.init();
		addFunctionBtn("入库单", "stockin");
		addFunctionBtn("出库单", "stockout");
		addFunctionBtn("库存查看", "stocksee");
		addFunctionBtn("库存盘点", "stockcheck");
		addFunctionBtn("单据管理", "receipts");
		
		addFunctionPanel(new ArriAddPanel(receiptbl), "manage","arrive");
		addFunctionPanel(new TransAddPanel(receiptbl), "manage","trans");
		
		addFunctionPanel(new ReceiptManagePanel(receiptbl), "manage", "receipts");
	}

}
