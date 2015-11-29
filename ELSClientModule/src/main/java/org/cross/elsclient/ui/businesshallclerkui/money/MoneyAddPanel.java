package org.cross.elsclient.ui.businesshallclerkui.money;

import java.rmi.RemoteException;

import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elsclient.ui.businesshallclerkui.ReceiptManagePanel;
import org.cross.elsclient.ui.component.ELSDialog;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.ui.component.ELSPanel;
import org.cross.elsclient.ui.component.ELSStateBar;
import org.cross.elsclient.ui.util.ConstantValue;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.vo.Receipt_MoneyInVO;
import org.cross.elscommon.util.ResultMessage;

public class MoneyAddPanel extends ELSInfoPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Receipt_MoneyInVO arrivo;
	ReceiptBLService bl;
	
	public MoneyAddPanel(ReceiptBLService receiptbl){
		this.bl = receiptbl;
		init();
	}
	
	@Override
	public void init(){
		super.init();
		setTitle("新增收款单");
		addEditableItem("收款单编号", ConstantValue.getReceiptTransNum(), false);
		addEditableItem("快件单编号", "", true);
		addEditableItem("收款时间", "", true);
		addEditableItem("收款快递员", "", true);
		addEditableItem("收款金额", "", true);
		addConfirmAndCancelBtn();
		confirmBtn.setText("确认添加");
		cancelBtn.setText("查看单据");
		container.packHeight();
	}
	
	@Override
	protected void confirm() throws RemoteException {
		if(bl.add(arrivo)==ResultMessage.SUCCESS){
			ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this),"添加成功");
			ReceiptManagePanel receiptManagePanel = new ReceiptManagePanel(bl);
			ELSPanel parent = (ELSPanel) getParent();
			parent.add("manage",receiptManagePanel);
			parent.cl.show(parent, "manage");
		}else{
			ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this),"添加失败");
		}
	}
	
	@Override
	protected void cancel() {		
		if(ELSDialog.showConfirmDlg(GetPanelUtil.getFunctionPanel(this), "取消新增", "确认放弃新增单据？")){
			ReceiptManagePanel receiptManagePanel = new ReceiptManagePanel(bl);
			ELSPanel parent = (ELSPanel) getParent();
			parent.add("manage",receiptManagePanel);
			parent.cl.show(parent, "manage");
		}		
	}


}