package org.cross.elsclient.ui.businesshallclerkui.driver;

import java.rmi.RemoteException;

import org.cross.elsclient.blservice.personnelblservice.PersonnelBLService;
import org.cross.elsclient.ui.component.ELSDialog;
import org.cross.elsclient.ui.component.ELSFunctionPanel;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.ui.component.ELSStateBar;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.ui.util.LogUtil;
import org.cross.elsclient.util.ConstantVal;
import org.cross.elsclient.vo.DriverVO;
import org.cross.elsclient.vo.PersonnelVO;
import org.cross.elsclient.vo.UserVO;
import org.cross.elscommon.po.SalaryPO;
import org.cross.elscommon.util.InfoType;
import org.cross.elscommon.util.NumberType;
import org.cross.elscommon.util.PositionType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.SalaryType;


public class DriverAddPanel extends ELSInfoPanel{
	DriverVO drivervo;
	PersonnelBLService bl;
	UserVO user;
	String number;

	public DriverAddPanel(PersonnelBLService bl, UserVO user) {
		this.bl = bl;
		this.user = user;
		init();
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		super.init();
		String[] it1 = {"男", "女"};
		
		number = ConstantVal.numberbl.getPostNumber(NumberType.PERSONNEL);
		setTitle("增加司机信息");
		/*0*/addEditableItem("司机编号",number , false);
		addEditableItem("姓名", "", true,InfoType.NAME);
		addComboxItem("性别", it1, true);
		addEditableItem("身份证号码", "", true,InfoType.ID);
		addEditableItem("手机", "", true,InfoType.TELEPHONE);
		addDateItem("出生日期", true);
		addEditableItem("车辆单位", user.orgNameID, false);
		addDateItem("行驶证期限", true);
		addConfirmAndCancelBtn();
		confirmBtn.setText("确认添加");
		cancelBtn.setText("取消添加");
		container.packHeight();
	}
	
	@Override
	protected void confirm() throws RemoteException {
		super.confirm();
		SalaryPO salary = new SalaryPO(SalaryType.ADDONCE, 0, 100, 0, itemLabels.get(0).toString());
		drivervo = new DriverVO(itemLabels.get(0).toString(), itemLabels.get(1).toString(), PositionType.DRIVER, 
				user.orgNameID, itemLabels.get(2).toString(), itemLabels.get(3).toString(), 
				itemLabels.get(4).toString(), itemLabels.get(5).toString(), 
				salary, itemLabels.get(7).toString(), itemLabels.get(7).toString());
		if(bl.add(drivervo) == ResultMessage.SUCCESS){
			ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this), "添加成功");
			ConstantVal.numberbl.addone(NumberType.PERSONNEL, number);
			LogUtil.addLog("新增司机");
			back();
		}else {
			ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this), "添加失败");
		}
	}
	
	@Override
	protected void cancel() {
		if (ELSDialog.showConfirmDlg(GetPanelUtil.getFunctionPanel(this), "取消新增", "确认放弃新增单据？")) {
			back();
		}
	}

}
