package org.cross.elsclient.ui.businesshallclerkui.vehicle;

import java.rmi.RemoteException;

import org.cross.elsclient.blservice.userblservice.UserBLService;
import org.cross.elsclient.blservice.vehicleblservice.VehicleBLService;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.vo.UserVO;
import org.cross.elsclient.vo.VehicleVO;
import org.cross.elscommon.util.InfoType;

public class VehicleUpdatePanel extends ELSInfoPanel{
	VehicleVO vo;
	VehicleBLService vehiclebl;

	public VehicleUpdatePanel(VehicleVO vo, VehicleBLService bl) {
		this.vo = vo;
		this.vehiclebl = bl;
		init();
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		super.init();
		
		setTitle("修改车辆信息");
		/*0*/addEditableItem("车辆编号", vo.number, false);
		addEditableItem("车牌号", "",true,InfoType.NAME);
		addDateItem("购买时间", true);
		addDateItem("服役时间", true);
		addEditableItem("发动机号", "",true,InfoType.NAME);
		addEditableItem("底盘号", "",true,InfoType.NAME);
		
		addConfirmAndCancelBtn();
		confirmBtn.setText("确认修改");
		cancelBtn.setText("取消修改");
		
		container.packHeight();
	}
	
	@Override
	protected void confirm() throws RemoteException {
		super.confirm();
		vo.licence = itemLabels.get(1).toString();
		vo.buyTime = itemLabels.get(2).toString();
		vo.lastTime = itemLabels.get(3).toString();
		vo.engineNumber = itemLabels.get(4).toString();
		vo.baseNumber = itemLabels.get(5).toString();
		vehiclebl.update(vo);
		back();
	}
	
	@Override
	protected void cancel() {
		super.cancel();
		back();
	}
}
