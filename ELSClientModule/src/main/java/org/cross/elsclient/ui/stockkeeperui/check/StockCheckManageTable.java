package org.cross.elsclient.ui.stockkeeperui.check;

import org.cross.elsclient.ui.component.ELSManageTable;
import org.cross.elsclient.vo.StockCheckVO;

public class StockCheckManageTable extends ELSManageTable{
	
	public StockCheckManageTable(){
		super();
	}
	public StockCheckManageTable(String[] name, int[] itemWidth){
		super(name, itemWidth);
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
