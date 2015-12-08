package org.cross.elsclient.ui.businesshallclerkui.vehicle;

import java.rmi.RemoteException;

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
		/*0*/addEditableItem("车牌编号", "",true);
		addEditableItem("车牌号", "",true);
		addEditableItem("营业厅编号", "",true);
		addEditableItem("购买时间", "",true);
		addEditableItem("服役时间", "",true);
		addEditableItem("发动机号", "",true);
		addEditableItem("底盘号", "",true);
		
		addConfirmAndCancelBtn();
		confirmBtn.setText("确认添加");
		cancelBtn.setText("取消添加");
		
		container.packHeight();
	}
	
	@Override
	protected void confirm() throws RemoteException {
		super.confirm();
		vo = new VehicleVO(itemLabels.get(0).toString(), itemLabels.get(1).toString(), itemLabels.get(2).toString(), 
				itemLabels.get(5).toString(), itemLabels.get(6).toString(), itemLabels.get(3).toString(), 
				itemLabels.get(4).toString(), null, false);
		vehiclebl.add(vo);
		back();
	}
	
	@Override
	protected void cancel() {
		super.cancel();
		back();
	}
}
