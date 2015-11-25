package org.cross.elsclient.ui.adminui;

import java.rmi.RemoteException;

import org.cross.elsclient.blservice.userblservice.UserBLService;
import org.cross.elsclient.ui.component.ELSButton;
import org.cross.elsclient.ui.component.ELSDialog;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.ui.component.ELSStateBar;
import org.cross.elsclient.ui.util.ComponentFactory;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.vo.UserVO;
import org.cross.elscommon.util.InfoType;
import org.cross.elscommon.util.ResultMessage;

public class UserUpdatePanel extends ELSInfoPanel{
	UserVO vo;
	UserBLService userbl;
	
	public UserUpdatePanel(UserVO vo, UserBLService bl) {
		this.vo = vo;
		this.userbl = bl;
		init();
	}
	
	@Override
	public void init() {
		super.init();
		
		setTitle("修改用户");
		addEditableItem("用户名", "U000001", false);
		addEditableItem("姓名", vo.name, true,InfoType.PASSWORD);
		addEditableItem("职位", vo.type.toString(), true);
		
		addConfirmAndCancelBtn();
		confirmBtn.setText("确认修改");
		cancelBtn.setText("取消修改");
	}
	
	@Override
	protected void confirm() throws RemoteException {
		if(userbl.update(vo)==ResultMessage.SUCCESS){
			ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this),"更新成功");
			back();
		}else{
			ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this),"更新失败");
		}
	}
	
	@Override
	protected void cancel() {
		super.cancel();
		if(ELSDialog.showConfirmDlg(GetPanelUtil.getFunctionPanel(this), "取消更新", "确认退出更新界面？")){
			back();
		}
	}
}
