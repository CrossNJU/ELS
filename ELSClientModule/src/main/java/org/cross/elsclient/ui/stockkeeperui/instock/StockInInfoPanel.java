package org.cross.elsclient.ui.stockkeeperui.instock;

import org.cross.elsclient.blservice.stockblservice.StockBLService;
import org.cross.elsclient.ui.component.ELSInfoPanel;
import org.cross.elsclient.vo.Receipt_StockInVO;

public class StockInInfoPanel extends ELSInfoPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Receipt_StockInVO vo;
	public StockBLService stockbl;
	
	public StockInInfoPanel(Receipt_StockInVO vo){
		this.vo = vo;
	}
	
	@Override
	public void init(){
		super.init();
		
		setTitle("创建入库单");
		addNormalItem("入库单编号", vo.number);
		addNormalItem("快件单编号", vo.goodsNumber);
		addNormalItem("入库时间", vo.time);
		addNormalItem("仓库区号", String.valueOf(vo.place.number));
		
		container.packHeight();
	}


}
