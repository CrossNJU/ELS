package org.cross.elsclient.ui.courierui;

import org.cross.elsclient.blimpl.goodsblimpl.GoodsBLImpl;
import org.cross.elsclient.blservice.goodsblservice.GoodsBLService;
import org.cross.elsclient.blservice.goodsblservice.GoodsBLService_Driver;
import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService_Stub;
import org.cross.elsclient.ui.adminui.UserManagePanel;
import org.cross.elsclient.ui.component.ELSFunctionPanel;
import org.cross.elsclient.ui.component.ELSPanel;

public class CourierFunctionPanel extends ELSFunctionPanel{
	public ReceiptBLService receiptbl;
	public GoodsBLService goodsbl;
	
	public CourierFunctionPanel() {
		super();
		receiptbl = new ReceiptBLService_Stub();
//		goodsbl = new GoodsBLImpl(new GoodsData)
		init();
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		super.init();
		addFunctionBtn("揽收快递", "expressReceive");
		addFunctionBtn("派送快递", "expressSend");
		addFunctionBtn("派送快递", "goodsCheck");
		
		addFunctionPanel(new ELSPanel(), "manage","expressReceive");
		addFunctionPanel(new ELSPanel(), "manage","expressSend");
		addFunctionPanel(new ELSPanel(), "manage","goodsCheck");
		
	}
	
}
