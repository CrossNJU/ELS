package org.cross.elsclient.ui.courierui.send;

import java.rmi.RemoteException;

import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elsclient.blservice.userblservice.UserBLService;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.ui.component.ELSStateBar;
import org.cross.elsclient.ui.util.GetPanelUtil;
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
		
		setTitle("派发快件");
//		addAutoItem("订单编号", "", true);
		addEditableItem("订单编号", "", true,InfoType.NUM);
		addEditableItem("收件人", "", true,InfoType.NAME);
		addDateItem("收件时间", true);
		
		addConfirmAndCancelBtn();
		confirmBtn.setText("确认已派发");
		cancelBtn.setText("查看单据");
		container.packHeight();
	}
	
	@Override
	protected void confirm() throws RemoteException {
		super.confirm();
		vo = (Receipt_OrderVO)bl.findByID(itemLabels.get(0).toString());
		vo.receiveTime = itemLabels.get(2).toString();
		vo.receiverName = itemLabels.get(1).toString();
			if(bl.update(vo)==ResultMessage.SUCCESS){
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
	}
}
