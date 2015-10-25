package org.cross.elsclient.demo;

import org.cross.elsclient.blservice.stockblservice.StockBLService;
import org.cross.elsclient.blservice.stockblservice.StockBLService_Stub;

public class UIFactory {
	
	StockBLService stockbl;
	
	public UIFactory(){
		stockbl = new StockBLService_Stub();
	}
	
	public StockUI getStockUI(){
		return new StockUI(stockbl);
	}
}
