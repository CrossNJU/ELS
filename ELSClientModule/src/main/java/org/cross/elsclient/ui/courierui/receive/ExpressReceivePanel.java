package org.cross.elsclient.ui.courierui.receive;

import java.rmi.RemoteException;

import javax.rmi.CORBA.Tie;

import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elsclient.ui.component.ELSDialog;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.ui.component.ELSStateBar;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.vo.GoodsVO;
import org.cross.elsclient.vo.Receipt_OrderVO;
import org.cross.elscommon.util.ResultMessage;

public class ExpressReceivePanel extends ELSInfoPanel{
	Receipt_OrderVO vo;
	ReceiptBLService bl;
	
	public ExpressReceivePanel(ReceiptBLService receiptbl) {
		this.bl = receiptbl;
		init();
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		super.init();
		
		setTitle("创建快件单");
		addEditableItem("快件单编号", "", false);
		addEditableItem("寄件人姓名", "", true);
		addEditableItem("寄件人地址", "", true);
		addEditableItem("寄件人单位", "", true);
		addEditableItem("寄件人电话", "", true);
		addEditableItem("寄件人手机", "", true);
		addEditableItem("收件人姓名", "", true);
		addEditableItem("收件人地址", "", true);
		addEditableItem("收件人单位", "", true);
		addEditableItem("收件人电话", "", true);
		
		titlePanel.remove(titlePanel.backBtn);
		addConfirmAndCancelBtn();
		confirmBtn.setText("确认创建");
		cancelBtn.setText("取消创建");
		
	}
	
	@Override
	protected void confirm() throws RemoteException {
		if(isAllLegal()){
			if(bl.add(vo)==ResultMessage.SUCCESS){
				ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this),"添加成功");
				init();
			}else{
				ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this),"添加失败");
			}
		}
	}
	
	@Override
	protected void cancel() {
		if(ELSDialog.showConfirmDlg(GetPanelUtil.getFunctionPanel(this), "取消新增", "确认退出新增界面？")){
			init();
		}
	}
}
