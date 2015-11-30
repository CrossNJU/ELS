package org.cross.elsclient.ui.managerui.personnel;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blservice.personnelblservice.PersonnelBLService;
import org.cross.elsclient.ui.component.ELSDialog;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.ui.component.ELSStateBar;
import org.cross.elsclient.ui.counterui.initial.InitialManagePanel;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.vo.PersonnelVO;
import org.cross.elscommon.util.InfoType;
import org.cross.elscommon.util.OrganizationType;
import org.cross.elscommon.util.PositionType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StringToType;

public class PerAddPanel extends ELSInfoPanel {
	PersonnelVO vo;
	PersonnelBLService personelbl;
	
	public PerAddPanel(PersonnelBLService personnelbl) {
		super();
		this.personelbl = personnelbl;
		init();
	}
	
	@Override
	public void init() {
		super.init();
		
		setTitle("新增人员");
		addEditableItem("人员编号", "", true);
		addEditableItem("姓名", "", true,InfoType.NAME);
//		addComboxItem("性别",new String[]{"男","女"} , true);
//		addEditableItem("身份证", "", true,InfoType.IDCARD);
		String []items = {OrganizationType.BUSINESSHALL.toString(),
				OrganizationType.HEADQUARTERS.toString(),
				OrganizationType.TRANSITCENTER.toString()
		};
		addComboxItem("所属机构类型", items, true);
		addEditableItem("所属机构ID", "", true,InfoType.NAME);
		addEditableItem("职位", "", true,InfoType.NAME);
//		addDateItem("出生日期", true);
		
		
		addConfirmAndCancelBtn();
		confirmBtn.setText("确认添加");
		cancelBtn.setText("取消添加");
		setBackPanel("add");
	}
	
	@Override
	protected void confirm() throws RemoteException {
		super.confirm();
		if(isAllLegal()){
			vo = new PersonnelVO(itemLabels.get(0).toString(),itemLabels.get(1).toString() , 
					StringToType.toPositionType(itemLabels.get(5).toString()), 
					StringToType.toOrg(itemLabels.get(3).toString()), itemLabels.get(4).toString());
			if(personelbl.add(vo)==ResultMessage.SUCCESS){
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
