package org.cross.elsclient.ui.businesshallclerkui.vehicle;

import java.rmi.RemoteException;

import org.cross.elsclient.blservice.userblservice.UserBLService;
import org.cross.elsclient.blservice.vehicleblservice.VehicleBLService;
import org.cross.elsclient.ui.component.ELSDialog;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.ui.component.ELSStateBar;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.ui.util.LogUtil;
import org.cross.elsclient.util.ConstantVal;
import org.cross.elsclient.vo.UserVO;
import org.cross.elsclient.vo.VehicleVO;
import org.cross.elscommon.util.InfoType;
import org.cross.elscommon.util.NumberType;
import org.cross.elscommon.util.ResultMessage;

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
		addEditableItem("车牌号", vo.licence,true,InfoType.NAME);
		addDateItem("购买时间", true);
		addDateItem("服役时间", true);
		addEditableItem("发动机号", vo.engineNumber,true,InfoType.NAME);
		addEditableItem("底盘号", vo.baseNumber,true,InfoType.NAME);
		
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
		if(vehiclebl.update(vo) == ResultMessage.SUCCESS){
			LogUtil.addLog("更新车辆");
			ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this), "修改成功");
			back();
		}else {
			ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this), "修改失败");
		}
	}
	
	@Override
	protected void cancel() {
		if (ELSDialog.showConfirmDlg(GetPanelUtil.getFunctionPanel(this), "取消新增", "确认放弃新增单据？")) {
			back();
		}
	}
}
