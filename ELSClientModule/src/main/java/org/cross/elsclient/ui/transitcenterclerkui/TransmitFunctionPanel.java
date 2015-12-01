package org.cross.elsclient.ui.transitcenterclerkui;

import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService_Stub;
import org.cross.elsclient.ui.businesshallclerkui.ReceiptManagePanel;
import org.cross.elsclient.ui.businesshallclerkui.arri.ArriAddPanel;
import org.cross.elsclient.ui.businesshallclerkui.trans.TransAddPanel;
import org.cross.elsclient.ui.component.ELSFunctionPanel;

public class TransmitFunctionPanel extends ELSFunctionPanel {
	public ReceiptBLService receiptbl;
	
	public TransmitFunctionPanel() {
		super();
		receiptbl = new ReceiptBLService_Stub();
		init();
	}
	@Override
	public void init() {
		super.init();
		addFunctionBtn("接收单", "arrive");
		addFunctionBtn("装运单", "trans");
		addFunctionBtn("库存查看", "stocksee");
		addFunctionBtn("单据管理", "receipts");
		
		addFunctionPanel(new ArriAddPanel(receiptbl), "add","arrive");
		addFunctionPanel(new TransAddPanel(receiptbl), "add","trans");
		
		addFunctionPanel(new ReceiptManagePanel(receiptbl), "manage", "receipts");
	}

}
