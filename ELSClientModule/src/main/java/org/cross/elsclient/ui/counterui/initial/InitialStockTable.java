package org.cross.elsclient.ui.counterui.initial;

import java.util.ArrayList;

import org.cross.elsclient.vo.OrganizationVO;
import org.cross.elsclient.vo.StockVO;

public class InitialStockTable extends InitialManageTable {
	ArrayList<StockVO> vos;

	public InitialStockTable(String[] name, int[] itemWidth,ArrayList<StockVO> vos) {
		super(name, itemWidth);
		this.vos = vos;
		refresh();
	}
	
	@Override
	public void init(){
		super.init();
		isUpdateAndDelete = false;
	}
	
	@Override
	public void refresh(){
		removeAll();
		init();
//		for (StockVO vo : vos) {
//			String item[] = {vo.id,vo.city.toString(),vo.type.toString()};
//			addItemLabel(item);
//		}
	}

}
