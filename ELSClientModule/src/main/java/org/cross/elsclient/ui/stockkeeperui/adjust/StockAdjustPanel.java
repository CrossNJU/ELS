package org.cross.elsclient.ui.stockkeeperui.adjust;

import java.rmi.RemoteException;

import org.cross.elsclient.blservice.stockblservice.StockBLService;
import org.cross.elsclient.ui.component.ELSDialog;
import org.cross.elsclient.ui.component.ELSFunctionPanel;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.ui.component.ELSStateBar;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.vo.StockVO;
import org.cross.elsclient.vo.UserVO;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StringToType;

public class StockAdjustPanel extends ELSInfoPanel{

	StockBLService stockbl;
	UserVO user;
	StockVO stockvo;
	
	public StockAdjustPanel(StockBLService stockbl, UserVO user, StockVO stockvo){
		this.stockbl = stockbl;
		this.stockvo = stockvo;
		init();
	}
	
	@Override
	public void init(){
		super.init();
		titlePanel.remove(titlePanel.backBtn);
		
		//需呀find
		String[] it1 = {"S0001-特快"};
		String[] it2 = {"S0002"};
		
		setTitle("调整库存");
		/*0*/addComboxItem("需要调整的仓库", it1, true);
		addComboxItem("需要配合的仓库", it2, true);
		addConfirmAndCancelBtn();
		confirmBtn.setText("确认调整");
		cancelBtn.setVisible(false);
		container.packHeight();
	}
	
	@Override
	protected void confirm() throws RemoteException {
		String id = itemLabels.get(1).toString();
		String type = itemLabels.get(0).toString().split("-")[1];
		if(stockbl.stockAdjust(id, StringToType.toGoodsType(type))==ResultMessage.SUCCESS){
			ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this),"调整成功");
			ELSFunctionPanel parent = GetPanelUtil.getFunctionPanel(this);
//			parent.contentPanel.cl.show(parent.contentPanel, "receipts");
			parent.setChosenFunction("receipts");
		}else{
			ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this),"调整失败");
		}
	}
}
