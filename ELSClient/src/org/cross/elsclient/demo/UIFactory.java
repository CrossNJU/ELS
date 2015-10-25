package org.cross.elsclient.demo;

import java.rmi.RemoteException;

import org.cross.elsclient.blservice.stockblservice.StockBLImpl;
import org.cross.elsclient.blservice.stockblservice.StockBLService;
import org.cross.elsclient.dataservice.datafactoryservice.DataFactoryServiceImpl;

public class UIFactory {
	
	StockBLService stockbl;
	
	public UIFactory(){
		try {
			stockbl = new StockBLImpl(new DataFactoryServiceImpl().getStockData());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public StockUI getStockUI(){
		return new StockUI(stockbl);
	}
}
