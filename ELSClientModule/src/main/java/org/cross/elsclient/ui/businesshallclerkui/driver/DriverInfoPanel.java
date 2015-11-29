package org.cross.elsclient.ui.businesshallclerkui.driver;

import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.vo.PersonnelVO;
import org.cross.elsclient.vo.VehicleVO;

public class DriverInfoPanel extends ELSInfoPanel{

	PersonnelVO vo;
	
	public DriverInfoPanel(PersonnelVO vo) {
		this.vo = vo;
		init();
	}
	
	@Override
	public void init() {
		super.init();
		
		setTitle("司机详细信息");
		addNormalItem("司机编号", vo.id);
		addNormalItem("姓名", vo.name);
		addNormalItem("性别", "男");
		addNormalItem("身份证号码", "321838198801828381");
		addNormalItem("手机", "18372681982");
		addNormalItem("出生日期", "1978-10-11");
		addNormalItem("车辆单位", "上海中转中心");
		addNormalItem("行驶证期限", "2014-10-22");
	}
}
