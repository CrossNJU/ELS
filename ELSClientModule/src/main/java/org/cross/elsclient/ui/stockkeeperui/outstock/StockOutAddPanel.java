package org.cross.elsclient.ui.stockkeeperui.outstock;

import java.rmi.RemoteException;

import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elsclient.blservice.stockblservice.StockBLService;
import org.cross.elsclient.ui.businesshallclerkui.ReceiptManagePanel;
import org.cross.elsclient.ui.component.ELSDialog;
import org.cross.elsclient.ui.component.ELSFunctionPanel;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.ui.component.ELSPanel;
import org.cross.elsclient.ui.component.ELSStateBar;
import org.cross.elsclient.ui.util.ConstantValue;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.vo.Receipt_StockOutVO;
import org.cross.elscommon.util.ResultMessage;

public class StockOutAddPanel extends ELSInfoPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Receipt_StockOutVO stockoutvo;
	StockBLService stockbl;
	ReceiptBLService receiptbl;
	
	public StockOutAddPanel(StockBLService stockbl, ReceiptBLService receiptbl){
		this.stockbl = stockbl;
		init();
	}
	
	@Override
	public void init(){
		super.init();
		titlePanel.remove(titlePanel.backBtn);
		setTitle("新增出库单");
		addEditableItem("出库单编号", ConstantValue.getReceiptTransNum(), false);
		addEditableItem("快件单编号", "", true);
		addEditableItem("出库时间", "", true);
		addEditableItem("目的地", "", true);
		addEditableItem("中转/装车单号", "", true);
		addEditableItem("运输方式", "", true);
		addConfirmAndCancelBtn();
		confirmBtn.setText("确认添加");
		cancelBtn.setText("查看单据");
		container.packHeight();
	}
	
	@Override
	protected void confirm() throws RemoteException {
		if(receiptbl.add(stockoutvo)==ResultMessage.SUCCESS){
			ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this),"添加成功");
			ELSFunctionPanel parent = GetPanelUtil.getFunctionPanel(this);
			parent.contentPanel.cl.show(parent.contentPanel, "receipts");
		}else{
			ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this),"添加失败");
		}
	}
	
	@Override
	protected void cancel() {		
		if(ELSDialog.showConfirmDlg(GetPanelUtil.getFunctionPanel(this), "取消新增", "确认放弃新增单据？")){
			ELSFunctionPanel parent = GetPanelUtil.getFunctionPanel(this);
			parent.contentPanel.cl.show(parent.contentPanel, "receipts");
		}		
	}



}
