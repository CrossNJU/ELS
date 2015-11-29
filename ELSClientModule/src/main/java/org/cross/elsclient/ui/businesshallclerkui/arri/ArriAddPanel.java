package org.cross.elsclient.ui.businesshallclerkui.arri;

import java.rmi.RemoteException;

import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elsclient.ui.businesshallclerkui.ReceiptManagePanel;
import org.cross.elsclient.ui.component.ELSDialog;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.ui.component.ELSPanel;
import org.cross.elsclient.ui.component.ELSStateBar;
import org.cross.elsclient.ui.util.ConstantValue;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.vo.Receipt_ArriveVO;
import org.cross.elscommon.util.ResultMessage;

public class ArriAddPanel extends ELSInfoPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Receipt_ArriveVO arrivo;
	ReceiptBLService bl;
	
	public ArriAddPanel(ReceiptBLService receiptbl){
		this.bl = receiptbl;
		init();
	}
	
	@Override
	public void init(){
		super.init();
		String it1[] = {"南京营业厅","北京营业厅","上海营业厅","广州营业厅"};
		
		setTitle("新增到达单");
		addEditableItem("到达单编号", ConstantValue.getReceiptTransNum(), false);
		addEditableItem("装车/中转单号", "", true);
		addComboxItem("出发地", it1, true);
		addEditableItem("出发时间", "", true);
		addComboxItem("到达地", it1, true);
		addEditableItem("到达时间", "", true);
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