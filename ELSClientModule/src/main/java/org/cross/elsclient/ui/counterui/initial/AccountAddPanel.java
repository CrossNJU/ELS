package org.cross.elsclient.ui.counterui.initial;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blservice.organizationblservice.OrganizationBLService;
import org.cross.elsclient.ui.component.ELSDialog;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.ui.component.ELSStateBar;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.vo.AccountVO;
import org.cross.elsclient.vo.OrganizationVO;
import org.cross.elscommon.util.City;
import org.cross.elscommon.util.InfoType;
import org.cross.elscommon.util.OrganizationType;

public class AccountAddPanel extends ELSInfoPanel{
	ArrayList<AccountVO> vos;
	AccountVO vo;
	
	public AccountAddPanel(ArrayList<AccountVO> vos) {
		super();
		this.vos = vos;
		init();
	}
	
	@Override
	public void init() {
		super.init();
		
		setTitle("新增账户");
		addEditableItem("账户名称", "", true,InfoType.NAME);
		addEditableItem("账户卡号", "", true,InfoType.NAME);
		addEditableItem("账户余额", "", true,InfoType.NUM);
		
		addConfirmAndCancelBtn();
		confirmBtn.setText("确认添加");
		cancelBtn.setText("取消添加");
		setBackPanel("add");
	}
	
	@Override
	protected void confirm() throws RemoteException {
		super.confirm();
		if(isAllLegal()){
			vo = new AccountVO(itemLabels.get(0).toString(), 
					itemLabels.get(1).toString(), Double.valueOf(itemLabels.get(2).toString()));
			vos.add(vo);
			((InitialManagePanel)GetPanelUtil.getSubFunctionPanel(this, 3).getComponent(1)).refresh();
			ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(AccountAddPanel.this), "添加成功");
			back();
		}
	}
	
	@Override
	protected void cancel() {
		// TODO Auto-generated method stub
		super.cancel();
		if(ELSDialog.showConfirmDlg(GetPanelUtil.getFunctionPanel(this),
				"取消添加", "确认退出新增界面？")){
			back();
		}
	}
}
