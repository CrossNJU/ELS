package org.cross.elsclient.ui.managerui.organizationui;

import java.rmi.RemoteException;

import org.cross.elsclient.blservice.organizationblservice.OrganizationBLService;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.vo.OrganizationVO;

public class OrganizationAddPanel extends ELSInfoPanel{
	OrganizationVO vo;
	OrganizationBLService bl;
	
	public OrganizationAddPanel(OrganizationVO vo){
		this.vo = vo;
		init();
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		super.init();
		
		setTitle("机构详细信息");
		addEditableItem("机构编号", "",true);
		addEditableItem("地区", "",true);
		addEditableItem("类型", "",true);
		
		vo = new OrganizationVO(null, null, null);
		addConfirmAndCancelBtn();
		confirmBtn.setText("确认添加");
		cancelBtn.setText("取消添加");
	}
	
	@Override
	protected void confirm() {
		try {
			super.confirm();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bl.add(vo);
		back();
	}
	
	@Override
	protected void cancel() {
		super.cancel();
		back();
	}
}
