package org.cross.elsclient.ui.managerui.constant;

import java.awt.Font;
import java.rmi.RemoteException;

import org.cross.elsclient.blservice.constantblservice.ConstantBLService;
import org.cross.elsclient.ui.component.ELSDialog;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.ui.component.ELSStateBar;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.vo.ConstantVO;
import org.cross.elscommon.util.InfoType;
import org.cross.elscommon.util.ResultMessage;

public class ConstantUpdatePanel extends ELSInfoPanel {
	ConstantVO vo;
	ConstantBLService bl;
	
	public ConstantUpdatePanel(ConstantBLService bl) {
		this.bl = bl;
		init();
	}
	
	@Override
	public void init() {
		super.init();
		vo = bl.show();
		
		setTitle("更改业务常量");
		addNormalItem("城市距离", "");
		itemLabels.get(0).nameLabel.setFont(itemLabels.get(0).nameLabel.getFont().deriveFont(Font.BOLD));
		addEditableItem("北京-上海", vo.distance_Beijing_Shanghai+"",true,InfoType.NUM);
		addEditableItem("北京-南京", vo.distance_Beijing_Nanjing+"",true,InfoType.NUM);
		addEditableItem("北京-广州", vo.distance_Beijing_Guangzhou+"",true,InfoType.NUM);
		addEditableItem("南京-广州", vo.distance_Nanjing_Guangzhou+"",true,InfoType.NUM);
		addEditableItem("南京-上海", vo.distance_Nanjing_Shanghai+"",true,InfoType.NUM);
		addEditableItem("广州-上海", vo.distance_Shanghai_Guangzhou+"",true,InfoType.NUM);
		addNormalItem("", "");
		addEditableItem("价格(元/(kilo*kg))", vo.price+"",true,InfoType.NUM);
		addEditableItem("预估每公里所花时间(hour/km)", vo.timeBykilo+"",true,InfoType.NUM);
	
		addConfirmAndCancelBtn();
		confirmBtn.setText("确认修改");
		cancelBtn.setText("取消修改");
		
		container.packHeight();

	}
	
	@Override
	protected void confirm() throws RemoteException {
		// TODO Auto-generated method stub
		super.confirm();
		
		if(isAllLegal()){
			vo.distance_Beijing_Shanghai = Double.valueOf(itemLabels.get(1).toString());
			vo.distance_Beijing_Nanjing = Double.valueOf(itemLabels.get(2).toString());
			vo.distance_Beijing_Guangzhou = Double.valueOf(itemLabels.get(3).toString());
			vo.distance_Nanjing_Guangzhou = Double.valueOf(itemLabels.get(4).toString());
			vo.distance_Nanjing_Shanghai = Double.valueOf(itemLabels.get(5).toString());
			vo.distance_Shanghai_Guangzhou = Double.valueOf(itemLabels.get(6).toString());
			vo.price = Double.valueOf(itemLabels.get(8).toString());
			vo.timeBykilo = Double.valueOf(itemLabels.get(9).toString());
			if(bl.update(vo)==ResultMessage.SUCCESS){
				ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this),"更新成功");
				back();
			}else{
				ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this),"更新失败");
			}
		}
	}
	
	@Override
	protected void cancel() {
		super.cancel();
		if(ELSDialog.showConfirmDlg(GetPanelUtil.getFunctionPanel(this), "取消更新", "确认退出更新界面？")){
			back();
		}
	}
}