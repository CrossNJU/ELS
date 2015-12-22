package org.cross.elsclient.ui.managerui.organizationui;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blservice.stockblservice.StockBLService;
import org.cross.elsclient.ui.component.ELSDialog;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.ui.component.ELSStateBar;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.util.ConstantVal;
import org.cross.elsclient.vo.StockAreaVO;
import org.cross.elsclient.vo.StockVO;
import org.cross.elscommon.util.InfoType;
import org.cross.elscommon.util.NumberType;
import org.cross.elscommon.util.ResultMessage;
import org.cross.elscommon.util.StockType;

public class StockAddPanel extends ELSInfoPanel{
	StockBLService stockbl;
	StockVO vo;
	String number;
	
	public StockAddPanel(StockBLService stockbl) {
		super();
		this.stockbl = stockbl;
		init();
	}
	
	@Override
	public void init() {
		super.init();
		
		setTitle("新增仓库");
		number = ConstantVal.numberbl.getPostNumber(NumberType.STOCK);
		addEditableItem("仓库编号", number, true,InfoType.ID);
		addEditableItem("特快仓库数量", "", true,InfoType.NUM);
		addEditableItem("特快仓库容量", "", true,InfoType.NUM);
		addEditableItem("标准仓库数量", "", true,InfoType.NUM);
		addEditableItem("标准仓库容量", "", true,InfoType.NUM);
		addEditableItem("经济仓库数量", "", true,InfoType.NUM);
		addEditableItem("经济仓库容量", "", true,InfoType.NUM);
		addEditableItem("所属机构", "", true,InfoType.ID);
		
		addConfirmAndCancelBtn();
		confirmBtn.setText("确认添加");
		cancelBtn.setText("取消添加");
		setBackPanel("add");
	}
	
	@Override
	protected void confirm() throws RemoteException {
		super.confirm();
		if(isAllLegal()){
			String id = itemLabels.get(0).toString();
			int fastNum = Integer.valueOf((itemLabels.get(1).toString()));
			int fastCap = Integer.valueOf((itemLabels.get(2).toString()));
			int commonNum = Integer.valueOf((itemLabels.get(3).toString()));
			int commonCap = Integer.valueOf((itemLabels.get(4).toString()));
			int ecoNum = Integer.valueOf((itemLabels.get(5).toString()));
			int ecoCap = Integer.valueOf((itemLabels.get(6).toString()));
			String orgNum = itemLabels.get(7).toString();
			int totalNum = fastNum+commonNum+ecoNum;
			
			ArrayList<StockAreaVO> areas = new ArrayList<>();
			StockAreaVO area;
			for(int i = 0;i<fastNum;i++) {
				String number = ConstantVal.getNumber().getPostNumber(NumberType.STOCKAREA);
				area = new StockAreaVO(number,
						id, StockType.Fast, fastCap, 0, null);
				ConstantVal.numberbl.addone(NumberType.STOCKAREA, number);
				areas.add(area);
			}
			for(int i = 0;i<commonNum;i++) {
				String number = ConstantVal.getNumber().getPostNumber(NumberType.STOCKAREA);
				area = new StockAreaVO(number,
						id, StockType.COMMON, commonCap, 0, null);
				ConstantVal.numberbl.addone(NumberType.STOCKAREA, number);
				areas.add(area);
			}
			for(int i = 0;i<ecoNum;i++) {
				String number = ConstantVal.getNumber().getPostNumber(NumberType.STOCKAREA);
				area = new StockAreaVO(number,
						id, StockType.ECONOMICAL, ecoCap, 0, null);
				ConstantVal.numberbl.addone(NumberType.STOCKAREA, number);
				areas.add(area);
			}
			vo = new StockVO(id, totalNum, 0, 0, 0, 0, 0, 0, orgNum, areas);
			if(stockbl.addStock(vo)==ResultMessage.SUCCESS){
				ConstantVal.numberbl.addone(NumberType.STOCK, number);
				ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(StockAddPanel.this), "添加成功");
				back();
			}else{
				ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(StockAddPanel.this), "添加失败");
			}
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
