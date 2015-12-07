package org.cross.elsclient.ui.transitcenterclerkui;

import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService_Stub;
import org.cross.elsclient.ui.businesshallclerkui.ReceiptManagePanel;
import org.cross.elsclient.ui.businesshallclerkui.arri.ArriAddPanel;
import org.cross.elsclient.ui.businesshallclerkui.trans.TransAddPanel;
import org.cross.elsclient.ui.component.ELSFunctionPanel;
import org.cross.elsclient.ui.util.UIConstant;
import org.cross.elsclient.vo.UserVO;

public class TransmitFunctionPanel extends ELSFunctionPanel {
	public ReceiptBLService receiptbl;
	UserVO user;
	
	public TransmitFunctionPanel() {
		super();
		receiptbl = new ReceiptBLService_Stub();
		user = UIConstant.CURRENT_USER;
		init();
	}
	@Override
	public void init() {
		super.init();
		addFunctionBtn("接收单", "arrive");
		addFunctionBtn("装运单", "trans");
		addFunctionBtn("库存查看", "stocksee");
		addFunctionBtn("单据管理", "receipts");
		
		addFunctionPanel(new ArriAddPanel(receiptbl, user), "add","arrive");
		addFunctionPanel(new TransAddPanel(receiptbl, user), "add","trans");
		
		addFunctionPanel(new ReceiptManagePanel(receiptbl), "manage", "receipts");
	}

}
