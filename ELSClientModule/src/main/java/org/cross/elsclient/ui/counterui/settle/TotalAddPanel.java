package org.cross.elsclient.ui.counterui.settle;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elsclient.ui.component.ELSDialog;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.ui.component.ELSStateBar;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.ui.util.UIConstant;
import org.cross.elsclient.util.ConstantVal;
import org.cross.elsclient.util.TimeUtil;
import org.cross.elsclient.vo.Receipt_MoneyInVO;
import org.cross.elsclient.vo.Receipt_MoneyOutVO;
import org.cross.elsclient.vo.Receipt_TotalMoneyInVO;
import org.cross.elscommon.util.InfoType;
import org.cross.elscommon.util.NumberType;
import org.cross.elscommon.util.ResultMessage;

public class TotalAddPanel extends ELSInfoPanel{
	Receipt_TotalMoneyInVO vo;
	ArrayList<Receipt_MoneyInVO> vos;
	ReceiptBLService bl;
	String number;
	
	public TotalAddPanel(ReceiptBLService bl, ArrayList<Receipt_MoneyInVO> vos) {
		this.bl = bl;
		this.vos = vos;
		init();
	}
	
	@Override
	public void init() {
		super.init();
		double sum= 0;
		for (Receipt_MoneyInVO receipt_MoneyInVO : vos) {
			sum += receipt_MoneyInVO.money;
		}
		
		setTitle("创建总收款款单");
		number = ConstantVal.numberbl.getPostNumber(NumberType.RECEIPT);
		addEditableItem("总收款单编号", number, false, InfoType.NAME);
		addEditableItem("收款单数量", ""+vos.size(), false, InfoType.NAME);
		addEditableItem("收款人", "", true,InfoType.NAME);
//		addEditableItem("收款账号", "", true,InfoType.NUM);
		addEditableItem("收款金额", sum+"", false, InfoType.NUM);
		addEditableItem("建单人",UIConstant.CURRENT_USER.number, false,InfoType.ID);
		addEditableItem("所属机构", UIConstant.CURRENT_USER.orgNameID, false, InfoType.NAME);
		
//		titlePanel.backBtn.setVisible(false);
//		titleLabel.setLocation(10, titleLabel.getLocation().y);
		
		addConfirmAndCancelBtn();
		confirmBtn.setText("确认添加");
		cancelBtn.setText("取消添加");
		
	}
	
	@Override
	protected void confirm() throws RemoteException {
		if(isAllLegal()){
			String number = itemLabels.get(0).toString();
			String perNameID = itemLabels.get(2).toString();
			double sum = Double.valueOf(itemLabels.get(3).toString());
			String perNum = itemLabels.get(4).toString();
			String orgNum = itemLabels.get(5).toString();
			vo = new Receipt_TotalMoneyInVO(number, TimeUtil.getCurrentTime(), perNameID, sum, vos, perNum,orgNum);
			if(bl.add(vo)==ResultMessage.SUCCESS){
				ConstantVal.numberbl.addone(NumberType.RECEIPT, number);
				ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this),"添加成功");
				init();
				back();
			}else{
				ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this),"添加失败");
			}
		}
		
	}
	
	@Override
	protected void cancel() {
		if(ELSDialog.showConfirmDlg(GetPanelUtil.getFunctionPanel(this), "取消新增", "确认退出新增界面？")){
			back();
		}
	}
}
