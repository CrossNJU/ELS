package org.cross.elsclient.ui.counterui.settle;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elsclient.ui.component.ELSDialog;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.ui.component.ELSStateBar;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.util.ConstantVal;
import org.cross.elsclient.vo.Receipt_MoneyInVO;
import org.cross.elsclient.vo.Receipt_MoneyOutVO;
import org.cross.elscommon.util.InfoType;
import org.cross.elscommon.util.NumberType;
import org.cross.elscommon.util.ResultMessage;

public class TotalAddPanel extends ELSInfoPanel{
	Receipt_MoneyInVO vo;
	ArrayList<Receipt_MoneyInVO> vos;
	ReceiptBLService bl;
	
	public TotalAddPanel(ReceiptBLService bl, ArrayList<Receipt_MoneyInVO> vos) {
		this.bl = bl;
		this.vos = vos;
		init();
	}
	
	@Override
	public void init() {
		super.init();
		
		setTitle("创建总收款款单");
		addEditableItem("总收款单编号", ConstantVal.getNumber().getPostNumber(NumberType.RECEIPT), false, InfoType.NAME);
		addEditableItem("收款单数量", ""+vos.size(), false, InfoType.NAME);
		addEditableItem("收款人", "", true,InfoType.NAME);
		addEditableItem("收款账号", "", true,InfoType.NUM);
		addEditableItem("收款金额", "", true, InfoType.NUM);
		addEditableItem("营业厅编号", "", true, InfoType.NAME);
		
//		titlePanel.backBtn.setVisible(false);
//		titleLabel.setLocation(10, titleLabel.getLocation().y);
		
		addConfirmAndCancelBtn();
		confirmBtn.setText("确认添加");
		cancelBtn.setText("取消添加");
		
	}
	
	@Override
	protected void confirm() throws RemoteException {
		if(bl.add(vo)==ResultMessage.SUCCESS){
			ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this),"添加成功");
			back();
		}else{
			ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this),"添加失败");
		}
	}
	
	@Override
	protected void cancel() {
		if(ELSDialog.showConfirmDlg(GetPanelUtil.getFunctionPanel(this), "取消新增", "确认退出新增界面？")){
			back();
		}
	}
}
