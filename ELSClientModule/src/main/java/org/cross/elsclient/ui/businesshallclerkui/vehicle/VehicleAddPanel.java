package org.cross.elsclient.ui.businesshallclerkui.vehicle;

import java.rmi.RemoteException;

import org.cross.elsclient.blservice.vehicleblservice.VehicleBLService;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.util.ConstantVal;
import org.cross.elsclient.vo.VehicleVO;
import org.cross.elscommon.util.InfoType;
import org.cross.elscommon.util.NumberType;

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
		
		setTitle("新增车辆信息");
		/*0*/addEditableItem("车辆编号", ConstantVal.numberbl.getPostNumber(NumberType.VEHICLE), false);
		addEditableItem("车牌号", "",true,InfoType.NAME);
		addEditableItem("营业厅编号", "",true,InfoType.NAME);
		addDateItem("购买时间", true);
		addDateItem("服役时间", true);
		addEditableItem("发动机号", "",true,InfoType.NAME);
		addEditableItem("底盘号", "",true,InfoType.NAME);
		
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
