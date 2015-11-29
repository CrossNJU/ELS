package org.cross.elsclient.ui.businesshallclerkui.driver;

import java.rmi.RemoteException;

import org.cross.elsclient.blservice.personnelblservice.PersonnelBLService;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.vo.PersonnelVO;

public class DriverUpdatePanel extends ELSInfoPanel{
	PersonnelVO vo;
	PersonnelBLService personnelBLService;

	public DriverUpdatePanel(PersonnelVO vo, PersonnelBLService bl) {
		this.vo = vo;
		this.personnelBLService = bl;
		init();
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		super.init();

		setTitle("增加司机信息");
		addEditableItem("司机编号", vo.id, false);
		addEditableItem("姓名", vo.name, true);
		addEditableItem("性别", "男", true);
		addEditableItem("身份证号码", "321838198801828381", true);
		addEditableItem("手机", "18372681982", true);
		addEditableItem("出生日期", "1978-10-11", true);
		addEditableItem("车辆单位", "上海中转中心", true);
		addEditableItem("行驶证期限", "2014-10-22", true);
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
