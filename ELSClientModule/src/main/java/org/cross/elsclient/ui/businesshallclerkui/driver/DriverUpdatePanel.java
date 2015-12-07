package org.cross.elsclient.ui.businesshallclerkui.driver;

import java.rmi.RemoteException;

import org.cross.elsclient.blservice.personnelblservice.PersonnelBLService;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.vo.DriverVO;
import org.cross.elsclient.vo.PersonnelVO;

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

		setTitle("更新司机信息");
		addEditableItem("司机编号", vo.number, false);
		addEditableItem("姓名", vo.name, true);
		addEditableItem("性别", vo.sex, true);
		addEditableItem("身份证号码", vo.id, true);
		addEditableItem("手机", vo.phone, true);
		addEditableItem("出生日期", vo.birthday, true);
		addEditableItem("车辆单位", vo.orgNum, true);
		addEditableItem("行驶证期限", vo.licenceEnd, true);
	}
	
	@Override
	protected void confirm() throws RemoteException {
		super.confirm();
		personnelBLService.update(vo);
		back();
	}
	
	@Override
	protected void cancel() {
		super.cancel();
		back();
	}

}
