package org.cross.elsclient.ui.counterui.account;

import java.rmi.RemoteException;

import org.cross.elsclient.blservice.accountblservice.AccountBLService;
import org.cross.elsclient.ui.component.ELSDialog;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.ui.component.ELSStateBar;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.vo.AccountVO;
import org.cross.elscommon.util.InfoType;
import org.cross.elscommon.util.ResultMessage;

public class AccoutAddPanel extends ELSInfoPanel{
	AccountVO vo;
	AccountBLService bl;
	public AccoutAddPanel(AccountBLService bl) {
		super();
		this.bl = bl;
		init();
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		super.init();
		
		setTitle("新增账户");
		addEditableItem("账户名称", "", true,InfoType.NAME);
		addEditableItem("账户卡号", "", true,InfoType.NUM);
		addEditableItem("账户余额", "", true,InfoType.NUM);
		
		addConfirmAndCancelBtn();
		confirmBtn.setText("确认添加");
		cancelBtn.setText("取消添加");
	}
	
	@Override
	protected void confirm() throws RemoteException {
		if(isAllLegal()){
			
			String name = itemLabels.get(0).getText();
			String account = itemLabels.get(1).getText();
			double balance = Double.valueOf(itemLabels.get(0).getText());
			
			vo = new AccountVO(name, account, balance);
			if(bl.add(vo)==ResultMessage.SUCCESS){
				ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this),"添加成功");
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
