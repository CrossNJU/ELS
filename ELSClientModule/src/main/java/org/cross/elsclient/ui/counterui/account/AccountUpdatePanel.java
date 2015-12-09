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

public class AccountUpdatePanel extends ELSInfoPanel{
	AccountVO vo;
	AccountBLService bl;
	
	public AccountUpdatePanel(AccountVO vo,AccountBLService bl) {
		super();
		this.vo = vo;
		this.bl = bl;
		init();
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		super.init();
		
		setTitle("新增账户");
		addEditableItem("账户名称", vo.name, true,InfoType.NAME);
		addEditableItem("账户卡号", vo.account, true,InfoType.NUM);
		addEditableItem("账户余额", String.valueOf(vo.balance), true,InfoType.NUM);
		
		addConfirmAndCancelBtn();
		confirmBtn.setText("确认修改");
		cancelBtn.setText("取消修改");
	}
	
	@Override
	protected void confirm() throws RemoteException {
		if(isAllLegal()){
			vo.name = itemLabels.get(0).toString();
			vo.account = itemLabels.get(1).toString();
			vo.balance = Double.valueOf(itemLabels.get(2).toString());
			
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
