package org.cross.elsclient.ui.stockkeeperui.check;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elsclient.blservice.stockblservice.StockBLService;
import org.cross.elsclient.ui.component.ELSManageTable;
import org.cross.elsclient.ui.component.ELSPanel;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.vo.GoodsVO;
import org.cross.elsclient.vo.StockAreaVO;
import org.cross.elsclient.vo.StockCheckVO;
import org.cross.elsclient.vo.StockVO;
import org.cross.elsclient.vo.UserVO;

public class StockCheckManageTable extends ELSManageTable{
	StockBLService stockbl;
	StockVO stockvo;
	UserVO user;
	ArrayList<StockCheckVO> stockchecks;
	
	public StockCheckManageTable(){
		super();
	}
	public StockCheckManageTable(String[] name, int[] itemWidth, StockBLService stockbl, UserVO user){
		super(name, itemWidth);
		this.stockbl = stockbl;
		this.user = user;
		try {
			stockvo = stockbl.findStockByOrg(user.orgNameID);
			stockchecks = stockbl.showStockCheck(stockvo.number);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		init();
	}
	
	@Override
	public void init(){
		super.init();
		isUpdateAndDelete = false;
	}
	
	public void addItem(StockCheckVO check){
		String[] item = {check.goodsNumber, check.inTime, check.targetCity , check.stockAreaNum};
		addItemLabel(item);
	}

}
