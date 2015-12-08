package org.cross.elsclient.ui.counterui.initial;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.ui.component.ELSDialog;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.ui.component.ELSStateBar;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.util.ConstantVal;
import org.cross.elsclient.vo.AccountVO;
import org.cross.elsclient.vo.StockAreaVO;
import org.cross.elsclient.vo.StockVO;
import org.cross.elscommon.util.InfoType;
import org.cross.elscommon.util.NumberType;
import org.cross.elscommon.util.StockType;

public class StockAddPanel extends ELSInfoPanel{
	ArrayList<StockVO> vos;
	StockVO vo;
	
	public StockAddPanel(ArrayList<StockVO> vos) {
		super();
		this.vos = vos;
		init();
	}
	
	@Override
	public void init() {
		super.init();
		
		setTitle("新增仓库");
		addEditableItem("仓库编号", ConstantVal.getNumber().getPostNumber(NumberType.STOCK), true,InfoType.ID);
		addEditableItem("仓库总量", "", true,InfoType.NUM);
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
				area = new StockAreaVO(ConstantVal.getNumber().getPostNumber(NumberType.STOCKAREA),
						id, StockType.Fast, fastCap, 0, null);
				areas.add(area);
			}
			for(int i = 0;i<commonNum;i++) {
				area = new StockAreaVO(ConstantVal.getNumber().getPostNumber(NumberType.STOCKAREA),
						id, StockType.COMMON, commonCap, 0, null);
				areas.add(area);
			}
			for(int i = 0;i<ecoNum;i++) {
				area = new StockAreaVO(ConstantVal.getNumber().getPostNumber(NumberType.STOCKAREA),
						id, StockType.ECONOMICAL, ecoCap, 0, null);
				areas.add(area);
			}
			vo = new StockVO(id, totalNum, 0, 0, 0, 0, 0, 0, orgNum, areas);
			vos.add(vo);
			((InitialManagePanel)GetPanelUtil.getSubFunctionPanel(this, 3).getComponent(1)).refresh();
			ELSStateBar.showStateBar(GetPanelUtil.getFunctionPanel(StockAddPanel.this), "添加成功");
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
