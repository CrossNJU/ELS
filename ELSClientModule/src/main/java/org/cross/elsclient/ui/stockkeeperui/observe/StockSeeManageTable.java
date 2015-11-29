package org.cross.elsclient.ui.stockkeeperui.observe;

import java.util.ArrayList;

import org.cross.elsclient.blservice.receiptblservice.ReceiptBLService;
import org.cross.elsclient.blservice.stockblservice.StockBLService;
import org.cross.elsclient.ui.businesshallclerkui.trans.TransInfoPanel;
import org.cross.elsclient.ui.component.ELSManageTable;
import org.cross.elsclient.ui.component.ELSPanel;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.vo.GoodsVO;
import org.cross.elsclient.vo.Receipt_TransVO;
import org.cross.elsclient.vo.StockAreaVO;
import org.cross.elsclient.vo.StockVO;

public class StockSeeManageTable extends ELSManageTable{
	ReceiptBLService reciptbl;
	StockBLService stockbl;
	ArrayList<GoodsVO> goods;
	
	public StockSeeManageTable(){super();}
	public StockSeeManageTable(String[] name, int[] itemWidth, ReceiptBLService receiptbl){
		super(name, itemWidth);
		this.reciptbl = receiptbl;
		init();
	}
	
	@Override
	public void init(){
		super.init();
		goods = new ArrayList<GoodsVO>();
		isUpdateAndDelete = false;
	}
	
	public void addItem(GoodsVO vo , String areaNum){
		goods.add(vo);
		String[] item = {vo.number,areaNum};
		addItemLabel(item);
	}
	
	@Override
	public void infoBtn(int index){
		super.updateBtn(index);
		ELSPanel contentPanel = GetPanelUtil.getSubFunctionPanel(this, 0);
		GoodsVO vo = goods.get(index);
//		contentPanel.add("info", new TransInfoPanel(vo));
//		contentPanel.cl.show(contentPanel, "info");
	}

}
