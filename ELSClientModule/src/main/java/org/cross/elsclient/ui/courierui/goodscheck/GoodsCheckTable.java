package org.cross.elsclient.ui.courierui.goodscheck;

import java.util.ArrayList;

import org.cross.elsclient.ui.component.ELSManageTable;
import org.cross.elsclient.vo.GoodsVO;
import org.cross.elsclient.vo.HistoryVO;

public class GoodsCheckTable extends ELSManageTable{

	public GoodsCheckTable(String[] name, int[] itemWidth) {
		super(name, itemWidth);
		// TODO Auto-generated constructor stub
	}
	
	public void addItem(HistoryVO vo){
//		String triggerPlace = vo.place.toString();
//		String arrivePlace = vo.place.toString();
		String triggerTime = vo.time;
		String arriveTime = vo.time;
		
		if(arriveTime==null){
			arriveTime = "未到达";
		}
//		String []item = {triggerPlace,triggerTime,arrivePlace,arriveTime};
//		addItemLabel(item);
	}
}
