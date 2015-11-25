package org.cross.elsclient.ui.businesshallclerkui.vehicle;

import java.rmi.RemoteException;

import org.cross.elsclient.blservice.userblservice.UserBLService;
import org.cross.elsclient.blservice.vehicleblservice.VehicleBLService;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.vo.UserVO;
import org.cross.elsclient.vo.VehicleVO;

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
		addEditableItem("车牌编号", vo.number,true);
		addEditableItem("车牌号", "",true);
		addEditableItem("营业厅编号", "",true);
		addEditableItem("购买时间", vo.buyTime,true);
		addEditableItem("服役时间", vo.buyTime+"~"+vo.lastTime,true);
		addEditableItem("发动机号", vo.engineNumber,true);
		addEditableItem("底盘号", vo.apparatusNumber,true);
	}
	
	@Override
	protected void confirm() throws RemoteException {
		super.confirm();
		vehiclebl.update(vo);
		back();
	}
	
	@Override
	protected void cancel() {
		super.cancel();
		back();
	}
}
