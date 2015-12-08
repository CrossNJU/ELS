package org.cross.elsclient.ui.stockkeeperui;

import java.rmi.RemoteException;

import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService_Stub;
import org.cross.elsclient.blservice.stockblservice.StockBLService;
import org.cross.elsclient.blservice.stockblservice.StockBL_stub;
import org.cross.elsclient.test.StockBLTest;
import org.cross.elsclient.ui.businesshallclerkui.ReceiptManagePanel;
import org.cross.elsclient.ui.businesshallclerkui.arri.ArriAddPanel;
import org.cross.elsclient.ui.businesshallclerkui.trans.TransAddPanel;
import org.cross.elsclient.ui.component.ELSFunctionPanel;
import org.cross.elsclient.ui.stockkeeperui.check.StockCheckManageTable;
import org.cross.elsclient.ui.stockkeeperui.instock.StockInAddPanel;
import org.cross.elsclient.ui.stockkeeperui.observe.StockSeeManagePanel;
import org.cross.elsclient.ui.stockkeeperui.outstock.StockOutAddPanel;
import org.cross.elsclient.ui.util.UIConstant;
import org.cross.elsclient.vo.StockVO;
import org.cross.elsclient.vo.UserVO;

public class StockFunctionPanel extends ELSFunctionPanel{
	public ReceiptBLService receiptbl;
	public StockBLService stockbl;
	UserVO user;
	StockVO stock;
	
	public StockFunctionPanel() {
		super();
		receiptbl = new ReceiptBLService_Stub();
		stockbl = new StockBL_stub();
		init();
	}
	@Override
	public void init() {
		super.init();

		this.user = UIConstant.CURRENT_USER;
		try {
			stock = stockbl.findStockByOrg(user.orgNameID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String[] name = {"快件单编号","入库时间","目的地","所属小间"};
		int[] itemWidth = {200,200,200,100};
		
		addFunctionBtn("入库单", "stockin");
		addFunctionBtn("出库单", "stockout");
		addFunctionBtn("库存查看", "stocksee");
		addFunctionBtn("库存盘点", "stockcheck");
		addFunctionBtn("单据管理", "receipts");
		
		addFunctionPanel(new StockInAddPanel(stockbl, receiptbl ,user, stock), "add","stockin");
		addFunctionPanel(new StockOutAddPanel(stockbl, receiptbl, user, stock), "add","stockout");
		addFunctionPanel(new StockSeeManagePanel(stockbl,user, stock), "manage", "stocksee");
		addFunctionPanel(new StockCheckManageTable(name, itemWidth, stockbl,user, stock), "manage", "stockcheck");
		
		addFunctionPanel(new ReceiptManagePanel(receiptbl), "manage", "receipts");
	}

}
