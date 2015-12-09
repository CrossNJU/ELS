package org.cross.elsclient.ui.counterui.initial;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.ui.component.ELSDialog;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.ui.component.ELSStateBar;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.util.ConstantVal;
import org.cross.elsclient.vo.AccountVO;
import org.cross.elsclient.vo.VehicleVO;
import org.cross.elscommon.util.InfoType;
import org.cross.elscommon.util.NumberType;
import org.cross.elscommon.util.VehicleType;

public class VehicleAddPanel extends ELSInfoPanel{
	ArrayList<VehicleVO> vos;
	VehicleVO vo;
	
	public VehicleAddPanel(ArrayList<VehicleVO> vos) {
		super();
		this.vos = vos;
		init();
	}
	
	@Override
	public void init() {
		super.init();
		
		setTitle("新增车辆");
		addEditableItem("车牌编号", ConstantVal.numberbl.getPostNumber(NumberType.VEHICLE),true,InfoType.NUM);
		addEditableItem("车牌号", "",true,InfoType.NUM);
		addEditableItem("营业厅编号", "",true,InfoType.NUM);
		addDateItem("购买时间",true);
		addDateItem("服役时间",true);
		addEditableItem("发动机号", "",true,InfoType.NUM);
		addEditableItem("底盘号", "",true,InfoType.NUM);
		
		addConfirmAndCancelBtn();
		confirmBtn.setText("确认添加");
		cancelBtn.setText("取消添加");
		setBackPanel("add");
	}
	
	@Override
	protected void confirm() throws RemoteException {
		super.confirm();
		if(isAllLegal()){
			String number = itemLabels.get(0).toString();
			String licence = itemLabels.get(1).toString();
			String orgNum = itemLabels.get(2).toString();
			String buyTime = itemLabels.get(3).toString();
			String lastTime = itemLabels.get(4).toString();
			String engineNumber = itemLabels.get(5).toString();
			String apparatusNumber = itemLabels.get(6).toString();
			
			vo = new VehicleVO(number, licence, orgNum, engineNumber, apparatusNumber, buyTime, lastTime, null, false);
			vos.add(vo);
			((InitialManagePanel)GetPanelUtil.getSubFunctionPanel(this, 3).getComponent(1)).refresh();
			ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this), "添加成功");
			back();
		}
	}
	
	@Override
	protected void cancel() {
		// TODO Auto-generated method stub
		super.cancel();
		if(ELSDialog.showConfirmDlg(GetPanelUtil.getFunctionPanel(this),
				"取消添加", "确认退出新增界面？")){
			back();
		}
	}
	
}
