package org.cross.elsclient.ui.counterui.initial;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.ui.component.ELSDialog;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.ui.component.ELSStateBar;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.vo.PersonnelVO;
import org.cross.elsclient.vo.VehicleVO;
import org.cross.elscommon.util.InfoType;
import org.cross.elscommon.util.OrganizationType;
import org.cross.elscommon.util.PositionType;
import org.cross.elscommon.util.StringToType;
import org.cross.elscommon.util.VehicleType;

public class PerAddPanel extends ELSInfoPanel{
	ArrayList<PersonnelVO> vos;
	PersonnelVO vo;
	
	public PerAddPanel(ArrayList<PersonnelVO> vos) {
		super();
		this.vos = vos;
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
		String []items = OrganizationType.toStrings();
		String []position = PositionType.toStrings();
		addComboxItem("所属机构类型", items, true);
		addEditableItem("所属机构ID", "", true,InfoType.NAME);
		addComboxItem("职位", position, true);
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
					StringToType.toPositionType(itemLabels.get(4).toString()), 
					StringToType.toOrg(itemLabels.get(2).toString()), itemLabels.get(3).toString());
			vos.add(vo);
			((InitialManagePanel)GetPanelUtil.getSubFunctionPanel(this, 3).getComponent(1)).refresh();
			ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this), "添加成功");
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
