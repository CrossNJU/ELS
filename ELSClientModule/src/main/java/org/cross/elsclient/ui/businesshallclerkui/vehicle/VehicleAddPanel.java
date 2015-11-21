package org.cross.elsclient.ui.businesshallclerkui.vehicle;

import org.cross.elsclient.blservice.vehicleblservice.VehicleBLService;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.vo.VehicleVO;

public class VehicleAddPanel extends ELSInfoPanel {
	VehicleBLService vehiclebl;
	VehicleVO vo;

	public VehicleAddPanel(VehicleBLService bl) {
		this.vehiclebl = bl;
		init();
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		super.init();
		
		setTitle("修改车辆信息");
		addEditableItem("车牌编号", "",true);
		addEditableItem("车牌号", "",true);
		addEditableItem("营业厅编号", "",true);
		addEditableItem("购买时间", "",true);
		addEditableItem("服役时间", "",true);
		addEditableItem("发动机号", "",true);
		addEditableItem("底盘号", "",true);
		
//		vo = new VehicleVO(itemLabels.get(0).getText(), itemLabels.get(0).getText(), itemLabels.get(0).getText(), buyTime, lastTime, null, type)
	}
	
	@Override
	protected void confirm() {
		super.confirm();
		vehiclebl.add(vo);
		back();
	}
	
	@Override
	protected void cancel() {
		super.cancel();
		back();
	}
}
