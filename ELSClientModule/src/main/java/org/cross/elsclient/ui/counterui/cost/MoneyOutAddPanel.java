package org.cross.elsclient.ui.counterui.cost;

import java.rmi.RemoteException;

import org.cross.elsclient.blservice.accountblservice.AccountBLService;
import org.cross.elsclient.blservice.personnelblservice.PersonnelBLService;
import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elsclient.ui.component.ELSDialog;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.ui.component.ELSStateBar;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.ui.util.LogUtil;
import org.cross.elsclient.ui.util.UIConstant;
import org.cross.elsclient.util.ConstantVal;
import org.cross.elsclient.vo.AccountVO;
import org.cross.elsclient.vo.PersonnelVO;
import org.cross.elsclient.vo.Receipt_MoneyOutVO;
import org.cross.elscommon.util.InfoType;
import org.cross.elscommon.util.NumberType;
import org.cross.elscommon.util.ResultMessage;

public class MoneyOutAddPanel extends ELSInfoPanel{
	Receipt_MoneyOutVO vo;
	ReceiptBLService receiptbl;
	PersonnelBLService personnelbl;
	AccountBLService accountbl;
	String number;
	
	public MoneyOutAddPanel(ReceiptBLService receiptbl, PersonnelBLService personnelbl,AccountBLService accountbl) {
		this.receiptbl = receiptbl;
		this.personnelbl = personnelbl;
		this.accountbl = accountbl;
		init();
	}
	
	@Override
	public void init() {
		super.init();
		
		setTitle("创建付款单");
		number = ConstantVal.numberbl.getPostNumber(NumberType.RECEIPT);
		addEditableItem("付款单编号", number, false);
		addEditableItem("条目", "", true, InfoType.NAME);
		addEditableItem("付款人", "", true,InfoType.NAME);
		addEditableItem("付款账号", "", true,InfoType.NUM);
		addEditableItem("付款金额", "", true, InfoType.NUM);
		addDateItem("付款时间", true);
		addEditableItem("备注", "", true, InfoType.NAME);
		addEditableItem("建单人",UIConstant.CURRENT_USER.number, false,InfoType.ID);
		addEditableItem("所属机构", UIConstant.CURRENT_USER.orgNameID, false,InfoType.ID);
		
		titlePanel.backBtn.setVisible(false);
//		titleLabel.setLocation(10, titleLabel.getLocation().y);
		
		addConfirmAndCancelBtn();
		confirmBtn.setText("确认添加");
		cancelBtn.setText("取消添加");
		
	}
	
	@Override
	protected void confirm() throws RemoteException {
		if(isAllLegal()){
			String number = itemLabels.get(0).toString();
			String clause = itemLabels.get(1).toString();
			String receivePersonID = itemLabels.get(2).toString();
			String iD = itemLabels.get(3).toString();
			double money = Double.valueOf(itemLabels.get(4).toString());
			String time = itemLabels.get(5).toString();
			String comments = itemLabels.get(6).toString();
			String perNum = itemLabels.get(7).toString();
			String orgNum = itemLabels.get(8).toString();
			
			vo = new Receipt_MoneyOutVO(number, time, money, receivePersonID, iD, clause, comments,perNum,orgNum);
			AccountVO account = accountbl.findByID(iD);
			if(account!=null){
				account.balance -= money;
				if(accountbl.update(account)==ResultMessage.SUCCESS){
					if(receiptbl.add(vo)==ResultMessage.SUCCESS){
						LogUtil.addLog("新增付款单");
						ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this),"添加成功");
						ConstantVal.numberbl.addone(NumberType.RECEIPT, number);
						init();
					}else{
						ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this),"添加失败");
					}
				}else{
					ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this),"添加失败");
				}
			}else{
				ELSDialog.showConfirmDlg(GetPanelUtil.getFunctionPanel(this), "找不到账户", "查询不到此账户,无法扣款");
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
