package org.cross.elsclient.ui.managerui.organizationui;

import java.rmi.RemoteException;

import org.cross.elsclient.blservice.organizationblservice.OrganizationBLService;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.vo.OrganizationVO;

public class OrganizationUpdatePanel extends ELSInfoPanel{
	OrganizationVO vo;
	OrganizationBLService bl;
	
	public OrganizationUpdatePanel(OrganizationVO vo){
		this.vo = vo;
		init();
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		super.init();
		
		setTitle("机构详细信息");
		addEditableItem("机构编号", vo.id,true);
		addEditableItem("地区", vo.city.toString(),true);
		addEditableItem("类型", vo.type.toString(),true);
		
		addConfirmAndCancelBtn();
		confirmBtn.setText("确认修改");
		cancelBtn.setText("取消修改");
	}
	
	@Override
	protected void confirm() throws RemoteException {
		super.confirm();
		bl.update(vo);
		back();
	}
	
	@Override
	protected void cancel() {
		super.cancel();
		back();
	}
	
	
}
