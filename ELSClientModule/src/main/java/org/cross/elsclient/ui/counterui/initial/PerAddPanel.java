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
		addComboxItem("性别",new String[]{"男","女"} , true);
		addEditableItem("身份证", "", true,InfoType.IDCARD);
		String []position = PositionType.toStrings();
		addEditableItem("所属机构ID", "", true,InfoType.ID);
		addComboxItem("职位", position, true);
		addDateItem("出生日期", true);
		addEditableItem("手机", "", true,InfoType.TELEPHONE);
		
		addConfirmAndCancelBtn();
		confirmBtn.setText("确认添加");
		cancelBtn.setText("取消添加");
		setBackPanel("add");
	}
	
	@Override
	protected void confirm() throws RemoteException {
		super.confirm();
		if(isAllLegal()){
			String id = itemLabels.get(0).toString();
			String name = itemLabels.get(1).toString();
			String sex = itemLabels.get(2).toString();
			String idcard = itemLabels.get(3).toString();
			String orgNum = itemLabels.get(4).toString();
			PositionType position = StringToType.toPositionType(itemLabels.get(5).toString());
			String birthday = itemLabels.get(6).toString();
			String phone = itemLabels.get(7).toString();
			
			
			vo = new PersonnelVO(id, name, position, orgNum, sex, id, phone, birthday);
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
