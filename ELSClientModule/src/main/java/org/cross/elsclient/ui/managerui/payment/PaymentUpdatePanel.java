package org.cross.elsclient.ui.managerui.payment;

import java.rmi.RemoteException;

import org.cross.elsclient.blservice.personnelblservice.PersonnelBLService;
import org.cross.elsclient.ui.component.ELSDialog;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.ui.component.ELSStateBar;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.vo.PersonnelVO;
import org.cross.elscommon.util.InfoType;
import org.cross.elscommon.util.OrganizationType;
import org.cross.elscommon.util.PositionType;
import org.cross.elscommon.util.ResultMessage;

public class PaymentUpdatePanel extends ELSInfoPanel{
	PersonnelVO vo;
	PersonnelBLService personelbl;
	
	public PaymentUpdatePanel(PersonnelVO vo,PersonnelBLService personnelbl) {
		super();
		this.personelbl = personnelbl;
		this.vo = vo;
		init();
	}
	
	@Override
	public void init() {
		super.init();
		
		setTitle("新增人员");
		addEditableItem("人员编号", vo.id, false);
		addEditableItem("姓名", vo.name, false,InfoType.NAME);
		addEditableItem("工资", vo.payment+"", true);
		
		
		addConfirmAndCancelBtn();
		confirmBtn.setText("确认添加");
		cancelBtn.setText("取消添加");
		setBackPanel("add");
	}
	
	@Override
	protected void confirm() throws RemoteException {
		super.confirm();
		if(isAllLegal()){
			vo.payment = Double.valueOf(itemLabels.get(3).toString());
			if(personelbl.update(vo)==ResultMessage.SUCCESS){
				ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this), "添加成功");
				back();
			}else {
				ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this), "添加失败");
			}
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
