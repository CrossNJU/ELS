package org.cross.elsclient.ui.stockkeeperui.check;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.cross.elsclient.blservice.stockblservice.StockBLService;
import org.cross.elsclient.ui.component.ELSDatePicker;
import org.cross.elsclient.ui.component.ELSManagePanel;
import org.cross.elsclient.ui.util.UIConstant;
import org.cross.elsclient.vo.StockCheckVO;
import org.cross.elsclient.vo.StockVO;
import org.cross.elsclient.vo.UserVO;

public class StockCheckManagePanel extends ELSManagePanel{

	StockBLService stockbl;
	ArrayList<StockCheckVO> checkvos;
	StockVO stock;
	UserVO user;
	
	ELSDatePicker beginDate;
	ELSDatePicker endDate;
	
	StockCheckManageTable list;
	
	public StockCheckManagePanel(){}
	public StockCheckManagePanel(StockBLService stockbl, UserVO user, StockVO stockvo){
		super();
		this.stockbl = stockbl;
		this.user = user;
		this.stock = stockvo;
		this.checkvos = new ArrayList<StockCheckVO>();
		
		try {
			if(stockvo!=null) checkvos = stockbl.showStockCheck(stockvo.number);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		init();
	}
	

	@Override
	public void setContentPanel(){
		super.setContentPanel();
		String[] name = {"快件单编号","入库时间","目的地","所属小间"};
		int[] itemWidth = {200,200,100,200};
		list = new StockCheckManageTable(name, itemWidth);
		list.setLocation(UIConstant.CONTENTPANEL_MARGIN_LEFT,UIConstant.CONTENTPANEL_MARGIN_TOP);
		for(StockCheckVO check : checkvos){
			list.addItem(check);
		}
		container.add(list);
		container.remove(searchPanel);
	}
	
}
