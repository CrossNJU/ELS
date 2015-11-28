package org.cross.elsclient.ui.businesshallclerkui.trans;

import java.rmi.RemoteException;

import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elsclient.ui.component.ELSDialog;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.ui.component.ELSPanel;
import org.cross.elsclient.ui.component.ELSStateBar;
import org.cross.elsclient.ui.util.ConstantValue;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.vo.Receipt_TransVO;
import org.cross.elscommon.util.City;
import org.cross.elscommon.util.ResultMessage;

public class TransAddPanel extends ELSInfoPanel{
	Receipt_TransVO vo;
	ReceiptBLService bl;
	
	public TransAddPanel(ReceiptBLService receiptbl){
		this.bl = receiptbl;
		init();
	}
	
	@Override
	public void init(){
		super.init();
		String it1[] = {"南京营业厅","北京营业厅","上海营业厅","广州营业厅"};
		String it2[] = {"营业厅","中转中心"};
		String it3[] = ConstantValue.getUnusedVehicle();
		String it4[] = ConstantValue.getUnusedDriver();
		String it5[] = ConstantValue.getUnusedObserver();
		
		setTitle("新增装车单");
		addEditableItem("装车单编号", ConstantValue.getReceiptTransNum(), false);
		addEditableItem("快件单编号", "R2000001;R20000002", false);
		addComboxItem("出发地", it1, true);
		addComboxItem("到达城市", it1, true);
		addComboxItem("到达机构", it2, true);
		addEditableItem("装车时间", ConstantValue.getTime(), false);
		addEditableItem("运输编号", ConstantValue.getReceiptTransLocalNum(), false);
		addComboxItem("车辆编号", it3, true);
		addComboxItem("押运员", it4, true);
		addComboxItem("监装员", it5, true);
		addEditableItem("运费", "$"+String.valueOf(ConstantValue.getTrans(City.NANJING, City.BEIJING)), false);
		addConfirmAndCancelBtn();
		confirmBtn.setText("确认添加");
		cancelBtn.setText("查看单据");
		container.packHeight();
	}
	
	@Override
	protected void confirm() throws RemoteException {
		if(bl.add(vo)==ResultMessage.SUCCESS){
			ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this),"添加成功");
			cancel();
		}else{
			ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(this),"添加失败");
		}
	}
	
	@Override
	protected void cancel() {		
		if(ELSDialog.showConfirmDlg(GetPanelUtil.getFunctionPanel(this), "取消新增", "确认放弃新增单据？")){
			TransManagePanel transManagePanel = new TransManagePanel(bl);
			ELSPanel parent = (ELSPanel) getParent();
			parent.add("manage",transManagePanel);
			parent.cl.show(parent, "manage");
		}		
	}

}
