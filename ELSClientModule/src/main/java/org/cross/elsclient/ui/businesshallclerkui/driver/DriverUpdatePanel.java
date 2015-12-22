package org.cross.elsclient.ui.businesshallclerkui.driver;

import java.rmi.RemoteException;

import org.cross.elsclient.blservice.personnelblservice.PersonnelBLService;
import org.cross.elsclient.ui.component.ELSDialog;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.ui.component.ELSStateBar;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.util.ConstantVal;
import org.cross.elsclient.vo.DriverVO;
import org.cross.elsclient.vo.PersonnelVO;
import org.cross.elscommon.util.InfoType;
import org.cross.elscommon.util.NumberType;
import org.cross.elscommon.util.ResultMessage;

public class DriverUpdatePanel extends ELSInfoPanel{
	DriverVO vo;
	PersonnelBLService personnelBLService;

	public DriverUpdatePanel(DriverVO vo, PersonnelBLService bl) {
		this.vo = vo;
		this.personnelBLService = bl;
		init();
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		super.init();
		String[] it1 = {"男", "女"};

		setTitle("更新司机信息");
		addEditableItem("司机编号", vo.number, false);
		addEditableItem("姓名", vo.name, true,InfoType.NAME);
		addComboxItem("性别", it1, true);
		addEditableItem("身份证号码", vo.id, true,InfoType.ID);
		addEditableItem("手机", vo.phone, true,InfoType.TELEPHONE);
		addDateItem("出生日期", true);
		addDateItem("行驶证期限", true);
		
		addConfirmAndCancelBtn();
		confirmBtn.setText("确认修改");
		cancelBtn.setText("取消修改");
	}
	
	@Override
	protected void confirm() throws RemoteException {
		super.confirm();
		vo.name = itemLabels.get(1).toString();
		vo.sex = itemLabels.get(2).toString();
		vo.id = itemLabels.get(3).toString();
		vo.phone = itemLabels.get(4).toString();
		vo.birthday = itemLabels.get(5).toString();
		vo.licenceEnd = itemLabels.get(6).toString();
		if(personnelBLService.update(vo) == ResultMessage.SUCCESS){
			ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this), "修改成功");
			back();
		}else {
			ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this), "修改失败");
		}
	}
	
	@Override
	protected void cancel() {
		if (ELSDialog.showConfirmDlg(GetPanelUtil.getFunctionPanel(this), "取消新增", "确认放弃新增单据？")) {
			back();
		}
	}

}
