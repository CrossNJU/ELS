package org.cross.elsclient.ui.managerui.approval;

import java.rmi.RemoteException;

import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elsclient.ui.component.ELSDialog;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.vo.ReceiptVO;
import org.cross.elscommon.util.ApproveType;

public class ApprovalInfoPanel extends ELSInfoPanel {
	ReceiptBLService receiptbl;
	ReceiptVO vo;
	
	public ApprovalInfoPanel(ReceiptVO vo,ReceiptBLService receiptbl) {
		super();
		this.vo = vo;
		this.receiptbl = receiptbl;
		init();
	}
	
	@Override
	public void init() {
		super.init();
		
		addNormalItem("单据编号", vo.number);
		addNormalItem("单据类型", vo.type.toString());
		addNormalItem("建单时间", vo.time);
		addNormalItem("状态", vo.type.toString());
		
		if(vo.approveState==ApproveType.UNCHECKED){
			this.addConfirmAndCancelBtn();
		}
		container.packHeight();
	}
	
	@Override
	protected void confirm() throws RemoteException {
		super.confirm();
		if(ELSDialog.showConfirmDlg(this, "审批单据", "确认审批通过该单据？")){
			receiptbl.check(vo, ApproveType.APPROVED);
		}
	}
	
	@Override
	protected void cancel() {
		// TODO Auto-generated method stub
		super.cancel();
		if(ELSDialog.showConfirmDlg(this, "审批单据", "确认审批不通过该单据？")){
			try {
				receiptbl.check(vo, ApproveType.NOT_APPROVED);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
