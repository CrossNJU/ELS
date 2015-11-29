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
import org.cross.elsclient.vo.StockVO;

public class StockCheckManageTable extends ELSManageTable{
	StockBLService stockbl;
	ArrayList<GoodsVO> goods;
	
	public StockCheckManageTable(){
		super();
	}
	public StockCheckManageTable(String[] name, int[] itemWidth, StockBLService stockbl){
		super(name, itemWidth);
		this.stockbl = stockbl;
		init();
	}
	
	@Override
	public void init(){
		super.init();
		goods = new ArrayList<GoodsVO>();
		StockVO vo =  null;
//		try {
//			vo = new StockVO(number, totalAreas)
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		for (int i = 0; i < vo.stockAreas.size(); i++) {
//			StockAreaVO area = vo.stockAreas.get(i);
//			for (int j = 0; j < area.goodsList.size(); j++) {
//				GoodsVO goods  = area.goodsList.get(j);
//				addItem(goods, "time", "target place", area.number);
//			}
//		}
		isUpdateAndDelete = false;
	}
	
	public void addItem(GoodsVO vo , String time, String place, String areaNum){
		goods.add(vo);
		String[] item = {vo.number,time, place, areaNum};
		addItemLabel(item);
	}

}
