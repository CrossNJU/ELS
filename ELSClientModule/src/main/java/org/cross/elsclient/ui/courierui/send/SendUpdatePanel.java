package org.cross.elsclient.ui.courierui.send;

import java.rmi.RemoteException;

import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elsclient.blservice.userblservice.UserBLService;
import org.cross.elsclient.ui.component.ELSDialog;
import org.cross.elsclient.ui.component.ELSFunctionPanel;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.ui.component.ELSStateBar;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.ui.util.LogUtil;
import org.cross.elsclient.vo.ReceiptVO;
import org.cross.elsclient.vo.Receipt_OrderVO;
import org.cross.elscommon.util.InfoType;
import org.cross.elscommon.util.ResultMessage;

public class SendUpdatePanel extends ELSInfoPanel {
	Receipt_OrderVO vo;
	ReceiptBLService bl;
	
	public SendUpdatePanel(ReceiptBLService bl) {
		this.bl = bl;
		init();
	}
	
	@Override
	public void init() {
		super.init();
		titlePanel.backBtn.setVisible(false);
		setTitle("派发快件");
//		addAutoItem("订单编号", "", true);
		addEditableItem("订单编号", "", true,InfoType.ID,"id");
		addEditableItem("收件人", "", true,InfoType.NAME,"per");
		addDateItem("收件时间", true,"time");
		
		addConfirmAndCancelBtn();
		confirmBtn.setText("确认已派发");
		cancelBtn.setText("查看单据");
		container.packHeight();
	}
	
	@Override
	protected void confirm() throws RemoteException {
		super.confirm();
		vo = (Receipt_OrderVO)bl.findByID(findItem("id").toString());
		vo.receiveTime = findItem("time").toString();
		vo.receiverName = findItem("per").toString();
			if(bl.update(vo)==ResultMessage.SUCCESS){
				LogUtil.addLog("派送快件");
				ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this),"派件成功");
				this.init();
				this.validate();
				this.repaint();
			}else{
				ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this),"派件失败");
			}
//		}
	}
	
	@Override
	protected void cancel() {
		super.cancel();
		if (ELSDialog.showConfirmDlg(GetPanelUtil.getFunctionPanel(this), "取消派件", "确认放弃派件单？")) {
			ELSFunctionPanel parent = GetPanelUtil.getFunctionPanel(this);
			this.init();
			parent.setChosenFunction("receipts");
		}
	}
}
