package org.cross.elsclient.ui.courierui.receive;

import java.rmi.RemoteException;

import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.vo.Receipt_OrderVO;

public class ExpressReceivePanel extends ELSInfoPanel{
	Receipt_OrderVO vo;
	ReceiptBLService receiptbl;
	
	public ExpressReceivePanel(ReceiptBLService receiptbl) {
		this.receiptbl = receiptbl;
		init();
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		super.init();
		
		setTitle("创建快件单");
		addEditableItem("快件单编号", vo.number, false);
		addEditableItem("寄件人姓名", "", true);
		addEditableItem("寄件人地址", "", true);
		addEditableItem("寄件人单位", "", true);
		addEditableItem("寄件人电话", "", true);
		addEditableItem("寄件人手机", "", true);
		addEditableItem("收件人姓名", "", true);
		addEditableItem("收件人地址", "", true);
		addEditableItem("收件人单位", "", true);
		addEditableItem("收件人电话", "", true);
		
		addConfirmAndCancelBtn();
		confirmBtn.setText("确认创建");
		cancelBtn.setText("取消创建");
	}
	
	@Override
	protected void confirm() throws RemoteException {
		super.confirm();
		receiptbl.add(vo);
		back();
	}
	
	@Override
	protected void cancel() {
		super.cancel();
		back();
	}
}
