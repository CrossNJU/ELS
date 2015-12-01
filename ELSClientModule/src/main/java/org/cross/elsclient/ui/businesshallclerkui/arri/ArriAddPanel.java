package org.cross.elsclient.ui.businesshallclerkui.arri;

import java.rmi.RemoteException;

import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elsclient.ui.businesshallclerkui.ReceiptManagePanel;
import org.cross.elsclient.ui.component.ELSDialog;
import org.cross.elsclient.ui.component.ELSFunctionPanel;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.ui.component.ELSPanel;
import org.cross.elsclient.ui.component.ELSStateBar;
import org.cross.elsclient.ui.util.ConstantValue;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.vo.Receipt_ArriveVO;
import org.cross.elscommon.util.ReceiptType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StringToType;

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
		
		titlePanel.remove(titlePanel.backBtn);
		
		String it1[] = {"南京","北京","上海","广州"};
		
		setTitle("新增到达单");
		/*0*/addEditableItem("到达单编号", ConstantValue.getReceiptNum(ReceiptType.ARRIVE), false);
		/*1*/addEditableItem("装车/中转单号", "", true);
		/*2*/addComboxItem("出发地", it1, true);
		/*3*/addDateItem("出发时间",  true);
		/*4*/addComboxItem("到达地", it1, true);
		/*5*/addDateItem("到达时间",  true);
		/*6*/addConfirmAndCancelBtn();
		confirmBtn.setText("确认添加");
		cancelBtn.setText("查看单据");
		container.packHeight();
	}
	
	@Override
	protected void confirm() throws RemoteException {
		arrivo = new Receipt_ArriveVO(itemLabels.get(0).toString(), ReceiptType.ARRIVE, itemLabels.get(5).toString(), 
				StringToType.toCity(itemLabels.get(2).toString()), itemLabels.get(1).toString(), null, StringToType.toOrg(itemLabels.get(4).toString()));
		if(bl.add(arrivo)==ResultMessage.SUCCESS){
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
