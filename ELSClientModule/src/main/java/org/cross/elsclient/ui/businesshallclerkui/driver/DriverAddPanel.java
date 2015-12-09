package org.cross.elsclient.ui.businesshallclerkui.driver;

import java.rmi.RemoteException;

import org.cross.elsclient.blservice.personnelblservice.PersonnelBLService;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.util.ConstantVal;
import org.cross.elsclient.vo.DriverVO;
import org.cross.elsclient.vo.PersonnelVO;
import org.cross.elsclient.vo.UserVO;
import org.cross.elscommon.po.SalaryPO;
import org.cross.elscommon.util.InfoType;
import org.cross.elscommon.util.NumberType;
import org.cross.elscommon.util.PositionType;
import org.cross.elscommon.util.SalaryType;


public class DriverAddPanel extends ELSInfoPanel{
	DriverVO drivervo;
	PersonnelBLService bl;
	UserVO user;

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
		
		setTitle("增加司机信息");
		/*0*/addEditableItem("司机编号", ConstantVal.numberbl.getPostNumber(NumberType.PERSONNEL), false);
		addEditableItem("姓名", "", true,InfoType.NAME);
		addComboxItem("性别", it1, true);
		addEditableItem("身份证号码", "", true,InfoType.ID);
		addEditableItem("手机", "", true,InfoType.TELEPHONE);
		addDateItem("出生日期", true);
		addEditableItem("车辆单位", user.orgNameID, false);
		addDateItem("行驶证期限", true);
		
	}
	
	@Override
	protected void confirm() throws RemoteException {
		super.confirm();
		SalaryPO salary = new SalaryPO(SalaryType.ADDONCE, 0, 100, 0, itemLabels.get(0).toString());
		drivervo = new DriverVO(itemLabels.get(0).toString(), itemLabels.get(1).toString(), PositionType.DRIVER, 
				user.orgNameID, itemLabels.get(2).toString(), itemLabels.get(3).toString(), 
				itemLabels.get(4).toString(), itemLabels.get(5).toString(), 
				salary, itemLabels.get(7).toString(), itemLabels.get(7).toString());
		bl.add(drivervo);
		back();
	}
	
	@Override
	protected void cancel() {
		super.cancel();
		back();
	}

}
