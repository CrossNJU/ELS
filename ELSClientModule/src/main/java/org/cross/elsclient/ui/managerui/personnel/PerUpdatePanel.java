package org.cross.elsclient.ui.managerui.personnel;

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
import org.cross.elscommon.util.StringToType;

public class PerUpdatePanel extends ELSInfoPanel{
	PersonnelVO vo;
	PersonnelBLService personelbl;
	
	public PerUpdatePanel(PersonnelVO vo,PersonnelBLService personnelbl) {
		super();
		this.personelbl = personnelbl;
		this.vo = vo;
		init();
	}
	
	@Override
	public void init() {
		super.init();
		
		setTitle("更改人员信息");
		addEditableItem("人员编号", vo.number, false);
		addEditableItem("姓名", vo.name, true,InfoType.NAME);
		addComboxItem("性别",new String[]{"男","女"} , vo.sex,true);
		addEditableItem("身份证", vo.id, true,InfoType.NAME);
		String []position = PositionType.toStrings();
		addEditableItem("所属机构ID", vo.orgNum, true,InfoType.ID);
		addComboxItem("职位", position, vo.position.toString(),true);
		addDateItem("出生日期", true);
		addEditableItem("手机", vo.phone, true,InfoType.TELEPHONE);
		
		
		addConfirmAndCancelBtn();
		confirmBtn.setText("确认添加");
		cancelBtn.setText("取消添加");
		setBackPanel("add");
	}
	
	@Override
	protected void confirm() throws RemoteException {
		super.confirm();
		if(isAllLegal()){
			vo.number = itemLabels.get(0).toString();
			vo.name = itemLabels.get(1).toString();
			vo.sex = itemLabels.get(2).toString();
			vo.id = itemLabels.get(3).toString();
			vo.orgNum = itemLabels.get(4).toString();
			vo.position = StringToType.toPositionType(itemLabels.get(5).toString());
//			vo.birthday = itemLabels.get(6).toString();
			vo.phone = itemLabels.get(7).toString();
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
